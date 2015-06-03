package com.betel.travelguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.maps.model.LatLng;

public class RestaurantFullDescription extends Activity {
	String[] restaurantAddress = {
			"Restaurant Louis Fitzgerald  Point VillageDublin 1(01) " , 
			"Arlington  at Restaurant College Green, Westmoreland StreetDublin(01) 645 1000", 
			"Generator Restaurant   Dublin Point VillageDublin 1(01) 681 5000", 
			"Westin  Ireland Ltd Castle AveClontarf, Dublin 3(01) 833 2321",
			"The Gibson Restaurant Golden LaneDublin 8(01) 898 2900",
			"The Hilton Restaurant College Green, Westmoreland 8(01) 898 2900"
			};
	LatLng[] latLangs = {
							new LatLng(53.348200, -6.265800),
							new LatLng(53.339442, -6.261306),
							new LatLng(53.3186911831946,-6.3642060756683305),
							new LatLng(53.331009, -6.258452),
							new LatLng(53.348518, -6.228583),
							new LatLng(53.348518, -6.228583) 
						};
	
	String[] url = {
			"http://www.menupages.ie/",
			"http://www.edenrestaurant.ie/",
			"http://www.joburger.ie/bear",
			"http://www.merrionhotel.com/cellar_rest.php",
			"http://www.groupon.ie/",
			"http://dineindublin.ie/"
	};
	
	VideoView vidio;
    MediaController mc;
    Uri uri;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant_full_description);
		final int posistion = getIntent().getExtras().getInt("id");
		TextView address = (TextView) findViewById(R.id.txtViewRestaurantAddress);
		address.setText(restaurantAddress[posistion]);
		Button btnmap = (Button) findViewById(R.id.btnmap);
		
		ImageButton btnurl = (ImageButton) findViewById(R.id.url);
		
		btnurl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url[posistion]));
				startActivity(i);
			}
		});
		
		
		
		btnmap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(RestaurantFullDescription.this,MyMapp.class);
				i.putExtra("latlang",latLangs[posistion]);
				startActivity(i);
			}
		});
			
		if(posistion==5){   
			vidio = (VideoView) findViewById(R.id.restaurantVideo);
			mc = new MediaController(this);
			uri = Uri.parse(("android.resource://"+ getPackageName() + "/" + R.raw.hv));
			vidio.setMediaController(mc);
			vidio.setVideoURI(uri);
			vidio.start();
		} else{
			RestaurantImageAdapter imageAdapter = new RestaurantImageAdapter(this);
			ImageView imageview = (ImageView) findViewById(R.id.fullImageView);
			imageview.setImageResource(imageAdapter.images[posistion]);			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.restaurant_full_description, menu);
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
