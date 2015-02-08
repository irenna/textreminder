package info.pixelbunny.textreminder;

/**
 * Created by meggz on 23/12/14.
 */
import android.app.Fragment;
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

        Button submitButton = (Button) fragmentView.findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
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

        return fragmentView;

    }

/*
    public void BindSubmitMessage() {


    }
*/


}
