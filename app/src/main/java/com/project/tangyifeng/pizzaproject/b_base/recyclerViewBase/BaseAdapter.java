package com.project.tangyifeng.pizzaproject.b_base.recyclerViewBase;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    private List<T> dataList;

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        holder.bindData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    public void addData(List<T> data) {
        if (null == dataList) {
            setDataList(data);
        }
        int p = dataList.size();
        data.addAll(data);
        notifyItemChanged(p);
    }

    public void setDataList(List<T> data) {
        dataList = data;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return dataList;
    }
}
