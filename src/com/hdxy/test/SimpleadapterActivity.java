package com.hdxy.test;

import java.util.HashMap;
import java.util.LinkedList;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.app.Activity;

public class SimpleadapterActivity extends Activity {

	public String[] itemTEXTUP = new String[] { "这里是大文字", "这里是大文字", "这里是大文字" };
	public String[] itemTEXTDOWN = new String[] { "这里是小文字", "这里是小文字", "这里是小文字" };
	public int[] itempicture = new int[] { R.drawable.qq, R.drawable.v,
			R.drawable.yuanplan };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simpleadapter);
		String[] from = new String[] { "ITEMpicture", "itemtextup",
				"itemtextdown" };
		int[] to = new int[] { R.id.list_imageview,
				R.id.simpleadapter_lisview_textviewUP,
				R.id.simpleadapter_lisview_textviewdown };
		LinkedList<HashMap<String, Object>> datas = new LinkedList<HashMap<String, Object>>();
		for (int i = 0; i < itemTEXTUP.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put(from[0], itempicture[i]);
			map.put(from[1], itemTEXTUP[i] + "第" + i + "行");
			map.put(from[2], itemTEXTDOWN[i] + "第" + i + "行");
			datas.add(map);
		}
		ListView simpleAdapterlistview = (ListView) findViewById(R.id.simpleadapterListView);
		/*ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView233);
		expandableListView.setAdapter(new ArrayAdapter<String>(this,
				R.layout.my_list_view, itemTEXTUP));*/
		simpleAdapterlistview.setAdapter(new SimpleAdapter(
				SimpleadapterActivity.this, datas,
				R.layout.my_simpleadapter_listview, from, to));
		simpleAdapterlistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"你点了第" + position + "行", Toast.LENGTH_SHORT).show();

			}
		});

	}

}
