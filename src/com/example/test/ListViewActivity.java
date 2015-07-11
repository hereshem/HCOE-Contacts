package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends Activity{
	
	String list[] = new String[]{"Hello", "this", "is", "Android", "Class"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, android.R.id.text1, list){

					@Override
					public View getView(int position, View convertView, ViewGroup parent) {
						
						View view = getLayoutInflater().inflate(R.layout.list_item, null);
						
						// set values
						TextView title = (TextView) view.findViewById(R.id.text1);
						title.setText(list[position]);
						
						return view;
					}
			
		};
		
		
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		
	}
}
