package com.zixin.login.activity;

import android.os.Bundle;
import android.widget.Button;

import com.company.zixin.commonlibrary.base.MyBaseActivity;
import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.shape.DevShape;
import com.zixin.login.BR;
import com.zixin.login.R;
import com.zixin.login.databinding.ActivityRegistBinding;
import com.zixin.login.viewmodel.activity.RegistViewModel;
/**
 *author:lovezh
 *params:
 *description:注册界面
 */
public class RegistActivity extends MyBaseActivity<ActivityRegistBinding,RegistViewModel> {

    private Button btnPersonalRegist;
    private Button btnPersonalRegistCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }



    @Override
    public int initContentView() {
        return R.layout.activity_regist;
    }

    @Override
    public int initVariableId() {
        return BR.registModel;
    }

    @Override
    public RegistViewModel initViewModel() {
        return new RegistViewModel();
    }
       //初始化一些自定义控件
    private void initView() {
        btnPersonalRegist = binding.btnPersonalRegist;//个人更新按钮
        btnPersonalRegistCode = binding.btnPersonalRegistCode;//验证码
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.bcompany).radius(10).into(btnPersonalRegist);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.bcompany).radius(10).into(btnPersonalRegistCode);

    }
}
