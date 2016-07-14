package com.shishanqing.mvp.presenter;

import android.os.Handler;

import com.shishanqing.mvp.bean.User;
import com.shishanqing.mvp.model.IUserBiz;
import com.shishanqing.mvp.model.LoginListener;
import com.shishanqing.mvp.model.UserBiz;
import com.shishanqing.mvp.view.IUserLoginView;


/**
 * Created by shishanqing on 16-7-14.
 * Presenter用于View和Model之间交互的桥梁
 */
public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView){
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login()
    {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUsername(), userLoginView.getPassword(), new LoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFail()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear()
    {
        userLoginView.clearUsername();
        userLoginView.clearPassword();
    }
}
