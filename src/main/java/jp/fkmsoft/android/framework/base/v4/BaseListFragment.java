package jp.fkmsoft.android.framework.base.v4;

import jp.fkmsoft.android.framework.App;
import jp.fkmsoft.android.framework.UI;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

abstract public class BaseListFragment<T extends UI, U extends App> extends ListFragment {
    protected T ui;
    protected U app;

    /*
     * (non-Javadoc)
     * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        Context context = getActivity();
        
        ui = createUI(context);
        app = createApp(savedInstanceState, context, ui);
    }

    /**
     * This method will be called in {@link BaseListFragment#onCreate(Bundle)}
     * @param context
     * @return instance of T
     */
    abstract protected T createUI(Context context);
    
    /**
     * This method will be called in {@link BaseListFragment#onCreate(Bundle)}
     * @param savedInstanceState instance state. if not null, app must be restore
     * @param context
     * @return instance of U
     */
    abstract protected U createApp(Bundle savedInstanceState, Context context, T ui);
}
