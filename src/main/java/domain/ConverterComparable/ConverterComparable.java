package domain.ConverterComparable;

import domain.LanguagesEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lukas on 27.04.2015.
 */
public abstract class ConverterComparable<T> {
    public T entityToCompare;
    public ConverterComparable(T entityToCompare){
        this.entityToCompare = entityToCompare;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ConverterComparable<T> lol;
        try {
            lol = (ConverterComparable<T>)obj;
        }catch (Exception e){
            return false;
        }
        return lol.getTextToCompare().toUpperCase().trim() == this.getTextToCompare().toUpperCase().trim();
    }

    public abstract String getTextToCompare();
}
