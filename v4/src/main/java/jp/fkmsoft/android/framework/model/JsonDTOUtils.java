package jp.fkmsoft.android.framework.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for {@link jp.fkmsoft.android.framework.model.JsonDTO}
 */
public class JsonDTOUtils {
    /**
     * Decodes {@link org.json.JSONArray} into {@link T}
     * @param array Input array
     * @param dto DTO
     * @param <T> Target class
     * @return List of {@link T}
     */
    public static <T> List<T> decodeList(JSONArray array, JsonDTO<T> dto) {
        if (array == null) { return new ArrayList<>(); }
        List<T> list = new ArrayList<>(array.length());
        for (int i = 0 ; i < array.length() ; ++i) {
            JSONObject obj = array.optJSONObject(i);
            if (obj == null) { continue; }

            list.add(dto.decode(obj));
        }
        return list;
    }

    /**
     * Encodes List of {@link T} into {@link org.json.JSONArray}
     * @param list Input List
     * @param dto DTO
     * @param <T> Target class
     * @return JSONArray
     */
    public static <T> JSONArray encodeList(List<T> list, JsonDTO<T> dto) {
        JSONArray array = new JSONArray();
        if (list == null) { return array; }

        for (T item : list) {
            array.put(dto.encode(item));
        }

        return array;
    }
}
