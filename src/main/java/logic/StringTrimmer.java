package logic;

/**
 * Created by Lukas on 22.04.2015.
 */
public class StringTrimmer {
    public static String trim(String value) {
        String result = value.trim();
        result = result.replace("\"", "");
        return result;
    }
}

