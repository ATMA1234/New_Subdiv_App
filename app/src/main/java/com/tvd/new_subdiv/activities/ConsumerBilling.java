package com.tvd.new_subdiv.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.tvd.new_subdiv.R;
import com.tvd.new_subdiv.database.Databasehelper;
import com.tvd.new_subdiv.model.GetSet_Mast;
import com.tvd.new_subdiv.model.Subdiv_Details;
import com.tvd.new_subdiv.values.FunctionCall;

import java.util.ArrayList;
import java.util.List;

public class ConsumerBilling extends AppCompatActivity {
     TextView textview_accid,textview_rrno,textview_name,textview_address,textview_tariff,textview_previous_sts,textview_previous_reading,textview_mf,textview_hp,textview_kw,textview_date,text_accid_count;
     Spinner spinner_status,spinner_feeder,spinner_dtc;
     EditText edittext_noofdays,edittext_pdrecorded,edittext_tccode,edittext_curread,edittext_meterdigit,edittext_pf,edittext_todonpeak,edittext_normal_peak,edittext_tod_offpeak,
                     edittext_bmd,edittext_kvah;
     Toolbar toolbar;
     String cons_dl_count="",strBilledNumber="",cons_RRno="",cons_Name="",cons_Addr="",cons_Tariff="",cons_tariff_name="",cons_mf="",cons_prevmonth_sts="",cons_avg_con="",cons_Linemin="",
                   cons_sanc_hp="",cons_sanc_kw="", cons_prevread="",cons_FR="",cons_IR="",cons_DLCount1="",cons_Arrears="";
    private List<GetSet_Mast>SetList;
    private List<Subdiv_Details> Subdiv_List;
    private boolean UnBilled=false,DLBilled = false;
    Databasehelper dbh;
    private FunctionCall fcall;
    int a= 0,inttariff = 0,intmf =0,intPrvMonthStatus=0,intprevRead=0,intFR=0,intIR=0;
    double cons_DLCount=0;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_billing);
        initialize();
        //setData();
    }
    public void initialize(){
        dbh = new Databasehelper(this);
        dbh.openDatabase();
        /************Toolbar Initialization*******************/
        toolbar =  findViewById(R.id.my_toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /************TextView Initialization******************/
        textview_accid = findViewById(R.id.txt_accid);
        textview_rrno = findViewById(R.id.txt_rrno);
        textview_name = findViewById(R.id.txt_name);
        textview_address = findViewById(R.id.txt_address);
        textview_tariff = findViewById(R.id.txt_tariff);
        textview_previous_sts = findViewById(R.id.txt_prevsts);
        textview_previous_reading = findViewById(R.id.txt_prvrdg);
        textview_mf = findViewById(R.id.txt_mf);
        textview_hp = findViewById(R.id.txt_hp);
        textview_kw = findViewById(R.id.txt_kw);
        textview_date = findViewById(R.id.txt_date);
        text_accid_count = findViewById(R.id.txt_count_id);
        /************Spinner Initialization******************/
        spinner_status = findViewById(R.id.spin_status);
        spinner_feeder = findViewById(R.id.spin_feeder);
        spinner_dtc = findViewById(R.id.spin_dtc);
        /************Edittext Initialization******************/
        edittext_noofdays = findViewById(R.id.edit_noofdays);
        edittext_pdrecorded = findViewById(R.id.edit_pd_recorded);
        edittext_tccode = findViewById(R.id.edit_tccode);
        edittext_curread = findViewById(R.id.edit_curreading);
        edittext_meterdigit = findViewById(R.id.edit_meterdigit);
        edittext_pf = findViewById(R.id.editpf);
        edittext_todonpeak = findViewById(R.id.edit_todonpeak);
        edittext_normal_peak = findViewById(R.id.edit_tod_normalpeak);
        edittext_tod_offpeak = findViewById(R.id.edit_tod_offpeak);
        edittext_bmd = findViewById(R.id.edit_bmd);
        edittext_kvah = findViewById(R.id.edit_kvah);
        /***********List Initialization********************/
        SetList = new ArrayList<>();
        Subdiv_List = new ArrayList<>();

        SetList = dbh.getMastCustDetails2();
        Subdiv_List = dbh.getsetSubdiv_Details();
        fcall = new FunctionCall();
    }
    private void setData(int i){
        try{
            if (SetList.size()>0){
                String pres_date = SetList.get(i).getREADDATE();
                String prev_date = SetList.get(i).getPREVREADDATE();
                double days_diff = Double.parseDouble(fcall.CalculateDays(prev_date, pres_date));
                if (days_diff > 31) {
                    double dl_diff = (days_diff / 30);
                    cons_dl_count = ""+dl_diff;
                    dl_diff = dl_diff - 1;
                    Cursor updatedl = dbh.updateDLrecord(""+dl_diff);
                    updatedl.moveToNext();
                } else if (days_diff < 28) {
                    double dl_diff = ((days_diff+1) / 30);
                    cons_dl_count = ""+dl_diff;
                    dl_diff = dl_diff - 1;
                    Cursor updatedl = dbh.updateDLrecord(""+dl_diff);
                    updatedl.moveToNext();
                }
            }
            strBilledNumber = Subdiv_List.get(0).getBilledRecord();
            text_accid_count.setText(strBilledNumber);
            a = Integer.parseInt(strBilledNumber);
            if (a ==0){
                dbh.updatebill(1);
            }
            if (a<=i){
                if (UnBilled){
                    SetList = dbh.getMastCust_UnbilledRecordData();
                }else {
                 if (DLBilled){
                    SetList = dbh.getDLBilledRecordData();
                 }else {
                     SetList = dbh.getMastCustDetails2();
                 }
                }
                SetList = dbh.getMastCustDetails2();
                if (SetList.size()>0){
                    cons_RRno = SetList.get(i).getRRNO();
                    cons_Name = SetList.get(i).getNAME();
                    cons_Addr = SetList.get(i).getADD1();
                    cons_Tariff = SetList.get(i).getTARIFF();
                    inttariff = Integer.parseInt(cons_Tariff);
                    cons_tariff_name = SetList.get(i).getTARIFFNAME();
                    cons_mf = SetList.get(i).getMF();
                    intmf = Integer.parseInt(cons_mf);
                    cons_prevmonth_sts = SetList.get(i).getPREVSTAT();
                    intPrvMonthStatus = Integer.parseInt(cons_prevmonth_sts.replaceAll("\\s", ""));
                    cons_avg_con = SetList.get(i).getAVGCON();
                    cons_Linemin = SetList.get(i).getLINEMIN();
                    cons_sanc_hp = SetList.get(i).getSANCHP();
                    cons_sanc_kw = SetList.get(i).getSANCKW();
                    cons_prevread = SetList.get(i).getPRESRDG();
                    try{
                        intprevRead =Integer.parseInt(cons_prevread);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                        double cd = Double.parseDouble(cons_prevread);
                        intprevRead = (int) cd;
                    }
                    cons_FR = SetList.get(i).getFR();
                    intFR = Integer.parseInt(cons_FR);
                    cons_IR = SetList.get(i).getIR();
                    intIR = Integer.parseInt(cons_IR);
                    cons_DLCount1 = SetList.get(i).getDLCOUNT();
                    cons_DLCount = Double.parseDouble(cons_DLCount1);
                    cons_Arrears = SetList.get(i).getARREARS();
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
