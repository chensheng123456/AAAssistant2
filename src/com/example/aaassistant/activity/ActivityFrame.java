package com.example.aaassistant.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.example.aaassistant.R;
import com.example.aaassistant.control.SlipeMenuItem;
import com.example.aaassistant.control.SlipeMenuView;

public class ActivityFrame extends ActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
	}
	
	public void addMainBody(int resousId)
	{
		LinearLayout linearLayout=(LinearLayout) findViewById(R.id.ll_activity_main_body);
		View view=LayoutInflater.from(this).inflate(resousId, null);
		linearLayout.addView(view);
	}
	
	public void addSlipMenuMain(int pResID)
	{
		SlipeMenuView slipeMenuView=new SlipeMenuView(this);
		String[] arr=getResources().getStringArray(pResID);
		for(int i=0;i<arr.length;i++)
		{
			slipeMenuView.addData(new SlipeMenuItem(i, arr[i]));
		}
		slipeMenuView.bindData();
	}
	
}
