package com.example.administrator.toolsmanager.list_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.toolsmanager.R;
import com.example.administrator.toolsmanager.showxinxi_activity;

/**
 * Created by Administrator on 2016/6/24.
 */
public class yazhu_list extends AppCompatActivity {
    private String[]yazhu={"冲头","固定中子","运水管","浇道脱出销","顶杆",
            "可动中子","顶杆导套"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toollist);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                yazhu);
        ListView listView=(ListView)findViewById(R.id.tool_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                int i=(int)adapter.getItemId(position);
                String str =  yazhu[i];
                Intent intent=new Intent(getApplicationContext(),showxinxi_activity.class);
                intent.putExtra("name",str);
                intent.putExtra("from",3);
                startActivity(intent);
            }
        });
    }
}
