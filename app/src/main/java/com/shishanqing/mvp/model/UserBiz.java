package com.shishanqing.mvp.model;

import com.shishanqing.mvp.bean.User;

/**
 * Created by shishanqing on 16-7-14.
 * 实现业务类，实现模拟登陆耗时操作
 */
public class UserBiz implements IUserBiz {

    @Override
    public void login(final String username, final String password, final LoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                //模拟登陆成功
                if ("ssq".equals(username) && "123".equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }else {
                    loginListener.loginFail();
                }
            }
        }.start();
    }
}
