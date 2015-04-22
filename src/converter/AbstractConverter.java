package converter;

/**
 * Created by Lukas on 21.04.2015.
 */
public abstract class AbstractConverter<T>{
    public abstract AbstractConverter<T> addValue(String value);
    public abstract T build();
}
