package com.tvd.new_subdiv.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetSet_MastCust extends GetSet_Mast_Out implements Serializable {
    @SerializedName("INVENTORY_LOAD")
    @Expose
    private String iNVENTORY_LOAD;
    @SerializedName("HP")
    @Expose
    private String hP;
    @SerializedName("BMDKW")
    @Expose
    private String bMDKW;
    @SerializedName("CONNLDHP")
    @Expose
    private String cONNLDHP;
    @SerializedName("CONNLDKW")
    @Expose
    private String cONNLDKW;
    @SerializedName("READKVAH")
    @Expose
    private String rEADKVAH;
    @SerializedName("units")
    @Expose
    private String units;
    @SerializedName("pd_penalty")
    @Expose
    private String pd_penalty;
    @SerializedName("column_name")
    @Expose
    private String column_name;

    @SerializedName("COMPANY")
    @Expose
    private String cOMPANY;
    @SerializedName("SUBDIV_CODE")
    @Expose
    private String sUBDIV_CODE;
    @SerializedName("SUB_DIVISION")
    @Expose
    private String sUB_DIVISION;
    @SerializedName("MOBILE_NO")
    @Expose
    private String mOBILE_NO;
    @SerializedName("HELPLINE_NO")
    @Expose
    private String hELPLINE_NO;
    @SerializedName("COLLECTION_FLAG")
    @Expose
    private String cOLLECTION_FLAG;
    @SerializedName("COLL_MAX_AMOUNT")
    @Expose
    private String cOLL_MAX_AMOUNT;
    @SerializedName("COLLECTION_DATE")
    @Expose
    private String cOLLECTION_DATE;
    @SerializedName("LOGO_PRINT")
    @Expose
    private String lOGO_PRINT;
    @SerializedName("BARCODE_PRINT")
    @Expose
    private String bARCODE_PRINT;
    @SerializedName("SLABS_PRINT")
    @Expose
    private String sLABS_PRINT;
    @SerializedName("BIOMETRIC_TEMPLATE")
    @Expose
    private String bIOMETRIC_TEMPLATE;
    @SerializedName("MRNAME")
    @Expose
    private String mRNAME;
    @SerializedName("MRPASSWD")
    @Expose
    private String mRPASSWD;
    @SerializedName("BILL_OPEN_TIME")
    @Expose
    private String bILL_OPEN_TIME;
    @SerializedName("BILL_CLOSE_TIME")
    @Expose
    private String bILL_CLOSE_TIME;
    @SerializedName("BILLING_STATUS")
    @Expose
    private String bILLING_STATUS;
    @SerializedName("MACHINE_ID")
    @Expose
    private String mACHINE_ID;
    @SerializedName("DB_VERSION")
    @Expose
    private String dB_VERSION;
    @SerializedName("SERVER_DOMAIN")
    @Expose
    private String sERVER_DOMAIN;
    @SerializedName("BIOMETRIC_INTERVAL")
    @Expose
    private String bIOMETRIC_INTERVAL;
    @SerializedName("BIOMETRIC_ENABLE")
    @Expose
    private String bIOMETRIC_ENABLE;
    @SerializedName("BILLING_MMYYYY")
    @Expose
    private String bILLING_MMYYYY;
    @SerializedName("FTP_UPLOAD")
    @Expose
    private String fTP_UPLOAD;
    @SerializedName("FTP_DOWNLOAD")
    @Expose
    private String fTP_DOWNLOAD;
    @SerializedName("BIO_PRINT_CNT")
    @Expose
    private String bIO_PRINT_CNT;
    @SerializedName("Billed_Record")
    @Expose
    private String billed_Record;
    @SerializedName("UPLOAD_STATUS")
    @Expose
    private String uPLOAD_STATUS;
    @SerializedName("PRINTER_TYPE")
    @Expose
    private String pRINTER_TYPE;
    @SerializedName("PRE_PRINT")
    @Expose
    private String pRE_PRINT;
    @SerializedName("INTR_ON_ARR")
    @Expose
    private String iNTR_ON_ARR;
    @SerializedName("TAX_ON_EC")
    @Expose
    private String tAX_ON_EC;
    @SerializedName("BT_PRINTER")
    @Expose
    private String bT_PRINTER;
    @SerializedName("APP_VER")
    @Expose
    private String aPP_VER;
    @SerializedName("PRINTER_FORMAT")
    @Expose
    private String pRINTER_FORMAT;
    @SerializedName("FEC")
    @Expose
    private String fEC;
    @SerializedName("DL_FLAG")
    @Expose
    private String dL_FLAG;
    @SerializedName("NWTRF_DATE")
    @Expose
    private String nWTRF_DATE;
    @SerializedName("FAC_START")
    @Expose
    private String fAC_START;
    @SerializedName("FAC_END")
    @Expose
    private String fAC_END;
    @SerializedName("TAX_NEW_EFFECT")
    @Expose
    private String tAX_NEW_EFFECT;
    @SerializedName("FAC_OLD")
    @Expose
    private String FAC_OLD;
    @SerializedName("FAC_DEC_18")
    @Expose
    private String FAC_DEC_18;
    @SerializedName("FAC_DEC_18_RATE")
    @Expose
    private String FAC_DEC_18_RATE;

    @SerializedName("INSERT_SSNO")
    @Expose
    private String iNSERT_SSNO;
    @SerializedName("INSERT_EXTRA1")
    @Expose
    private String iNSERT_EXTRA1;
    @SerializedName("INSERT_DATA1")
    @Expose
    private String iNSERT_DATA1;
    @SerializedName("INSERT_EXTRA2")
    @Expose
    private String iNSERT_EXTRA2;
    @SerializedName("INSERT_DATA2")
    @Expose
    private String iNSERT_DATA2;
    @SerializedName("INSERT_BMDVAL")
    @Expose
    private String iNSERT_BMDVAL;
    @SerializedName("INSERT_INTEREST_AMT")
    @Expose
    private String iNSERT_INTEREST_AMT;
    @SerializedName("INSERT_REBATE_AMOUNT")
    @Expose
    private String iNSERT_REBATE_AMOUNT;
    @SerializedName("INSERT_BMD_PENALTY")
    @Expose
    private String iNSERT_BMD_PENALTY;
    @SerializedName("CONSUMER_NAME")
    @Expose
    private String CONSUMER_NAME;
    @SerializedName("TARIFFBILLING")
    @Expose
    private String TARIFFBILLING;
    @SerializedName("SANC_LOAD")
    @Expose
    private String SANC_LOAD;
    @SerializedName("KW")
    @Expose
    private String KW;
    @SerializedName("PREVREAD")
    @Expose
    private String PREVREAD;
    @SerializedName("OLDIR")
    @Expose
    private String OLDIR;
    @SerializedName("OLDFR")
    @Expose
    private String OLDFR;
    @SerializedName("LEGFALIO")
    @Expose
    private String LEGFALIO;
    @SerializedName("CONSID")
    @Expose
    private String CONSID;
    @SerializedName("RRBTFLAG")
    @Expose
    private String RRBTFLAG;
    @SerializedName("PF")
    @Expose
    private String PF;
    @SerializedName("BMD")
    @Expose
    private String BMD;
    @SerializedName("ASD")
    @Expose
    private String ASD;
    @SerializedName("BILLNO")
    @Expose
    private String BILLNO;
    @SerializedName("Interest")
    @Expose
    private String Interest;
    @SerializedName("INTEREST_ON_DEPOSIT")
    @Expose
    private String INTEREST_ON_DEPOSIT;
    @SerializedName("BILLDAYS")
    @Expose
    private String BILLDAYS;
    @SerializedName("MTR_SLNO")
    @Expose
    private String MTR_SLNO;
    @SerializedName("CHQ_DISHONOUR_FLAG")
    @Expose
    private String CHQ_DISHONOUR_FLAG;
    @SerializedName("MTRFLAG")
    @Expose
    private String MTRFLAG;
    @SerializedName("CREDIT_ADJ")
    @Expose
    private String CREDIT_ADJ;
    @SerializedName("LONGITUDE")
    @Expose
    private String LONGITUDE;
    @SerializedName("LATITUDE")
    @Expose
    private String LATITUDE;
    @SerializedName("EMAIL_ID")
    @Expose
    private String EMAIL_ID;
    @SerializedName("ELECTION_CARD_NO")
    @Expose
    private String ELECTION_CARD_NO;
    @SerializedName("WATER_CON_NO")
    @Expose
    private String WATER_CON_NO;
    @SerializedName("HOME_NO")
    @Expose
    private String HOME_NO;
    @SerializedName("Message")
    @Expose
    private String Message;
    @SerializedName("flags")
    @Expose
    private String flags;
    @SerializedName("MTRXCHNGFLG")
    @Expose
    private String mTRXCHNGFLG;
    @SerializedName("MTRCHGOLDUNITS")
    @Expose
    private String mTRCHGOLDUNITS;

    private String data2_1;
    private String data2_2;
    private String data2_3;

    private int old_days=0;
    private int normal_days=0;
    private int bill_read_count=0;
    private double fc_old_value=0;
    private double fc_normal_value=0;
    private double ec_old_value=0;
    private double ec_normal_value=0;
    private double fac_days=0;
    private double fac_old=0;
    private double fac_old_days=0;
    private double fac_remaining_days=0;
    private double fac_dec_18_days=0;
    private double fac_dec_18_rate=0;
    private double fec;
    private String tax_days_new="";
    private String tax_days_old="";
    private String error_id="";

    private double[] arrFrate = new double[10];
    private double[] arrFslab = new double[10];
    private double[] arrErate = new double[10];
    private double[] arrEslab = new double[10];
    private double[] arrEc = new double[10];
    private double[] arrFc = new double[10];
    private double[] arrFrate_old = new double[10];
    private double[] arrFslab_old = new double[10];
    private double[] arrErate_old = new double[10];
    private double[] arrEslab_old = new double[10];
    private double[] arrEc_old = new double[10];
    private double[] arrFc_old = new double[10];
    private double[] arrdlFslab = new double[10];
    private double[] arrdlFslab_old = new double[10];

    public GetSet_MastCust() {
    }

    String getINVENTORY_LOAD() {
        return iNVENTORY_LOAD;
    }

    void setINVENTORY_LOAD(String iNVENTORY_LOAD) {
        this.iNVENTORY_LOAD = iNVENTORY_LOAD;
    }

    public String getHP() {
        return hP;
    }

    public void setHP(String hP) {
        this.hP = hP;
    }

    String getBMDKW() {
        return bMDKW;
    }

    void setBMDKW(String bMDKW) {
        this.bMDKW = bMDKW;
    }

    String getCONNLDHP() {
        return cONNLDHP;
    }

    void setCONNLDHP(String cONNLDHP) {
        this.cONNLDHP = cONNLDHP;
    }

    String getCONNLDKW() {
        return cONNLDKW;
    }

    void setCONNLDKW(String cONNLDKW) {
        this.cONNLDKW = cONNLDKW;
    }

    String getREADKVAH() {
        return rEADKVAH;
    }

    void setREADKVAH(String rEADKVAH) {
        this.rEADKVAH = rEADKVAH;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String uNITS) {
        this.units = uNITS;
    }

    String getPd_penalty() {
        return pd_penalty;
    }

    void setPd_penalty(String pD_PENALTY) {
        this.pd_penalty = pD_PENALTY;
    }

    public String getColumn_name() {
        return column_name;
    }

    void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public String getCOMPANY() {
        return cOMPANY;
    }

    public void setCOMPANY(String cOMPANY) {
        this.cOMPANY = cOMPANY;
    }

    public String getSUBDIV_CODE() {
        return sUBDIV_CODE;
    }

    public void setSUBDIV_CODE(String sUBDIV_CODE) {
        this.sUBDIV_CODE = sUBDIV_CODE;
    }

    public String getSUB_DIVISION() {
        return sUB_DIVISION;
    }

    void setSUB_DIVISION(String sUB_DIVISION) {
        this.sUB_DIVISION = sUB_DIVISION;
    }

    String getMOBILE_NO() {
        return mOBILE_NO;
    }

    void setMOBILE_NO(String mOBILE_NO) {
        this.mOBILE_NO = mOBILE_NO;
    }

    String getHELPLINE_NO() {
        return hELPLINE_NO;
    }

    void setHELPLINE_NO(String hELPLINE_NO) {
        this.hELPLINE_NO = hELPLINE_NO;
    }

    String getCOLLECTION_FLAG() {
        return cOLLECTION_FLAG;
    }

    void setCOLLECTION_FLAG(String cOLLECTION_FLAG) {
        this.cOLLECTION_FLAG = cOLLECTION_FLAG;
    }

    String getCOLL_MAX_AMOUNT() {
        return cOLL_MAX_AMOUNT;
    }

    void setCOLL_MAX_AMOUNT(String cOLL_MAX_AMOUNT) {
        this.cOLL_MAX_AMOUNT = cOLL_MAX_AMOUNT;
    }

    String getCOLLECTION_DATE() {
        return cOLLECTION_DATE;
    }

    void setCOLLECTION_DATE(String cOLLECTION_DATE) {
        this.cOLLECTION_DATE = cOLLECTION_DATE;
    }

    String getLOGO_PRINT() {
        return lOGO_PRINT;
    }

    void setLOGO_PRINT(String lOGO_PRINT) {
        this.lOGO_PRINT = lOGO_PRINT;
    }

    String getBARCODE_PRINT() {
        return bARCODE_PRINT;
    }

    void setBARCODE_PRINT(String bARCODE_PRINT) {
        this.bARCODE_PRINT = bARCODE_PRINT;
    }

    String getSLABS_PRINT() {
        return sLABS_PRINT;
    }

    void setSLABS_PRINT(String sLABS_PRINT) {
        this.sLABS_PRINT = sLABS_PRINT;
    }

    String getBIOMETRIC_TEMPLATE() {
        return bIOMETRIC_TEMPLATE;
    }

    void setBIOMETRIC_TEMPLATE(String bIOMETRIC_TEMPLATE) {
        this.bIOMETRIC_TEMPLATE = bIOMETRIC_TEMPLATE;
    }

    public String getMRNAME() {
        return mRNAME;
    }

    void setMRNAME(String mRNAME) {
        this.mRNAME = mRNAME;
    }

    String getMRPASSWD() {
        return mRPASSWD;
    }

    void setMRPASSWD(String mRPASSWD) {
        this.mRPASSWD = mRPASSWD;
    }

    String getBILL_OPEN_TIME() {
        return bILL_OPEN_TIME;
    }

    void setBILL_OPEN_TIME(String bILL_OPEN_TIME) {
        this.bILL_OPEN_TIME = bILL_OPEN_TIME;
    }

    String getBILL_CLOSE_TIME() {
        return bILL_CLOSE_TIME;
    }

    void setBILL_CLOSE_TIME(String bILL_CLOSE_TIME) {
        this.bILL_CLOSE_TIME = bILL_CLOSE_TIME;
    }

    String getBILLING_STATUS() {
        return bILLING_STATUS;
    }

    void setBILLING_STATUS(String bILLING_STATUS) {
        this.bILLING_STATUS = bILLING_STATUS;
    }

    public String getMACHINE_ID() {
        return mACHINE_ID;
    }

    void setMACHINE_ID(String mACHINE_ID) {
        this.mACHINE_ID = mACHINE_ID;
    }

    String getDB_VERSION() {
        return dB_VERSION;
    }

    void setDB_VERSION(String dB_VERSION) {
        this.dB_VERSION = dB_VERSION;
    }

    String getSERVER_DOMAIN() {
        return sERVER_DOMAIN;
    }

    void setSERVER_DOMAIN(String sERVER_DOMAIN) {
        this.sERVER_DOMAIN = sERVER_DOMAIN;
    }

    String getBIOMETRIC_INTERVAL() {
        return bIOMETRIC_INTERVAL;
    }

    void setBIOMETRIC_INTERVAL(String bIOMETRIC_INTERVAL) {
        this.bIOMETRIC_INTERVAL = bIOMETRIC_INTERVAL;
    }

    String getBIOMETRIC_ENABLE() {
        return bIOMETRIC_ENABLE;
    }

    void setBIOMETRIC_ENABLE(String bIOMETRIC_ENABLE) {
        this.bIOMETRIC_ENABLE = bIOMETRIC_ENABLE;
    }

    String getBILLING_MMYYYY() {
        return bILLING_MMYYYY;
    }

    void setBILLING_MMYYYY(String bILLING_MMYYYY) {
        this.bILLING_MMYYYY = bILLING_MMYYYY;
    }

    String getFTP_UPLOAD() {
        return fTP_UPLOAD;
    }

    void setFTP_UPLOAD(String fTP_UPLOAD) {
        this.fTP_UPLOAD = fTP_UPLOAD;
    }

    String getFTP_DOWNLOAD() {
        return fTP_DOWNLOAD;
    }

    void setFTP_DOWNLOAD(String fTP_DOWNLOAD) {
        this.fTP_DOWNLOAD = fTP_DOWNLOAD;
    }

    String getBIO_PRINT_CNT() {
        return bIO_PRINT_CNT;
    }

    void setBIO_PRINT_CNT(String bIO_PRINT_CNT) {
        this.bIO_PRINT_CNT = bIO_PRINT_CNT;
    }

    String getBilled_Record() {
        return billed_Record;
    }

    void setBilled_Record(String billed_Record) {
        this.billed_Record = billed_Record;
    }

    String getUPLOAD_STATUS() {
        return uPLOAD_STATUS;
    }

    void setUPLOAD_STATUS(String uPLOAD_STATUS) {
        this.uPLOAD_STATUS = uPLOAD_STATUS;
    }

    String getPRINTER_TYPE() {
        return pRINTER_TYPE;
    }

    void setPRINTER_TYPE(String pRINTER_TYPE) {
        this.pRINTER_TYPE = pRINTER_TYPE;
    }

    String getPRE_PRINT() {
        return pRE_PRINT;
    }

    void setPRE_PRINT(String pRE_PRINT) {
        this.pRE_PRINT = pRE_PRINT;
    }

    String getINTR_ON_ARR() {
        return iNTR_ON_ARR;
    }

    void setINTR_ON_ARR(String iNTR_ON_ARR) {
        this.iNTR_ON_ARR = iNTR_ON_ARR;
    }

    String getTAX_ON_EC() {
        return tAX_ON_EC;
    }

    void setTAX_ON_EC(String tAX_ON_EC) {
        this.tAX_ON_EC = tAX_ON_EC;
    }

    String getBT_PRINTER() {
        return bT_PRINTER;
    }

    void setBT_PRINTER(String bT_PRINTER) {
        this.bT_PRINTER = bT_PRINTER;
    }

    String getAPP_VER() {
        return aPP_VER;
    }

    void setAPP_VER(String aPP_VER) {
        this.aPP_VER = aPP_VER;
    }

    String getPRINTER_FORMAT() {
        return pRINTER_FORMAT;
    }

    void setPRINTER_FORMAT(String pRINTER_FORMAT) {
        this.pRINTER_FORMAT = pRINTER_FORMAT;
    }

    public String getFEC() {
        return fEC;
    }

    void setFEC(String fEC) {
        this.fEC = fEC;
    }

    String getDL_FLAG() {
        return dL_FLAG;
    }

    void setDL_FLAG(String dL_FLAG) {
        this.dL_FLAG = dL_FLAG;
    }

    String getNWTRF_DATE() {
        return nWTRF_DATE;
    }

    void setNWTRF_DATE(String nWTRF_DATE) {
        this.nWTRF_DATE = nWTRF_DATE;
    }

    String getFAC_START() {
        return fAC_START;
    }

    void setFAC_START(String fAC_START) {
        this.fAC_START = fAC_START;
    }

    String getFAC_END() {
        return fAC_END;
    }

    void setFAC_END(String fAC_END) {
        this.fAC_END = fAC_END;
    }

    String getTAX_NEW_EFFECT() {
        return tAX_NEW_EFFECT;
    }

    void setTAX_NEW_EFFECT(String tAX_NEW_EFFECT) {
        this.tAX_NEW_EFFECT = tAX_NEW_EFFECT;
    }

    String getINSERT_SSNO() {
        return iNSERT_SSNO;
    }

    void setINSERT_SSNO(String iNSERT_SSNO) {
        this.iNSERT_SSNO = iNSERT_SSNO;
    }

    String getINSERT_EXTRA1() {
        return iNSERT_EXTRA1;
    }

    void setINSERT_EXTRA1(String iNSERT_EXTRA1) {
        this.iNSERT_EXTRA1 = iNSERT_EXTRA1;
    }

    String getINSERT_DATA1() {
        return iNSERT_DATA1;
    }

    void setINSERT_DATA1(String iNSERT_DATA1) {
        this.iNSERT_DATA1 = iNSERT_DATA1;
    }

    String getINSERT_EXTRA2() {
        return iNSERT_EXTRA2;
    }

    void setINSERT_EXTRA2(String iNSERT_EXTRA2) {
        this.iNSERT_EXTRA2 = iNSERT_EXTRA2;
    }

    String getINSERT_DATA2() {
        return iNSERT_DATA2;
    }

    void setINSERT_DATA2(String iNSERT_DATA2) {
        this.iNSERT_DATA2 = iNSERT_DATA2;
    }

    String getINSERT_BMDVAL() {
        return iNSERT_BMDVAL;
    }

    void setINSERT_BMDVAL(String iNSERT_BMDVAL) {
        this.iNSERT_BMDVAL = iNSERT_BMDVAL;
    }

    String getINSERT_INTEREST_AMT() {
        return iNSERT_INTEREST_AMT;
    }

    void setINSERT_INTEREST_AMT(String iNSERT_INTEREST_AMT) {
        this.iNSERT_INTEREST_AMT = iNSERT_INTEREST_AMT;
    }

    String getINSERT_REBATE_AMOUNT() {
        return iNSERT_REBATE_AMOUNT;
    }

    void setINSERT_REBATE_AMOUNT(String iNSERT_REBATE_AMOUNT) {
        this.iNSERT_REBATE_AMOUNT = iNSERT_REBATE_AMOUNT;
    }

    String getINSERT_BMD_PENALTY() {
        return iNSERT_BMD_PENALTY;
    }

    void setINSERT_BMD_PENALTY(String iNSERT_BMD_PENALTY) {
        this.iNSERT_BMD_PENALTY = iNSERT_BMD_PENALTY;
    }

    public int getOld_days() {
        return old_days;
    }

    public void setOld_days(int old_days) {
        this.old_days = old_days;
    }

    public int getNormal_days() {
        return normal_days;
    }

    public void setNormal_days(int normal_days) {
        this.normal_days = normal_days;
    }

    int getBill_read_count() {
        return bill_read_count;
    }

    void setBill_read_count(int bill_read_count) {
        this.bill_read_count = bill_read_count;
    }

    public double getFc_old_value() {
        return fc_old_value;
    }

    public void setFc_old_value(double fc_old_value) {
        this.fc_old_value = fc_old_value;
    }

    public double getFc_normal_value() {
        return fc_normal_value;
    }

    public void setFc_normal_value(double fc_normal_value) {
        this.fc_normal_value = fc_normal_value;
    }

    public double getEc_old_value() {
        return ec_old_value;
    }

    public void setEc_old_value(double ec_old_value) {
        this.ec_old_value = ec_old_value;
    }

    public double getEc_normal_value() {
        return ec_normal_value;
    }

    public void setEc_normal_value(double ec_normal_value) {
        this.ec_normal_value = ec_normal_value;
    }

    public double getFac_days() {
        return fac_days;
    }

    public void setFac_days(double fac_days) {
        this.fac_days = fac_days;
    }

    public double getFac_remaining_days() {
        return fac_remaining_days;
    }

    public void setFac_remaining_days(double fac_remaining_days) {
        this.fac_remaining_days = fac_remaining_days;
    }

    public double getFac_dec_18_days() {
        return fac_dec_18_days;
    }

    public void setFac_dec_18_days(double fac_dec_18_days) {
        this.fac_dec_18_days = fac_dec_18_days;
    }

    public double getFac_dec_18_rate() {
        return fac_dec_18_rate;
    }

    public void setFac_dec_18_rate(double fac_dec_18_rate) {
        this.fac_dec_18_rate = fac_dec_18_rate;
    }

    double getFec() {
        return fec;
    }

    void setFec(double fec) {
        this.fec = fec;
    }

    public String getTax_days_new() {
        return tax_days_new;
    }

    public void setTax_days_new(String tax_days_new) {
        this.tax_days_new = tax_days_new;
    }

    public String getTax_days_old() {
        return tax_days_old;
    }

    public void setTax_days_old(String tax_days_old) {
        this.tax_days_old = tax_days_old;
    }

    double[] getArrFrate() {
        return arrFrate;
    }

    void setArrFrate(double[] arrFrate) {
        this.arrFrate = arrFrate;
    }

    double[] getArrFslab() {
        return arrFslab;
    }

    void setArrFslab(double[] arrFslab) {
        this.arrFslab = arrFslab;
    }

    double[] getArrErate() {
        return arrErate;
    }

    void setArrErate(double[] arrErate) {
        this.arrErate = arrErate;
    }

    double[] getArrEslab() {
        return arrEslab;
    }

    void setArrEslab(double[] arrEslab) {
        this.arrEslab = arrEslab;
    }

    double[] getArrEc() {
        return arrEc;
    }

    void setArrEc(double[] arrEc) {
        this.arrEc = arrEc;
    }

    double[] getArrFc() {
        return arrFc;
    }

    void setArrFc(double[] arrFc) {
        this.arrFc = arrFc;
    }

    double[] getArrFrate_old() {
        return arrFrate_old;
    }

    void setArrFrate_old(double[] arrFrate_old) {
        this.arrFrate_old = arrFrate_old;
    }

    double[] getArrFslab_old() {
        return arrFslab_old;
    }

    void setArrFslab_old(double[] arrFslab_old) {
        this.arrFslab_old = arrFslab_old;
    }

    double[] getArrErate_old() {
        return arrErate_old;
    }

    void setArrErate_old(double[] arrErate_old) {
        this.arrErate_old = arrErate_old;
    }

    double[] getArrEslab_old() {
        return arrEslab_old;
    }

    void setArrEslab_old(double[] arrEslab_old) {
        this.arrEslab_old = arrEslab_old;
    }

    double[] getArrEc_old() {
        return arrEc_old;
    }

    void setArrEc_old(double[] arrEc_old) {
        this.arrEc_old = arrEc_old;
    }

    double[] getArrFc_old() {
        return arrFc_old;
    }

    void setArrFc_old(double[] arrFc_old) {
        this.arrFc_old = arrFc_old;
    }

    double[] getArrdlFslab() {
        return arrdlFslab;
    }

    void setArrdlFslab(double[] arrdlFslab) {
        this.arrdlFslab = arrdlFslab;
    }

    double[] getArrdlFslab_old() {
        return arrdlFslab_old;
    }

    void setArrdlFslab_old(double[] arrdlFslab_old) {
        this.arrdlFslab_old = arrdlFslab_old;
    }

    String getCONSUMER_NAME() {
        return CONSUMER_NAME;
    }

    public void setCONSUMER_NAME(String CONSUMER_NAME) {
        this.CONSUMER_NAME = CONSUMER_NAME;
    }

    String getTARIFFBILLING() {
        return TARIFFBILLING;
    }

    public void setTARIFFBILLING(String TARIFFBILLING) {
        this.TARIFFBILLING = TARIFFBILLING;
    }

    public String getSANC_LOAD() {
        return SANC_LOAD;
    }

    public void setSANC_LOAD(String SANC_LOAD) {
        this.SANC_LOAD = SANC_LOAD;
    }

    public String getKW() {
        return KW;
    }

    public void setKW(String KW) {
        this.KW = KW;
    }

    String getPREVREAD() {
        return PREVREAD;
    }

    public void setPREVREAD(String PREVREAD) {
        this.PREVREAD = PREVREAD;
    }

    String getOLDIR() {
        return OLDIR;
    }

    public void setOLDIR(String OLDIR) {
        this.OLDIR = OLDIR;
    }

    String getOLDFR() {
        return OLDFR;
    }

    public void setOLDFR(String OLDFR) {
        this.OLDFR = OLDFR;
    }

    String getLEGFALIO() {
        return LEGFALIO;
    }

    public void setLEGFALIO(String LEGFALIO) {
        this.LEGFALIO = LEGFALIO;
    }

    public String getCONSID() {
        return CONSID;
    }

    public void setCONSID(String CONSID) {
        this.CONSID = CONSID;
    }

    String getRRBTFLAG() {
        return RRBTFLAG;
    }

    public void setRRBTFLAG(String RRBTFLAG) {
        this.RRBTFLAG = RRBTFLAG;
    }

    public String getPF() {
        return PF;
    }

    public void setPF(String PF) {
        this.PF = PF;
    }

    public String getBMD() {
        return BMD;
    }

    public void setBMD(String BMD) {
        this.BMD = BMD;
    }

    String getASD() {
        return ASD;
    }

    public void setASD(String ASD) {
        this.ASD = ASD;
    }

    public String getBILLNO() {
        return BILLNO;
    }

    public void setBILLNO(String BILLNO) {
        this.BILLNO = BILLNO;
    }

    public String getInterest() {
        return Interest;
    }

    public void setInterest(String interest) {
        Interest = interest;
    }

    String getINTEREST_ON_DEPOSIT() {
        return INTEREST_ON_DEPOSIT;
    }

    public void setINTEREST_ON_DEPOSIT(String INTEREST_ON_DEPOSIT) {
        this.INTEREST_ON_DEPOSIT = INTEREST_ON_DEPOSIT;
    }

    String getBILLDAYS() {
        return BILLDAYS;
    }

    public void setBILLDAYS(String BILLDAYS) {
        this.BILLDAYS = BILLDAYS;
    }

    String getMTR_SLNO() {
        return MTR_SLNO;
    }

    public void setMTR_SLNO(String MTR_SLNO) {
        this.MTR_SLNO = MTR_SLNO;
    }

    String getCHQ_DISHONOUR_FLAG() {
        return CHQ_DISHONOUR_FLAG;
    }

    public void setCHQ_DISHONOUR_FLAG(String CHQ_DISHONOUR_FLAG) {
        this.CHQ_DISHONOUR_FLAG = CHQ_DISHONOUR_FLAG;
    }

    public String getMTRFLAG() {
        return MTRFLAG;
    }

    public void setMTRFLAG(String MTRFLAG) {
        this.MTRFLAG = MTRFLAG;
    }

    String getCREDIT_ADJ() {
        return CREDIT_ADJ;
    }

    public void setCREDIT_ADJ(String CREDIT_ADJ) {
        this.CREDIT_ADJ = CREDIT_ADJ;
    }

    String getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(String LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    String getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(String LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    String getEMAIL_ID() {
        return EMAIL_ID;
    }

    public void setEMAIL_ID(String EMAIL_ID) {
        this.EMAIL_ID = EMAIL_ID;
    }

    String getELECTION_CARD_NO() {
        return ELECTION_CARD_NO;
    }

    public void setELECTION_CARD_NO(String ELECTION_CARD_NO) {
        this.ELECTION_CARD_NO = ELECTION_CARD_NO;
    }

    String getWATER_CON_NO() {
        return WATER_CON_NO;
    }

    public void setWATER_CON_NO(String WATER_CON_NO) {
        this.WATER_CON_NO = WATER_CON_NO;
    }

    String getHOME_NO() {
        return HOME_NO;
    }

    public void setHOME_NO(String HOME_NO) {
        this.HOME_NO = HOME_NO;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public double getFac_old_days() {
        return fac_old_days;
    }

    public void setFac_old_days(double fac_old_days) {
        this.fac_old_days = fac_old_days;
    }

    String getFAC_OLD() {
        return FAC_OLD;
    }

    void setFAC_OLD(String FAC_OLD) {
        this.FAC_OLD = FAC_OLD;
    }

    public String getFAC_DEC_18() {
        return FAC_DEC_18;
    }

    public void setFAC_DEC_18(String FAC_DEC_18) {
        this.FAC_DEC_18 = FAC_DEC_18;
    }

    public String getFAC_DEC_18_RATE() {
        return FAC_DEC_18_RATE;
    }

    public void setFAC_DEC_18_RATE(String FAC_DEC_18_RATE) {
        this.FAC_DEC_18_RATE = FAC_DEC_18_RATE;
    }

    public String getData2_1() {
        return data2_1;
    }

    public void setData2_1(String data2_1) {
        this.data2_1 = data2_1;
    }

    public String getData2_2() {
        return data2_2;
    }

    public void setData2_2(String data2_2) {
        this.data2_2 = data2_2;
    }

    public String getData2_3() {
        return data2_3;
    }

    public void setData2_3(String data2_3) {
        this.data2_3 = data2_3;
    }

    public double getFac_old() {
        return fac_old;
    }

    public void setFac_old(double fac_old) {
        this.fac_old = fac_old;
    }

    String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    String getMTRXCHNGFLG() {
        return mTRXCHNGFLG;
    }

    public void setMTRXCHNGFLG(String mTRXCHNGFLG) {
        this.mTRXCHNGFLG = mTRXCHNGFLG;
    }

    String getMTRCHGOLDUNITS() {
        return mTRCHGOLDUNITS;
    }

    void setMTRCHGOLDUNITS(String mTRCHGOLDUNITS) {
        this.mTRCHGOLDUNITS = mTRCHGOLDUNITS;
    }

    public String getError_id() {
        return error_id;
    }

    void setError_id(String error_id) {
        this.error_id = error_id;
    }
}