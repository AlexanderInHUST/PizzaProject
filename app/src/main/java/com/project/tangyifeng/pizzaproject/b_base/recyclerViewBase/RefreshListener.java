package com.project.tangyifeng.pizzaproject.b_base.recyclerViewBase;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public interface RefreshListener {
    void onRefreshStateChanged(boolean isRefreshing);
    void onError(Throwable t);
}
