package idv.derekhsu.helloword50.data01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by derekhsu on 2016/9/28.
 */

public class PlaceDAO {

    public static final String TABLE_NAME = "place";

    public static final String KEY_ID = "_id";

    public static final String LATITUDE_COLUMN = "latitude";

    public static final String LONGITUDE_COLUMN = "longitude";

    public static final String ACCURACY_COLUMN = "accuracy";

    public static final String DATETIME_COLUMN = "datetime";

    public static final String NOTE_COLUMN = "note";

    public static final String[] COLUMNS = {
            KEY_ID, LATITUDE_COLUMN, LONGITUDE_COLUMN, ACCURACY_COLUMN, DATETIME_COLUMN, NOTE_COLUMN
    };

    public static final String[] SHOW_COLUMNS = {
            KEY_ID, DATETIME_COLUMN, NOTE_COLUMN
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LATITUDE_COLUMN + " REAL NOT NULL, " +
                    LONGITUDE_COLUMN + " REAL NOT NULL, " +
                    ACCURACY_COLUMN + " REAL NOT NULL, " +
                    DATETIME_COLUMN + " TEXT NOT NULL, " +
                    NOTE_COLUMN + " TEXT NOT NULL)";

    private SQLiteDatabase db;

    public PlaceDAO(Context context) {
        db = MyDBHelper.getDatabase(context);
    }

    public Place insert(Place place) {
        ContentValues cv = new ContentValues();

        cv.put(LATITUDE_COLUMN, place.getLatitude());
        cv.put(LONGITUDE_COLUMN, place.getLongitude());
        cv.put(ACCURACY_COLUMN, place.getAccuracy());
        cv.put(DATETIME_COLUMN, place.getDatetime());
        cv.put(NOTE_COLUMN, place.getNote());
        long id = db.insert(TABLE_NAME, null, cv);

        place.setId(id);

        return place;
    }

    public boolean update(Place place) {
        ContentValues cv = new ContentValues();

        cv.put(LATITUDE_COLUMN, place.getLatitude());
        cv.put(LONGITUDE_COLUMN, place.getLongitude());
        cv.put(ACCURACY_COLUMN, place.getAccuracy());
        cv.put(DATETIME_COLUMN, place.getDatetime());
        cv.put(NOTE_COLUMN, place.getNote());

        String where = KEY_ID + "=" + place.getId();

        return db.update(TABLE_NAME, cv, where, null) > 0;
    }

    public boolean delete(long id) {
        String where = KEY_ID + "=" + id;
        return db.delete(TABLE_NAME, where, null) > 0;
    }

    public Cursor getAllCursor() {
        return db.query(TABLE_NAME, SHOW_COLUMNS, null, null, null, null, null);
    }

    public Cursor getSearchCursor(String date) {
        String where = "substr(datetime, 1, 10) = '" + date + "'";
        return db.query(TABLE_NAME, SHOW_COLUMNS, where, null, null, null, null);
    }

    public Place get(long id) {
        Place place = null;

        String where = KEY_ID + " = " + id;
        Cursor result = db.query(TABLE_NAME, COLUMNS, where, null, null, null, null);

        if (result.moveToFirst()) {
            place = getRecord(result);
        }

        result.close();

        return place;
    }

    public void close() {
        db.close();
    }

    public Place getRecord(Cursor cursor) {
        Place result = new Place();

        result.setId(cursor.getLong(0));
        result.setLatitude(cursor.getDouble(1));
        result.setLongitude(cursor.getDouble(2));
        result.setAccuracy(cursor.getDouble(3));
        result.setDatetime(cursor.getString(4));
        result.setNote(cursor.getString(5));

        return result;
    }
}
