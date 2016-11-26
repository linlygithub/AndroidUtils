package com.linly.androidutils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast管理类
 * Created by linly on 2016/11/18.
 */

public class T {
    private static boolean isShow = true;


    /**
     * 私有化构造函数
     */
    private T() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 默认短时间提示
     *
     * @param context 上下文
     * @param msg 信息
     */
    public static void showShort(Context context, CharSequence msg) {
        if (isShow) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 短时间提示
     *
     * @param context 上下文
     * @param msg 信息
     */
    public static void showShort(Context context, int msg) {
        if (isShow) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 长时间提示
     *
     * @param context 上下文
     * @param msg 信息
     */
    public static void showLong(Context context, CharSequence msg) {
        if (isShow) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 长时间提示
     *
     * @param context 上下文
     * @param msg 信息
     */
    public static void showLong(Context context, int msg) {
        if (isShow) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
