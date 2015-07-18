package com.example.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
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
	
	List<Students> listStudent = new ArrayList<Students>();
	HTTPConnection http;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		http = new HTTPConnection(getApplicationContext());
		
		if(http.isNetworkConnected()){
			task.execute();
		}
		else{
			Toast.makeText(getApplicationContext(), "No internet connection"
					, Toast.LENGTH_LONG).show();
		}
	}
	
	AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>(){

		@Override
		protected String doInBackground(Void... arg0) {
			String data = http.getHTTPData("http://pi.hemshrestha.com.np/test/contacto.php?action=list");
			return data;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			populateList(result);
			displayList();
		}
		
	};


	protected void populateList(String result) {
		try{
			JSONObject jObj = new JSONObject(result);
			String res = jObj.getString("res");
			if(!res.equals("success")){
				Toast.makeText(getApplicationContext(), "JSON Error", Toast.LENGTH_SHORT).show();
				return;
			}
			
			JSONArray data = jObj.getJSONArray("data");
			for (int i = 0; i < data.length(); i++) {
				JSONObject student = data.getJSONObject(i);
				String name = student.getString("c_fname");
				Students st = new Students(name, student.getString("n_home")
						, student.getString("n_mobile"), student.getString("n_office"), "");
				
				listStudent.add(st);
				
			}
			
			
		}catch(Exception e){}
	}


	protected void displayList() {
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
