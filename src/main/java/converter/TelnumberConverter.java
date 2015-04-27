package converter;

import domain.TelnumbersEntity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lukas on 27.04.2015.
 */
public class TelnumberConverter extends AbstractConverter<Collection<TelnumbersEntity>> {

    Collection<TelnumbersEntity> telnumbersEntities;

    public TelnumberConverter() {
        this.telnumbersEntities = new ArrayList<TelnumbersEntity>();
    }

    @Override
    public AbstractConverter<Collection<TelnumbersEntity>> addValue(String value) {
        if(telnumbersEntities.size() >= 2){
            telnumbersEntities.clear();
        }
        TelnumbersEntity telnumbersEntity = new TelnumbersEntity();
        telnumbersEntity.setValue(value);
        telnumbersEntity.setImportant(telnumbersEntities.isEmpty());
        return this;
    }

    @Override
    public Collection<TelnumbersEntity> build() {
        return telnumbersEntities;
    }
}
