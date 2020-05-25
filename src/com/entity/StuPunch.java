package com.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StuPunch {

    private String sno;
    private String sname;
    private String sclass;
    private String specialty;
    private String sdept;
    private String sispunch;
    private Date spunchdate;
    private String spunchtime;
    private String sishot;
    private String siscough;
    private String sisseem;
    private String sisdiagnose;
    private String sstatus;

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setSispunch(String sispunch) {
        this.sispunch = sispunch;
    }

    public void setSpunchdate(Date spunchdate) {
        this.spunchdate = spunchdate;
    }

    public void setSpunchtime(String spunchtime) {
        this.spunchtime = spunchtime;
    }

    public void setSishot(String sishot) {
        this.sishot = sishot;
    }

    public void setSiscough(String siscough) {
        this.siscough = siscough;
    }

    public void setSisseem(String sisseem) {
        this.sisseem = sisseem;
    }

    public void setSisdiagnose(String sisdiagnose) {
        this.sisdiagnose = sisdiagnose;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }

    public String getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public String getSclass() {
        return sclass;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getSdept() {
        return sdept;
    }

    public String getSispunch() {
        return sispunch;
    }

    public Date getSpunchdate() {
        return spunchdate;
    }

    public String getSpunchtime() {
        return spunchtime;
    }

    public String getSishot() {
        return sishot;
    }

    public String getSiscough() {
        return siscough;
    }

    public String getSisseem() {
        return sisseem;
    }

    public String getSisdiagnose() {
        return sisdiagnose;
    }

    public String getSstatus() {
        return sstatus;
    }

    @Override
    public String toString() {
        return "StuPunch{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sclass='" + sclass + '\'' +
                ", specialty='" + specialty + '\'' +
                ", sdept='" + sdept + '\'' +
                ", sispunch='" + sispunch + '\'' +
                ", spunchdate=" + spunchdate +
                ", spunchtime='" + spunchtime + '\'' +
                ", sishot='" + sishot + '\'' +
                ", siscough='" + siscough + '\'' +
                ", sisseem='" + sisseem + '\'' +
                ", sisdiagnose='" + sisdiagnose + '\'' +
                ", sstatus='" + sstatus + '\'' +
                '}';
    }
}
