package jp.fkmsoft.android.framework.base;

import jp.fkmsoft.android.framework.App;
import jp.fkmsoft.android.framework.UI;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

abstract public class BaseFragment<U extends App> extends Fragment {
    protected U mApp;
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        mApp = createApp();
    }

    /**
     * This method will be called in {@link BaseFragment#onActivityCreated(android.os.Bundle)}
     * @return instance of U
     */
    abstract protected U createApp();
}
