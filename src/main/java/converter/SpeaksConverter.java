package converter;

import domain.ConverterComparable.ComparableConverter;
import domain.ConverterComparable.LanguageEntityComparable;
import domain.LanguagesEntity;
import domain.SpeaksEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Lukas on 27.04.2015.
 */
public class SpeaksConverter extends AbstractConverter<Collection<SpeaksEntity>> {
    Collection<SpeaksEntity> speaksEntities;
    List<LanguagesEntity> languagesEntities;

    public SpeaksConverter(List<LanguagesEntity> languagesEntities) {
        this.languagesEntities = languagesEntities;
    }



    @Override
    public AbstractConverter<Collection<SpeaksEntity>> addValue(String value) {
       String[] languages =  new ArrayConverter(',').addValue(value).build();
        speaksEntities = new ArrayList<>();
        List<LanguageEntityComparable> lol = new ComparableConverter<LanguageEntityComparable, LanguagesEntity>().convert(languagesEntities, LanguageEntityComparable.class)
        for(String language: languages){
            LanguagesEntity languagesEntity = new LanguagesEntity();
            //TODO
        }

    }

    @Override
    public Collection<SpeaksEntity> build() {
        return null;
    }
}
