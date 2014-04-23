package jp.fkmsoft.android.framework.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

public class ProgressDialogFragment extends DialogFragment {
    public static final String FRAGMENT_TAG = "progress";
    private static final String ARGS_TITLE = "title";
    private static final String ARGS_MESSAGE = "message";

    public static ProgressDialogFragment newInstance(Context context, int titleId, int messageId) {
        return newInstance(context.getString(titleId), context.getString(messageId));
    }
    
    public static void hide(FragmentManager manager) {
        if (manager == null) { return; }
        DialogFragment dialog = (DialogFragment) manager.findFragmentByTag(ProgressDialogFragment.FRAGMENT_TAG);
        if (dialog == null) { return; }
        dialog.dismiss();
    }
    public static ProgressDialogFragment newInstance(String title, String message) {
        ProgressDialogFragment fragment = new ProgressDialogFragment();

        Bundle args = new Bundle();
        args.putString(ARGS_TITLE, title);
        args.putString(ARGS_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // get args
        Bundle args = getArguments();
        String title = args.getString(ARGS_TITLE);
        String msg = args.getString(ARGS_MESSAGE);
        
        ProgressDialog progress = new ProgressDialog(getActivity());
        progress.setTitle(title);
        progress.setMessage(msg);
        progress.setCancelable(false);
        
        return progress;
    }   
}
