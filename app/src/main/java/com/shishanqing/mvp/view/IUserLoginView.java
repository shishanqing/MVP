package com.shishanqing.mvp.view;

import com.shishanqing.mvp.bean.User;

/**
 * Created by shishanqing on 16-7-14.
 * Presenter和View互通的接口类，主要是View中需要实现些哪些方法
 */
public interface IUserLoginView {

    //该操作需要做什么
    String getUsername();

    String getPassword();

    void clearUsername();

    void clearPassword();

    //该操作过程中对应的友好的交互
    void showLoading();

    void hideLoading();

    //该操作的结果，对应的反馈
    void toMainActivity(User user);

    void showFailedError();
}
