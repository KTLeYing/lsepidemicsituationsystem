package com.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class TeaPunch {

    private String tno;
    private String tname;
    private String tdept;
    private String tispunch;
    private Date tpunchdate;
    private String tpunchtime;
    private String tishot;
    private String tiscough;
    private String tisseem;
    private String tisdiagnose;
    private String tstatus;

    public void setTno(String tno) {
        this.tno = tno;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public void setTispunch(String tispunch) {
        this.tispunch = tispunch;
    }

    public void setTpunchdate(Date tpunchdate) {
        this.tpunchdate = tpunchdate;
    }

    public void setTpunchtime(String tpunchtime) {
        this.tpunchtime = tpunchtime;
    }

    public void setTishot(String tishot) {
        this.tishot = tishot;
    }

    public void setTiscough(String tiscough) {
        this.tiscough = tiscough;
    }

    public void setTisseem(String tisseem) {
        this.tisseem = tisseem;
    }

    public void setTisdiagnose(String tisdiagnose) {
        this.tisdiagnose = tisdiagnose;
    }

    public void setTstatus(String tstatus) {
        this.tstatus = tstatus;
    }

    public String getTno() {
        return tno;
    }

    public String getTname() {
        return tname;
    }

    public String getTdept() {
        return tdept;
    }

    public String getTispunch() {
        return tispunch;
    }

    public Date getTpunchdate() {
        return tpunchdate;
    }

    public String getTpunchtime() {
        return tpunchtime;
    }

    public String getTishot() {
        return tishot;
    }

    public String getTiscough() {
        return tiscough;
    }

    public String getTisseem() {
        return tisseem;
    }

    public String getTisdiagnose() {
        return tisdiagnose;
    }

    public String getTstatus() {
        return tstatus;
    }

    @Override
    public String toString() {
        return "TeaPunch{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tdept='" + tdept + '\'' +
                ", tispunch='" + tispunch + '\'' +
                ", tpunchdate=" + tpunchdate +
                ", tpunchtime='" + tpunchtime + '\'' +
                ", tishot='" + tishot + '\'' +
                ", tiscough='" + tiscough + '\'' +
                ", tisseem='" + tisseem + '\'' +
                ", tisdiagnose='" + tisdiagnose + '\'' +
                ", tstatus='" + tstatus + '\'' +
                '}';
    }
}
