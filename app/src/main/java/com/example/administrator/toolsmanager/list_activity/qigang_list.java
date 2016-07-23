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
public class qigang_list extends AppCompatActivity {
    private String[]qi={"下座","上座","下座圆柱销","下座偏心销","下座防错销"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toollist);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                qi);
        ListView listView=(ListView)findViewById(R.id.tool_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                int i=(int)adapter.getItemId(position);
                String str = qi[i];
                Intent intent=new Intent(getApplicationContext(),showxinxi_activity.class);
                intent.putExtra("name",str);
                intent.putExtra("from",2);
                startActivity(intent);
            }
        });
    }
}
