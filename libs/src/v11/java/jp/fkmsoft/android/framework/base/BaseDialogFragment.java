package jp.fkmsoft.android.framework.base;

import android.app.DialogFragment;

import jp.fkmsoft.android.framework.App;
import jp.fkmsoft.android.framework.UI;

public class BaseDialogFragment<T extends UI, U extends App> extends DialogFragment {
    protected T ui;
    protected U app;
}
