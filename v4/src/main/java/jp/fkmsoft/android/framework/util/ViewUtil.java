package jp.fkmsoft.android.framework.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import jp.fkmsoft.libs.app_framework.R;

/**
 * Utility class for View
 */
public class ViewUtil {
    /**
     * replace with next fragment
     * @param manager is fragment manager
     * @param next is fragment you want to replace with
     * @param addBackstack true : add current fragment to backstack
     */
    public static void toNextFragment(FragmentManager manager, Fragment next, boolean addBackstack) {
        toNextFragment(manager, next, addBackstack, "");
    }

    /**
     * replace with next fragment
     * @param manager is fragment manager
     * @param next is fragment you want to replace with
     * @param addBackstack true : add current fragment to backstack
     * @param tag fragment tag
     */
    public static void toNextFragment(FragmentManager manager, Fragment next, boolean addBackstack, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (addBackstack) {
            transaction.addToBackStack("");
        }
        transaction.replace(R.id.container, next, tag);
        transaction.commit();
    }
}
