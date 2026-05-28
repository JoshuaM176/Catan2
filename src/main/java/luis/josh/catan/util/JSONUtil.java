package luis.josh.catan.util;

import org.json.simple.JSONArray;

public class JSONUtil {

    @SuppressWarnings("unchecked")
    public static <T> JSONArray ArrayToJSON(T[] array) {
        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i < array.length; i++) {
            jsonArray.add(array[i]);
        }
        return jsonArray;
    }
}
