package info.pixelbunny.textreminder;

/**
 * Created by meggz on 23/12/14.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
//import android.view.ViewGroup;


public class MessageFragment extends Fragment {


    public MessageFragment() {
        //constructor

    }

    //copied from other other code
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);

        return fragmentView;

    }



}
