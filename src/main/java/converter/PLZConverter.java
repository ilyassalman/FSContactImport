package converter;

import domain.ConverterComparable.ComparableConverter;
import domain.ConverterComparable.PLZComparable;
import domain.PostleitzahlEntity;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Lukas on 27.04.2015.
 */
public class PLZConverter extends AbstractConverter<PostleitzahlEntity> {

    public List<PLZComparable> list;
    private PLZComparable currentPLZ;

    public PLZConverter(List<PostleitzahlEntity> list){
        ComparableConverter<PLZComparable, PostleitzahlEntity> converter = new ComparableConverter<>();
        this.list = converter.convert(list, PostleitzahlEntity.class, PLZComparable.class);
    }

    @Override
    public AbstractConverter<PostleitzahlEntity> addValue(String value) throws CriticalConvertFailException {
        if(value!= null && !value.trim().isEmpty()) {
            PostleitzahlEntity plz = new PostleitzahlEntity();
            try {
                plz.setPlz(Integer.parseInt(value));
            }catch (Exception e){
                this.fail();
                return this;
            }
            PLZComparable comparable = new PLZComparable(plz);
            try {
                currentPLZ = list.get(list.indexOf(comparable));
            }catch (ArrayIndexOutOfBoundsException e){
                throw new CriticalConvertFailException();
            }
        }
        return this;
    }

    @Override
    public PostleitzahlEntity build() {
        if(currentPLZ == null){
            return null;
        }
        return currentPLZ.entityToCompare;
    }
}
