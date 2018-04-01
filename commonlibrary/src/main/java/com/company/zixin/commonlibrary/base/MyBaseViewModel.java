package com.company.zixin.commonlibrary.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.bigkoo.svprogresshud.SVProgressHUD;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/2.
 */

public class MyBaseViewModel extends BaseViewModel {
    private SVProgressHUD svProgressHUD ;
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
        if (svProgressHUD!=null){
            svProgressHUD.showWithStatus("加载中");
        } else{
            svProgressHUD=new SVProgressHUD(context);
            svProgressHUD.showWithStatus("加载中");
        }


    }

    @Override
    public void dismissDialog() {
          if(svProgressHUD.isShowing()){
              svProgressHUD.dismiss();
          }
    }

}
