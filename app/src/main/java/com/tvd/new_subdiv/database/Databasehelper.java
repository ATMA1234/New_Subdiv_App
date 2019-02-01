package com.tvd.new_subdiv.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.tvd.new_subdiv.model.GetSet_Mast;
import com.tvd.new_subdiv.model.Subdiv_Details;
import com.tvd.new_subdiv.values.FunctionCall;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import static com.tvd.new_subdiv.values.ConstantValues.DIR_DATABASE;
import static com.tvd.new_subdiv.values.ConstantValues.FILE_TRM_DATABASE;
import static com.tvd.new_subdiv.values.ConstantValues.FILE_TRM_JOURNAL;
import static com.tvd.new_subdiv.values.ConstantValues.ZIP_EXTRACT_PASSWORD;

public class Databasehelper {
    private String dwnfilepath;
    private String dwnfilename;
    private String dwnfileformat;
    private MyHelper mh;
    private SQLiteDatabase myDataBase;
    private FunctionCall fcall = new FunctionCall();
    private String DATABASE_NAME, DATABASE_JOURNAL;
    private String path = fcall.filepath(DIR_DATABASE);
    private String DATABASE_PATH = path + File.separator;

    //Constructor
    public Databasehelper(Context context) {
        DATABASE_NAME = FILE_TRM_DATABASE;
        DATABASE_JOURNAL = FILE_TRM_JOURNAL;
        mh = new MyHelper(context, DATABASE_NAME, null, 1);
    }

    public class MyHelper extends SQLiteOpenHelper {
        MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    //Create a empty database on the system
    public void createDatabase(String localfilepath, String localfilename, String localfileformat) {
        dwnfilepath = localfilepath;
        dwnfilename = localfilename;
        dwnfileformat = localfileformat;

        boolean dbExist = checkDataBase();
        if (dbExist) {
            db_delete();
        }

        boolean dbExist1 = checkDataBase();
        if (!dbExist1) {
            try {
                mh.close();
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error in copying database");
            }
        }
    }

    //Check database already exist or not
    private boolean checkDataBase() {
        boolean checkDB = false;

        try {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            File dbfile = new File(myPath);
            checkDB = dbfile.exists();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return checkDB;
    }


    //Copies your database from your local assets-folder to the
    //just created empty database in the system folder
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void copyDataBase() throws IOException {
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        String source = dwnfilepath + dwnfilename + dwnfileformat;
        String destination = dwnfilepath;
        String password = ZIP_EXTRACT_PASSWORD;
        try {
            net.lingala.zip4j.core.ZipFile zipFile = new ZipFile(source);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password);
            }
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
        File hh = new File(DATABASE_PATH);
        if (!hh.exists()) {
            hh.mkdirs();
        }
        OutputStream myOutput = new FileOutputStream(outFileName);
        InputStream myInput = new FileInputStream(destination + "/" + dwnfilename + ".db");
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myInput.close();
        myOutput.flush();
        myOutput.close();
    }

