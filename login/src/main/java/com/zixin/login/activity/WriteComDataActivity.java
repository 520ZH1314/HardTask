package com.zixin.login.activity;

import com.company.zixin.commonlibrary.base.MyBaseActivity;
import com.zixin.login.BR;
import com.zixin.login.R;
import com.zixin.login.databinding.ActivityWriteComDataBinding;
import com.zixin.login.viewmodel.activity.WriteComViewModel;

/**
 *author:lovezh
 *params:
 *description:完善企业基本资料
 */
public class WriteComDataActivity extends MyBaseActivity<ActivityWriteComDataBinding,WriteComViewModel> {



    @Override
    public int initContentView() {
        return R.layout.activity_write_com_data;
    }

    @Override
    public int initVariableId() {
        return BR.writeComModel;
    }

    @Override
    public WriteComViewModel initViewModel() {
        return new WriteComViewModel();
    }
}
