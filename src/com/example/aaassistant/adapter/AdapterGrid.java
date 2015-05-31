package com.example.aaassistant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.aaassistant.R;

public class AdapterGrid extends BaseAdapter {

	String[] tvNames = { "记录消费", "查询消费", "统计管理", "账本管理", "类别管理", "人员管理" };
	int[] iconIDs = { R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher, };
	private Context context;
	

	public AdapterGrid(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tvNames.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return tvNames[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder;
		
		if(convertView==null)
		{
			holder=new Holder();
			convertView=LayoutInflater.from(context).inflate(R.layout.grid_item_list, null);
			holder.iv_item_grid_icon=(ImageView) convertView.findViewById(R.id.iv_item_grid_icon);
			holder.tv_item_grid_icon=(TextView) convertView.findViewById(R.id.tv_item_grid_icon);
			convertView.setTag(holder);
		}else
		{
			holder=(Holder) convertView.getTag();
		}
		holder.iv_item_grid_icon.setImageResource(iconIDs[position]);
		LayoutParams params=new LayoutParams(150, 150);
		holder.iv_item_grid_icon.setLayoutParams(params);
		holder.iv_item_grid_icon.setScaleType(ScaleType.FIT_XY);
		holder.tv_item_grid_icon.setText(tvNames[position]);
		return convertView;
	}
	
	private class Holder
	{
		ImageView iv_item_grid_icon;
		TextView tv_item_grid_icon;
	}

}
