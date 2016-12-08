package com.hdxy.test;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SQLliteActivity extends Activity {
private SQLiteDatabase db=null;
private final static String create_table="CREATE TABLE table01(_store_name String,acountofyear INTERGER,date TEXT)";
Button add,del,update,search;
EditText store_name,acountofyear,year,addinfo,delinfo,sreachinfo;
String addallinfo;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqllite);
		 store_name=(EditText) findViewById(R.id.dbeditstore_name);
		final String store_name_str=store_name.getText().toString();
		
		final String yeardate=((EditText) findViewById(R.id.dbyear)).getText().toString();
		add=(Button) findViewById(R.id.dbbuttonadd);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				acountofyear=(EditText) findViewById(R.id.dbedtacount_year);
				final int acountofyear_folat=Integer.valueOf(acountofyear.getText().toString()).intValue() ;
				try{
				db=openOrCreateDatabase("db.db", MODE_PRIVATE, null);
				db.execSQL(create_table);
				addallinfo="INSERT INTO table01(store_name,acountofyear,date)values('"+store_name_str+"',"+acountofyear_folat+",'"+yeardate+"')";
				db.execSQL(addallinfo);
				}catch(Exception e){
					Log.e("chu", "chucuole");
				}
			}
		});
}
}
