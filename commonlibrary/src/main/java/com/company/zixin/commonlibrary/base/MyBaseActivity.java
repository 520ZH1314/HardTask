package com.company.zixin.commonlibrary.base;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.IBaseActivity;
import me.goldze.mvvmhabit.bus.Messenger;

public abstract class MyBaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends RxAppCompatActivity implements IBaseActivity {
    protected V binding;
    protected VM viewModel;
    private BaseApplication application;
    private MyBaseActivity oContext;
    public MyBaseActivity() {}

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (application == null) {
            // 得到Application对象
            application = BaseApplication.getInstance();
        }
        oContext = this;// 把当前的上下文对象赋值给BaseActivity
        addActivity(oContext);// 调用添加方法
        this.initParam();
        this.initViewDataBinding();
        this.initData();
        this.initViewObservable();
        this.viewModel.onCreate();
        this.viewModel.registerRxBus();
    }

    protected void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
        this.viewModel.removeRxBus();
        this.viewModel.onDestroy();
    }

    private void initViewDataBinding() {
        this.binding = DataBindingUtil.setContentView(this, this.initContentView());
        this.binding.setVariable(this.initVariableId(), this.viewModel = this.initViewModel());
    }

    public void refreshLayout() {
        if(this.viewModel != null) {
            this.binding.setVariable(this.initVariableId(), this.viewModel);
        }

    }

    public void initParam() {
    }

    public abstract int initContentView();

    public abstract int initVariableId();

    public abstract VM initViewModel();

    public void initData() {
    }

    public void initViewObservable() {
    }
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });
    }
    public void addActivity(Activity act) {
       application.addActivity(act);

    }

    public void removeActivity(Activity act) {
        application.removeActivity(act);
    }

    public void exitApp() {
      application.exitApp();
    }

}
