package com.project.tangyifeng.pizzaproject.b_base.mvpBase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/22.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment
        implements IView {

    protected T mPresenter;
    protected View mView;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayout(), container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mPresenter = getPresenter();
        initEventAndData();
    }

    protected abstract T getPresenter();
    protected abstract int getLayout();

    // Remember to add attachView() in BasePresenter.java
    protected abstract void initEventAndData();
}
