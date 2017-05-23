package com.project.tangyifeng.pizzaproject.b_base.recyclerViewBase;

import com.project.tangyifeng.pizzaproject.b_base.mvpBase.BaseActivity;
import com.project.tangyifeng.pizzaproject.b_base.mvpBase.BasePresenter;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public abstract class BaseListActivity<T extends BaseListPresenter> extends BaseActivity<T>
        implements IRefresh, RefreshListener {

    @Override
    public void refreshTop() {
        mPresenter.refreshTop();
    }

    @Override
    public void refreshBottom() {
        mPresenter.refreshBottom();
    }

    @Override
    public boolean isRefreshing() {
        return mPresenter.isRefreshing();
    }


    @Override
    public abstract void onRefreshStateChanged(boolean isRefreshing);

    @Override
    public abstract void onError(Throwable t);
}
