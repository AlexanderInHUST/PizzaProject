package com.project.tangyifeng.pizzaproject.b_util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.project.tangyifeng.pizzaproject.b_global.AppData;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public class NetworkUtil {

    //TODO permission
    public static boolean checkIsNetworkConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) AppData.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connMgr.getActiveNetworkInfo() != null;
    }

    public static boolean isWlanAvailable() {
        ConnectivityManager manager = (ConnectivityManager) AppData.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        return (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING);
    }
}
