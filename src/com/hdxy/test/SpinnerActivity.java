package com.hdxy.test;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;

public class SpinnerActivity extends Activity {
	private Spinner spinnerprefer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);
		
		spinnerprefer = (Spinner) findViewById(R.id.spinner1);
		final TextView tv=(TextView) findViewById(R.id.spinner_largetextView1);
		String[] movieArray = getResources().getStringArray(R.array.Studed);
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, 
//				android.R.layout.simple_spinner_item, movieArray);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(SpinnerActivity.this,
				android.R.layout.simple_spinner_item, movieArray) {

					@Override
					public View getDropDownView(int position, View convertView,
							ViewGroup parent) {
						View view = getLayoutInflater().inflate(R.layout.spinner_cotainimage_dropdownlayout, parent, false);
						ImageView iv = (ImageView)view.findViewById(R.id.spinner_imageView1);
						if(position == spinnerprefer.getSelectedItemPosition()) {
							iv.setVisibility(View.VISIBLE);
						} else {
							iv.setVisibility(View.INVISIBLE);
						}
						TextView tv = (TextView)view.findViewById(R.id.spinner_textView);
						tv.setText(getItem(position));
						
						return view;
					}
			
		};
		
		spinnerprefer.setAdapter(adapter);
	
		
		//SPINNER列表的监听
		spinnerprefer.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				String sel=parent.getSelectedItem().toString();
				tv.setText("你选择的是\nposition"+position+":"+sel);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
