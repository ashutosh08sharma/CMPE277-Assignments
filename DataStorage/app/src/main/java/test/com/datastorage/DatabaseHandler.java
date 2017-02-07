package test.com.datastorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

/**
 * Created by Ashutosh on 9/28/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CMPE277.db";
    private static final int DATABASE_VERSION = 1;
    public static final String PERSON_TABLE_NAME = "User";
    public static final String PERSON_COLUMN_ID = "_id";
    String result;
    public static final String PERSON_COLUMN_Message = "message";
    public static final String PERSON_COLUMN_Date = "Date";
    private static final String LOG = "databasehandler";
    private String message;
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_DATABASE = "CREATE TABLE " + PERSON_TABLE_NAME + "(" +
            PERSON_COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, " + PERSON_COLUMN_Message + " TEXT" + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DATABASE); // creation of table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    public boolean insertMessage(String message) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PERSON_COLUMN_Message, message);
        db.insert(PERSON_TABLE_NAME, null, contentValues);//insert query
        return true;
    }


    public String getAllMessage() {

        // getting all the rows form table_comments
        String selectQuery = " SELECT * FROM " + PERSON_TABLE_NAME ;


        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c != null) {

            c.moveToFirst();
            result = c.getString(1);;
            c.close();
        }

        return result;

    }

}
