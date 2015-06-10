package com.supersmashcoders.backtoback.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.supersmashcoders.backtoback.R;
import com.supersmashcoders.backtoback.models.EventModel;

import java.util.List;

public class EventAdapter extends ArrayAdapter<EventModel>{
    LayoutInflater inflater;

    public EventAdapter(Context context, int resource, List<EventModel> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if( convertView == null ){
            convertView = inflater.inflate(R.layout.list_item_event, parent, false);
        }
        TextView itemName = (TextView) convertView.findViewById(R.id.item_name);
        TextView itemDescription = (TextView) convertView.findViewById(R.id.item_description);
        TextView itemDate = (TextView) convertView.findViewById(R.id.item_start_date);

        EventModel jsonObject = getItem(position);
        itemName.setText(String.valueOf(jsonObject.getName()));
        itemDescription.setText(jsonObject.getDescription());
        itemDate.setText(jsonObject.getStartDate().toString());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }
}
