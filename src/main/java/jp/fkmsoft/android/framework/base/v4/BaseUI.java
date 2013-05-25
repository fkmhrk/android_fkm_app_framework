package jp.fkmsoft.android.framework.base.v4;

import java.lang.ref.WeakReference;

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
}
