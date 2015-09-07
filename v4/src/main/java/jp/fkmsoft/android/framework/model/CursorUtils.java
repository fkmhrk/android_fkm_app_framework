package jp.fkmsoft.android.framework.model;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for {@link Cursor}
 */
public class CursorUtils {
    /**
     * Converts Cursor to {@link List<T>}
     * @param c Cursor
     * @param dto DTO that converts Cursor line to {@link T}
     * @param <T> Type
     * @return List of {@link T}
     */
    public static <T> List<T> toList(@Nullable Cursor c, @NonNull CursorDTO<T> dto) {
        if (c == null) {
            return new ArrayList<>();
        }
        if (!c.moveToFirst()) {
            c.close();
            return new ArrayList<>();
        }
        dto.prepare(c);
        List<T> list = new ArrayList<>(c.getCount());
        do {
            list.add(dto.toItem(c));
        } while (c.moveToNext());
        c.close();
        return list;
    }
}