    //delete database
    private void db_delete() {
        db_close();
        delete_file(DATABASE_JOURNAL);
        delete_file(DATABASE_NAME);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void delete_file(String file) {
        if (!TextUtils.isEmpty(file)) {
            File journal = new File(DATABASE_PATH + file);
            if (journal.exists()) {
                journal.delete();
            }
        }
    }

    private void db_close() {
        mh.close();
    }

    //Open database
    public boolean openDatabase() throws SQLException {
        String myPath = DATABASE_PATH + DATABASE_NAME;
        File file = new File(myPath);
        if (file.exists()) {
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
            return true;
        } else return false;
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
        /*fcall.logStatus(resultSet.toString());
        text_report(resultSet.toString());*/
        return resultSet.toString();
    }

    //For Reading mast_cust values
    private String getMastCust() {
        return getJSONArray(myDataBase.rawQuery("select * from MAST_CUST", null));
    }

    //Binding mast_cust values into GetSet_MastCust pojo class
    public List<GetSet_Mast> getsetMastCustDetails() {
        return Arrays.asList(new Gson().fromJson(getMastCust(), GetSet_Mast[].class));
    }

    //For Reading Subdiv_details values
    private String getSubdivDetails() {
        return getJSONArray(myDataBase.rawQuery("select * from SUBDIV_DETAILS", null));
    }

    //Binding subdiv_details values into Subdiv_Details
    public List<Subdiv_Details> getsetSubdiv_Details() {
        return Arrays.asList(new Gson().fromJson(getSubdivDetails(), Subdiv_Details[].class));
    }

    //For Getting mast_cust details based on billed record no
    private String getBilledRecord() {
        return getJSONArray(myDataBase.rawQuery("select * from mast_cust,subdiv_details where mast_cust._id = (select billed_record from subdiv_details)", null));
    }

    public List<GetSet_Mast> getMastCustDetails2() {
        return Arrays.asList(new Gson().fromJson(getBilledRecord(), GetSet_Mast[].class));
    }

    public Cursor updateDLrecord(String monthdiff) {
        return myDataBase.rawQuery("update MAST_CUST set DLCOUNT = '" + monthdiff + "' where rowid = (select billed_record from subdiv_details)", null);
    }

    //Update the Billed Record
    public void updatebill(int billUpdate) {
        ContentValues cv = new ContentValues();
        cv.put("Billed_Record", billUpdate);
        myDataBase.update("SUBDIV_DETAILS", cv, "Billed_Record", null);
    }

    //For getting unbilled record
    private String getUnBilledRecordData() {
        return getJSONArray(myDataBase.rawQuery("select * from mast_cust where CONSNO not in (select CONSNO from mast_out) and _id = (select billed_record from subdiv_details)", null));
    }

    public List<GetSet_Mast> getMastCust_UnbilledRecordData() {
        return Arrays.asList(new Gson().fromJson(getUnBilledRecordData(), GetSet_Mast[].class));
    }

    //FOr getting DLbilled record
    private String getDLBilledRecord() {
        return getJSONArray(myDataBase.rawQuery("select * from MAST_OUT where PRES_STS = '1' and _id = (select billed_record from subdiv_details)", null));
    }

    public List<GetSet_Mast> getDLBilledRecordData() {
        return Arrays.asList(new Gson().fromJson(getDLBilledRecord(), GetSet_Mast[].class));
    }

    public String flECcount() {
        return fcall.getJSONresult(myDataBase.rawQuery("select * from TARIFF_CONFIG_CURRENT where TARIFF_CODE = '23' " +
                "and RUFLAG = '0'", null));
    }

    public String flECcount_old() {
        return fcall.getJSONresult(myDataBase.rawQuery("select * from TARIFF_CONFIG_CURRENT_OLD where TARIFF_CODE = '23' " +
                "and RUFLAG = '0'", null));
    }

    public String getTarrifData(String rRNO, String rRebate) {
        return fcall.getJSONresult(myDataBase.rawQuery("select * from TARIFF_CONFIG_CURRENT where TARIFF_CODE = " +
                "(select TARIFF from MAST_CUST where CONSNO = " + "'" + rRNO + "') and RUFLAG = (select RREBATE from MAST_CUST " +
                "where RREBATE = " + "'" + rRebate + "')", null));
    }

    public String getTarrifData_old(String rRNO, String rRebate) {
        return fcall.getJSONresult(myDataBase.rawQuery("select * from TARIFF_CONFIG_CURRENT_OLD where TARIFF_CODE = (select TARIFF from MAST_CUST where CONSNO = " + "'" + rRNO + "') and RUFLAG = (select RREBATE from MAST_CUST where RREBATE = " + "'" + rRebate + "')", null));
    }


    //Tariff = 10
    public String getTarrifDataBJ(String rRebate, String Tariff) {
        return fcall.getJSONresult(myDataBase.rawQuery("select * from TARIFF_CONFIG_CURRENT where TARIFF_CODE = " + "'" + Tariff + "'and RUFLAG = " + "'" + rRebate + "'", null));
    }

    public String getTarrifDataBJ_old(String rRebate, String Tariff) {
        return fcall.getJSONresult(myDataBase.rawQuery("select * from TARIFF_CONFIG_CURRENT_OLD where TARIFF_CODE = " + "'" + Tariff + "'and RUFLAG = " + "'" + rRebate + "'", null));
    }
}
