package com.betel.travelguide;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class RestaurantDataService extends SQLiteOpenHelper {

	private static final String TABLE_NAME = "Restaurant";
	private static final String ID = "id";
	private static final String IMAGE_URL = "image_url";
	private static final String ADDRESS = "address";
	private static final String DESCRIPTION = "description";

	private static final String[] COLUMNS = { ID, IMAGE_URL, ADDRESS, DESCRIPTION };

	public RestaurantDataService(Context context) {
		super(context, TABLE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String query = "CREATE TABLE IF NOT EXISTS Restaurant ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "image_url TEXT, "
				+ "address TEXT, " + "description TEXT)";

		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLE IF EXISTS Restaurant");

		this.onCreate(db);

	}

	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("image_url", item.getImageUrl());
		values.put("description", item.getDescription());
		values.put("address", item.getAddress());

		db.insert(TABLE_NAME, null, values);
		db.close();

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Item getItem(int id){
		
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, COLUMNS," id = ?", new String[] { String.valueOf(id) },null, null, null, null);
       
        if (cursor != null)
            cursor.moveToFirst();

        Item item = new Item();
        item.setImageUrl(cursor.getString(1));
        item.setAddress(cursor.getString(2));
        item.setDescription(cursor.getString(3));
        
        return item;		
	}

	/**
	 * 
	 * @return
	 */
	public List<Item> getItems() {
		List<Item> items = new LinkedList<Item>();
		String query = "SELECT  * FROM " + TABLE_NAME;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		Item item = null;
		if (cursor.moveToFirst()) {
			do {
				item = new Item();
				item.setImageUrl(cursor.getString(1));
				item.setAddress(cursor.getString(2));
				item.setDescription(cursor.getString(3));

				items.add(item);
			} while (cursor.moveToNext());
		}
		return items;
	}

	public void deleteAllItems() {
		
		 SQLiteDatabase db = this.getWritableDatabase();
	        db.execSQL("DELETE FROM Restaurant");
	        db.close();
		
	}
}
