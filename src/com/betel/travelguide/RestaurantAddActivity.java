package com.betel.travelguide;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RestaurantAddActivity extends Activity {

	EditText description, address, imageUrl;
	Button add, back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant_add);
		description = (EditText) findViewById(R.id.edt_description);
		address = (EditText) findViewById(R.id.edt_address);
		imageUrl = (EditText) findViewById(R.id.image_url);
		add = (Button) findViewById(R.id.add_restaurant);
		back = (Button) findViewById(R.id.btback);
		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String desc = description.getText().toString();
				String addr = address.getText().toString();
				String imgUrl = imageUrl.getText().toString();

				Item item = new Item(imgUrl, addr, desc);
				RestaurantDataService service = new RestaurantDataService(
						getApplicationContext());
				service.addItem(item);
				Toast.makeText(RestaurantAddActivity.this, "Added to Datbase", Toast.LENGTH_LONG).show();
			}
		});

		back.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent backIntent = new Intent(RestaurantAddActivity.this,
						Admin.class);
				startActivity(backIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.restaurant_add, menu);
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
