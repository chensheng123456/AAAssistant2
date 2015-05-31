package com.example.aaassistant.adapter;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.aaassistant.control.SlipeMenuItem;

public abstract class AdapterBase extends BaseAdapter {
	private List<SlipeMenuItem> mSlipeMenuItems;
	private Activity activity;
	private LayoutInflater layoutInflater;
	
	LayoutInflater getLayoutInflater() {
		layoutInflater=LayoutInflater.from(activity);
		return layoutInflater;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mSlipeMenuItems.size();
	}

	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mSlipeMenuItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	List<SlipeMenuItem> getmSlipeMenuItems() {
		return mSlipeMenuItems;
	}

	void setmSlipeMenuItems(List<SlipeMenuItem> mSlipeMenuItems) {
		this.mSlipeMenuItems = mSlipeMenuItems;
	}

	Activity getActivity() {
		return activity;
	}

	void setActivity(Activity activity) {
		this.activity = activity;
	}

	public AdapterBase(List<SlipeMenuItem> mSlipeMenuItems, Activity activity) {
		this.mSlipeMenuItems = mSlipeMenuItems;
		this.activity = activity;
	}

	
}
