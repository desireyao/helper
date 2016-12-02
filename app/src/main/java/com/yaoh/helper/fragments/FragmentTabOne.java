package com.yaoh.helper.fragments;

import android.os.Bundle;

import com.yaoh.helper.R;
import com.yaoh.helper.message.MessageEvent;
import com.yaoh.helper.utils.LogTool;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by yaoh on 2016/11/13.
 */

public class FragmentTabOne extends BaseFragment{
    private static final String TAG = "FragmentTabOne";

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_tab_one;
    }

    @Override
    protected void initData(Bundle arguments) {
        super.initData(arguments);
    }

    protected void initView() {
        super.initView();
    }



}
