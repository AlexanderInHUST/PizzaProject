package com.project.tangyifeng.pizzaproject.b_global;

import android.content.Context;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public class AppData {

    private static Context sContext;

    public static Context getContext(){
        return sContext;
    }

    public static void init(Context context){
        sContext = context;
    }
}
