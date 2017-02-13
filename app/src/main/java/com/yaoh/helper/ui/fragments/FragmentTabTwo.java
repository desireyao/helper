package com.yaoh.helper.ui.fragments;

import android.os.Bundle;

import com.yaoh.helper.R;

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
}
