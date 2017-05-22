package com.project.tangyifeng.pizzaproject.b_base.mvpBase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.project.tangyifeng.pizzaproject.R;
import com.project.tangyifeng.pizzaproject.b_global.App;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/22.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements IView {

    protected T mPresenter;
    protected AppCompatActivity mContext;

    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        App.getInstance().addActivity(this);
        mContext = this;
        mPresenter = getPresenter();
        if (isToolbarEnable()) {
            mToolbar = (Toolbar)findViewById(R.id.tool_bar);
        }
        baseInit();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        App.getInstance().finishActivity(this);
    }

    protected void baseInit() {
        if (isToolbarEnable()) {
            initToolbar();
        }
    }

    private void initToolbar(){
        setSupportActionBar(mToolbar);
        mToolbar.setContentInsetsAbsolute(0, 0);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(null);
        }
    }

    protected boolean isToolbarEnable() {
        return false;
    }

    protected abstract T getPresenter();
    protected abstract int getLayout();

    // Remember to add attachView() in BasePresenter.java
    protected abstract void initEventAndData();
}
