package com.betel.travelguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class HotelFullDescription extends Activity {
	
	String[] hotelsAddress = {
			"Louis Fitzgerald" , 
			"Arlington Hotel at College Green, Westmoreland StreetDublin(01) 645 1000", 
			"Generator Hostel Dublin Point VillageDublin 1(01) 681 5000", 
			"Westin Hotels Ireland Ltd Castle AveClontarf, Dublin 3(01) 833 2321",
			"The Gibson Hotel Golden LaneDublin 8(01) 898 2900",
			"The Hilton Hotel  8(01) 898 2900"
			};
	
	VideoView vidio;
    MediaController mc;
    Uri uri;
    Button btnclose;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hotel_full_description);
         btnclose = (Button) findViewById(R.id.btnclose);
        
         btnclose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				LocationLoader ll = new LocationLoader();
				ll.execute(new String[] {});
			}
		});
		int posistion = getIntent().getExtras().getInt("id");
		TextView address = (TextView) findViewById(R.id.txtViewHotelAddress);
		address.setText(hotelsAddress[posistion]);
		
		
		if(posistion==0){   
			vidio = (VideoView) findViewById(R.id.hotelVideo);
			mc = new MediaController(this);
			uri = Uri.parse(("android.resource://"+ getPackageName() + "/" + R.raw.hv));
			vidio.setMediaController(mc);
			vidio.setVideoURI(uri);
			vidio.start();
		} else{
			HotelGalleryAdapter hotelGallery = new HotelGalleryAdapter(this);
			ImageView imageview = (ImageView) findViewById(R.id.fullImageView);
			imageview.setImageResource(hotelGallery.hotels[posistion]);
					
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hotel_full_description, menu);
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
	
	
	/**
	 * 
	 * @author BETELS
	 *
	 */
	private class LocationLoader extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			Intent i = new Intent(HotelFullDescription.this,ClosestService.class); 
			startActivity(i);
			return null;
		}
		
	}
}
