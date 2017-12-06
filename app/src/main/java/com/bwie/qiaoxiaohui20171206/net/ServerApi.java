package com.bwie.qiaoxiaohui20171206.net;

import com.bwie.qiaoxiaohui20171206.bean.ClassBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 乔晓慧 on 2017/12/6.
 */

public interface ServerApi {
    @GET(Api.URL)
    Observable<ClassBean> call();
}
