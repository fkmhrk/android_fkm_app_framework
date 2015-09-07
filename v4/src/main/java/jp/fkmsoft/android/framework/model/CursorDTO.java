package jp.fkmsoft.android.framework.model;

import android.database.Cursor;
import android.support.annotation.NonNull;

/**
 * DTO for {@link CursorUtils}
 */
public interface CursorDTO<T> {
    /**
     * This method will be called before iteration.
     * You can get column index in this call.
     * @param c Cursor
     */
    void prepare(@NonNull Cursor c);

    /**
     * Converts current line to {@link T}
     * @param c Cursor
     * @return instance of T
     */
    T toItem(@NonNull Cursor c);
}
