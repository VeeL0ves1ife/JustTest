package com.hdxy.test;

import java.util.LinkedList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;

public class ExpandableListViewActivity extends Activity {
	private List<GroupList> grouplist = new LinkedList<GroupList>();
	public int[] head = new int[] { R.drawable.ic_launcher, R.drawable.qq,
			R.drawable.v, R.drawable.yuanplan };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_list_view);
		intdata("默认分组一","骚翔","哈哈哈哈h",head[0]);
		intfriends(0, "manman", "happy", head[3]);
		intdata("默认分组二","骚翔","哈哈哈哈h",head[1]);
		intdata("默认分组3","yuanyuan","heihie",head[2]);
		intdata("默认分组4",null,null,head[3]);
		
		// gl01.setGroupname("默认分组2");
		ExpandableListView expandablelistview = (ExpandableListView) findViewById(R.id.expandableListView);
		MyExpandableListViewAdapter adapter = new MyExpandableListViewAdapter(
				ExpandableListViewActivity.this, grouplist);
		expandablelistview.setAdapter(adapter);
	}

	public void intdata(String inputgroupname,String inputfriends,String inputfriendsinfo,int picid) {
		GroupList gl01 = new GroupList();
		gl01.setGroupname(inputgroupname);
		if(inputfriends!=null&&inputfriendsinfo!=null&&picid!=0){
		ChildList cl01 = new ChildList();
		cl01.setHead(picid);
		cl01.setFriends(inputfriends);
		cl01.setInfo(inputfriendsinfo);
		gl01.getFriedsinfo().add(cl01);}
		
		
		grouplist.add(gl01);
	}
	public void intfriends(int grouplistposition,String inputfriends,String inputfriendsinfo,int picid){
		ChildList cl01 = new ChildList();
		cl01.setHead(picid);
		cl01.setFriends(inputfriends);
		cl01.setInfo(inputfriendsinfo);
		grouplist.get(grouplistposition).getFriedsinfo().add(cl01);
	}

	// 自定义用于可折叠列表的适配器
	public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {
		private Context context;
		private List<GroupList> groupinfo;

		public MyExpandableListViewAdapter(Context context,
				List<GroupList> groupinfo) {
			this.context = context;
			this.groupinfo = groupinfo;
		}

		@Override
		// 获得子列表的位置 ;
		public Object getChild(int groupPosition, int childPosition) {
			GroupList grouppositioninfo = groupinfo.get(groupPosition);
			return grouppositioninfo.getFriedsinfo().get(childPosition);
		}

		@Override
		// 子列表的id信息
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return childPosition;
		}

		@Override
		// 设置子列表视图
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			ChildList childListinfo = (ChildList) getChild(groupPosition,
					childPosition);
			if (convertView == null) {
				LayoutInflater li = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				convertView = li.inflate(R.layout.expandable_child_listview,
						null);
			}
			ImageView iv = (ImageView) convertView
					.findViewById(R.id.expandable_child_head_imageview);
			iv.setImageResource(childListinfo.getHead());
			TextView tvfriends = (TextView) convertView
					.findViewById(R.id.expandable_child_friends);
			tvfriends.setText(childListinfo.getFriends().trim());
			TextView tvfriendsinfo = (TextView) convertView
					.findViewById(R.id.expandable_child_info);
			tvfriendsinfo.setText(childListinfo.getInfo().trim());
			return convertView;
		}
		@Override
		// 设置父列表的视图
				public View getGroupView(int groupPosition, boolean isExpanded,
						View convertView, ViewGroup parent) {
					GroupList glinfo = (GroupList) getGroup(groupPosition);
					if (convertView == null) {
						LayoutInflater li = (LayoutInflater) context
								.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						convertView = li.inflate(R.layout.expandable_item_group, null);
					}
					TextView tv = (TextView) convertView
							.findViewById(R.id.expandablelistview_group);
					tv.setText(glinfo.getGroupname().trim());
					return convertView;
				}

		@Override
		public int getChildrenCount(int groupPosition) {
			GroupList grouppositioninfo = groupinfo.get(groupPosition);
			return grouppositioninfo.getFriedsinfo().size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return groupinfo.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return groupinfo.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		
		

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isChildSelectable(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return true;
		}

	}

	// 封装列表项数据的类
	public class GroupList {
		private String groupname;
		private List<ChildList> friedsinfo = new LinkedList<ChildList>();

		public String getGroupname() {
			return groupname;
		}

		public void setGroupname(String groupname) {
			this.groupname = groupname;
		}

		public List<ChildList> getFriedsinfo() {
			return friedsinfo;
		}

		public void setFriedsinfo(List<ChildList> friedsinfo) {
			this.friedsinfo = friedsinfo;
		}

	}

	// 封装子列表项数据的类
	public class ChildList {
		private String friends;
		private String info;
		private int head;

		public String getFriends() {
			return friends;
		}

		public void setFriends(String friends) {
			this.friends = friends;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		public int getHead() {
			return head;
		}

		public void setHead(int head) {
			this.head = head;
		}

	}
}
