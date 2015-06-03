package com.betel.travelguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

public class ShoopingAddress extends Activity {

	final Integer[] images = { R.drawable.sh, R.drawable.sh1, R.drawable.sh2,
			R.drawable.sh3, R.drawable.sh5, R.drawable.sh6 };

	final String[] addresses = { "addresses Blanchardstown Centre",
			"addresses Dundrum Town Centre",
			"addresses Jervis Shopping Centre",
			"addresses Ilac Shopping Centre",
			"addresses Pavilions Shopping Centre" };

	LatLng[] latLangs = { new LatLng(53.348200, -6.265800),
			new LatLng(53.286100, -6.241700),
			new LatLng(53.3186911831946, -6.3642060756683305),
			new LatLng(53.331009, -6.258452), 
			new LatLng(53.348518, -6.228583),
			new LatLng(53.348518, -6.228583) };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_adapter);
		Button btnmap = (Button) findViewById(R.id.btnmap);

		
		String name = getIntent().getExtras().getString("name");
		final int index = getIntent().getExtras().getInt("index");

		ImageView imageView = (ImageView) findViewById(R.id.fullImageViewShop);
		imageView.setImageResource(images[index]);

		TextView addressView = (TextView) findViewById(R.id.txtViewShopAdress);
		addressView.setText(addresses[index]);

		TextView descriptionView = (TextView) findViewById(R.id.txtViewShopDescription);
		descriptionView.setText(name);
		
		
		btnmap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(ShoopingAddress.this,
						MyMapp.class);
				i.putExtra("latlang", latLangs[index]);
				startActivity(i);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shooping_address, menu);
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
