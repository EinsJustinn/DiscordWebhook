package de.justin.json;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JsonObject {

    private final HashMap<String, Object> map = new HashMap<>();

    public JsonObject put(String key, Object value) {
        map.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Set<Map.Entry<String, Object>> entrySet = this.map.entrySet();
        builder.append("{");
        int i = 0;

        for (Map.Entry<String, Object> entry : entrySet) {
            Object object = entry.getValue();
            builder.append(this.quote(entry.getKey())).append(":");
            if (object instanceof String) {
                builder.append(this.quote(String.valueOf(object)));
            } else if (object instanceof Integer) {
                builder.append(Integer.valueOf(String.valueOf(object)));
            } else if (object instanceof Boolean) {
                builder.append(object);
            } else if (object instanceof JsonObject) {
                builder.append(object);
            } else if (object.getClass().isArray()) {
                builder.append("[");
                int len = Array.getLength(object);

                for (int j = 0; j < len; ++j) {
                    builder.append(Array.get(object, j).toString()).append(j != len - 1 ? "," : "");
                }

                builder.append("]");
            }

            ++i;
            builder.append(i == entrySet.size() ? "}" : ",");
        }

        return builder.toString();
    }

    private String quote(String string) {
        return "\"" + string + "\"";
    }
}
