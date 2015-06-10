package com.supersmashcoders.backtoback.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.supersmashcoders.backtoback.R;
import com.supersmashcoders.backtoback.proxy.EventRequestType;

public class DrawerOptionsAdapter extends ArrayAdapter<EventRequestType>{
    LayoutInflater inflater;

    public DrawerOptionsAdapter(Context context, int resource, EventRequestType[] objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if( convertView == null ){
            convertView = inflater.inflate(R.layout.drawer_option, parent, false);
        }
        TextView optionName = (TextView) convertView.findViewById(R.id.drawer_option_text);

        EventRequestType type = getItem(position);
        optionName.setText(type.getRequestName());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
