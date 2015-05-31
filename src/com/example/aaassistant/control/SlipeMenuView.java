package com.example.aaassistant.control;

import java.util.ArrayList;
import java.util.List;

import com.example.aaassistant.R;
import com.example.aaassistant.adapter.AdapterSlipeMenu;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SlipeMenuView {

	private List<SlipeMenuItem> mList;
	private boolean isClosed;
	private Activity mActivity;
	private RelativeLayout include_bottombox;
	private ListView listView;
	private OnSlipeMenuListener menuClickListener;
	
	public SlipeMenuView(Activity mActivity)
	{
		this.mActivity=mActivity;
		initConstant();
		initView();
		initListener();
		menuClickListener=(OnSlipeMenuListener)mActivity;
	}
	public void initConstant() {
		mList = new ArrayList<SlipeMenuItem>();
		isClosed = true;
		
	}

	public void initView() {
		include_bottombox = (RelativeLayout) mActivity
				.findViewById(R.id.include_bottombox);
		
		listView=(ListView) include_bottombox.findViewById(R.id.lv_slipeMenu_main_buttom);

	}

	public void initListener() {
		include_bottombox.setOnClickListener(new OnSlipeMenuClickListener());
		include_bottombox.setFocusableInTouchMode(true);
		include_bottombox.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(keyCode==KeyEvent.KEYCODE_MENU&&event.getAction()==KeyEvent.ACTION_UP)
				{
					change();
				}
				return false;
			}
		});
	}

	public void open() {
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.BELOW, R.id.include_top);
		include_bottombox.setLayoutParams(layoutParams);
	}

	public void close() {
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				110);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, R.layout.activity_main);
		include_bottombox.setLayoutParams(layoutParams);
	}

	public void change() {
		if(isClosed)
		{
			open();
			isClosed=false;
		}else
		{
			close();
			isClosed=true;
		}
	}

	public void bindData() {
		listView.setAdapter(new AdapterSlipeMenu(mList, mActivity));
		listView.setOnItemClickListener(new OnSlipeMentItemClickListener());
	}

	public void addData(SlipeMenuItem slipeMenuItem) {
		mList.add(slipeMenuItem);
	}

	private class OnSlipeMenuClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			change();
		}

	}
	
	private class OnSlipeMentItemClickListener implements OnItemClickListener
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			SlipeMenuItem menuItem=(SlipeMenuItem) parent.getItemAtPosition(position);
			menuClickListener.onSlipeMenuItemClick(view, menuItem);
		}
		
	}
	public  interface OnSlipeMenuListener
	{
		public abstract void onSlipeMenuItemClick(View view,SlipeMenuItem item);
	}
}
