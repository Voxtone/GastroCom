package de.fhws.gastrocom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import de.fhws.gastrocom.action.Action;

public class CustomListAdapter extends ArrayAdapter<Action> {
    private final Context context;
    private final List<Action> values;


    public CustomListAdapter(Context context, List<Action> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        final TextView firstLine = rowView.findViewById(R.id.firstLine);
        final TextView secondLine = rowView.findViewById(R.id.secondLine);
        firstLine.setText("Tisch " + values.get(position).getTable());
        secondLine.setText(values.get(position).getType().toString());
        return rowView;
    }
}
