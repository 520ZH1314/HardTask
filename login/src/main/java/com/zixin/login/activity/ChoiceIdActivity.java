package com.zixin.login.activity;

import com.company.zixin.commonlibrary.base.MyBaseActivity;
import com.zixin.login.BR;
import com.zixin.login.R;
import com.zixin.login.databinding.ActivityChoiceIdBinding;
import com.zixin.login.viewmodel.activity.ChoiceIdViewModel;

/**
 *author:lovezh
 *params:
 *description:选择身份界面
 */
public class ChoiceIdActivity extends MyBaseActivity<ActivityChoiceIdBinding,ChoiceIdViewModel> {


    @Override
    public int initContentView() {
        return R.layout.activity_choice_id;
    }

    @Override
    public int initVariableId() {
        return BR.choiceIdModel;
    }

    @Override
    public ChoiceIdViewModel initViewModel() {
        return new ChoiceIdViewModel();
    }
}
