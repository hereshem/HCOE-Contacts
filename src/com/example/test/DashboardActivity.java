package com.example.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class DashboardActivity extends Activity implements OnClickListener {

	SharedPreferences pf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		findViewById(R.id.ll_add).setOnClickListener(this);
		findViewById(R.id.ll_del).setOnClickListener(this);
		findViewById(R.id.ll_list).setOnClickListener(this);
		findViewById(R.id.ll_view).setOnClickListener(this);

		pf = PreferenceManager.getDefaultSharedPreferences(
				getApplicationContext());
		tx_pf = (TextView) findViewById(R.id.txt_pref);
		tx_pf.setText(pf.getString("title", "Dashboard"));
		tx_pf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				showDialogBox();
			}
		});
	}
	TextView tx_pf;
	protected void showDialogBox() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		final EditText ed_pf = new EditText(this);
		ed_pf.setText(pf.getString("title", "Dashboard"));
		dialog.setView(ed_pf)
			.setTitle("Set Title")
			.setPositiveButton("Set", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					String data = ed_pf.getText().toString();
					pf.edit().putString("title", data).commit();
					tx_pf.setText(data);
				}
			})
			.setNegativeButton("Cancel", null)
			.create().show();
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
				break;
		}
	}
}
