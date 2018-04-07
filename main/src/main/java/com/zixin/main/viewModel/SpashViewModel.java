package com.zixin.main.viewModel;

import android.databinding.ObservableField;

import com.company.zixin.commonlibrary.base.MyBaseViewModel;
import com.zixin.main.activity.MainActivity;
import com.zixin.main.activity.SpashActivity;

import me.goldze.mvvmhabit.binding.command.BindingCommand;
import rx.Subscriber;
import rx.functions.Action0;

/**
 * 项目名称:HardTask
 * Created by lovezh
 * CreatedData: on 2018/4/7.
 */

public class SpashViewModel extends MyBaseViewModel {
    public boolean isClick=false;
    public ObservableField<String> SpashDate = new ObservableField<String>();
    public SpashActivity mContext;
    public SpashViewModel(SpashActivity spashActivity) {
        super(spashActivity);
        this.mContext=spashActivity;
        init();
    }

    private void init() {
        ADTime();


        //判断是否登录
        if (isLogin()) {


        } else {

        }


    }

    //    广告时间
    private void ADTime() {
        countdown(3)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                        if(isClick){
                            return;
                        }else{
                            //跳转到主界面
                            startActivity(MainActivity.class);
                            mContext.finish();
                            isClick=false;
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        SpashDate.set(integer + "");
                    }
                });
    }

    private boolean isLogin() {
        return false;
    }



/**    点击事件    * */

public BindingCommand jumpAdTime=new BindingCommand(() -> {
    isClick=true;
    startActivity(MainActivity.class);
    mContext.finish();


});





}
