package com.project.tangyifeng.pizzaproject.b_base.recyclerViewBase;

import com.project.tangyifeng.pizzaproject.R;
import com.project.tangyifeng.pizzaproject.b_base.mvpBase.BaseFragment;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public abstract class BaseListFragment<T extends BaseListPresenter> extends BaseFragment<T>
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
