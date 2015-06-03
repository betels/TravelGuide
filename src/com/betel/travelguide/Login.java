package com.betel.travelguide;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity implements OnClickListener {

	EditText name, pass;
	Button login, cancel,back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		name = (EditText) findViewById(R.id.name);
		pass = (EditText) findViewById(R.id.pass);
		login = (Button) findViewById(R.id.login);
		cancel = (Button) findViewById(R.id.cancel);

		login.setOnClickListener(this);
		cancel.setOnClickListener(this);
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		String namein, passin;

		namein = name.getText().toString();
		passin = pass.getText().toString();

		switch (v.getId()) {
		case R.id.login:

			if (namein.equalsIgnoreCase("ad") && passin.equalsIgnoreCase("ad")) {
				LocationLoader ll = new LocationLoader();
				ll.execute(new String[] {});

			}

			break;
		case R.id.cancel:
			
			name.setText("");
			pass.setText("");
			break;

		default:
			break;
		}
	}

	private class LocationLoader extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			Intent i = new Intent(Login.this, Admin.class);
			startActivity(i);
			return null;
		}

	}
}
