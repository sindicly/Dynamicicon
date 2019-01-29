package com.example.it_android.dynamicicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MyClick(View v) {
        PackageManager pm = getPackageManager();
        ComponentName oldCN = new ComponentName(getPackageName(), "com.example.it_android.dynamicicon.IconAlias");
        ComponentName newCN = new ComponentName(getPackageName(), "com.example.it_android.dynamicicon.IconAliaNew");
        switch (v.getId()) {
            case R.id.oldIcon:
                //去除旧图标，不去除的话会出现2个App图标
                pm.setComponentEnabledSetting(oldCN, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                pm.setComponentEnabledSetting(newCN, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                break;
            case R.id.newIcon:
                //显示新图标
                pm.setComponentEnabledSetting(newCN, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                pm.setComponentEnabledSetting(oldCN, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                break;
        }
    }

}
