package com.betel.travelguide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("Instantiatable")
public class ShoppingAdapter extends BaseAdapter {
	Context content;
	String[] shooping = { 
			"Blanchardstown Centre", 
			"Dundrum Town Centre",
			"Jervis Shopping Centre", 
			"Ilac Shopping Centre",
			"Pavilions Shopping Centre" };
	
	@SuppressLint("Instantiatable")
	public ShoppingAdapter(Context content){
		this.content=content;
	}
	public int getCount() {
		return shooping.length;
	}

	
	public Object getItem(int position) {
		return shooping[position];
	}

	public long getItemId(int position) {
		return 0;
	}


	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(content);
        textView.setText(shooping[position]);  
        textView.setLayoutParams(new LayoutParams(50, 50));
		return textView;
		
	}

}
