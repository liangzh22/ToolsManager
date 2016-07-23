package com.example.administrator.toolsmanager;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

/**
 * Created by Administrator on 2016/6/24.
 */
public class login_activity extends TabActivity implements View.OnClickListener {

    public static TabHost tabHost;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_dianji;
    private RadioButton rb_bupin;
    private RadioButton rb_zongzhuang;
    private RadioButton rb_guanli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_dianji = (RadioButton) findViewById(R.id.rb_dianji);
        rb_bupin = (RadioButton) findViewById(R.id.rb_bupin);
        rb_zongzhuang = (RadioButton) findViewById(R.id.rb_zongzhuang);
        rb_guanli = (RadioButton) findViewById(R.id.rb_guanli);
        rb_dianji.setOnClickListener(this);
        rb_bupin.setOnClickListener(this);
        rb_zongzhuang.setOnClickListener(this);
        rb_guanli.setOnClickListener(this);
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
        tabHost.addTab(tabHost.newTabSpec("guanli").setIndicator("管理")
                .setContent(new Intent(this,guanli_activity.class)));
    }
    @Override
    public void onClick(View v) {
        rg_tab_bar.clearCheck();
        switch (v.getId()) {
            case R.id.rb_dianji:
                rb_dianji.setChecked(true);
                tabHost.setCurrentTabByTag("dianji");
                break;
            case R.id.rb_bupin:
                rb_bupin.setChecked(true);
                tabHost.setCurrentTabByTag("bupin");
                break;
            case R.id.rb_zongzhuang:
                rb_zongzhuang.setChecked(true);
                tabHost.setCurrentTabByTag("zongzhuang");
                break;
            case R.id.rb_guanli:
                rb_guanli.setChecked(true);
                tabHost.setCurrentTabByTag("guanli");
                break;
            default:
                break;
        }
    }
}
