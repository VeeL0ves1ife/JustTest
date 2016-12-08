package com.hdxy.test;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ContextClassTestActivity extends Activity {
	public TextView clasststlongclicktv, DEL_ADD_textview;
	public Button clasststButton,delbutton;
	public ToggleButton clasststToggleButton;
	private ContextMenu contextmenu;
	private Menu menu;
	public static final int context_class_test_menu1 = Menu.FIRST;
	public static final int context_class_test_menu2 = Menu.FIRST + 1;
	public static final int context_class_test_menu3 = Menu.FIRST + 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_class_test);

		DEL_ADD_textview = (TextView) findViewById(R.id.context_Class_Test_delandadd);
		clasststButton = (Button) findViewById(R.id.context_Class_Test_button1);
		delbutton=(Button) findViewById(R.id.context_Class_Test_buttondel);
		clasststToggleButton = (ToggleButton) findViewById(R.id.context_Class_Test_toggleButton1);
		clasststlongclicktv = (TextView) findViewById(R.id.context_Class_Test_TextView);
		registerForContextMenu(clasststlongclicktv);// 注册长按菜单事件
		delbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//try{
				menu.removeItem(context_class_test_menu1);
				//}catch(Exception e){
					//Toast.makeText(getApplicationContext(), "没有找到该菜单", Toast.LENGTH_SHORT).show();
				//}
			}
		});
		clasststToggleButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e("test", "点击开关");
			}
		});

		clasststButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				//contextmenu.add(0, context_class_test_menu1, 0,
			//			"menu1" + Math.random());
			//	contextmenu.add(1, context_class_test_menu2, 1,
				//		"menu2" + Math.random());
			//	contextmenu.add(2, context_class_test_menu3, 2,
			//			"menu3" + Math.random());
				menu.add(0,context_class_test_menu1, 0, "newmenu"+Math.random());
				Log.e("test", "完成添加");

			}
		});
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// MenuItem itemcenter=menu.findItem(R.id.Center);
		// itemcenter.setEnabled(false);
		menu.findItem(R.id.context_class_test_add).setEnabled(clasststToggleButton.isChecked());
		Log.e("test", "onPrepareOptionsMenu");
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.long_click_context, menu);
		//menu.setHeaderIcon(R.drawable.qq);
		menu.setHeaderTitle("选项菜单");//设置菜单标题
		this.contextmenu = menu;
		
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.context_class_test, menu);
		this.menu = menu;
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.context_class_test_add: {
			DEL_ADD_textview.setVisibility(View.VISIBLE);
			break;
		}
		case R.id.context_class_test_delete: {
			DEL_ADD_textview.setVisibility(View.INVISIBLE);
			break;
		}
		case R.id.context_class_test_update: {
			DEL_ADD_textview.setText("文本改变了");
			break;
		}
		case R.id.context_class_test_search: {
			break;
		}
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.Center: {
			clasststlongclicktv.setGravity(Gravity.CENTER);
			break;
		}
		case R.id.LeftTop: {
			clasststlongclicktv.setGravity(Gravity.LEFT | Gravity.TOP);
			break;
		}
		case R.id.RightTop: {
			clasststlongclicktv.setGravity(Gravity.RIGHT | Gravity.TOP);
			break;
		}
		case R.id.LeftBotton: {
			clasststlongclicktv.setGravity(Gravity.LEFT | Gravity.BOTTOM);
			break;
		}
		case R.id.RightBotton: {
			clasststlongclicktv.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
			break;
		}

		}
		return super.onContextItemSelected(item);
	}

}
