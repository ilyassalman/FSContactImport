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
    List<LanguageEntityComparable> lol;

    public SpeaksConverter(List<LanguagesEntity> languagesEntities) {
        this.languagesEntities = languagesEntities;
        lol = new ComparableConverter<LanguageEntityComparable, LanguagesEntity>().convert(languagesEntities, LanguagesEntity.class, LanguageEntityComparable.class);
    }



    @Override
    public AbstractConverter<Collection<SpeaksEntity>> addValue(String value) {
        if(value.trim().isEmpty()){
            return this;
        }
       String[] languages =  new ArrayConverter(',').addValue(value).build();
        speaksEntities = new ArrayList<>();
        for(String language: languages){
            LanguagesEntity languagesEntity = new LanguagesEntity();
            languagesEntity.setGermanName(language);
            LanguageEntityComparable languageEntityComparable = new LanguageEntityComparable(languagesEntity);
            try {
                languageEntityComparable = lol.get(lol.indexOf(languageEntityComparable));
            }catch (IndexOutOfBoundsException e){continue;}
            SpeaksEntity speaksEntity = new SpeaksEntity();
            speaksEntity.setLanguagesByLanguagesId(languageEntityComparable.entityToCompare);
            speaksEntities.add(speaksEntity);
        }
        return this;
    }

    @Override
    public Collection<SpeaksEntity> build() {
        return speaksEntities;
    }
}
