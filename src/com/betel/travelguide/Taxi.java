package com.betel.travelguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.AdapterView.OnItemClickListener;

public class Taxi extends Activity {
ListView listView;
	
	final String[] taxiAddress = { 
			"NRC Taxis (National Radio Cabs)", 
			"Eight Twenty Cabs",
			"Dublin Taxis", 
			"LOCAL SOUTHSIDE TAXIS",
			"Xpert Taxis Ltd" 
			};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi);
		ArrayAdapter<String> adapter  = new  ArrayAdapter<String>(this, R.layout.activity_taxi_adress,taxiAddress);
		setContentView(R.layout.activity_shopping);
		listView = (ListView) findViewById(R.id.listViews);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(getApplicationContext(),TaxiAdress.class);
				i.putExtra("name", taxiAddress[position]);
				i.putExtra("index", position);
				startActivity(i);
			}
		});
		
		
		
	}
//	public void onBackPressed() {
//		MainActivity.mam.stop();
//		finish();
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi, menu);
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
}
