package com.entity;

public class Teacher {

    private String tno;
    private String tname;
    private String tsex;
    private int tage;
    private String tdept;
    private String tphone;
    private String tpsw;

    public void setTno(String tno) {
        this.tno = tno;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public void setTpsw(String tpsw) {
        this.tpsw = tpsw;
    }

    public String getTno() {
        return tno;
    }

    public String getTname() {
        return tname;
    }

    public String getTsex() {
        return tsex;
    }

    public int getTage() {
        return tage;
    }

    public String getTdept() {
        return tdept;
    }

    public String getTphone() {
        return tphone;
    }

    public String getTpsw() {
        return tpsw;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tage=" + tage +
                ", tdept='" + tdept + '\'' +
                ", tphone='" + tphone + '\'' +
                ", tpsw='" + tpsw + '\'' +
                '}';
    }
}
