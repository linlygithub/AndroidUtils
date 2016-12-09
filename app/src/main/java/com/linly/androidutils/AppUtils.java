package com.linly.androidutils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import static android.R.attr.id;

/**
 * Created by linly on 2016-12-08.
 */

public class AppUtils {

    public static String getAppName(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            int id = packageInfo.applicationInfo.labelRes;
            L.d("getPackageInfo", context.getResources().getString(id));
            return context.getResources().getString(id);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getAppVersionName(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            String versionName = packageInfo.versionName;
            L.d("versionName", versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
