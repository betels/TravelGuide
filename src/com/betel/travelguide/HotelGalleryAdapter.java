package com.betel.travelguide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


@SuppressLint("Instantiatable")
public class HotelGalleryAdapter extends BaseAdapter {
	Context content;

	public Integer[] hotels = { 
			R.drawable.h1,
			R.drawable.h2, 
			R.drawable.h3,
			R.drawable.h4, 
			R.drawable.h5, 
			R.drawable.h6 };

	@SuppressLint("Instantiatable")
	public HotelGalleryAdapter(Context content) {
		this.content = content;
	}

	public int getCount() {
		return hotels.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(content);
		imageView.setImageResource(hotels[position]);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
		return imageView;
	}

}
