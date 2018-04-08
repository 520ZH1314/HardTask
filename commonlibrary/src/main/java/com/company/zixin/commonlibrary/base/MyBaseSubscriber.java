package com.company.zixin.commonlibrary.base;

/**
 * 项目名称:HardTask
 * Created by lovezh
 * CreatedData: on 2018/4/8.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.content.Context;
import android.widget.Toast;

import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.http.NetworkUtil;
import me.goldze.mvvmhabit.utils.KLog;
import me.goldze.mvvmhabit.utils.ToastUtils;


        import android.content.Context;
        import android.widget.Toast;
        import me.goldze.mvvmhabit.http.ExceptionHandle.ResponeThrowable;
        import me.goldze.mvvmhabit.utils.KLog;
        import me.goldze.mvvmhabit.utils.ToastUtils;
        import rx.Subscriber;

public abstract class MyBaseSubscriber<T> extends Subscriber<T> {
    private Context context;
    private boolean isNeedCahe;

    public abstract void onResult(T var1);

    public MyBaseSubscriber(Context context) {
        this.context = context;
    }

    public void onError(Throwable e) {
        KLog.e(e.getMessage());
        if(e instanceof ResponeThrowable) {
            this.onError((ResponeThrowable)e);
        } else {
            this.onError(new ResponeThrowable(e, 1000));
        }

    }

    public void onStart() {
        super.onStart();
        Toast.makeText(this.context, "http is start", Toast.LENGTH_SHORT).show();
        if(!NetworkUtil.isNetworkAvailable(this.context)) {
            Toast.makeText(this.context, "无网络，读取缓存数据", Toast.LENGTH_SHORT).show();
            this.onCompleted();
        }

    }

    public void onCompleted() {
        Toast.makeText(this.context, "http is Complete", 0).show();
    }

    public abstract void onError(ResponeThrowable var1);

    public void onNext(T o) {
        BaseResponse baseResponse = (BaseResponse)o;
        if(baseResponse.getCode() == 200) {
            this.onResult((T) baseResponse.getResult());
        } else if(baseResponse.getCode() == 330) {
            ToastUtils.showShort(baseResponse.getMessage());
        } else if(baseResponse.getCode() == 503) {
            KLog.e(baseResponse.getMessage());
        } else {
            ToastUtils.showShort("操作失败！错误代码:" + baseResponse.getCode());
        }

    }
}

