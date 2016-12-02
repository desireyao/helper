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

public class FragmentTabTwo extends BaseFragment{
    private static final String TAG = "FragmentTabTwo";

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_tab_two;
    }

    @Override
    protected void initData(Bundle arguments) {
        super.initData(arguments);
    }

    protected void initView() {
        super.initView();
    }

    private void init(){
        for (int i = 0; i < 10; i ++){
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        LogTool.LogE(TAG,"FragmentTabTwo event.getCODE(): " + event.getCODE());
    };
}
