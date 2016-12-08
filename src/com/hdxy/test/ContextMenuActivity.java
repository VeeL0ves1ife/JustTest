package com.hdxy.test;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

import android.graphics.Color;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContextMenuActivity extends Activity {
	int textsize = 10;
	 
	Button add_test_button;
	TextView longclicktv;
	TextView longcilcktextsize;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_menu);
	    longclicktv = (TextView) findViewById(R.id.longclicktextview);
	    longcilcktextsize=(TextView) findViewById(R.id.textviewsize);
	    add_test_button=(Button) findViewById(R.id.add_test_button);
	    add_test_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//ContextMenu daamenu=new ContextMenu();
				// TODO Auto-generated method stub
				//daamenu.add(4, 511, 4, "改变字体颜色");
			}
		});
		registerForContextMenu(longclicktv);
	}

	protected static final int MENU_CHANGECOLOR = Menu.FIRST;

	 protected static final int menu_changetolargetextsize = Menu.FIRST + 1;
	 protected static final int menu_changetosmalltextsize = Menu.FIRST + 2;

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,/*
															 * source-
															 * implementsmethords
															 * -
															 * onCreateContextMenu
															 * 快捷菜单显示的内容，
															 * 可以使用if语句判断长按的是哪一个视图以显示不同的内容
															 * 。判断的是V
															 */
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		//super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, MENU_CHANGECOLOR, 0, "改变字体颜色");
		 menu.add(0, menu_changetolargetextsize, 1, "增大字体");
		 menu.add(0, menu_changetosmalltextsize, 2, "缩小字体");

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_CHANGECOLOR: {
			longclicktv.setTextColor(Color.RED);
			break;
		}
		case menu_changetolargetextsize: {
			//textsize=++textsize;
			final Handler myHandler = new Handler();
			new Thread() {
				public void run() {

					for (int i = 0; i < 100; i++) {

						try {
							Thread.sleep(100);
						} catch (Exception e) {
							// TODO: handle exception
						}
						final int textsize = i + 1;
						myHandler.post(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
						
								longclicktv.setTextSize(textsize);
								longcilcktextsize.setText("当前字体大小是\n  "+textsize+"  dp");
								Log.e("textsize",String.valueOf(textsize) );
							}
						});
					}

				}

			}.start();
			//for(int textsize=1;textsize<=2000;textsize++){longclicktv.setTextSize(textsize);}
			//longclicktv.setTextSize(textsize);
			
			Toast.makeText(getApplicationContext(),"字体大小是"+textsize, Toast.LENGTH_SHORT).show();
			break;
		}
		case menu_changetosmalltextsize: {
			final Handler myHandler = new Handler();
			new Thread() {
				public void run() {

					for (int i = 99; i > 12; i--) {

						try {
							Thread.sleep(100);
						} catch (Exception e) {
							// TODO: handle exception
						}
						final int textsize = i + 1;
						myHandler.post(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
						
								longclicktv.setTextSize(textsize);
								longcilcktextsize.setText("当前字体大小是\n  "+textsize+"  dp");
								Log.e("textsize",String.valueOf(textsize) );
							}
						});
					}

				}

			}.start();
			//textsize=--textsize;
			//longclicktv.setTextSize(textsize);
			//Toast.makeText(getApplicationContext(),"字体大小是"+textsize, Toast.LENGTH_SHORT).show();
			break;
		}
		}
		return super.onContextItemSelected(item);
	}

}
