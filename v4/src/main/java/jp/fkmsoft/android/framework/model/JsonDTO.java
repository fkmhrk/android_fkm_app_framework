package jp.fkmsoft.android.framework.model;

import org.json.JSONObject;


/**
 * DTO from {@link org.json.JSONObject} to T
 * @param <T> Target class
 */
public interface JsonDTO<T> extends DTO<JSONObject, T> {
}
