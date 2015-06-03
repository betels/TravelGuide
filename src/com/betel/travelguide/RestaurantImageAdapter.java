package com.betel.travelguide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

@SuppressLint("Instantiatable")
public class RestaurantImageAdapter extends BaseAdapter {
	Context content;
	public Integer[] images = {
			R.drawable.r1, 
			R.drawable.r2,
			R.drawable.r3,
			R.drawable.r4,
			R.drawable.r5,
			R.drawable.r6
			};

	@SuppressLint("Instantiatable")
	public RestaurantImageAdapter(Context content) {
		this.content = content;
	}

	@Override
	public int getCount() {
		return images.length;

	}

	public Object getItem(int position) {
		return images[position];
	}

	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(content);
		imageView.setImageResource(images[position]);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
		return imageView;
	}

}
