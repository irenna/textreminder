package info.pixelbunny.textreminder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by meggz on 23/02/15.
 */
public class MessageListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MessageListAdapter(Context context, String[] values) {
        super(context, R.layout.list_row, values); //fix this once I figure out what goes there
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_row, parent, false);

        TextView phoneNumber = (TextView) rowView.findViewById(R.id.msgPhoneNumber);
        TextView messageContent = (TextView) rowView.findViewById(R.id.msgContent);
        phoneNumber.setText(values[messagePhoneNumber]);
        messageContent.setText(values[messageText]);

        return rowView;

    }

}
