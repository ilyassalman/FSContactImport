package converter;

import java.util.ArrayList;

/**
 * Created by Lukas on 21.04.2015.
 */
public class LimitedArrayConverter extends AbstractConverter<String[]> {
    ArrayList<String> values;
    int maxLength;
    public LimitedArrayConverter(int length) {
        maxLength = length;
        values = new ArrayList<String>();
    }

    @Override
    public AbstractConverter<String[]> addValue(String value) {
        if(values.size() >= maxLength){
            values.clear();
        }
        values.add(value);
        return this;
    }

    @Override
    public String[] build() {
        if(values.size() != maxLength){
            return null;
        }
        return values.toArray(new String[maxLength]);
    }
}
