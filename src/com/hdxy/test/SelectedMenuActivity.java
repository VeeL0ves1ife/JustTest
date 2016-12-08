package com.hdxy.test;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;

public class SelectedMenuActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {//�����˵�����
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selected_menu, menu);
		//Item����ĵ�1����Ӧ����
		final MenuItem item=menu.findItem(R.id.Setblank);
		item.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				// TODO Auto-generated method stub
				TextView tv = (TextView) findViewById(R.id.SelectedMenuTextView);
				tv.setTextColor(Color.BLACK);
				//menu.removeItem(R.id.Setblank);
				return false;
			}
		});
		return true;
	}
////Item����ĵ�2����Ӧ����
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.SetBlue: {
			TextView tv = (TextView) findViewById(R.id.SelectedMenuTextView);
			tv.setTextColor(Color.BLUE);
			//item.setEnabled(false);
			return true;
		}
		case R.id.Setred: {
			TextView tv = (TextView) findViewById(R.id.SelectedMenuTextView);
			tv.setTextColor(Color.RED);
			return true;
		}
		case R.id.Setgreen: {
			TextView tv = (TextView) findViewById(R.id.SelectedMenuTextView);
			tv.setTextColor(Color.GREEN);
			return true;
		}
		default: {
			return super.onOptionsItemSelected(item);
		}
		}

	}
//Item����ĵ�3����Ӧ����
	public boolean setLargeSize(MenuItem item) {
		TextView tv = (TextView) findViewById(R.id.SelectedMenuTextView);
		tv.setTextSize(50);
		return true;

	}

	public boolean setSmallSize(MenuItem item) {
		TextView tv = (TextView) findViewById(R.id.SelectedMenuTextView);
		tv.setTextSize(10);
		return true;

	}

	public boolean setnormalSize(MenuItem item) {
		TextView tv = (TextView) findViewById(R.id.SelectedMenuTextView);
		tv.setTextSize(30);
		return true;

	}

	

}
