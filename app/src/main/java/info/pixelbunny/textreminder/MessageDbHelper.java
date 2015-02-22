package info.pixelbunny.textreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.*;

/**
 * Created by meggz on 14/02/15.
 */
public class MessageDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Message.db";

    private static MessageDbContract.MessageEntry msgEntry;
	
	private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + msgEntry.TABLE_NAME + " (" +
            msgEntry._ID + " INTEGER PRIMARY KEY, " + msgEntry.COLUMN_MESSAGE_TEXT + " TEXT, " +
            msgEntry.COLUMN_MESSAGE_PHONENUMBER + " TEXT)";

    private static final String DELETE_ENTRIES = "DROP TABLE IF EXISTS " + msgEntry.TABLE_NAME;


    public MessageDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //apparently need to store data somewhere, drop table, recreate tabled, and then insert data back?
    }

    public long insertMessage(String message, String phoneNumber) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MessageDbContract.MessageEntry.COLUMN_MESSAGE_TEXT, message);
        values.put(MessageDbContract.MessageEntry.COLUMN_MESSAGE_PHONENUMBER, phoneNumber);

        long newRowId;
        newRowId = db.insert(MessageDbContract.MessageEntry.TABLE_NAME, null, values);
        return newRowId;

    }


}


