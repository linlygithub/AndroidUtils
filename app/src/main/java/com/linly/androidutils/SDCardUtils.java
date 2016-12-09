package com.linly.androidutils;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;
import java.text.DecimalFormat;

/**
 * SD卡辅助类
 * Created by linly on 2016-11-26.
 */

public class SDCardUtils {

    private SDCardUtils(){

    }

    /**
     * 判断sd卡是否挂载
     * @return  布尔值
     */
    public static boolean isSdcardEnable(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取sd卡绝对路径
     * @return
     */
    public static String getSdcardPath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator;
    }

    /**
     * 获取sd卡总容量大小
     * 空闲大小包含不可见的空间,使用getAvailableBytes
     * @return 返回sd卡的可用大小字节数
     */
    public static long getSdcardSize(){
        if(isSdcardEnable()){
            StatFs fs = new StatFs(getSdcardPath());
            return fs.getAvailableBytes();
        }
        return  0;
    }

    public static String convertToString(long fileSize){
        if(fileSize < 0){
            return "0B";
        }
        final String[] Utils = new String[]{"B","KB","MB","GB","TB"};
        int n = (int) (Math.log10(fileSize)/Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(fileSize/Math.pow(1024, n)) + "" + Utils[n];
    }

}
