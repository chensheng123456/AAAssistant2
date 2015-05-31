package com.example.aaassistant.activity;

import com.example.aaassistant.R;
import com.example.aaassistant.adapter.AdapterGrid;
import com.example.aaassistant.control.SlipeMenuItem;
import com.example.aaassistant.control.SlipeMenuView.OnSlipeMenuListener;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends ActivityFrame implements OnSlipeMenuListener{

	private GridView gridView;
	private AdapterGrid adapterGrid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addMainBody(R.layout.main_body_grid);
		initConstant();
		initView();
		initListener();
		bindData();
		addSlipMenuMain(R.array.SlipeMenuMainActivity);
	}
	
	public void initConstant()
	{
		adapterGrid=new AdapterGrid(this);
	}
	
	public void initView()
	{
		gridView = (GridView) findViewById(R.id.gv_mainBodyGrid);
	}
	
	public void initListener()
	{
		
	}
	
	public void bindData()
	{
		gridView.setAdapter(adapterGrid);
	}

	@Override
	public void onSlipeMenuItemClick(View view, SlipeMenuItem item) {
		// TODO Auto-generated method stub
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
	}

}
