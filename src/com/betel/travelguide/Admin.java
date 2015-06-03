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

public class Admin extends Activity {
Button btndb,viewbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		btndb = (Button) findViewById(R.id.btndb);
		viewbtn = (Button) findViewById(R.id.btnview);
		
		btndb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				LocationLoader ll = new LocationLoader();
				ll.execute(new String[] {});
			}
		});
		
		viewbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Admin.this, ViewAddress.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
						| Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);

		}
	});

		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
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
	
	private class LocationLoader extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			
			
			Intent i = new Intent(Admin.this,
					RestaurantAddActivity.class);
			startActivity(i);
			return null;
		}
		
	}
	
	private class LocationLoader2 extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			
			
			Intent i = new Intent(Admin.this,
					MainActivity.class);
			startActivity(i);
			return null;
		}
		
	}
}
