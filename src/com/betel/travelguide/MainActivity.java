package com.betel.travelguide;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	Button btnShooping, btnRestaurant, btnTaxi, btnHotel;
	ImageButton admin;
	GridView gridView;
	public static MediaPlayer mp = null;
	public static MediaPlayer mam;

	private void hotel() {
		Intent i = new Intent(this, Hotels.class);
		startActivity(i);
	}

	private void restaurant() {
		Intent i = new Intent(this, Restaurant.class);
		startActivity(i);

	}

	private void shooping() {
		Intent i = new Intent(this, Shopping.class);
		startActivity(i);
	}

	private void taxi() {
		Intent i = new Intent(this, Taxi.class);
		startActivity(i);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnShooping = (Button) findViewById(R.id.btnshooping);
		btnRestaurant = (Button) findViewById(R.id.btnrestaurants);
		btnTaxi = (Button) findViewById(R.id.btntaxi);
		btnHotel = (Button) findViewById(R.id.btnhotel);
		admin = (ImageButton) findViewById(R.id.btnadmin);
	
		
		btnShooping.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				shooping();
				if (mam != null) {
					mam.stop();
					mam.release();
				}
				mam = MediaPlayer
						.create(getApplicationContext(), R.raw.shoping);
				mam.start();

			}
		});

		btnRestaurant.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				restaurant();
				if (mam != null) {
					mam.stop();
					mam.release();
				}
				mam = MediaPlayer.create(getApplicationContext(),
						R.raw.restaurant);
				mam.start();

			}
		});

		btnTaxi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				taxi();
				if (mam != null) {
					mam.stop();
					mam.release();
				}
				mam = MediaPlayer.create(getApplicationContext(), R.raw.taxi);
				mam.start();

			}
		});
		
		admin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(MainActivity.this, Login.class);
				startActivity(i);
			}
		});
		
		

		btnHotel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				hotel();
				if (mam != null) {
					mam.stop();
					mam.release();
				}
				mam = MediaPlayer.create(getApplicationContext(), R.raw.hotel);
				mam.start();

			}
		});
		if (mp != null) {
			mp.stop();
			mp.release();
		}
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
