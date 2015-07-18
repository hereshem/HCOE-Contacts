package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DashboardActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		findViewById(R.id.ll_add).setOnClickListener(this);
		findViewById(R.id.ll_del).setOnClickListener(this);
		findViewById(R.id.ll_list).setOnClickListener(this);
		findViewById(R.id.ll_view).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.ll_list:
		Intent i = new Intent(getApplicationContext(), ListViewActivity.class);
		startActivity(i);
		break;
		case R.id.ll_add:
		Intent in = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(in);
		}
	}
}
