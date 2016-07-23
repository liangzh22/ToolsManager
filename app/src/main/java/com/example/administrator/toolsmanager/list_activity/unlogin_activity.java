package com.example.administrator.toolsmanager.list_activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.example.administrator.toolsmanager.R;
import com.example.administrator.toolsmanager.bupin_activity;
import com.example.administrator.toolsmanager.dianji_activity;
import com.example.administrator.toolsmanager.zongzhuang_activity;

/**
 * Created by Administrator on 2016/6/25.
 */
public class unlogin_activity extends TabActivity implements View.OnClickListener {

    public static TabHost tabHost;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_dianji;
    private RadioButton rb_bupin;
    private RadioButton rb_zongzhuang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unlogin_activity);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar_u);
        rb_dianji = (RadioButton) findViewById(R.id.rb_dianji_u);
        rb_bupin = (RadioButton) findViewById(R.id.rb_bupin_u);
        rb_zongzhuang = (RadioButton) findViewById(R.id.rb_zongzhuang_u);
        rb_dianji.setOnClickListener(this);
        rb_bupin.setOnClickListener(this);
        rb_zongzhuang.setOnClickListener(this);
        rb_dianji.setChecked(true);
        initTab();

    }
    public void initTab(){
        tabHost=getTabHost();
        tabHost.addTab(tabHost.newTabSpec("dianji").setIndicator("电机")
                .setContent(new Intent(this,dianji_activity.class)));
        tabHost.addTab(tabHost.newTabSpec("bupin").setIndicator("部品")
                .setContent(new Intent(this,bupin_activity.class)));
        tabHost.addTab(tabHost.newTabSpec("zongzhuang").setIndicator("总装")
                .setContent(new Intent(this,zongzhuang_activity.class)));
    }
    @Override
    public void onClick(View v) {
        rg_tab_bar.clearCheck();
        switch (v.getId()) {
            case R.id.rb_dianji_u:
                rb_dianji.setChecked(true);
                tabHost.setCurrentTabByTag("dianji");
                break;
            case R.id.rb_bupin_u:
                rb_bupin.setChecked(true);
                tabHost.setCurrentTabByTag("bupin");
                break;
            case R.id.rb_zongzhuang_u:
                rb_zongzhuang.setChecked(true);
                tabHost.setCurrentTabByTag("zongzhuang");
                break;
            default:
                break;
        }
    }
}
