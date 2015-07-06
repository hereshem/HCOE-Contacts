package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent intent = getIntent();
		
		String name = intent.getStringExtra("name");
		String email = intent.getStringExtra("email");
		String phone = intent.getStringExtra("phone");
		
		
		TextView txt_name = (TextView) findViewById(R.id.textView3);
		txt_name.setText(name);
		
		
		((TextView)findViewById(R.id.textView5)).setText(email);
		((TextView)findViewById(R.id.textView7)).setText(phone);
		
		
		showToast("From Second Activity ---- Your name is " + name + ", email is " + email + ", phone is " + phone);
		
	}
	private void showToast(String name) {
		Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
	}
	
}
