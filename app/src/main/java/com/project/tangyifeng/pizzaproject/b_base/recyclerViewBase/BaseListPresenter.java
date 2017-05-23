package com.project.tangyifeng.pizzaproject.b_base.recyclerViewBase;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.project.tangyifeng.pizzaproject.R;
import com.project.tangyifeng.pizzaproject.b_base.mvpBase.BasePresenter;
import com.project.tangyifeng.pizzaproject.b_base.mvpBase.IView;
import com.project.tangyifeng.pizzaproject.b_util.NetworkUtil;
import com.project.tangyifeng.pizzaproject.b_util.ToastUtil;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public abstract class BaseListPresenter<T extends IView, D> extends BasePresenter<T> implements IRefresh {

    private int mListPage = INIT_PAGE;
    private static final int INIT_PAGE = 1;
    private boolean isRefreshing = false;

    private RefreshListener listener;

    public BaseListPresenter(AppCompatActivity appCompatActivity, RefreshListener listener) {
        super(appCompatActivity);
        this.listener = listener;
    }

    public BaseListPresenter(Fragment fragment, RefreshListener listener) {
        super(fragment);
        this.listener = listener;
    }

    @Override
    public void refreshTop() {
        if (isRefreshing) {
            return;
        }
        mListPage = INIT_PAGE;
        changeRefreshState(true);
        Subscription subscription = requestData(mListPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    getAdapter().addData(data);
                    changeRefreshState(false);
                }, throwable -> {
                    onError(throwable);
                    changeRefreshState(false);
                });
        addSubscribe(subscription);
    }

    @Override
    public boolean isRefreshing() {
        return isRefreshing;
    }

    private void onError(Throwable t) {
        if (!NetworkUtil.checkIsNetworkConnected()) {
            ToastUtil.TextToast(R.string.no_network);
            return;
        }
        listener.onError(t);
    }

    private void onRefreshStateChanged(boolean isRefreshing) {
        if (listener != null) {
            listener.onRefreshStateChanged(isRefreshing);
        }
    }

    private void changeRefreshState(boolean refreshing) {
        this.isRefreshing = refreshing;
        onRefreshStateChanged(refreshing);
    }

    protected abstract Observable<List<D>> requestData(int page);
    protected abstract BaseAdapter<D> getAdapter();
}
