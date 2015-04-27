package domain.ConverterComparable;

import domain.BasePersistable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukas on 27.04.2015.
 */
public class ComparableConverter<T extends ConverterComparable, P extends BasePersistable> {

    public List<T> convert(List<P> toConvert, Class<P> pClass, Class<T> tClass){
        List<T> converted = new ArrayList<>();
        for(P convertEntity: toConvert){
            T convertedEntity;
            try {
                convertedEntity = tClass.getConstructor(pClass).newInstance(convertEntity);
            } catch (InstantiationException e) {
                e.printStackTrace();
                continue;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                continue;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                continue;
            }
            converted.add(convertedEntity);
        }
        return converted;
    }
}
