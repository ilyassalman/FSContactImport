package converter;

/**
 * Created by Lukas on 22.04.2015.
 */
public class ArrayConverter extends AbstractConverter<String[]> {
    char trimChar;
    String[] result;
    public ArrayConverter(char c) {
        super();
        trimChar = c;
    }

    @Override
    public AbstractConverter<String[]> addValue(String value) {
        if(value.trim().isEmpty()){
            this.result = new String[0];
        }
        String[] untrimmedResult = value.split(String.valueOf(trimChar));
        result = new String[untrimmedResult.length];
        int i = 0;
        for(String uS: untrimmedResult){
            result[i] = uS.trim();
            i++;
        }
        return this;
    }

    @Override
    public String[] build() {
        return result;
    }
}
