package com.bwie.qiaoxiaohui20171206.model;

import com.bwie.qiaoxiaohui20171206.bean.ClassBean;
import com.bwie.qiaoxiaohui20171206.net.OnNetListener;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/6.
 */

public interface IMainModel {
    public void recy(OnNetListener<ClassBean> bean);
}
