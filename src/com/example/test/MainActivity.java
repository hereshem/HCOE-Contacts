package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btn_submit;
	EditText edt_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_submit = (Button) findViewById(R.id.button1);
		edt_name = (EditText) findViewById(R.id.editText1);
		
		btn_submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String name = edt_name.getText().toString();
				EditText e = (EditText) findViewById(R.id.editText2);
				String email = e.getText().toString();
				String phone = ((EditText) findViewById(R.id.editText3)).
						getText().toString();
				
				showToast("Your name is " + name + ", email is " + email + ", phone is " + phone);
				
				Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
				intent.putExtra("name", name);
				intent.putExtra("email", email);
				intent.putExtra("phone", phone);
				
				startActivity(intent);
			}
		});
	}

	private void showToast(String name) {
		Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
	}
}
