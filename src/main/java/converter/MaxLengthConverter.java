package converter;

/**
 * Created by Lukas on 28.04.2015.
 */
public class MaxLengthConverter extends AbstractConverter<String> {

    String result;
    int maxlength;

    public MaxLengthConverter(int maxlength) {
        this.maxlength = maxlength;
    }

    @Override
    public AbstractConverter<String> addValue(String value) {
        result = null;
        if(value.length() <= maxlength){
            result = value;
        }
        return this;
    }

    @Override
    public String build() {
        return result;
    }
}
