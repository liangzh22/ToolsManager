package com.example.administrator.toolsmanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/24.
 */
public class guanli_activity extends AppCompatActivity implements View.OnClickListener {
    private EditText gai_name;
    private EditText gai_code;
    private EditText gai_in;
    private EditText gai_out;
    private EditText zeng_name;
    private EditText zeng_code;
    private EditText zeng_ku;
    private EditText zeng_fei;
    private EditText shan_name;
    private EditText shan_code;
    private Button gai_ok;
    private Button zeng_ok;
    private Button shan_ok;
    private MyDataBaseHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guanli);
        dbHelper=new MyDataBaseHelper(this,"TOOL.db",null,1);
        gai_name=(EditText)findViewById(R.id.guanli_gai_name);
        gai_code=(EditText)findViewById(R.id.guanli_gai_code);
        gai_in=(EditText)findViewById(R.id.guanli_gai_in);
        gai_out=(EditText)findViewById(R.id.guanli_gai_out);
        zeng_name=(EditText)findViewById(R.id.guanli_zeng_name);
        zeng_code=(EditText)findViewById(R.id.guanli_zeng_code);
        zeng_ku=(EditText)findViewById(R.id.guanli_zeng_in);
        zeng_fei=(EditText)findViewById(R.id.guanli_zeng_out);
        shan_name=(EditText)findViewById(R.id.guanli_shan_name);
        shan_code=(EditText)findViewById(R.id.guanli_shan_code);
        gai_ok=(Button)findViewById(R.id.guanli_gai_ok);
        zeng_ok=(Button)findViewById(R.id.guanli_zeng_ok);
        shan_ok=(Button)findViewById(R.id.guanli_shan_ok);
        gai_ok.setOnClickListener(this);
        zeng_ok.setOnClickListener(this);
        shan_ok.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        switch (v.getId()){
            case R.id.guanli_gai_ok:
                String code=gai_code.getText().toString();
                int in=Integer.parseInt(gai_in.getText().toString());
                int out=Integer.parseInt(gai_out.getText().toString());
                String name=gai_name.getText().toString();
                String kind=code.substring(0,2);
                if(kind.equals("GA")) {
                    Cursor cursor = db.query("zongzhuang", null, "code=?", new String[]{code}, null,
                            null, null);
                    int ku;
                    int fei;
                    if (cursor.moveToFirst()) {
                        do {
                            ku = cursor.getInt(cursor.getColumnIndex("ku"));
                            fei = cursor.getInt(cursor.getColumnIndex("fei"));
                        }while (cursor.moveToNext());
                        int ku_gai = ku + in - out;
                        int fei_gai =fei+out;
                        ContentValues values = new ContentValues();
                        values.put("ku", ku_gai);
                        values.put("fei", fei_gai);
                        db.update("zongzhuang", values, "code=?", new String[]{code});
                        Toast.makeText(this,"修改成功!",Toast.LENGTH_SHORT).show();
                        gai_name.setText("");
                        gai_code.setText("");
                        gai_in.setText("");
                        gai_out.setText("");
                    }
                    cursor.close();
                }
                if(kind.equals("GB")) {
                    Cursor cursor = db.query("bupin", null, "code=?", new String[]{code}, null,
                            null, null);
                    int ku;
                    int fei;
                    if (cursor.moveToFirst()) {
                        do {
                            ku = cursor.getInt(cursor.getColumnIndex("ku"));
                            fei = cursor.getInt(cursor.getColumnIndex("fei"));
                        }while (cursor.moveToNext());
                        int ku_gai = ku + in - out;
                        int fei_gai =fei+out;
                        ContentValues values = new ContentValues();
                        values.put("ku", ku_gai);
                        values.put("fei", fei_gai);
                        db.update("bupin", values, "code=?", new String[]{code});
                        Toast.makeText(this,"修改成功!",Toast.LENGTH_SHORT).show();
                        gai_name.setText("");
                        gai_code.setText("");
                        gai_in.setText("");
                        gai_out.setText("");
                    }
                    cursor.close();
                }
                if(kind.equals("GC")) {
                    Cursor cursor = db.query("dianji", null, "code=?", new String[]{code}, null,
                            null, null);
                    int ku;
                    int fei;
                    if (cursor.moveToFirst()) {
                        do {
                            ku = cursor.getInt(cursor.getColumnIndex("ku"));
                            fei = cursor.getInt(cursor.getColumnIndex("fei"));
                        }while (cursor.moveToNext());
                        int ku_gai = ku + in - out;
                        int fei_gai =fei+out;
                        ContentValues values = new ContentValues();
                        values.put("ku", ku_gai);
                        values.put("fei", fei_gai);
                        db.update("dianji", values, "code=?", new String[]{code});
                        Toast.makeText(this,"修改成功!",Toast.LENGTH_SHORT).show();
                        gai_name.setText("");
                        gai_code.setText("");
                        gai_in.setText("");
                        gai_out.setText("");
                    }
                    cursor.close();
                }
                break;

            case R.id.guanli_zeng_ok:
                String name_zeng=zeng_name.getText().toString();
                String code_zeng=zeng_code.getText().toString();
                int ku_zeng=Integer.parseInt(zeng_ku.getText().toString());
                int fei_zeng=Integer.parseInt(zeng_fei.getText().toString());
                ContentValues values=new ContentValues();
                values.put("name",name_zeng);
                values.put("code",code_zeng);
                values.put("ku",ku_zeng);
                values.put("fei",fei_zeng);
                String kind_zeng=code_zeng.substring(0,2);
                if(kind_zeng.equals("GA")){
                    db.insert("zongzhuang",null,values);
                    Toast.makeText(this,"添加成功!",Toast.LENGTH_SHORT).show();
                    zeng_name.setText("");
                    zeng_code.setText("");
                    zeng_ku.setText("");
                    zeng_fei.setText("");
                }
                if(kind_zeng.equals("GB")){
                    db.insert("bupin",null,values);
                    Toast.makeText(this,"添加成功!",Toast.LENGTH_SHORT).show();
                    zeng_name.setText("");
                    zeng_code.setText("");
                    zeng_ku.setText("");
                    zeng_fei.setText("");
                }
                if(kind_zeng.equals("GC")){
                    db.insert("dianji",null,values);
                    Toast.makeText(this,"添加成功!",Toast.LENGTH_SHORT).show();
                    zeng_name.setText("");
                    zeng_code.setText("");
                    zeng_ku.setText("");
                    zeng_fei.setText("");
                }
                break;

            case R.id.guanli_shan_ok:
                String name_shan=shan_name.getText().toString();
                String code_shan=shan_code.getText().toString();
                String kind_shan=code_shan.substring(0,2);
                if(kind_shan.equals("GA")){
                    db.delete("zongzhuang","code=?",new String[]{code_shan});
                    Toast.makeText(this,"删除成功!",Toast.LENGTH_SHORT).show();
                    shan_name.setText("");
                    shan_code.setText("");
                }
                if(kind_shan.equals("GB")){
                    db.delete("bupin","code=?",new String[]{code_shan});
                    Toast.makeText(this,"删除成功!",Toast.LENGTH_SHORT).show();
                    shan_name.setText("");
                    shan_code.setText("");
                }
                if(kind_shan.equals("GC")){
                    db.delete("dianji","code=?",new String[]{code_shan});
                    Toast.makeText(this,"删除成功!",Toast.LENGTH_SHORT).show();
                    shan_name.setText("");
                    shan_code.setText("");
                }
                break;

        }
    }
}
