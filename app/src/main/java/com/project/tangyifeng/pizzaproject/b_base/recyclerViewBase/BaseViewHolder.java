package com.project.tangyifeng.pizzaproject.b_base.recyclerViewBase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View viewItem) {
        super(viewItem);
    }

    public BaseViewHolder(ViewGroup viewGroup, int layoutId) {
        super(fromResLayout(viewGroup, layoutId));
    }

    public static View fromResLayout(ViewGroup viewGroup, int layoutId) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
    }

    public static View fromResLyaout(Context context, int layoutId) {
        return LayoutInflater.from(context).inflate(layoutId, null);
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public abstract void bindData(T data);
}
