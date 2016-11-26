package com.linly.androidutils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.provider.Settings;

/**
 * 网络状态管理类
 * Created by linly on 2016-11-26.
 */

public class NetUtils {
    /**
     * 构造函数私有，防止实例化
     */
    private NetUtils(){

    }

    /**
     * 判断网络是否链接
     * @param context 上下文
     * @return 连接true,未连接false
     */
    public static boolean isConnection(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null == connectivityManager){
            return false;
        }
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(null == info  ){
            return false;
        }
        if (!info.isConnected()){
            return false;
        }
        if(info.getState() == NetworkInfo.State.CONNECTED){
            return true;
        }
        return false;
    }

    /**
     * 连接是否为wifi
     * @param context 上下文
     * @return 无连接返回false,wifi连接返回true
     */
    public static boolean isWifiConnection(Context context){
        ConnectivityManager connect = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(null == connect){
            return false;
        }
        if (connect.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI){
            return true;
        }
        return false;
    }


    /**
     * 打开网络设置界面
     */
    public static void openSetting(Activity activity)
    {
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        activity.startActivityForResult(intent, 0);
    }
}
