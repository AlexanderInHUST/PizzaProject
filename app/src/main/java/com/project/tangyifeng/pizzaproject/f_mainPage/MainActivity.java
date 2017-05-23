package com.project.tangyifeng.pizzaproject.f_mainPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.tangyifeng.pizzaproject.R;
import com.project.tangyifeng.pizzaproject.b_base.mvpBase.BaseActivity;
import com.project.tangyifeng.pizzaproject.b_base.mvpBase.BasePresenter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.tabbar_default;
    }

    @Override
    protected boolean isToolbarEnable() {
        return false;
    }

    @Override
    protected void initEventAndData() {

    }
}
