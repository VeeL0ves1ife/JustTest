package com.hdxy.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ObserveModeActivity extends Activity implements ColorDialog.OnColorSelectedListener {
	private TextView contentView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_observe_mode);
		
		contentView = (TextView)findViewById(R.id.content);
		Button btn = (Button)findViewById(R.id.btn);
		
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ColorDialog dlg = new ColorDialog(ObserveModeActivity.this);
				dlg.setOnColorSelectedListener(ObserveModeActivity.this);
				dlg.show();
			}
			
		});
	}

	@Override
	public void onColorSelected(int color) {
		contentView.setBackgroundColor(color);
	}
}
