package converter;

/**
 * Created by Lukas on 21.04.2015.
 */
public abstract class AbstractConverter<T> {
    public AbstractConverter() {
        this.valid = true;
    }

    private boolean valid;
    public abstract AbstractConverter<T> addValue(String value) throws CriticalConvertFailException;

    public abstract T build();

    public boolean isValid(){
        return valid;
    }

    protected void fail(){
        this.valid = false;
    }
}
