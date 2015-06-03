package com.betel.travelguide;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ViewAddress extends Activity {
	Button back, btnclear;
	TextView view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_address);

		view = (TextView) findViewById(R.id.taxitViewAdress);
		back = (Button) findViewById(R.id.btback);
		btnclear = (Button) findViewById(R.id.btnclear);
		String query = "Items Records:\n";
		RestaurantDataService db = new RestaurantDataService(ViewAddress.this);
		List<Item> items = db.getItems();

		for (int i = 0; i < items.size(); ++i) {
			query = query + "\n" + items.get(i).toString() + "\n";
		}
		view.setText("" + query);

		back.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent backIntent = new Intent(ViewAddress.this,
						Admin.class);
				startActivity(backIntent);
			}
		});

		btnclear.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				RestaurantDataService db = new RestaurantDataService(
						ViewAddress.this);
				db.deleteAllItems();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_address, menu);
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
