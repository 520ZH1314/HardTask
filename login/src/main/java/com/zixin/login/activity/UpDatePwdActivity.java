package com.zixin.login.activity;

import android.os.Bundle;
import android.widget.Button;

import com.company.zixin.commonlibrary.base.MyBaseActivity;
import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.shape.DevShape;
import com.zixin.login.BR;
import com.zixin.login.R;
import com.zixin.login.databinding.ActivityUpDatePwdBinding;
import com.zixin.login.viewmodel.activity.UpDatePwdViewModel;
 /**
  *author:lovezh
  *params:
  *description:忘记密码(更新密码)
  */
public class UpDatePwdActivity extends MyBaseActivity<ActivityUpDatePwdBinding,UpDatePwdViewModel> {
    private Button btnUpdate;
    private Button btnUpdatePwdCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }



    @Override
    public int initContentView() {
        return R.layout.activity_up_date_pwd;
    }

    @Override
    public int initVariableId() {
        return BR.upDatePwdModel;
    }

    @Override
    public UpDatePwdViewModel initViewModel() {
        return new UpDatePwdViewModel();
    }

    //初始化一些自定义组件
    private void initView() {
        btnUpdate = binding.btnUpdate;//个人注册按钮
        btnUpdatePwdCode = binding.btnUpdatePwdCode;//验证码
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.bcompany).radius(10).into(btnUpdate);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.bcompany).radius(10).into(btnUpdatePwdCode);

    }
}
