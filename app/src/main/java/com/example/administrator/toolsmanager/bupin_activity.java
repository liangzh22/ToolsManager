package com.example.administrator.toolsmanager;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.example.administrator.toolsmanager.list_activity.fuzhoucheng_list;
import com.example.administrator.toolsmanager.list_activity.huosai_list;
import com.example.administrator.toolsmanager.list_activity.qigang_list;
import com.example.administrator.toolsmanager.list_activity.zhuzhoucheng_list;

/**
 * Created by Administrator on 2016/6/24.
 */
public class bupin_activity extends TabActivity {
    public static TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dianji);
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        initTab();


    }
    public void initTab(){
        tabHost=getTabHost();
        TabHost.TabSpec page1 = tabHost.newTabSpec("zhuzhoucheng")
                .setIndicator("主轴承")
                .setContent(new Intent(this,zhuzhoucheng_list.class));
        tabHost.addTab(page1);

        TabHost.TabSpec page2 = tabHost.newTabSpec("fuzhoucheng")
                .setIndicator("副轴承")
                .setContent(new Intent(this,fuzhoucheng_list.class));
        tabHost.addTab(page2);

        TabHost.TabSpec page3 = tabHost.newTabSpec("qigang")
                .setIndicator("气缸")
                .setContent(new Intent(this,qigang_list.class));
        tabHost.addTab(page3);

        TabHost.TabSpec page4 = tabHost.newTabSpec("huosai")
                .setIndicator("活塞")
                .setContent(new Intent(this,huosai_list.class));
        tabHost.addTab(page4);
        TabWidget tabWidget = tabHost.getTabWidget();
        for (int i = 0; i < tabWidget.getChildCount(); i++) {
            View child = tabWidget.getChildAt(i);
            LinearLayout.LayoutParams lp =
                    (LinearLayout.LayoutParams) child.getLayoutParams();
            lp.width = LinearLayout.LayoutParams.MATCH_PARENT;
            lp.height = 120;
            lp.weight = 0.0f;
        }

    }
}
