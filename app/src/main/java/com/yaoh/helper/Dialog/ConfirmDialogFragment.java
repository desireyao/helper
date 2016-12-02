package com.yaoh.helper.Dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaoh.helper.R;

/**
 * Package com.yaoh.helper.Dialog.
 * Created by yaoh on 2016/11/22.
 * Company Beacool IT Ltd.
 * <p/>
 * Description:用于确定取消的对话框
 */
public class ConfirmDialogFragment extends DialogFragment{

    public ConfirmDialogFragment(){
        setCancelable(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_edit,container);
        return view;
    }
}
