package com.yaoh.helper.activities;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.TextView;

import com.yaoh.helper.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yaoh on 2016/11/13.
 */

public abstract  class BaseActivity extends AppCompatActivity{

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        EventBus.getDefault().register(this);

        initToolbar();
        initData();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView();

    private void initToolbar() {
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    protected void setTitle(String title){
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    protected void showWaitDialog(){
        if(progressDialog == null){
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage("正在加载数据中...");
        progressDialog.show();
    }

    protected void showWaitDialog(String message) {
        if (progressDialog != null) {
            progressDialog.setMessage(message);
            progressDialog.show();
        }
    }

    protected void dismissDialog(){
        if(progressDialog != null){
            progressDialog.dismiss();
        }
    }


}
