package com.example.administrator.toolsmanager;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.example.administrator.toolsmanager.list_activity.gaochong_list;
import com.example.administrator.toolsmanager.list_activity.yazhu_list;
import com.example.administrator.toolsmanager.list_activity.zhuanzi_list;

/**
 * Created by Administrator on 2016/6/24.
 */
public class dianji_activity extends TabActivity {

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
        TabHost.TabSpec page1 = tabHost.newTabSpec("gaochong")
                .setIndicator("高冲")
                .setContent(new Intent(this,gaochong_list.class));
        tabHost.addTab(page1);

        TabHost.TabSpec page2 = tabHost.newTabSpec("yazhu")
                .setIndicator("压铸")
                .setContent(new Intent(this,yazhu_list.class));
        tabHost.addTab(page2);

        TabHost.TabSpec page3 = tabHost.newTabSpec("zhuanzi")
                .setIndicator("转子加工")
                .setContent(new Intent(this,zhuanzi_list.class));
        tabHost.addTab(page3);
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
