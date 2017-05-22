package com.project.tangyifeng.pizzaproject.b_base.mvpBase;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/22.
 */

public abstract class BasePresenter <T extends IView> {

    protected AppCompatActivity mActivity;
    protected Fragment mFragment;
    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    public BasePresenter(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    public BasePresenter(Fragment fragment){
        this.mFragment = fragment;
    }

    public void attachView(T view) {
        mView = view;
    }

    protected void unSubscribe(){
        if(mCompositeSubscription!=null){
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    public void detachView() {
        this.mView = null;
        mActivity = null;
        mFragment = null;
        unSubscribe();
    }
}
