package com.hdxy.test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ColorDialog {
	private Context context;
	private AlertDialog dialog;
	private static final String[] colorNames = new String[] {
			"red color", "blue color", "green color"
	};
	private static final int[] colors = new int[] {
			Color.RED, Color.BLUE, Color.GREEN
	};
	private int selectedPosition = 0;
	
	public static interface OnColorSelectedListener {
		public void onColorSelected(int color);
	}
	private OnColorSelectedListener onColorSelectedListener;
	
	public void setOnColorSelectedListener(OnColorSelectedListener listener) {
		this.onColorSelectedListener = listener;
	}
	
	private class ColorListAdapter extends BaseAdapter {
		private Context context;
		
		public ColorListAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			return colorNames.length;
		}

		@Override
		public Object getItem(int position) {
			return colorNames[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null) {
				String ns = Context.LAYOUT_INFLATER_SERVICE;
				LayoutInflater li = (LayoutInflater)context.getSystemService(ns);
				convertView = li.inflate(R.layout.color_list_item, null);
				
				TextView v = (TextView)convertView.findViewById(R.id.colortextview);
				v.setText(colorNames[position]);
			}
			return convertView;
		}

	}

	
	public ColorDialog(Context context) {
		this.context = context;
		init();
	}
	
	private void init() {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Select Color");
		
		String ns = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater li = (LayoutInflater)context.getSystemService(ns);
		View layout = li.inflate(R.layout.color_dialog, null);
		
		ListView lv = (ListView)layout.findViewById(R.id.colorlistview);
		lv.setAdapter(new ColorListAdapter(context));
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				selectedPosition = position;
			}
		});
		
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(onColorSelectedListener != null)
					onColorSelectedListener.onColorSelected(colors[selectedPosition]);
			}
		});
		
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		
		builder.setView(layout);
		dialog = builder.create();
	}
	
	public void show() {
		dialog.show();
	}
}
