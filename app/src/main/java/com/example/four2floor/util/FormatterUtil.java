package com.example.four2floor.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FormatterUtil {

    public static String firebaseDBDate = "dd-MM-yyyy'T'HH:mm:ss.SSSZ";
    public static String firebaseDBDay = "dd-MM-yyyy";

    public static String dateTime = "dd-MM-yyyy HH:mm:ss";

    public static SimpleDateFormat getFirebaseDateFormat() {
        SimpleDateFormat cbDateFormat = new SimpleDateFormat(firebaseDBDate);
        cbDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return cbDateFormat;
    }

    public static String formatFirebaseDay(Date date) {
        SimpleDateFormat cbDateFormat = new SimpleDateFormat(firebaseDBDay);
        cbDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return cbDateFormat.format(date);
    }

    public static String formatDateTime(Date date) {
        SimpleDateFormat cbDateFormat = new SimpleDateFormat(dateTime);
        cbDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return cbDateFormat.format(date);
    }
}
