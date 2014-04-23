package jp.fkmsoft.android.framework.base;

import java.lang.ref.WeakReference;

import android.app.Fragment;
import android.view.View;

import jp.fkmsoft.android.framework.dialog.ProgressDialogFragment;

/**
 * Base class of UI
 * @param <T>
 */
public abstract class BaseUI<T extends Fragment> {
    protected WeakReference<T> fragmentRef;
    
    protected BaseUI(T fragment) {
        this.fragmentRef = new WeakReference<T>(fragment);
    }
    
    protected View getRootView() {
        T fragment = fragmentRef.get();
        if (fragment == null) { return null; }
        return fragment.getView();
    }
    
    protected void showProgress(int title, int message) {
        Fragment fragment = fragmentRef.get();
        if (fragment == null) { return; }
        
        ProgressDialogFragment dialog = ProgressDialogFragment.newInstance(fragment.getString(title), fragment.getString(message));
        dialog.show(fragment.getFragmentManager(), ProgressDialogFragment.FRAGMENT_TAG);
    }

    public void hideProgress() {
        Fragment fragment = fragmentRef.get();
        if (fragment == null) { return; }
        
        ProgressDialogFragment.hide(fragment.getFragmentManager());
    }
}
