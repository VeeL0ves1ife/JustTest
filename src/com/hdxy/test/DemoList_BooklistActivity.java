package com.hdxy.test;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DemoList_BooklistActivity extends Activity {
	String[] neirong = new String[100];
	String[] input_time = new String[100];
	int shuzu_count = 1;
	int number3;
	// Book book=new Book();
	private BookListAdapter adapter;
	EditText add;
	EditText del;

	String time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_list__booklist);
		ListView lv = (ListView) findViewById(R.id.bookview);
		adapter = new BookListAdapter(DemoList_BooklistActivity.this);
		neirong[0] = "第零行提示信息";
		input_time[0] = "没有时间";

		lv.setAdapter(adapter);
		// 列表的监听
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				//BookListAdapter bookada = new BookListAdapter(null);
				String weizhi = Integer.toString(position);
				Log.e("这里是第几行", weizhi);
				// Book book = bookada.bookList.get(1);
				/*
				 * for (int i = 0; i < position; i++) { Log.e("当前行的desc",
				 * bookada.bookList.get(i).getDesc()); if (bookada.str[i] ==
				 * null) { String length = Integer.toString(i);
				 * Log.e("在第几位时数组str值为null", length); }
				 * 
				 * if (bookada.notetime[i] == null) { String length =
				 * Integer.toString(i); Log.e("在第几位时数组notetime值为null", length);
				 * } }
				 */

				// int 转 String
				//String length = Integer.toString(bookada.bookList.size());
				

				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						DemoList_BooklistActivity.this);
				builder.setTitle("备忘时间" + input_time[position]);
				// String s=bookada.str[position];
				builder.setMessage(neirong[position]);
				builder.setNeutralButton("确定",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
							}
						});
				AlertDialog show = builder.create();
				show.show();
			}
		});
		// 点击删除按钮
		Button btndel = (Button) findViewById(R.id.delbuuton);
		del = (EditText) findViewById(R.id.edtdel);
		btndel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("点击了删除", "进入删除");
				final String position = del.getText().toString();
				// String 转 int
				try{
					 number3 = Integer.valueOf(position).intValue();
				}catch(Exception e){
					Toast.makeText(getApplicationContext(), "请输入正确的删除行数", Toast.LENGTH_SHORT).show();
				}
				
				if (position.length() == 0) {
					Toast.makeText(getApplicationContext(), "请输入要删除的行数",
							Toast.LENGTH_SHORT).show();
				} else if (number3 > shuzu_count-1) {
					Toast.makeText(getApplicationContext(), "要删除的行数不能大于最大行数",
							Toast.LENGTH_SHORT).show();
				} else {
					int number = Integer.valueOf(position).intValue();
					adapter.delbook(number);
					for (int i = number; i < shuzu_count; i++) {
						String izhi = Integer.toString(i);
						Log.e("删除指定数据时的i值" + "删除前i位置的值", izhi + "  "
								+ neirong[i]);
						neirong[i] = neirong[i + 1];
						input_time[i]=input_time[i+1];
						Log.e("删除指定数据时的i值" + "删除后i位置的值", izhi + "  "
								+ neirong[i]);
						// Log.e("数组neirong 遍历", neirong[i]);

					}
					shuzu_count = shuzu_count - 1;
				}

				// int number2 = Integer.valueOf(position).intValue();

				for (int i = 0; i < shuzu_count; i++) {
					String izhi = Integer.toString(i);
					Log.e("数组neirong 遍历" + "i值" + izhi, neirong[i]);
				}

			}
		});
		// 点击添加按钮
		Button btnadd = (Button) findViewById(R.id.addbtn);
		add = (EditText) findViewById(R.id.edtaddbookname);
		btnadd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// for(int i=0;i<neirong.length;i++){
				// if(neirong[i]==null){
				// final int shuzusize=i;
				// }
				// }
				Log.e("点击了添加", "进入添加");

				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DATE);
				int hour = cal.get(Calendar.HOUR);
				int min = cal.get(Calendar.MINUTE);
				int sec = cal.get(Calendar.SECOND);
				time = year + "-" + month + 1 + "-" + day + " " + hour + ":"
						+ min + ":" + sec;
				String information = add.getText().toString();
				if(information.length()!=0){
				neirong[shuzu_count] = information;
				input_time[shuzu_count] = time;
				for (int i = 0; i < shuzu_count + 1; i++) {
					Log.e("数组neirong 遍历" + "shuzu count" + shuzu_count,
							neirong[i]);

				}
				shuzu_count = shuzu_count + 1;
				adapter.addBook(new Book("--" + time, information, time));
				add.setText("");
}else{
	Toast.makeText(getApplicationContext(), "你还没有输入要备忘的内容", Toast.LENGTH_SHORT).show();
}
			}
		});
	}

	// 自定义的适配器
	public class BookListAdapter extends BaseAdapter {
		String infor, infor1, infor2;
		private List<Book> bookList = new LinkedList<Book>();
		public String[] str = new String[200];
		public String[] notetime = new String[200];

		private Context context;

		public BookListAdapter(Context context) {
			this.context = context;
			initData();
		}

		private void initData() {
			bookList.add(new Book("--你输入的备忘将在这里显示", "none use", "null"));

		}

		public void jianting() {

		}

		@Override
		public int getCount() {

			String number = Integer.toString(bookList.size());
			Log.e("bookList.size()", number);
			return bookList.size();
		}

		@Override
		public Object getItem(int position) {

			return bookList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			Book b = bookList.get(position);

			String ns = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater li = (LayoutInflater) context.getSystemService(ns);
			View layout = li.inflate(R.layout.booklist_item, null);
			TextView bd = (TextView) layout.findViewById(R.id.books_xiangqing);
			bd.setText(b.getDesc());
			TextView num = (TextView) layout.findViewById(R.id.line_number);
			num.setText(position + " ");

			return layout;
		}

		// book的添加方法
		public void addBook(Book b) {
			Log.e("添加的方法", "进入添加方法");
			bookList.add(b);

			for (int i = 0; i < bookList.size(); i++) {
				Book book = bookList.get(i);

				infor = book.getDesc();
				infor1 = book.getInformation();
				infor2 = book.getTime();
				str[i] = infor1;
				notetime[i] = infor2;
				Log.e("添加Book后里面存储的内容", infor + " " + infor1 + " " + infor2);
				// Log.e("数组遍历", str[i]);
			}
			// for (int i = 0; i < bookList.size(); i++) {
			// Log.e("数组遍历", str[i]);

			// }
			// for (int i = 0; i < bookList.size(); i++) {

			// Log.e("数组遍历2", notetime[i]);
			// }
			this.notifyDataSetChanged();
		}

		// book的删除方法
		public void delbook(int id) {
			Log.e("删除的方法", "进入删除方法");
			bookList.remove(id);
			for (int i = 0; i < bookList.size(); i++) {
				Book book = bookList.get(i);

				infor = book.getDesc();
				infor1 = book.getInformation();
				infor2 = book.getTime();
				str[i] = infor1;
				notetime[i] = infor2;
				Log.e("删除Book后里面存储的内容", infor + " " + infor1 + " " + infor2);
				// Log.e("数组遍历", str[i]);
			}
			// for (int i = 0; i < bookList.size(); i++) {
			// Log.e("数组遍历", str[i]);
			// Log.e("数组遍历2", notetime[i]);
			// }
			this.notifyDataSetChanged();
		}
	}

	// 自定义链表类Book
	public class Book {
		private String desc;
		private String information;
		private String time;

		public Book() {

		}

		public Book(String desc, String information, String time) {
			this.desc = desc;
			this.information = information;
			this.time = time;
		}

		public String getInformation() {
			return information;
		}

		public void setInformation(String information) {
			this.information = information;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

	}
}
