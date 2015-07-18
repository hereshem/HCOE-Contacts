package com.example.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends Activity{
	
	//String list[] = new String[]{"Hello", "this", "is", "Android", "Class"};
	
	List<Students> listStudent = new ArrayList<Students>();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		listStudent.add(new Students("name", "email", "phone", "address", "image"));
		listStudent.add(new Students("name1", "email1", "phone1", "address1", "image1"));
		listStudent.add(new Students("name2", "email2", "phone2", "address2", "image2"));
		listStudent.add(new Students("name3", "email3", "phone3", "address3", "image3"));
		listStudent.add(new Students("name4", "email4", "phone4", "address4", "image4"));
		listStudent.add(new Students("name5", "email5", "phone5", "address5", "image5"));
		listStudent.add(new Students("name6", "email6", "phone6", "address6", "image6"));
		listStudent.add(new Students("name", "email", "phone", "address", "image"));
		listStudent.add(new Students("name1", "email1", "phone1", "address1", "image1"));
		listStudent.add(new Students("name2", "email2", "phone2", "address2", "image2"));
		listStudent.add(new Students("name3", "email3", "phone3", "address3", "image3"));
		listStudent.add(new Students("name4", "email4", "phone4", "address4", "image4"));
		listStudent.add(new Students("name5", "email5", "phone5", "address5", "image5"));
		listStudent.add(new Students("name6", "email6", "phone6", "address6", "image6"));
		

		ArrayAdapter<Students> adapter = new ArrayAdapter<Students>(this,
				R.layout.list_item, android.R.id.text1, listStudent){

					@Override
					public View getView(int position, View convertView, ViewGroup parent) {
						
						View view = getLayoutInflater().inflate(R.layout.list_item, null);
						
						// set values
						Students s = listStudent.get(position);
						
						((TextView) view.findViewById(R.id.textView1)).setText(s.getName());
						((TextView) view.findViewById(R.id.textView2)).setText(s.getEmail());
						((TextView) view.findViewById(R.id.textView3)).setText(s.getAddress());
						((TextView) view.findViewById(R.id.textView4)).setText(s.getPhone());
						
						((ImageView) view.findViewById(R.id.imageView1))
							.setImageResource(position%2 == 0 ?
									R.drawable.ic_launcher : R.drawable.abc_ic_clear);
						
						
						
						return view;
					}
			
		};
		
		
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				Toast.makeText(getApplicationContext(), 
						"You clicked position " + position + " with item name " 
								+ listStudent.get(position).getName()
						, Toast.LENGTH_SHORT).show();
				
			}
		});
		
	}
}
