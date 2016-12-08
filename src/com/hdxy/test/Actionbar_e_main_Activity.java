package com.hdxy.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.View;

public class Actionbar_e_main_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actionbar_e_main_);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actionbar_e_main_, menu);
		return true;
	}
public class MyProvider extends ActionProvider{
private Context context;
	public MyProvider(Context context) {
		super(context);
		this.context=context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateActionView() {
		// TODO Auto-generated method stub
		return null;
	}}
}
