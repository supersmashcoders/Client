package com.supersmashcoders.backtoback;


import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;
import com.supersmashcoders.backtoback.converters.DateConverter;
import com.supersmashcoders.backtoback.models.EventModel;
import com.supersmashcoders.backtoback.proxy.EventProxy;
import com.supersmashcoders.backtoback.proxy.RequestListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventFragment extends Fragment {
    private static final String EVENT_ID = "com.supersmashcoders.EVENT_ID";

    private View mRootView;
    private long mEventId;
    private EventProxy mEventProxy;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EventFragment.
     */
    public static EventFragment newInstance(long eventId) {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putLong(EVENT_ID, eventId);
        fragment.setArguments(args);
        return fragment;
    }

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mEventId = getArguments().getLong(EVENT_ID);
        }
        mEventProxy = new EventProxy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_event, container, false);

        MapFragment mMapFragment = MapFragment.newInstance();
        getChildFragmentManager().beginTransaction()
                .add(R.id.map_container, mMapFragment)
                .commit();
        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        mEventProxy.getEvent(getActivity(), mEventId, new RequestListener<EventModel>() {
            @Override
            public void onComplete(EventModel object) {
                TextView name = (TextView) mRootView.findViewById(R.id.name);
                TextView description = (TextView) mRootView.findViewById(R.id.description);
                TextView startDate = (TextView) mRootView.findViewById(R.id.start_date);
                TextView endDate = (TextView) mRootView.findViewById(R.id.end_date);
                TextView tags = (TextView) mRootView.findViewById(R.id.tags);

                name.setText(object.getName());
                description.setText(object.getDescription());
                startDate.setText(DateConverter.toDisplayString(object.getStartDate()));
                endDate.setText(DateConverter.toDisplayString(object.getEndDate()));
                tags.setText(TextUtils.join(",", object.getTags()));
            }

            @Override
            public void onError() {
            }
        });
    }
}
