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
 * Created by Administrator on 2016/6/25.
 */
public class benti_list extends AppCompatActivity {

    private String[]benti={"锥形管压头","密封圈","间隙检查片","伞形片","顶杆"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toollist);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                benti);
        ListView listView=(ListView)findViewById(R.id.tool_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                int i=(int)adapter.getItemId(position);
                String str =  benti[i];
                Intent intent=new Intent(getApplicationContext(),showxinxi_activity.class);
                intent.putExtra("name",str);
                intent.putExtra("from",1);
                startActivity(intent);
            }
        });
    }
}
