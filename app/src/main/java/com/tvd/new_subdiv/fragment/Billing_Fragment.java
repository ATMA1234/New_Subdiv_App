package com.tvd.new_subdiv.fragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tvd.new_subdiv.R;
import com.tvd.new_subdiv.activities.ConsumerBilling;
import com.tvd.new_subdiv.database.Databasehelper;
import com.tvd.new_subdiv.model.GetSet_Mast;
import com.tvd.new_subdiv.model.GetSet_MastCust;
import com.tvd.new_subdiv.model.Subdiv_Details;
import com.tvd.new_subdiv.values.FunctionCall;

import java.util.ArrayList;
import java.util.List;

import static com.tvd.new_subdiv.values.ConstantValues.BILLINGSTS_DLG;
import static com.tvd.new_subdiv.values.ConstantValues.BILLING_CUT_OFF_TIME;
import static com.tvd.new_subdiv.values.ConstantValues.BILLING_ERROR;
import static com.tvd.new_subdiv.values.ConstantValues.BILLING_TIME_OVER;

public class Billing_Fragment extends Fragment implements View.OnClickListener {
    View view;
    Databasehelper dbh;
    List<GetSet_Mast> Mast_Cust_LIst;
    List<Subdiv_Details> Subdiv_List;
    TextView billing_data_count;
    FunctionCall fcall;
    String billingstatus = "", billingflag = "";
    Button billing_button;

    public Billing_Fragment() {
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_billing, container, false);
        initialize();
        billing_data_count.setText(Mast_Cust_LIst.size() + "");
        return view;
    }

    private void initialize() {
        billing_data_count = view.findViewById(R.id.txt_billing_data_count);
        billing_button = view.findViewById(R.id.btn_billing);
        billing_button.setOnClickListener(this);
        dbh = new Databasehelper(getActivity());
        dbh.openDatabase();
        Mast_Cust_LIst = new ArrayList<>();
        Subdiv_List = new ArrayList<>();
        Mast_Cust_LIst = dbh.getsetMastCustDetails();
        Subdiv_List = dbh.getsetSubdiv_Details();
        fcall = new FunctionCall();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_billing:
                billing_method();
                break;
        }
    }

    private void billing_method() {
        if (fcall.compare_end_billing_time(fcall.convertTo24Hour(BILLING_CUT_OFF_TIME))) {
            billingstatus = Subdiv_List.get(0).getBILLINGSTATUS();
            billingflag = Subdiv_List.get(0).getCOLLECTIONFLAG();
            if (billingstatus.equals("BO")) {
                if (billingflag.equals("N") || billingflag.equals("n")) {
                    if (Mast_Cust_LIst.size() > 0) {
                        Intent intent = new Intent(getActivity(), ConsumerBilling.class);
                        startActivity(intent);
                    } else showDialog(BILLING_ERROR);
                } else
                    fcall.showtoastatcenter(getActivity(), "Can't take Billing from this device!!");
            } else showDialog(BILLINGSTS_DLG);
        } else showDialog(BILLING_TIME_OVER);
    }

    public void showDialog(int id) {
        Dialog d;
        switch (id) {
            case BILLING_ERROR:
                AlertDialog.Builder billerror = new AlertDialog.Builder(getActivity());
                billerror.setTitle("Billing");
                billerror.setMessage("Sorry no Records found in Billing so cannot take bills..");
                billerror.setNeutralButton("OK", null);
                d = billerror.create();
                d.show();
                break;
            case BILLINGSTS_DLG:
                AlertDialog.Builder ab1 = new AlertDialog.Builder(getActivity());
                ab1.setTitle("Subdiv Billing");
                ab1.setMessage("Billing Completed");
                ab1.setNeutralButton("OK", null);
                d = ab1.create();
                d.show();
                break;
            case BILLING_TIME_OVER:
                AlertDialog.Builder time_over = new AlertDialog.Builder(getActivity());
                time_over.setTitle("Time Over");
                time_over.setCancelable(false);
                time_over.setMessage("Billing Time is over... Can not take billing now...");
                time_over.setNeutralButton("OK", null);
                d = time_over.create();
                d.show();
                break;
        }
    }
}
