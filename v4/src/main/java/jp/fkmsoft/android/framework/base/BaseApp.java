package jp.fkmsoft.android.framework.base;

import jp.fkmsoft.android.framework.UI;
import jp.fkmsoft.android.framework.UIHolder;

public class BaseApp<T extends UI> {
    protected final UIHolder<T> mUIHolder;
    
    protected BaseApp(UIHolder<T> uiHolder) {
        this.mUIHolder = uiHolder;
    }
}
