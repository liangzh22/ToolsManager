package com.example.administrator.toolsmanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.example.administrator.toolsmanager.R;
import com.example.administrator.toolsmanager.xinxi;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/24.
 */
public class xinxiAdapter extends BaseAdapter {

    private ArrayList<xinxi> mData;
    private Context mContext;

    public xinxiAdapter(ArrayList<xinxi> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public xinxi getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        xinxi xinxi=getItem(position);
        View view;
        if(convertView==null){
            view=LayoutInflater.from(mContext).inflate(R.layout.xinxi_item,null);
        }else{
            view=convertView;
        }
        TextView name=(TextView) view.findViewById(R.id.xinxi_item_1);
        TextView code=(TextView) view.findViewById(R.id.xinxi_item_2);
        TextView in=(TextView) view.findViewById(R.id.xinxi_item_3);
        TextView fei=(TextView) view.findViewById(R.id.xinxi_item_4);
        name.setText(xinxi.getName());
        code.setText(xinxi.getCode());
        in.setText(xinxi.getIn());
        fei.setText(xinxi.getFei());
        return view;
    }
}
