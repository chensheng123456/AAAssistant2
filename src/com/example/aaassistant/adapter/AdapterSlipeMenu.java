package com.example.aaassistant.adapter;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aaassistant.R;
import com.example.aaassistant.control.SlipeMenuItem;

public class AdapterSlipeMenu extends AdapterBase {

	private Activity mActivity;
	private List<SlipeMenuItem> mList;
	public AdapterSlipeMenu(List<SlipeMenuItem> mSlipeMenuItems,
			Activity activity) {
		super(mSlipeMenuItems, activity);
		mActivity=activity;
		mList=mSlipeMenuItems;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;

		if (convertView == null) {
			holder = new Holder();
			convertView = getLayoutInflater().inflate(
					R.layout.slipemenu_item_list, null);
			holder.tv_item_slipemenu_textName = (TextView) convertView
					.findViewById(R.id.tv_item_slipemenu_textName);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		holder.tv_item_slipemenu_textName.setText(mList.get(position).getTitle());
		return convertView;
	}

	private class Holder {
		TextView tv_item_slipemenu_textName;
	}
}
