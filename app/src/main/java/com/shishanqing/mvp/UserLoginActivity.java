package com.shishanqing.mvp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.shishanqing.mvp.bean.User;
import com.shishanqing.mvp.presenter.UserLoginPresenter;
import com.shishanqing.mvp.view.IUserLoginView;

/**
 *Acitvity即是View,在view中实现接口类中的方法
 * 实现一些登陆界面的显示
 * MVP模型：
 * View------------>Presenter----->Model
 *   |-------接口<-----|
 * MVP模式建立步骤：
 * 1.定义一个实体类，即建个数据模型
 * 2.建立View接口（更新ui中的view状态）
 * 3.建立presenter（主导器，通过iView和iModel接口操作model和view），activity可以把所有逻辑给presenter处理，这样java逻辑就从手机的activity中分离出来
 * 4.在Acitivity中调用/实现以上类
 */

public class UserLoginActivity extends ActionBarActivity implements IUserLoginView {

    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews()
    {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.clear();
            }
        });
    }


    @Override
    public String getUsername()
    {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUsername()
    {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword()
    {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading()
    {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user)
    {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError()
    {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
