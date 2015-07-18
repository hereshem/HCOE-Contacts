package com.example.test;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btn_submit;
	EditText edt_name;
	String name, email, phone;
	
	HTTPConnection http;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_submit = (Button) findViewById(R.id.button1);
		edt_name = (EditText) findViewById(R.id.editText1);
		
		http = new HTTPConnection(getApplicationContext());
		
		btn_submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				name = edt_name.getText().toString();
				EditText e = (EditText) findViewById(R.id.editText2);
				email = e.getText().toString();
				phone = ((EditText) findViewById(R.id.editText3)).
						getText().toString();
				
				showToast("Your name is " + name + ", email is " + email + ", phone is " + phone);
				
//				Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//				intent.putExtra("name", name);
//				intent.putExtra("email", email);
//				intent.putExtra("phone", phone);
//				
//				startActivity(intent);
				
				
				task.execute();
				
			}
		});
	}

	AsyncTask<Void, Void, String> task  = new AsyncTask<Void, Void, String>(){

		@Override
		protected String doInBackground(Void... arg0) {
			ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			
			params.add(new BasicNameValuePair("action", "add"));
			params.add(new BasicNameValuePair("c_fname", name));
			params.add(new BasicNameValuePair("n_home", email));
			params.add(new BasicNameValuePair("n_mobile", phone));
			
			String data = http.getHTTPData("http://pi.hemshrestha.com.np/test/contacto.php"
					, params);
			return data;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			showToast("Result = " + result);
		}
		
		
	};
	
	private void showToast(String name) {
		Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
	}
	
	
	
	
	
}
