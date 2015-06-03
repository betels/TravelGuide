package com.betel.travelguide;

import java.io.Serializable;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1670608497059028763L;
	
	private String imageUrl;
	private String address;
	private String description;

	public Item() {

	}

	public Item(String imageUrl, String address, String description) {
		this.imageUrl = imageUrl;
		this.address = address;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Data [ imageUrl=" + imageUrl + ", address=" + address
				+ ", description=" + description + ", course=" + "]";
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
