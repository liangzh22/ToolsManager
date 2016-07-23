package com.example.administrator.toolsmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.toolsmanager.list_activity.unlogin_activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private Button unlogin;
    private CheckBox rememberPass;
    private MyDataBaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountEdit=(EditText)findViewById(R.id.account);
        passwordEdit=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        unlogin=(Button)findViewById(R.id.unlogin);
        dbHelper=new MyDataBaseHelper(this,"TOOL.db",null,1);
        rememberPass=(CheckBox)findViewById(R.id.remember_pass);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        login.setOnClickListener(this);
        unlogin.setOnClickListener(this);

        boolean isRemember=pref.getBoolean("remember_password",false);
        if(isRemember){
            String account=pref.getString("account","");
            String password=pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login:
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                if(account.equals("user")&&password.equals("1111")){
                    editor=pref.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else{
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent=new Intent(MainActivity.this,login_activity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.unlogin:
                Intent intent=new Intent(MainActivity.this,unlogin_activity.class);
                startActivity(intent);
                finish();
        }
    }
}
