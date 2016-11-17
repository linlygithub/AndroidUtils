package com.linly.androidutils;

import android.util.Log;

import static android.R.attr.tag;

/**
 * 日志管理类
 * 调用Log方法打印日志
 * Created by linly on 2016/11/17.
 */

public class L {
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;
    private static final int LEVEL = VERBOSE;

    private L(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 详细信息
     * @param tag TAG
     * @param msg Message
     */
    public static void v(String tag,String msg){
        if(LEVEL <= VERBOSE){
            Log.v(tag,msg);
        }
    }

    /**
     * debug级别
     * @param tag TAG
     * @param msg Message
     */
    public static void d(String tag,String msg){
        if(LEVEL <= DEBUG){
            Log.v(tag,msg);
        }
    }

    /**
     * info级别
     * @param tag TAG
     * @param msg Message
     */
    public static void i(String tag,String msg){
        if(LEVEL <= INFO){
            Log.v(tag,msg);
        }
    }

    /**
     * 警告级别
     * @param tag TAG
     * @param msg Message
     */
    public static void w(String tag,String msg){
        if(LEVEL <= WARN){
            Log.v(tag,msg);
        }
    }

    /**
     * 错误级别
     * @param tag TAG
     * @param msg Message
     */
    public static void e(String tag,String msg){
        if(LEVEL <= ERROR){
            Log.v(tag,msg);
        }
    }
}
