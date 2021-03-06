package com.betel.travelguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Shopping extends Activity{

	
	ListView listView;
	
	final String[] shooping = { 
			"Blanchardstown Centre", 
			"Dundrum Town Centre",
			"Jervis Shopping Centre", 
			"Ilac Shopping Centre",
			"Pavilions Shopping Centre" 
			};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayAdapter<String> adapter  = new  ArrayAdapter<String>(this, R.layout.activity_shooping_address,shooping);
		setContentView(R.layout.activity_shopping);
		listView = (ListView) findViewById(R.id.listViews);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(getApplicationContext(),ShoopingAddress.class);
				i.putExtra("name", shooping[position]);
				i.putExtra("index", position);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
