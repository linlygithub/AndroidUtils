package com.linly.androidutils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import static android.os.Build.VERSION_CODES.M;

/**
 * 屏幕工具类
 * Created by linly on 2016-12-08.
 */

public class ScreenUtils {

    private ScreenUtils() {
    }


    /**
     * 屏幕默认显示大小与屏幕的实际大小不同，因为部分手机有屏幕的装饰部分
     * @param context 上下文信息
     * @return 返回屏幕的宽高信息
     */
    public static DisplayMetrics getScreenMetrics(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        Log.d("getScreenMetrics",""+outMetrics.widthPixels+"\n"+outMetrics.heightPixels);
        return outMetrics;
    }

    /**
     * 返回状态栏的高度
     * @param context 上下文
     * @return 返回状态栏的高度
     */
    public static int getStatusHeight(Context context){
        int height = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object o = clazz.newInstance();
            int id = (int)clazz.getField("status_bar_height").get(o);
            height = context.getResources().getDimensionPixelSize(id);
            L.d("ss",height+"");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return height;
    }
}
