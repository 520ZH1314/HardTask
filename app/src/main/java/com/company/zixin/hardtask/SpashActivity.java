package com.company.zixin.hardtask;

import com.company.zixin.hardtask.databinding.ActivitySpashBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

 /**
  *author:lovezh
  *params:
  *description:引导界面
  */
public class SpashActivity extends BaseActivity<ActivitySpashBinding,SpashActivityViewModel> {


    @Override
    public int initContentView() {
        return R.layout.activity_spash;
    }

    @Override
    public int initVariableId() {
        return BR.spashModel;
    }

    @Override
    public SpashActivityViewModel initViewModel() {
        return new SpashActivityViewModel();
    }
}
