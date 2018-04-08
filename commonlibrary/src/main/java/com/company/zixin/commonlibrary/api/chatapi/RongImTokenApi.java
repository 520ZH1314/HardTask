package com.company.zixin.commonlibrary.api.chatapi;


import com.company.zixin.commonlibrary.model.chatmodel.UserTokenEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 项目名称:HardTask
 * Created by lovezh
 * CreatedData: on 2018/4/8.
 */
 //融云请求用户Token

public interface RongImTokenApi {

    @FormUrlEncoded
    @POST("/user/getToken.json")
    Observable<UserTokenEntity> getRonUserToken(@Field("userId") String userId, @Field("name") String name, @Field("portraitUri") String portraitUri);

}
