package com.tvd.new_subdiv.values;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FunctionCall {
    public String Appfoldername() {
        return "TRM_Smart_Billing" + File.separator + "data" + File.separator + "files";
    }

    public String filepath(String value) {
        File dir = new File(android.os.Environment.getExternalStorageDirectory(), Appfoldername()
                + File.separator + value);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir.toString();
    }
    public boolean compare_end_billing_time(String end_time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Date todate = null;
        try {
            todate = sdf.parse(end_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date currentime = collectiontime(currentTime());
        if (currentime.before(todate)) {
            logStatus("less");
            return true;
        } else return false;
    }
    private Date collectiontime(String date) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("HH:mm", Locale.US).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
    private String currentTime() {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        String present_date1 = hour + ":" + minute;
        Date date = null;
        try {
            date = new SimpleDateFormat("HH:mm", Locale.US).parse(present_date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.US);
        c.setTime(date);
        return sdf.format(c.getTime());
    }
    public void logStatus(String message) {
        Log.d("debug", message);
    }
    public String convertTo24Hour(String Time) {
        String convert = Time.substring(Time.length()-2);
        convert = convert.toUpperCase();
        Time = Time.substring(0, Time.length()-2)+ " " + convert;
        String formattedDate="";
        try {
            SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm aa", Locale.US);
            SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm", Locale.US);
            formattedDate = outFormat.format(inFormat.parse(Time));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logStatus("Converted: "+formattedDate);
        return formattedDate;
    }
    public void showtoastatcenter(Context context, String Message) {
        Toast toast = Toast.makeText(context, Message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
