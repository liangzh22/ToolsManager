package com.example.administrator.toolsmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/23.
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_DIANJI="create table dianji ("
            +"id integer primary key autoincrement,"
            +"name text,"+"code text,"+"ku integer,"+"fei integer)";
    public static final String CREATE_BUPIN="create table bupin ("
            +"id integer primary key autoincrement,"
            +"name text,"+"code text,"+"ku integer,"+"fei integer)";
    public static final String CREATE_ZONGZHUANG="create table zongzhuang ("
            +"id integer primary key autoincrement,"
            +"name text,"+"code text,"+"ku integer,"+"fei integer)";

    private Context mContext;

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version){
        super(context,name,factory,version);
        mContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_DIANJI);
        db.execSQL(CREATE_BUPIN);
        db.execSQL(CREATE_ZONGZHUANG);
        Toast.makeText(mContext,"创建成功",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
    }


}
