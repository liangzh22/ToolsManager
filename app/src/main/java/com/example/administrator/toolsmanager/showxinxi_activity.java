package com.example.administrator.toolsmanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
public class showxinxi_activity extends AppCompatActivity {
    private ArrayList<xinxi>xinxiList=new ArrayList<xinxi>();
    @Override
    protected void onCreate(Bundle savedaInstanceState) {
        super.onCreate(savedaInstanceState);
        setContentView(R.layout.xinxi);
        Intent intent = getIntent();
        MyDataBaseHelper dbHelper = new MyDataBaseHelper(this, "TOOL.db", null, 1);

        try {
            String name_get=intent.getStringExtra("name");
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String[] columns = { "name","code","ku","fei" };
            String[] selectionArgs = { name_get };
            int from=intent.getIntExtra("from",0);
            Cursor cursor;
            switch (from){
                case 1:
                    cursor = db.query("zongzhuang", columns,"name=?",selectionArgs, null, null, null);
                    break;
                case 2:
                    cursor = db.query("bupin", columns,"name=?",selectionArgs, null, null, null);
                    break;
                case 3:
                    cursor = db.query("dianji", columns,"name=?",selectionArgs, null, null, null);
                    break;
                default:
                    cursor = db.query("bupin", columns,"name=?",selectionArgs, null, null, null);
                    break;
            }
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            SimpleAdapter adapter = new SimpleAdapter(showxinxi_activity.this, list, R.layout.xinxi_item,
                    new String[]{"name", "code", "ku", "fei"},
                    new int[]{R.id.xinxi_item_1, R.id.xinxi_item_2, R.id.xinxi_item_3, R.id.xinxi_item_4});
            while(cursor.moveToNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put( "name", cursor.getString(cursor.getColumnIndex("name")) );
                map.put( "code", cursor.getString(cursor.getColumnIndex("code")) );
                map.put( "ku", cursor.getInt(cursor.getColumnIndex("ku")) );
                map.put( "fei", cursor.getInt(cursor.getColumnIndex("fei")) );
                list.add(map);
            }
            ListView listview = (ListView) findViewById(R.id.xinxi_list_view);
            listview.setAdapter(adapter);

        }
        catch (Exception e){
            Log.i("exception", e.toString());
        }

    }
}
