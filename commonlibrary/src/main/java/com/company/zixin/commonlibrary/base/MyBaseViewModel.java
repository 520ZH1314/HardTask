package com.company.zixin.commonlibrary.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.bigkoo.svprogresshud.SVProgressHUD;

import java.util.concurrent.TimeUnit;

import me.goldze.mvvmhabit.base.BaseViewModel;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/2.
 */

public class MyBaseViewModel extends BaseViewModel {
    private SVProgressHUD svProgressHUD;

    public MyBaseViewModel() {
    }

    public MyBaseViewModel(Context context) {
        this.context = context;
    }

    public MyBaseViewModel(Fragment fragment) {
        this(fragment.getContext());
    }

    @Override
    public void showDialog() {
        if (svProgressHUD != null) {
            svProgressHUD.showWithStatus("加载中");
        } else {
            svProgressHUD = new SVProgressHUD(context);
            svProgressHUD.showWithStatus("加载中");
        }


    }

    @Override
    public void dismissDialog() {
        if (svProgressHUD.isShowing()) {
            svProgressHUD.dismiss();
        }
    }

//定时器
    public static Observable<Integer> countdown(int time) {
        if (time < 0) time = 0;

        final int countTime = time;
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Long, Integer>() {
                    @Override
                    public Integer call(Long increaseTime) {
                        return countTime - increaseTime.intValue();
                    }
                })
                .take(countTime + 1);

    }
}



