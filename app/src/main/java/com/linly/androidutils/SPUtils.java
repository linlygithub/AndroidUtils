package com.linly.androidutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import static android.R.attr.defaultValue;
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

    public static void put(Context context, String key, Object value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).edit();


        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set<String>) value);
        }

        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    /**
     *
     * @param context 上下文
     * @param key 键
     * @param defaultValue 默认值
     * @return 返回键所对应的值，如果没有找到则返回默认值
     */
    public static Object get(Context context, String key, Object defaultValue) {
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        if (defaultValue instanceof String) {
            return spf.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return spf.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return spf.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Float) {
            return spf.getFloat(key, (Float) defaultValue);
        } else if (defaultValue instanceof Long) {
            return spf.getLong(key, (Long) defaultValue);
        } else if (defaultValue instanceof Set) {
            return spf.getStringSet(key, (Set<String>) defaultValue);
        }
        return null;
    }

    /**
     * 获取所有键值对
     * @param context 上下文
     * @return 返回map键值对
     */
    public static Map<String,?> getAll(Context context){
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE);
        return spf.getAll();
    }

    /**
     * 清除所有sharedperferences
     * @param context 上下文
     */
    public static void clear(Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.clear();
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    /**
     * sharedperferences中是否包含
     * @param context 上下文
     * @param key 键
     * @return 返回是否存在 boolean
     */
    public static boolean contains(Context context,String key){
        SharedPreferences spf = context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE);
        return spf.contains(key);
    }

    /**
     * 从sharedperferences中移除掉
     * @param context 上下文
     * @param key 键
     */
    public static void remove(Context context,String key){
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.remove(key);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }
}

