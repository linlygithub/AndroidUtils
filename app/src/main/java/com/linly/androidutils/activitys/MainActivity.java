package com.linly.androidutils.activitys;

import android.app.Activity;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.IntRange;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.linly.androidutils.AppUtils;
import com.linly.androidutils.L;
import com.linly.androidutils.NetUtils;
import com.linly.androidutils.R;
import com.linly.androidutils.SDCardUtils;
import com.linly.androidutils.SPUtils;
import com.linly.androidutils.ScreenUtils;
import com.linly.androidutils.T;

import java.util.HashSet;
import java.util.Set;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;
import static com.linly.androidutils.R.id.bt1;
import static com.linly.androidutils.SDCardUtils.convertToString;
import static com.linly.androidutils.SPUtils.contains;
import static com.linly.androidutils.SPUtils.get;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = getClass().getSimpleName();
    Set<String> set = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button t1 = (Button) findViewById(bt1);
        Button t2 = (Button) findViewById(R.id.bt2);
        Button t3 = (Button) findViewById(R.id.bt3);
        Button t4 = (Button) findViewById(R.id.bt4);
        Button t5 = (Button) findViewById(R.id.bt5);
        Button t6 = (Button) findViewById(R.id.bt6);

        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);

        set.add("haha");
        set.add("hehe");
        set.add("wuwu");
        set.add("xixi");
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case bt1:
                AppUtils.getAppVersionName(this);
                break;
            case R.id.bt2:

                if(NetUtils.isWifiConnection(getApplicationContext())){
                    T.showShort(MainActivity.this,"返回true");
                }else{
                    T.showShort(MainActivity.this,"返回false");
                }
                break;
            case R.id.bt3:
                NetUtils.openSetting(MainActivity.this);
                break;
            case R.id.bt4:
                if (SDCardUtils.isSdcardEnable()){
                    T.showShort(MainActivity.this,"返回true");
                }
                L.d("getSdcardPath",SDCardUtils.getSdcardPath());
                break;
            case R.id.bt5:
                SDCardUtils.getSdcardSize();
                break;
            case R.id.bt6:
                break;

        }
    }
}
