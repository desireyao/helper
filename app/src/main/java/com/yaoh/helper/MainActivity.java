package com.yaoh.helper;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.yaoh.helper.activities.BaseActivity;
import com.yaoh.helper.constants.Constants;
import com.yaoh.helper.fragments.FragmentTabOne;
import com.yaoh.helper.fragments.FragmentTabTwo;
import com.yaoh.helper.message.MessageEvent;
import com.yaoh.helper.utils.LogTool;
import com.yaoh.helper.widget.FragmentTabHost;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static String TAG = "MainActivity";

    private FragmentTabHost mTabHost;  // 自定义的tabhost
    private TabHost.TabSpec tabspec;

    private List<Fragment> fragments = new ArrayList<>();
    private String[] str_tabs =
            new String[]{Constants.STR_TAB_ONE, Constants.STR_TAB_TWO, Constants.STR_TAB_THR};

    private int imgs[] = new int[]{R.drawable.tab_one_selected,
            R.drawable.tab_two_selected,
            R.drawable.tab_thr_selected};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.setOnTabChangedListener(new TabOnChangeListener());
        fragments.add(new FragmentTabOne());
        fragments.add(new FragmentTabTwo());

        for (int i = 0; i < fragments.size(); i++) {
            tabspec = mTabHost.newTabSpec(str_tabs[i]).setIndicator(tabIndicatorView(i));
            mTabHost.addTab(tabspec, fragments.get(i).getClass(), null);
        }
    }

    private View tabIndicatorView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.tabindicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tabindicator_img);

        imageView.setBackgroundResource(imgs[i]);
        TextView tv = (TextView) view.findViewById(R.id.tabindicator_tv);
        tv.setText(str_tabs[i]);
        return view;
    }

    class TabOnChangeListener implements TabHost.OnTabChangeListener {

        @Override
        public void onTabChanged(String s) {
            setTitle(s);

            MessageEvent messageEvent = new MessageEvent();
            messageEvent.setCODE(100);
            EventBus.getDefault().post(messageEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        LogTool.LogE(TAG, "MainActivity event.getCODE(): " + event.getCODE());
    }

    ;
}
