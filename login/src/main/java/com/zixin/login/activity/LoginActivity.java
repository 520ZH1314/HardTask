package com.zixin.login.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.company.zixin.commonlibrary.base.MyBaseActivity;
import com.zixin.login.BR;
import com.zixin.login.R;
import com.zixin.login.databinding.ActivityLoginBinding;
import com.zixin.login.viewmodel.activity.LoginViewModel;

/**
 *author:lovezh
 *params:
 *description:登录界面
 */
public class LoginActivity extends MyBaseActivity<ActivityLoginBinding,LoginViewModel> {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
         initView();
    }



    @Override
    public int initContentView() {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.loginModel;
    }

    @Override
    public LoginViewModel initViewModel() {
        return new LoginViewModel();
    }

     //初始化一些需要自定义的控件
    private void initView() {

    }




}
