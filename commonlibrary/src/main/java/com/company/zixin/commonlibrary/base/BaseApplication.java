package com.company.zixin.commonlibrary.base;

import android.app.Activity;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.luliang.shapeutils.DevShapeUtils;

import java.util.HashSet;
import java.util.Set;

import io.rong.imkit.RongIM;


/**
 * Created by COOTEK on 2017/7/28.
 */

public class BaseApplication extends me.goldze.mvvmhabit.base.BaseApplication {

    private static BaseApplication instance;

    private Set<Activity> allActivities;



    public static synchronized BaseApplication getInstance() {
        return instance;
    }



    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }

    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);


    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();
        ARouter.init(this);
        RongIM.init(this);
        DevShapeUtils.init(this);

    }



}
