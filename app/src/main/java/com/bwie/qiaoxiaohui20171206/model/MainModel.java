package com.bwie.qiaoxiaohui20171206.model;

import com.bwie.qiaoxiaohui20171206.bean.ClassBean;
import com.bwie.qiaoxiaohui20171206.net.OnNetListener;
import com.bwie.qiaoxiaohui20171206.net.RetrofitHelper;
import com.bwie.qiaoxiaohui20171206.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by 乔晓慧 on 2017/12/6.
 */

public class MainModel implements IMainModel {
    @Override
    public void recy(final OnNetListener<ClassBean> bean) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.call()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ClassBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ClassBean classBean) {
                        bean.onSuccess(classBean);
                    }
                });
    }
}
