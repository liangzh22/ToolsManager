package com.example.administrator.toolsmanager;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.example.administrator.toolsmanager.list_activity.benti_list;
import com.example.administrator.toolsmanager.list_activity.tiaoxin_list;
import com.example.administrator.toolsmanager.list_activity.xingneng_list;

/**
 * Created by Administrator on 2016/6/24.
 */
public class zongzhuang_activity extends TabActivity {

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
        TabHost.TabSpec page1 = tabHost.newTabSpec("benti")
                .setIndicator("本体")
                .setContent(new Intent(this,benti_list.class));
        tabHost.addTab(page1);

        TabHost.TabSpec page2 = tabHost.newTabSpec("tiaoxin")
                .setIndicator("调芯")
                .setContent(new Intent(this,tiaoxin_list.class));
        tabHost.addTab(page2);

        TabHost.TabSpec page3 = tabHost.newTabSpec("xingneng")
                .setIndicator("性能")
                .setContent(new Intent(this,xingneng_list.class));
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
