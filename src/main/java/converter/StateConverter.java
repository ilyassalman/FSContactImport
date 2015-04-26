package converter;

import java.util.HashMap;

/**
 * Created by Lukas on 21.04.2015.
 */
public class StateConverter extends AbstractConverter<String> {

    HashMap<String, String> stateMapping;
    String state;

    public StateConverter() {
        stateMapping = new HashMap<String, String>();
        stateMapping.put("W", "Wien");
        stateMapping.put("N", "Niederösterreich");
        stateMapping.put("B", "Burgenland");
        stateMapping.put("St", "Steiermark");
        stateMapping.put("T", "Tirol");
        stateMapping.put("O", "Oberösterreich");
        stateMapping.put("K", "Kärnten");
        stateMapping.put("Sa", "Salzburg");
        stateMapping.put("V", "Vorarlberg");
    }

    @Override
    public AbstractConverter<String> addValue(String value) {
        state = null;
        try {
            state = stateMapping.get(value);
        } catch (Exception e) {
        }
        return this;
    }

    @Override
    public String build() {
        return state;
    }
}
