package com.hdxy.test;

import java.util.Calendar;

import android.os.Bundle;
import android.os.Handler;
//import android.view.Gravity;
//import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends Activity {

	public static class DatePickerFragment extends DialogFragment implements
			DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// TODO Auto-generated method stub

			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			DatePickerDialog t = new DatePickerDialog(getActivity(), this,
					year, month, day);
			return t;
		}

		@Override
		public void onDateSet(DatePicker v, int year, int month, int day) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(),
					"你选的日期是" + year + "年" + month + "月" + day + "日",
					Toast.LENGTH_SHORT).show();
		}

	}

	private ListView listprefer;
	Intent it = new Intent();
	public String[] dialog = new String[] { "SingleChoiceItems",
			"MultiChoiceItems", "DatePickerFragment", "ProgressDialog",
			"MyDialog" };
	public String[] learend = /* getResources().getStringArray(R.array.Studed); */new String[] {
			"Intent", "AlertDialog", "AutoComepleteTextView", "Progressbar",
			"MyToast", "ItemDialog", "SingleChoiceItems", "MultiChoiceItems",
			"DatePickerFragment", "ProgressDialog", "MyDialog", "Notification",
			"Spinner", "SimpleAdapterlistview", "ContextMenu",
			"DemoList_BooklistActivity","TabHost" ,"ExpandableListViewActivity",
			"SelectedMenuActivity","ObserveMode","My_ExpandableList","ContextClassTest,第九章菜单练习","Actionbar_e_main_Activity","SQLlite"};

	public void alertdialog(int itemposition) {
		final AlertDialog.Builder buildermore = new AlertDialog.Builder(
				MainActivity.this);
		switch (itemposition) {
		case 5: {
			buildermore.setItems(dialog, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub

				}
			});
			break;

		}
		case 6: {
			buildermore.setSingleChoiceItems(dialog, 0,
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub

						}
					});
			break;
		}
		case 7: {
			buildermore.setMultiChoiceItems(dialog, new boolean[] { false,
					false, false, false, false },
					new DialogInterface.OnMultiChoiceClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int arg1,
								boolean arg2) {
							// TODO Auto-generated method stub

						}
					});
			break;
		}
		case 8: {
			DatePickerFragment dpf = new DatePickerFragment();
			dpf.show(getFragmentManager(), "datePicker");
			break;
		}
		case 9: {
			final Handler mytimePickerHandler = new Handler();
			final ProgressDialog pb = new ProgressDialog(MainActivity.this);
			pb.setTitle("Title");
			pb.setMax(100);
			pb.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pb.show();

			new Thread() {
				@Override
				public void run() {
					for (int i = 0; i <= 100; i++) {
						try {
							Thread.sleep(100);
						} catch (Exception e) {
						}
						final int setprogress = i;
						mytimePickerHandler.post(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								pb.setProgress(setprogress);
								if (setprogress == 100) {
									Toast.makeText(getApplicationContext(),
											"读条结束了gg", Toast.LENGTH_SHORT)
											.show();
								}
							}
						});
					}

					pb.dismiss();

				}
			}.start();
			break;
		}
		case 10: {
			break;
		}

		}
		AlertDialog showitem = buildermore.create();
		showitem.show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listprefer = (ListView) findViewById(R.id.lv);
		ArrayAdapter<String> adapterlearend = new ArrayAdapter<String>(this,
				R.layout.my_list_view, learend);
		listprefer.setAdapter(adapterlearend);
		listprefer.setOnItemClickListener(myLister);
	}

	private OnItemClickListener myLister = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> prant, View v, int position,
				long id) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0: {
				it.setClass(getApplicationContext(), IntentActivity.class);
				startActivity(it);
				// Toast.makeText(getApplicationContext(),
				// "Intent就不用展示了吧",Toast.LENGTH_SHORT).show();
				break;
			}
			case 1: {
				final AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("AlertDialog");

				builder.setMessage("查看代码详情点击确定");
				builder.setNeutralButton("Cancle",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {

							}
						});
				builder.setNegativeButton("Yes",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								it.setClass(getApplicationContext(),
										AlertDialogActivity.class);
								startActivity(it);
							}
						});
				builder.setPositiveButton("No",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {

							}
						});
				AlertDialog show = builder.create();
				show.show();
				break;
			}
			case 2: {
				it.setClass(getApplicationContext(),
						AutoComepleteTextActivity.class);
				startActivity(it);
				break;
			}
			case 3: {
				it.setClass(getApplicationContext(), ProgressbarActivity.class);
				startActivity(it);
				break;
			}
			case 4: {

				Toast.makeText(MainActivity.this, "MyToast", Toast.LENGTH_SHORT)
						.show();
				break;
			}
			case 5: {// itemdialog
				alertdialog(5);
				break;
			}
			case 6: {// singlechoicedialog
				alertdialog(6);
				break;
			}
			case 7: {// Multichociedialog
				alertdialog(7);
				break;
			}
			case 8: {// Timedatapickerdialog
				alertdialog(8);
				break;
			}
			case 9: {// progressdialog
				alertdialog(9);
				break;
			}
			case 10: {// mydialog
				alertdialog(10);
				break;
			}
			case 11: {// notication
				// Intent intent=new Intent();
				// intent.setClass(getApplicationContext(),
				// NotificationActivity.class);
				PendingIntent pi = PendingIntent.getActivity(MainActivity.this,
						0, getIntent(), 0);
				Notification.Builder notificationBuilder = new Notification.Builder(
						MainActivity.this);
				notificationBuilder.setTicker("Ticker");
				notificationBuilder.setContentTitle("Title");
				notificationBuilder.setContentText("Text");
				notificationBuilder.setContentIntent(pi);
				notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
				Notification notification = notificationBuilder
						.getNotification();
				notification.flags |= Notification.FLAG_AUTO_CANCEL;
				// String notificationService = Context.NOTIFICATION_SERVICE;
				NotificationManager notificationManerager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				notificationManerager.notify(1, notification);
				break;
			}
			case 12: {// Spinner
				it.setClass(getApplicationContext(), SpinnerActivity.class);
				startActivity(it);
				break;
			}
			case 13: {// SimpleAdapterlistview
				it.setClass(getApplicationContext(),
						SimpleadapterActivity.class);
				startActivity(it);
				break;
			}
			case 14: {// ContextMenu
				it.setClass(getApplicationContext(), ContextMenuActivity.class);
				startActivity(it);
				break;
			}
			case 15: {// DemoList_BooklistActivity
				it.setClass(getApplicationContext(),
						DemoList_BooklistActivity.class);
				startActivity(it);
				break;
			}
			case 16:{//TabHost
				it.setClass(getApplicationContext(),
						TabHostActivity.class);
				startActivity(it);
				break;
			}
			case 17:{//expandableListView
				it.setClass(getApplicationContext(),
						ExpandableListViewActivity.class);
				startActivity(it);
				break;
			}
			case 18:{//SelectedMenuActivity
				it.setClass(getApplicationContext(),
						SelectedMenuActivity.class);
				startActivity(it);
				break;
			}
			case 19:{//ObserveModeActivity
				it.setClass(getApplicationContext(),
						ObserveModeActivity.class);
				startActivity(it);
				break;
			}
			case 21:{//ContextClassTestActivity
				it.setClass(getApplicationContext(),
						ContextClassTestActivity.class);
				startActivity(it);
				break;//Actionbar_e_main_Activity
			}
			case 22:{//Actionbar_e_main_Activity SQLliteActivity
				it.setClass(getApplicationContext(),
						Actionbar_e_main_Activity.class);
				startActivity(it);
				break;
			}
			case 23:{//SQLliteActivity
				it.setClass(getApplicationContext(),
						SQLliteActivity.class);
				startActivity(it);
				break;
			}
			}

		}
	};

}
