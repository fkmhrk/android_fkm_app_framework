package jp.fkmsoft.android.framework.base.v4;

import java.lang.ref.WeakReference;

import jp.fkmsoft.android.framework.dialog.v4.ProgressDialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;

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
