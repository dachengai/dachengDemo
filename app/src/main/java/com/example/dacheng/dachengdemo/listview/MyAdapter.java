package com.example.dacheng.dachengdemo.listview;

import android.content.Context;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dacheng.dachengdemo.R;

import java.util.List;
import java.util.Map;

/**
 * Created by dacheng on 16/5/26.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<Brand> brandsList;
    LayoutInflater mInflater;
    private ArrayMap<Integer,Boolean> selectMap;
    private String mStr;
    public MyAdapter(Context context,List<Brand> mList){
        this.context = context;
        this.brandsList = mList;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for(int i = 0;i < brandsList.size();i++){

        }
    }
    @Override
    public int getCount() {
        return brandsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.item_listview_adapter,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView)convertView.findViewById(R.id.id_name);
            viewHolder.select = (RadioButton)convertView.findViewById(R.id.id_select);
            viewHolder.et = (EditText) convertView.findViewById(R.id.id_et);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.name.setText(brandsList.get(position).getBandname());
        /*if(mSelectposition == position){
            viewHolder.select.setChecked(true);
        }
        else{
            viewHolder.select.setChecked(false);
        }*/
        switch (brandsList.get(position).getType()){
            case 1:
                viewHolder.et.setVisibility(View.VISIBLE);
                break;
            case 0:
                viewHolder.et.setVisibility(View.GONE);
                break;
            default:
                break;
        }
        return convertView;
    }

    public void setSelectionPosition(int pos){
        if(pos > -1){
          //  mSelectposition = pos;
        }
    }

    public String getEditText(){
        return mStr;
    }
    public class ViewHolder{
        TextView name;
        RadioButton select;
        EditText et;
    }
}


