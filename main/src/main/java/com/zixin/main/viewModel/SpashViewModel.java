package com.zixin.main.viewModel;

import android.databinding.ObservableField;

import com.company.zixin.commonlibrary.api.chatapi.RongImTokenApi;
import com.company.zixin.commonlibrary.base.Constant;
import com.company.zixin.commonlibrary.base.MyBaseViewModel;
import com.company.zixin.commonlibrary.model.chatmodel.UserTokenEntity;
import com.company.zixin.commonlibrary.utils.RetrofitClient;
import com.zixin.main.activity.MainActivity;
import com.zixin.main.activity.SpashActivity;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.SPUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;
import rx.Observer;
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
            getRonToken();

            //链接融云
            RongIM.connect(SPUtils.getInstance(Constant.SPTOKEN).getString(Constant.RONTOKEN), new RongIMClient.ConnectCallback() {
                @Override
                public void onSuccess(String s) {
                    ToastUtils.showShort(s+"成功");
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                }

                @Override
                public void onTokenIncorrect() {

                }
            });
        }
    }

    private void getRonToken() {
        RetrofitClient.getInstance("http://api.cn.ronghub.com").create(RongImTokenApi.class)
                .getRonUserToken("123", "测试用户", Constant.IMGURL)
                .compose(RxUtils.bindToLifecycle(context)) //请求与View周期同步
                .compose(RxUtils.schedulersTransformer()) //线程调度
                 .subscribe(new Observer<UserTokenEntity>() {
                     @Override
                     public void onCompleted() {

                     }

                     @Override
                     public void onError(Throwable e) {

                     }

                     @Override
                     public void onNext(UserTokenEntity o) {
                          //获取成功,链接融云
                          //保存Token
                         SPUtils.getInstance(Constant.SPTOKEN).put(Constant.RONTOKEN,o.getToken());
                         //保存 useid
                         SPUtils.getInstance(Constant.SPTOKEN).put(Constant.USEID, o.getUserId());
                     }
                 });
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
