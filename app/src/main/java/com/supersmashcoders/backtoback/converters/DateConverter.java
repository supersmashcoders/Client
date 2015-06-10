package com.supersmashcoders.backtoback.converters;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConverter {
    public static Date toDate(String dateStr) {
        // "2015-04-12T20:20:50.520Z",
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            Log.e("DATE ERROR", "Failed to parse date" ,e);
        }
        return date;
    }

    public static String toDisplayString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
