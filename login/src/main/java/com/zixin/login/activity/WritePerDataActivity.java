package com.zixin.login.activity;

import com.company.zixin.commonlibrary.base.MyBaseActivity;
import com.zixin.login.BR;
import com.zixin.login.R;
import com.zixin.login.databinding.ActivityWritePerDataBinding;
import com.zixin.login.viewmodel.activity.WritePerViewModel;

/**
  *author:lovezh
  *params:
  *description:完善个人基本资料
  */
public class WritePerDataActivity extends MyBaseActivity<ActivityWritePerDataBinding,WritePerViewModel> {


    @Override
    public int initContentView() {
        return R.layout.activity_write_per_data;
    }

    @Override
    public int initVariableId() {
        return BR.writePerModel;
    }

    @Override
    public WritePerViewModel initViewModel() {
        return new WritePerViewModel(this);
    }
}
