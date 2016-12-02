package com.yaoh.helper.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaoh.helper.Dialog.ConfirmDialogFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yaoh on 2016/11/13.
 */

public abstract class BaseFragment extends Fragment {

    protected View mRootView;
    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(setLayoutResouceId(), container, false);

        initData(getArguments());
        initView();
        setListener();

        return mRootView;
    }

    /**
     * 初始化数据
     * 接收到的从其他地方传递过来的参数
     */
    protected void initData(Bundle arguments) {

    }

    /**
     * 初始化View
     */
    protected void initView() {

    }

    protected abstract int setLayoutResouceId();

    /**
     * 设置监听事件
     */
    protected void setListener() {

    }

    public void showEditDialog() {
        ConfirmDialogFragment editNameDialog = new ConfirmDialogFragment();
        editNameDialog.show(getActivity().getFragmentManager(), "EditNameDialog");

    }

    protected <T extends View> T findViewById(int id) {
        if (mRootView == null) {
            return null;
        }
        return (T) mRootView.findViewById(id);
    }
}
