package com.yaoh.helper;

import android.app.Application;
import android.os.Environment;

import com.yaoh.helper.constants.Constants;
import com.yaoh.helper.utils.CrashHandler;
import com.yaoh.helper.utils.LogTool;

/**
 * Package com.yaoh.helper.
 * Created by yaoh on 2016/11/22.
 * Company Beacool IT Ltd.
 * <p/>
 * Description:
 */
public class App extends Application {

    private static App app;

    public static App get(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        LogTool.getInstance().init(Constants.SD_PATH + "/helper/Log",30,true);
        CrashHandler.getInstance().init(app);
    }

    /**
     * 退出整个应用
     */
    public void exit() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
