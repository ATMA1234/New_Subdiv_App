package com.tvd.new_subdiv.values;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tvd.new_subdiv.model.GetSet_Mast;
import com.tvd.new_subdiv.model.Subdiv_Details;
import com.tvd.new_subdiv.model.Tariff_Config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FunctionCall {
    private String Appfoldername() {
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

    private void logStatus(String message) {
        Log.d("debug", message);
    }

    public String convertTo24Hour(String Time) {
        String convert = Time.substring(Time.length() - 2);
        convert = convert.toUpperCase();
        Time = Time.substring(0, Time.length() - 2) + " " + convert;
        String formattedDate = "";
        try {
            SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm aa", Locale.US);
            SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm", Locale.US);
            formattedDate = outFormat.format(inFormat.parse(Time));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logStatus("Converted: " + formattedDate);
        return formattedDate;
    }

    public void showtoastatcenter(Context context, String Message) {
        Toast toast = Toast.makeText(context, Message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public String CalculateDays(String Prev_date, String Pres_date) {
        Prev_date = changedateformat(Prev_date, "/");
        Pres_date = changedateformat(Pres_date, "/");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Date Date1 = null;
        Date Date2 = null;
        try {
            Date1 = format.parse(Prev_date);
            Date2 = format.parse(Pres_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long result = 0;
        if (Date2 != null)
            result = (Date2.getTime() - Date1.getTime()) / (24 * 60 * 60 * 1000);
        return "" + result;
    }

    private String changedateformat(String datevalue, String changedivider) {
        Date date = null;
        if ((datevalue.substring(datevalue.length() - 5, datevalue.length() - 4)).equals("/")) {
            try {
                date = new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(datevalue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            if ((datevalue.substring(datevalue.length() - 5, datevalue.length() - 4)).equals("-")) {
                try {
                    date = new SimpleDateFormat("dd-MM-yyyy", Locale.US).parse(datevalue);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                if (datevalue.length() == 8) {
                    try {
                        date = new SimpleDateFormat("dd-MM-yyyy", Locale.US).parse(datevalue.substring(0, 2) + "-"
                                + datevalue.substring(2, 4) + "-" + datevalue.substring(4));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String format = sdf.format(c.getTime());
        return format.substring(0, 2) + changedivider + format.substring(3, 5) + changedivider + format.substring(6, 10);
    }

    public double getDouble(String value) {
        if (TextUtils.isEmpty(value))
            return 0;
        else return Double.parseDouble(value);
    }

    public int getInteger(String value) {
        return Integer.parseInt(value);
    }

    public double getBigdecimal(double value, int decimal) {
        return new BigDecimal(value).setScale(decimal, RoundingMode.HALF_EVEN).doubleValue();
    }

    public String decimalroundoff(double value) {
        BigDecimal a = new BigDecimal(value);
        BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return "" + roundOff;
    }

    public String getdecimal(String value) {
        DecimalFormat num = new DecimalFormat("##0.00");
        return String.valueOf(num.format(getDouble(value)));
    }

    public String getdecimal(double value) {
        DecimalFormat num = new DecimalFormat("##0.00");
        return String.valueOf(num.format(value));
    }

    public double getTaxAmount(GetSet_Mast getSet_mast, ArrayList<Tariff_Config> tariffConfigs,
                               ArrayList<Subdiv_Details> subdivDetails, double energy_charges) {
        String tax_date = subdivDetails.get(0).getTAXNEWEFFECT();
        String pres_date = getSet_mast.getREADDATE();
        String prev_date = getSet_mast.getPREVREADDATE();
        if (TextUtils.isEmpty(tax_date)) {
            return energy_charges * getDouble(tariffConfigs.get(0).getTAXPER());
        } else {
            Date present_date = null, previous_date = null, tax_date_change = null;
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            try {
                present_date = formatter.parse(changedateformat(pres_date, "-"));
                previous_date = formatter.parse(changedateformat(prev_date, "-"));
                tax_date_change = formatter.parse(tax_date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            double total_days = getDouble(CalculateDays(prev_date, pres_date));
            double tax_days_diff_old, tax_days_diff_new, new_tax, old_tax, dbl_tax_old, dbl_tax_new;
            assert previous_date != null;
            if (previous_date.before(tax_date_change)) {
                if (present_date.after(tax_date_change)) {
                    tax_days_diff_old = getDouble(CalculateDays(prev_date, tax_date));
                    tax_days_diff_new = getDouble(CalculateDays(tax_date, pres_date));
                } else {
                    tax_days_diff_old = total_days;
                    tax_days_diff_new = 0;
                }
            } else {
                tax_days_diff_old = 0;
                tax_days_diff_new = total_days;
            }
            getSet_mast.setTax_new_days(String.valueOf(tax_days_diff_new));
            getSet_mast.setTax_old_days(String.valueOf(tax_days_diff_old));
            tax_days_diff_new = tax_days_diff_new / total_days;
            tax_days_diff_old = tax_days_diff_old / total_days;
            new_tax = getDouble(tariffConfigs.get(0).getTAXPER());
            String old_tax_rate = tariffConfigs.get(0).getTAXPEROLD();
            if (TextUtils.isEmpty(old_tax_rate)) {
                old_tax = 0;
            } else old_tax = getDouble(old_tax_rate);
            dbl_tax_old = energy_charges * tax_days_diff_old * old_tax;
            dbl_tax_new = energy_charges * tax_days_diff_new * new_tax;
            return dbl_tax_old + dbl_tax_new;
        }
    }

    public String getJSONresult(Cursor cursor) {
        if (cursor.getCount() > 1)
            return getJSONArray(cursor);
        else return getJSONObject(cursor);
    }

    private String getJSONArray(Cursor cursor) {
        JSONArray resultSet = new JSONArray();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int totalColumn = cursor.getColumnCount();
            JSONObject rowObject = new JSONObject();
            for (int i = 0; i < totalColumn; i++) {
                if (cursor.getColumnName(i) != null) {
                    try {
                        if (cursor.getString(i) != null)
                            rowObject.put(cursor.getColumnName(i), cursor.getString(i));
                        else rowObject.put(cursor.getColumnName(i), "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            resultSet.put(rowObject);
            cursor.moveToNext();
        }
        logStatus(resultSet.toString());
        return resultSet.toString();
    }

    private String getJSONObject(Cursor cursor) {
        int totalColumn = cursor.getColumnCount();
        JSONObject rowObject = new JSONObject();
        cursor.moveToFirst();
        for (int i = 0; i < totalColumn; i++) {
            if (cursor.getColumnName(i) != null) {
                try {
                    if (cursor.getString(i) != null)
                        rowObject.put(cursor.getColumnName(i), cursor.getString(i));
                    else rowObject.put(cursor.getColumnName(i), "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        logStatus(rowObject.toString());
        return rowObject.toString();
    }

    public Tariff_Config getTariffConfig(String cursor) {
        return new Gson().fromJson(cursor, Tariff_Config.class);
    }

    public Subdiv_Details getSubdivDetails(String cursor) {
        return new Gson().fromJson(cursor, Subdiv_Details.class);
    }

}
