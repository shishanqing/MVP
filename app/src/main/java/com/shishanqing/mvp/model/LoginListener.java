package com.shishanqing.mvp.model;

import com.shishanqing.mvp.bean.User;

/**
 * Created by shishanqing on 16-7-14.
 */
public interface LoginListener {
    void loginSuccess(User user);
    void loginFail();
}
