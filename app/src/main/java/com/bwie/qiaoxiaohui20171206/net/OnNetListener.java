package com.bwie.qiaoxiaohui20171206.net;

/**
 * Created by 乔晓慧 on 2017/12/6.
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);
    public void onFailure(Exception e);
}
