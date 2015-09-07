package jp.fkmsoft.android.framework.provider;

import android.content.ContentProvider;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

/**
 * Base ContentProvider that supports account feature
 */
abstract public class AccountedContentProvider extends ContentProvider {
    private Map<String, SQLiteDatabase> mDBMap = new HashMap<>();

    protected synchronized SQLiteDatabase getDatabase(String accountId) {
        SQLiteDatabase db = mDBMap.get(accountId);
        if (db == null) {
            SQLiteOpenHelper helper = createHelper(accountId);
            db = helper.getWritableDatabase();
            mDBMap.put(accountId, db);
        }
        return db;
    }

    protected String getAccountId(Uri uri) {
        // 0 : users
        // 1 : <id>
        return uri.getPathSegments().get(1);
    }

    /**
     * Creates {@link SQLiteOpenHelper} for account
     * @param accountId Account ID
     * @return an instance
     */
    protected abstract SQLiteOpenHelper createHelper(String accountId);
}
