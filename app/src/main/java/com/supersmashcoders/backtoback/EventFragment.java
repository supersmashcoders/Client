package com.supersmashcoders.backtoback;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        mEventProxy.getEvent(getActivity(), mEventId, new RequestListener<EventModel>() {
            @Override
            public void onComplete(EventModel object) {
                TextView itemId = (TextView) mRootView.findViewById(R.id.item_id);
                TextView itemTitle = (TextView) mRootView.findViewById(R.id.item_title);
                TextView itemBody = (TextView) mRootView.findViewById(R.id.item_body);

                itemId.setText(String.valueOf(object.getId()));
                itemTitle.setText(object.getTitle());
                itemBody.setText(object.getBody());
            }

            @Override
            public void onError() {
            }
        });
    }
}
