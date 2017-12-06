package com.bwie.qiaoxiaohui20171206.presenter;

import com.bwie.qiaoxiaohui20171206.bean.ClassBean;
import com.bwie.qiaoxiaohui20171206.model.IMainModel;
import com.bwie.qiaoxiaohui20171206.model.MainModel;
import com.bwie.qiaoxiaohui20171206.net.OnNetListener;
import com.bwie.qiaoxiaohui20171206.view.IMainActivity;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/6.
 */

public class MainPresenter {
    public IMainModel iMainModel;
    public IMainActivity iMainActivity;

    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iMainModel = new MainModel();
    }
    public void getData(){
        iMainModel.recy(new OnNetListener<ClassBean>() {
            @Override
            public void onSuccess(ClassBean classBean) {
                iMainActivity.showrecy(classBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    public void getMore(){
        iMainModel.recy(new OnNetListener<ClassBean>() {
            @Override
            public void onSuccess(ClassBean classBean) {
                iMainActivity.showrecys(classBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
