package jp.fkmsoft.android.framework.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Utility class for Fragment operation
 */
public class FragmentUtils {
    /**
     * Replaces with next fragment
     * @param manager Fragment manager
     * @param containerId Container id
     * @param next The fragment you want to replace with
     * @param addBackstack true if you want to add current fragment to backstack with tag ""
     */
    public static void toNextFragment(FragmentManager manager, int containerId, Fragment next, boolean addBackstack) {
        toNextFragment(manager, containerId, next, addBackstack, "");
    }

    /**
     * Replaces with next fragment
     * @param manager Fragment manager
     * @param containerId Container id
     * @param next The Fragment you want to replace with
     * @param addBackstack true if you want to add current fragment to backstack with tag ""
     * @param tag The tag for next fragment.
     *            You can find next with this tag by {@link android.support.v4.app.FragmentManager#findFragmentByTag(String)}
     */
    public static void toNextFragment(FragmentManager manager, int containerId, Fragment next,
                                      boolean addBackstack, String tag) {
        toNextFragment(manager, containerId, next, FragmentTransaction.TRANSIT_FRAGMENT_OPEN,
                addBackstack, tag);
    }

    /**
     * Replaces with next fragment
     * @param manager Fragment manager
     * @param containerId Container id
     * @param next The Fragment you want to replace with
     * @param transition Passed to {@link android.support.v4.app.FragmentTransaction#setTransition(int)}
     * @param addBackstack true if you want to add current fragment to backstack with tag ""
     * @param tag The tag for next fragment.
     *            You can find next with this tag by {@link android.support.v4.app.FragmentManager#findFragmentByTag(String)}
     */
    public static void toNextFragment(FragmentManager manager, int containerId, Fragment next,
                                      int transition, boolean addBackstack, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(transition);
        if (addBackstack) {
            transaction.addToBackStack("");
        }
        transaction.replace(containerId, next, tag);
        transaction.commit();
    }
}
