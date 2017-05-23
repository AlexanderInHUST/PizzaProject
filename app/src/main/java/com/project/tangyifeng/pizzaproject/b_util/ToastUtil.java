package com.project.tangyifeng.pizzaproject.b_util;

import android.content.Context;
import android.widget.Toast;

import com.project.tangyifeng.pizzaproject.b_global.AppData;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/23.
 */

public class ToastUtil {

    private static Toast toast = null;

    public static int LENGTH_LONG = Toast.LENGTH_LONG;
    public static int LENGTH_SHORT = Toast.LENGTH_SHORT;
    private static Context CONTEXT = AppData.getContext();

    public static void Exception(Exception e) {
        ToastUtil.TextToast(e.getClass() + ": " + e.getMessage());
    }

    public static void TextToast(CharSequence text) {
        toast = Toast.makeText(CONTEXT, text, LENGTH_SHORT);
        toast.show();
    }

    public static void TextToast(int resId) {
        toast = Toast.makeText(CONTEXT, resId, LENGTH_SHORT);
        toast.show();
    }
}
