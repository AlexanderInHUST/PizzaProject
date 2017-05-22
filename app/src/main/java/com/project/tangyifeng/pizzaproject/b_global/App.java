package com.project.tangyifeng.pizzaproject.b_global;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/5/22.
 */

public class App extends Application {

    private static App singleton;
    private static ArrayList<Activity> activityStack;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public static App getInstance() {
        return singleton;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new ArrayList<>();
        }
        activityStack.add(activity);
    }

    public void finishActivity(Activity activity) {
        if (activity != null && activityStack != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    private void finishAllActivity() {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                if (activity != null) {
                    activity.finish();
                }
            }
            activityStack.clear();
        }
    }

    public void AppExit() {
        finishAllActivity();
    }

}
