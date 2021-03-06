package jp.fkmsoft.android.framework.util;

import android.support.v4.app.DialogFragment;
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
        toNextFragment(manager, containerId, next, FragmentTransaction.TRANSIT_FRAGMENT_OPEN,
                addBackstack, false, "");
    }

    /**
     * Replaces with next fragment. This method uses {@link FragmentTransaction#commitAllowingStateLoss()}
     * @param manager Fragment manager
     * @param containerId Container id
     * @param next The fragment you want to replace with
     * @param addBackstack true if you want to add current fragment to backstack with tag ""
     */
    public static void toNextFragmentAllowingStateLoss(FragmentManager manager, int containerId, Fragment next, boolean addBackstack) {
        toNextFragment(manager, containerId, next, FragmentTransaction.TRANSIT_FRAGMENT_OPEN,
                addBackstack, true, "");
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
                addBackstack, false, tag);
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
        toNextFragment(manager, containerId, next, transition, addBackstack, false, tag);
    }

    /**
     * Replaces with next fragment
     * @param manager Fragment manager
     * @param containerId Container id
     * @param next The Fragment you want to replace with
     * @param transition Passed to {@link android.support.v4.app.FragmentTransaction#setTransition(int)}
     * @param addBackstack true if you want to add current fragment to backstack with tag ""
     * @param stateLoss true if you want to call {@link FragmentTransaction#commitAllowingStateLoss()}
     * @param tag The tag for next fragment.
     *            You can find next with this tag by {@link android.support.v4.app.FragmentManager#findFragmentByTag(String)}
     */
    public static void toNextFragment(FragmentManager manager, int containerId, Fragment next,
                                      int transition, boolean addBackstack, boolean stateLoss, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(transition);
        if (addBackstack) {
            transaction.addToBackStack("");
        }
        transaction.replace(containerId, next, tag);
        if (stateLoss) {
            transaction.commitAllowingStateLoss();
        } else {
            transaction.commit();
        }
    }

    /**
     * Dismisses dialog
     * @param manager Fragment manager
     * @param tag The tag for Dialog
     */
    public static void dismissDialog(FragmentManager manager, String tag) {
        DialogFragment dialog = findDialogFragment(manager, tag);
        if (dialog == null) { return; }
        dialog.dismiss();
    }

    /**
     * Dismisses dialog that uses {@link DialogFragment#dismissAllowingStateLoss()}
     * @param manager Fragment manager
     * @param tag The tag for Dialog
     */
    public static void dismissDialogAllowingStateLoss(FragmentManager manager, String tag) {
        DialogFragment dialog = findDialogFragment(manager, tag);
        if (dialog == null) { return; }
        dialog.dismissAllowingStateLoss();
    }

    private static DialogFragment findDialogFragment(FragmentManager manager, String tag) {
        if (manager == null) { return null; }
        Fragment fragment = manager.findFragmentByTag(tag);
        if (fragment == null) { return null; }
        return (fragment instanceof DialogFragment) ? (DialogFragment) fragment : null;
    }
}
