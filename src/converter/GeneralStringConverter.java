package converter;

import logic.StringTrimmer;

/**
 * Created by Lukas on 22.04.2015.
 */
public class GeneralStringConverter extends AbstractConverter<String> {
    String value;
    @Override
    public AbstractConverter<String> addValue(String value) {
        this.value = StringTrimmer.trim(value);
        return this;
    }

    @Override
    public String build() {
        return value;
    }
}
