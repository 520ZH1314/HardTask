package com.zixin.login.viewmodel.activity;

import android.content.Context;

import com.company.zixin.commonlibrary.base.MyBaseViewModel;
import com.zixin.login.activity.UpDatePwdActivity;

/**
 * 项目名称:HardTask
 * Created by lovezh
 * CreatedData: on 2018/3/30.
 */

public class UpDatePwdViewModel extends MyBaseViewModel {
     public Context mContext;

    public UpDatePwdViewModel(UpDatePwdActivity upDatePwdActivity) {
        super(upDatePwdActivity);
        this.mContext=upDatePwdActivity;
        init();
    }

    private void init() {

    }


}
