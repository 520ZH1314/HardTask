package com.zixin.login.viewmodel.activity;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.Color;
import android.view.View;

import com.bigkoo.pickerview.TimePickerView;
import com.company.zixin.commonlibrary.base.MyBaseViewModel;
import com.zixin.login.R;
import com.zixin.login.activity.WritePerDataActivity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 项目名称:HardTask
 * Created by lovezh
 * CreatedData: on 2018/3/31.
 *  填写个人资料的 viewmodel
 */

public class WritePerViewModel extends MyBaseViewModel {
    private Context context;
    public List<String> mSexData;
    public List<String> mEducationsData;
    public List<String> mJobTimes;
    public TimePickerView pvTime;
    //出生年月的绑定
    public ObservableField<String> time = new ObservableField<>("");
    public WritePerViewModel(WritePerDataActivity writePerDataActivity) {
        super(writePerDataActivity);
        this.context=writePerDataActivity;
        init();
    }
     //初始化一些数据
    private void init() {
         String[] sex = context.getResources().getStringArray(R.array.login_module_sex);//性别
         mSexData= Arrays.asList(sex);


        String[] educations = context.getResources().getStringArray(R.array.login_module_education);//学历
        mEducationsData= Arrays.asList(educations);

        String[] jobTimes = context.getResources().getStringArray(R.array.login_module_job_all_time);//工作经验
        mJobTimes= Arrays.asList(jobTimes);

    }


    //日历点击事件
    public BindingCommand DataClick=new BindingCommand(() -> {
        if(pvTime==null){
            initTimer();
        }

           pvTime.show();

    });
   // 初始化时间 picker
    private void initTimer() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1920, 0, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2018, 12, 31);
        //时间选择器
        pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                /*btn_Time.setText(getTime(date));*/
                    time.set(getTime(date));

            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("", "", "", "", "", "")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
//                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                .setDecorView(null)
                .build();

    }
    //格式化 time
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

}
