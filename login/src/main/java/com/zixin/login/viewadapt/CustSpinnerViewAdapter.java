package com.zixin.login.viewadapt;

import android.databinding.BindingAdapter;

import org.angmarch.views.NiceSpinner;

import java.util.LinkedList;
import java.util.List;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/22.
 */

public class CustSpinnerViewAdapter {
    // 自定义 spanner
    @BindingAdapter(value = {"spinnerData"}, requireAll = false)
    public static void setSpinnerdatas(final NiceSpinner niceSpinner, final List<String> spinnerData) {

        if (spinnerData == null) {
            spinnerData.add("斗鱼tv");
            spinnerData.add("熊猫tv");
            spinnerData.add("龙珠tv");
        }
        List<String> data = new LinkedList<>(spinnerData);

        niceSpinner.attachDataSource(data);

    }

}
