package com.linly.androidutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import java.util.Set;
import java.util.StringTokenizer;

import static android.R.attr.key;
import static android.R.attr.value;

/**
 * SharedPreferences管理类
 * Created by linly on 2016/11/18.
 */

public class SPUtils {

    private static final String FILE_NAME = "share_data";

    /**
     * 数据写入,采用兼容模式
     * @param context 上下文
     * @param key 键
     * @param value 值 Object类型
     */
    public static Object void put(Context context,String key, Object value){
       SharedPreferences.Editor editor =  context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).edit();


        if(value instanceof String){
            editor.putString(key,(String)value);
        }else if (value instanceof Integer){
            editor.putInt(key, (Integer) value);
        }else if (value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        }else if (value instanceof Float){
            editor.putFloat(key, (Float) value);
        }else if (value instanceof Long){
            editor.putLong(key, (Long) value);
        }else if(value instanceof Set){
            editor.putStringSet(key, (Set<String>) value);
        }

        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    public static Object get(Context context, String key, Object defaultObject){
        SharedPreferences.Editor editor =  context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).edit();
        if(defaultObject instanceof String){
            editor.putString(key, (String) defaultObject);
        }else if (defaultObject instanceof  )
    }
}
