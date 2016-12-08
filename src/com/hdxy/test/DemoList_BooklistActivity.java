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
		neirong[0] = "��������ʾ��Ϣ";
		input_time[0] = "û��ʱ��";

		lv.setAdapter(adapter);
		// �б�ļ���
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				//BookListAdapter bookada = new BookListAdapter(null);
				String weizhi = Integer.toString(position);
				Log.e("�����ǵڼ���", weizhi);
				// Book book = bookada.bookList.get(1);
				/*
				 * for (int i = 0; i < position; i++) { Log.e("��ǰ�е�desc",
				 * bookada.bookList.get(i).getDesc()); if (bookada.str[i] ==
				 * null) { String length = Integer.toString(i);
				 * Log.e("�ڵڼ�λʱ����strֵΪnull", length); }
				 * 
				 * if (bookada.notetime[i] == null) { String length =
				 * Integer.toString(i); Log.e("�ڵڼ�λʱ����notetimeֵΪnull", length);
				 * } }
				 */

				// int ת String
				//String length = Integer.toString(bookada.bookList.size());
				

				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						DemoList_BooklistActivity.this);
				builder.setTitle("����ʱ��" + input_time[position]);
				// String s=bookada.str[position];
				builder.setMessage(neirong[position]);
				builder.setNeutralButton("ȷ��",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
							}
						});
				AlertDialog show = builder.create();
				show.show();
			}
		});
		// ���ɾ����ť
		Button btndel = (Button) findViewById(R.id.delbuuton);
		del = (EditText) findViewById(R.id.edtdel);
		btndel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("�����ɾ��", "����ɾ��");
				final String position = del.getText().toString();
				// String ת int
				try{
					 number3 = Integer.valueOf(position).intValue();
				}catch(Exception e){
					Toast.makeText(getApplicationContext(), "��������ȷ��ɾ������", Toast.LENGTH_SHORT).show();
				}
				
				if (position.length() == 0) {
					Toast.makeText(getApplicationContext(), "������Ҫɾ��������",
							Toast.LENGTH_SHORT).show();
				} else if (number3 > shuzu_count-1) {
					Toast.makeText(getApplicationContext(), "Ҫɾ�����������ܴ����������",
							Toast.LENGTH_SHORT).show();
				} else {
					int number = Integer.valueOf(position).intValue();
					adapter.delbook(number);
					for (int i = number; i < shuzu_count; i++) {
						String izhi = Integer.toString(i);
						Log.e("ɾ��ָ������ʱ��iֵ" + "ɾ��ǰiλ�õ�ֵ", izhi + "  "
								+ neirong[i]);
						neirong[i] = neirong[i + 1];
						input_time[i]=input_time[i+1];
						Log.e("ɾ��ָ������ʱ��iֵ" + "ɾ����iλ�õ�ֵ", izhi + "  "
								+ neirong[i]);
						// Log.e("����neirong ����", neirong[i]);

					}
					shuzu_count = shuzu_count - 1;
				}

				// int number2 = Integer.valueOf(position).intValue();

				for (int i = 0; i < shuzu_count; i++) {
					String izhi = Integer.toString(i);
					Log.e("����neirong ����" + "iֵ" + izhi, neirong[i]);
				}

			}
		});
		// �����Ӱ�ť
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
				Log.e("��������", "�������");

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
					Log.e("����neirong ����" + "shuzu count" + shuzu_count,
							neirong[i]);

				}
				shuzu_count = shuzu_count + 1;
				adapter.addBook(new Book("--" + time, information, time));
				add.setText("");
}else{
	Toast.makeText(getApplicationContext(), "�㻹û������Ҫ����������", Toast.LENGTH_SHORT).show();
}
			}
		});
	}

	// �Զ����������
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
			bookList.add(new Book("--������ı�������������ʾ", "none use", "null"));

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

		// book����ӷ���
		public void addBook(Book b) {
			Log.e("��ӵķ���", "������ӷ���");
			bookList.add(b);

			for (int i = 0; i < bookList.size(); i++) {
				Book book = bookList.get(i);

				infor = book.getDesc();
				infor1 = book.getInformation();
				infor2 = book.getTime();
				str[i] = infor1;
				notetime[i] = infor2;
				Log.e("���Book������洢������", infor + " " + infor1 + " " + infor2);
				// Log.e("�������", str[i]);
			}
			// for (int i = 0; i < bookList.size(); i++) {
			// Log.e("�������", str[i]);

			// }
			// for (int i = 0; i < bookList.size(); i++) {

			// Log.e("�������2", notetime[i]);
			// }
			this.notifyDataSetChanged();
		}

		// book��ɾ������
		public void delbook(int id) {
			Log.e("ɾ���ķ���", "����ɾ������");
			bookList.remove(id);
			for (int i = 0; i < bookList.size(); i++) {
				Book book = bookList.get(i);

				infor = book.getDesc();
				infor1 = book.getInformation();
				infor2 = book.getTime();
				str[i] = infor1;
				notetime[i] = infor2;
				Log.e("ɾ��Book������洢������", infor + " " + infor1 + " " + infor2);
				// Log.e("�������", str[i]);
			}
			// for (int i = 0; i < bookList.size(); i++) {
			// Log.e("�������", str[i]);
			// Log.e("�������2", notetime[i]);
			// }
			this.notifyDataSetChanged();
		}
	}

	// �Զ���������Book
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
