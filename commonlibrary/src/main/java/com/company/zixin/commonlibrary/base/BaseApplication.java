package com.company.zixin.commonlibrary.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.luliang.shapeutils.DevShapeUtils;


/**
 * Created by COOTEK on 2017/7/28.
 */

public class BaseApplication extends Application {



    private static BaseApplication instance;


    public static BaseApplication getInstance() {
        return instance;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);


    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();
        ARouter.init(this);
        DevShapeUtils.init(this);

    }



}
