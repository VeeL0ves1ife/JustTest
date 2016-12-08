package com.hdxy.test;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoComepleteTextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_comeplete_text);
		AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autocomepleteTextView);
		actv.setAdapter(new ArrayAdapter<String>(
				AutoComepleteTextActivity.this,
				android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Studed)));
	}

}
