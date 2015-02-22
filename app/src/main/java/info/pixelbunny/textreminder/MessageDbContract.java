package info.pixelbunny.textreminder;
import android.provider.*;

public final class MessageDbContract {

	public MessageDbContract() {
		//empty constructor
	}

	public static abstract class MessageEntry implements BaseColumns {

		public final static String TABLE_NAME = "messages";
		public final static String COLUMN_MESSAGE_TEXT = "messageText";
		public final static String COLUMN_MESSAGE_PHONENUMBER = "messagePhonenumber";
		public final static String[] PROJECTION_ALL = { _ID, COLUMN_MESSAGE_TEXT,
			COLUMN_MESSAGE_PHONENUMBER };
	}

}
