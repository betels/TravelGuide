package com.betel.travelguide;

import java.io.IOException;
import java.util.List;

import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ClosestService extends Activity {
	
	TextView tvAddress;
	TextView tvAccuracy;
	ProgressBar progress;
	Button bStart;
	Button bStop;
	private LocationManager manager;
	private Context mContext = this;
	boolean bDone = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_closest_service);
		
		tvAccuracy = (TextView) findViewById(R.id.textView1);
		tvAddress = (TextView) findViewById(R.id.txtaddressn);
		bStart = (Button) findViewById(R.id.btnstart);
		bStop = (Button) findViewById(R.id.btnstop);
		progress = (ProgressBar) findViewById(R.id.progressBar1);
		
		manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
		progress.setVisibility(View.GONE);
		
		Location startLocation;
		startLocation = manager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
		Geocoder coder = new Geocoder(mContext);
		List <Address> geocodeResults;
		LatLng latLang = null;
		try {
			if (startLocation != null) {
				geocodeResults = coder.getFromLocation(startLocation.getLatitude(), startLocation.getLongitude(), 1);
				for (Address address: geocodeResults) {
					latLang = new LatLng(address.getLatitude(), address.getLongitude());
					int maxLineIndex = address.getMaxAddressLineIndex();
					String fullAddress = "";
					for (int i=0; i<=maxLineIndex; ++i) {
						fullAddress = fullAddress + address.getAddressLine(i) + "\n";
					}
					tvAddress.setText("Last known location:\n" +fullAddress);							
				}
				Intent i = new Intent(ClosestService.this, MyMapp.class);
				i.putExtra("latlang", latLang);
				startActivity(i);				
			}
		} catch (IOException e) {
		}
		if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
	        buildAlertMessageNoGps();
	    }
		bStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					progress.setVisibility(View.VISIBLE);
					bDone = false;
					tvAddress.setText("GPS Loading...Please wait!!!");
					manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
				} else {
					Toast.makeText(ClosestService.this, "GPS is disabled!", Toast.LENGTH_LONG).show();
				}
			}
		});
		bStop.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					progress.setVisibility(View.GONE);
					if (!bDone) {
						tvAddress.setText("Address: N/A");
						bDone = true;
					}
					manager.removeUpdates(locationListener);
				} else {
					Toast.makeText(ClosestService.this, "GPS is disabled!", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	LocationListener locationListener = new LocationListener() {
		@Override
		public void onLocationChanged(Location location) {
			float currentAccuracy = location.getAccuracy();
			tvAccuracy.setText("Accuracy: " +currentAccuracy);
			progress.setVisibility(View.GONE);
			bDone = true;
			Geocoder coder = new Geocoder(mContext);
			List <Address> geocodeResults;
			try {
				
				geocodeResults = coder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
				for (Address address: geocodeResults) {
					int maxLineIndex = address.getMaxAddressLineIndex();
					String fullAddress = "";
					for (int i=0; i<=maxLineIndex; ++i) {
						fullAddress = fullAddress + address.getAddressLine(i) + "\n";
					}
					tvAddress.setText(fullAddress);
				}
				
			} catch (IOException e) {
			}
		}
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
		}
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
		}
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
		}
	};
	
	private void buildAlertMessageNoGps() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
        .setCancelable(false)
        .setPositiveButton("Enable GPS",
                new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent callGPSSettingIntent = new Intent(
                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(callGPSSettingIntent);
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                dialog.cancel();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
