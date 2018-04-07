package com.company.zixin.card.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.company.zixin.card.BR;
import com.company.zixin.card.R;
import com.company.zixin.card.databinding.FragmentCardBinding;
import com.company.zixin.card.viewModel.CardFragmentViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 项目名称:HardTask
 * Created by lovezh
 * CreatedData: on 2018/4/7.
 */
@Route(path ="/card/fragment")
public class CardFragemnt extends BaseFragment<FragmentCardBinding,CardFragmentViewModel> {
    @Override
    public int initContentView() {
        return R.layout.fragment_card;
    }

    @Override
    public int initVariableId() {
        return BR.CardModel;
    }

    @Override
    public CardFragmentViewModel initViewModel() {
        return new CardFragmentViewModel();
    }
}
