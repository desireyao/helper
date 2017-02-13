package com.yaoh.helper.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yaoh.helper.R;
import com.yaoh.helper.utils.LogTool;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by yaoh on 2016/11/13.
 */

public class FragmentTabOne extends BaseFragment implements View.OnClickListener{
    private static final String TAG = "FragmentTabOne";

    private Button btn;

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
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    private void testHttp() {

        String url = "http://apicloud.mob.com/wx/article/search?";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("page", "1")
                .addParams("cid", "37")
                .addParams("key", "520520test")
                .addParams("key", "520520test")
                .addParams("size", "20")
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                         LogTool.LogE("TAG","response: " + response);
                    }
                });


    }


    @Override
    public void onClick(View v) {
        testHttp();
    }
}
