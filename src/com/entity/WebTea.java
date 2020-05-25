package com.entity;

public class WebTea {

    private String tdept;
    private int tishotNum;
    private int tiscoughNum;
    private int tstatusNum;
    private int tisseemNum;
    private int tisdiagnoseNum;

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public void setTishotNum(int tishotNum) {
        this.tishotNum = tishotNum;
    }

    public void setTiscoughNum(int tiscoughNum) {
        this.tiscoughNum = tiscoughNum;
    }

    public void setTstatusNum(int tstatusNum) {
        this.tstatusNum = tstatusNum;
    }

    public void setTisseemNum(int tisseemNum) {
        this.tisseemNum = tisseemNum;
    }

    public void setTisdiagnoseNum(int tisdiagnoseNum) {
        this.tisdiagnoseNum = tisdiagnoseNum;
    }

    public String getTdept() {
        return tdept;
    }

    public int getTishotNum() {
        return tishotNum;
    }

    public int getTiscoughNum() {
        return tiscoughNum;
    }

    public int getTstatusNum() {
        return tstatusNum;
    }

    public int getTisseemNum() {
        return tisseemNum;
    }

    public int getTisdiagnoseNum() {
        return tisdiagnoseNum;
    }

    @Override
    public String toString() {
        return "WebTea{" +
                "tdept='" + tdept + '\'' +
                ", tishotNum=" + tishotNum +
                ", tiscoughNum=" + tiscoughNum +
                ", tstatusNum=" + tstatusNum +
                ", tisseemNum=" + tisseemNum +
                ", tisdiagnoseNum=" + tisdiagnoseNum +
                '}';
    }
}
