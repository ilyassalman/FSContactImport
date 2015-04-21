package converter;

/**
 * Created by Lukas on 21.04.2015.
 */
public abstract class AbstractConverter<T> implements iConverter{
    public abstract void addValue(String value);
    public abstract T build();
}
