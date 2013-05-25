package jp.fkmsoft.android.framework.base.v4;

import jp.fkmsoft.android.framework.App;
import jp.fkmsoft.android.framework.UI;
import android.support.v4.app.ListFragment;

public class BaseListFragment<T extends UI, U extends App> extends ListFragment {
    protected T ui;
    protected U app;
}
