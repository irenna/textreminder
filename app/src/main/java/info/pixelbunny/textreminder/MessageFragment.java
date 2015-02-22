package info.pixelbunny.textreminder;

/**
 * Created by meggz on 23/12/14.
 */
import android.app.Fragment;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;


public class MessageFragment extends Fragment {

    public MessageFragment() {
        //constructor
    }

    //copied from other other code
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);


        final EditText editTextNumber = (EditText) fragmentView.findViewById(R.id.editTextNumber);
        final EditText editTextMessage = (EditText) fragmentView.findViewById(R.id.editTextMessage);

        Button sendButton = (Button) fragmentView.findViewById(R.id.buttonSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View fragmentView) {

                String message;
                String phoneNumber;

                message = editTextMessage.getText().toString();
                phoneNumber = editTextNumber.getText().toString();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);



                //test stuff
                CharSequence testmsg = message + ' ' + phoneNumber;
                Toast.makeText(getActivity(), testmsg, Toast.LENGTH_LONG).show();

            }
        });
		
		Button saveButton = (Button) fragmentView.findViewById(R.id.buttonSave);
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View fragmentView) {
				//save the msg...

                MessageDbHelper dbHelper = new MessageDbHelper(getActivity().getApplicationContext());

                String message = editTextMessage.getText().toString();
                String phoneNumber = editTextNumber.getText().toString();

                long newRowId = dbHelper.insertMessage(message, phoneNumber);
                //check if insert was successful!
                CharSequence resultsMsg = (newRowId > 0) ?  "Message saved" : "Error - Saving Message Failed";
				Toast.makeText(getActivity(), resultsMsg, Toast.LENGTH_LONG).show();
				
			}
			
		});

        return fragmentView;

    }

/*
    public void BindSubmitMessage() {


    }
*/


}
