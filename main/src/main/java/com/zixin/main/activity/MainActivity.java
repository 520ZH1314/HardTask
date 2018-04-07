package com.zixin.main.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.company.zixin.commonlibrary.base.MyBaseActivity;
import com.zixin.main.BR;
import com.zixin.main.R;
import com.zixin.main.databinding.ActivityMainBinding;
import com.zixin.main.viewModel.MainViewModel;

import me.goldze.mvvmhabit.utils.ToastUtils;

public class MainActivity extends MyBaseActivity<ActivityMainBinding, MainViewModel> implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout containFrame;
    private RadioButton mianCard;
    private RadioButton mianChat;
    private RadioButton mianAppcontext;
    private RadioButton mianRank;
    private RadioButton mianMine;
    private RadioGroup mianRadiogruop;
    private Fragment[] mFragments;
    private int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        init();
        initListener();
    }


    private void init() {
        containFrame = binding.mianFragment;
        mianCard = binding.mianCard;

        mianChat = binding.mianChat;
        mianAppcontext = binding.mianAppcontext;
        mianRank = binding.mianRank;
        mianMine = binding.mianMine;


        mianRadiogruop = binding.mianRadiogruop;
        Fragment cardFragment = (Fragment) ARouter.getInstance().build("/card/fragment").navigation();
        Fragment chatFragment = (Fragment) ARouter.getInstance().build("/chat/fragment").navigation();
        Fragment appcontextFragment = (Fragment) ARouter.getInstance().build("/appcontext/fragment").navigation();
        Fragment rankFragment = (Fragment) ARouter.getInstance().build("/rank/fragment").navigation();
        Fragment mineFragment = (Fragment) ARouter.getInstance().build("/mine/fragment").navigation();
        mFragments = new Fragment[]{cardFragment,
                chatFragment, appcontextFragment, rankFragment, mineFragment};


        //开启事务

        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();

        //添加首页
        ft.add(R.id.mian_fragment, cardFragment).commit();

        //默认设置为第0个
        setIndexSelected(0);

    }

    private void setIndexSelected(int index) {

        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if (!mFragments[index].isAdded()) {
            ft.add(R.id.mian_fragment, mFragments[index]).show(mFragments[index]);
        } else {
            ft.show(mFragments[index]);
        }

        ft.commit();
        //再次赋值
        mIndex = index;

    }

    @Override
    public int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.mainModel;
    }

    @Override
    public MainViewModel initViewModel() {
        return new MainViewModel();
    }

    private void initListener() {
        mianRadiogruop.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (checkedId == R.id.mian_card) {
            setIndexSelected(0);

        } else if (checkedId == R.id.mian_chat) {
            setIndexSelected(1);

        } else if (checkedId == R.id.mian_appcontext) {
            setIndexSelected(2);

        } else if (checkedId == R.id.mian_rank) {
            setIndexSelected(3);

        } else if (checkedId == R.id.mian_mine) {
            setIndexSelected(4);

        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断当点击的是返回键
        if (keyCode == event.KEYCODE_BACK) {
            exit();//退出方法
        }
        return true;
    }

    private long time = 0;

    //退出方法
    private void exit() {
          //如果在两秒大于2秒
        if (System.currentTimeMillis() - time > 2000) {
           //获得当前的时间
            time = System.currentTimeMillis();
            ToastUtils.showShort("再次点击退出应用");
        } else {
          //点击在两秒以内
          exitApp();
        }
    }

}

