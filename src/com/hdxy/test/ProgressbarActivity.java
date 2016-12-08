package com.hdxy.test;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class ProgressbarActivity extends Activity {
	Boolean ifkeepprogress = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progressbar);

		final ProgressBar pb = (ProgressBar) findViewById(R.id.progressbar);
		final TextView tvTextView = (TextView) findViewById(R.id.progresstv);
		final Button stopprogressbuton = (Button) findViewById(R.id.stopprogress);
		stopprogressbuton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/* LayoutInflater layout_out = getLayoutInflater();
				 View toast_view = layout_out.inflate(R.layout.my_toast_layout, null);
				 final TextView tv = (TextView) findViewById(R.id.tvmytoast);
				  tv.setText("MyToast");
				  Toast toast = new Toast(ProgressbarActivity.this);
				  toast.setDuration(Toast.LENGTH_SHORT);
				  toast.setView(toast_view);
				  toast.setGravity(Gravity.CENTER, 0, 0);
				  toast.show();*/
				 

				stopprogressbuton.setText("进度被停止");
				ifkeepprogress = false;
			}
		});
		final Handler myHandler = new Handler();
		pb.setMax(100);
		new Thread() {
			public void run() {

				for (int i = 0; i < 100; i++) {

					try {
						Thread.sleep(200);
					} catch (Exception e) {
						// TODO: handle exception
					}while(ifkeepprogress==false){
						//
						Thread.interrupted();
						
					}
					final int p = i + 1;
					myHandler.post(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							pb.setProgress(p);
							tvTextView.setText("当前进度" + p + "%");
							if (p == 100) {
								Intent it = new Intent();
								it.setClass(getApplicationContext(),
										MainActivity.class);
								startActivity(it);
								ProgressbarActivity.this.finish();
							}
						}
					});
				}

			}

		}.start();
	}

}
