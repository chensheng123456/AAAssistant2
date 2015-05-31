package com.example.aaassistant.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class ActivityBase extends Activity {

	public void openActivity( Class<?> cls)
	{
		Intent intent=new Intent(this, cls);
		startActivity(intent);
	}
	
	public void showToast(String text)
	{
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
}
