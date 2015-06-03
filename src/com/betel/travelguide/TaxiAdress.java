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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TaxiAdress extends Activity {
	final String[] addresses = {
			"Addresses: 40 James's StDublin 8(01) 677 2222", 
			"Addresses: City House, Newmarket SquareDublin(01) 820 2020",
			"Addresses: 8 Main StreetDublin 14(01) 298 8444", 
			"Addresses:Pepper Canister House Mount Street Crescent, Dublin 2(01) 608 0900",
			"Addresses: 6/67, Butterly Business Park Kilmore Rd, Artane, Dublin 5"	
	};
	final String[] phones = {
			"0856772222", 
			"085820 2020",
			" 086298 8444", 
			" 082608 0900",
			"081608 0900"	
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi_adapter);
		
		int index = getIntent().getExtras().getInt("index");
		 TextView addressView = (TextView) findViewById(R.id.taxitViewAdress);
		addressView.setText(addresses[index]);
		
		Button call = (Button) findViewById(R.id.btncall);
		
		 index = getIntent().getExtras().getInt("index");
		 final TextView phone = (TextView) findViewById(R.id.txtTextPhone);
		 phone.setText(phones[index]);
		

		call.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String sPhone = phone.getText().toString();
				if ("".equals(sPhone)) {
					Toast.makeText(TaxiAdress.this,
							"Phone number cannot be blank", Toast.LENGTH_LONG)
							.show();
				} else {
					String sCall = "tel:" + sPhone;
					Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse(sCall));
					startActivity(callIntent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi_adress, menu);
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
