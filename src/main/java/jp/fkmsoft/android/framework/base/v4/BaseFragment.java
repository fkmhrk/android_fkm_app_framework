package jp.fkmsoft.android.framework.base.v4;

import jp.fkmsoft.android.framework.App;
import jp.fkmsoft.android.framework.UI;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

abstract public class BaseFragment<T extends UI, U extends App> extends Fragment {
    protected T ui;
    protected U app;
    
    /*
     * (non-Javadoc)
     * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Context context = getActivity();
        if (context == null) { return; }
        
        ui = createUI(context);
        app = createApp(context, ui);
    }

    /**
     * This method will be called in {@link BaseFragment#onCreate(Bundle)}
     * @param context
     * @return instance of T
     */
    abstract protected T createUI(Context context);
    
    /**
     * This method will be called in {@link BaseFragment#onCreate(Bundle)}
     * @param context
     * @return instance of U
     */
    abstract protected U createApp(Context context, T ui);
}
