package com.shishanqing.mvp.model;

/**
 * Created by shishanqing on 16-7-14.
 * 抽取一个登陆接口
 */
public interface IUserBiz {
    public void login(String username, String password, LoginListener loginListener);
}
