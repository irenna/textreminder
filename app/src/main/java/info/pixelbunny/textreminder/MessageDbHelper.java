package info.pixelbunny.textreminder;

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
	
	private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + DATABASE_NAME
		+ DATABASE_NAME + " (" + MessageDbContract.MessageEntry.TABLE_NAME +
		;

    public MessageDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

	//public final static String COLUMN_MESSAGE_ID = "messageId";
}


