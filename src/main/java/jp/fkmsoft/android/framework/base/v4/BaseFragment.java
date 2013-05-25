package jp.fkmsoft.android.framework.base.v4;

import jp.fkmsoft.android.framework.App;
import jp.fkmsoft.android.framework.UI;
import android.support.v4.app.Fragment;

public class BaseFragment<T extends UI, U extends App> extends Fragment {
    protected T ui;
    protected U app;
}
