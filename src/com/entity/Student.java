package com.entity;

public class Student {

    private String sno;
    private String sname;
    private String ssex;
    private int sage;
    private String sclass;
    private String specialty;
    private String sdept;
    private String sphone;
    private String spsw;

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public void setSpsw(String spsw) {
        this.spsw = spsw;
    }

    public String getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public String getSsex() {
        return ssex;
    }

    public int getSage() {
        return sage;
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

    public String getSphone() {
        return sphone;
    }

    public String getSpsw() {
        return spsw;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", sclass='" + sclass + '\'' +
                ", specialty='" + specialty + '\'' +
                ", sdept='" + sdept + '\'' +
                ", sphone='" + sphone + '\'' +
                ", spsw='" + spsw + '\'' +
                '}';
    }
}
