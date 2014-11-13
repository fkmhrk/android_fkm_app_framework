package jp.fkmsoft.android.framework.impl;

import java.lang.ref.WeakReference;

import jp.fkmsoft.android.framework.UI;
import jp.fkmsoft.android.framework.UIHolder;

/**
 * Implementation
 */
public class UIHolderImpl<T extends UI> extends WeakReference<T> implements UIHolder {
    public UIHolderImpl(T r) {
        super(r);
    }
}
