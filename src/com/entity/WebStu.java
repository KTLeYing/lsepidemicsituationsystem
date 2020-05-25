package com.entity;

public class WebStu {

    private String sdept;
    private int sishotNum;
    private int siscoughNum;
    private int sstatusNum;
    private int sisseemNum;
    private int sisdiagnoseNum;

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public void setSishotNum(int sishotNum) {
        this.sishotNum = sishotNum;
    }

    public void setSiscoughNum(int siscoughNum) {
        this.siscoughNum = siscoughNum;
    }

    public void setSstatusNum(int sstatusNum) {
        this.sstatusNum = sstatusNum;
    }

    public void setSisseemNum(int sisseemNum) {
        this.sisseemNum = sisseemNum;
    }

    public void setSisdiagnoseNum(int sisdiagnoseNum) {
        this.sisdiagnoseNum = sisdiagnoseNum;
    }

    public String getSdept() {
        return sdept;
    }

    public int getSishotNum() {
        return sishotNum;
    }

    public int getSiscoughNum() {
        return siscoughNum;
    }

    public int getSstatusNum() {
        return sstatusNum;
    }

    public int getSisseemNum() {
        return sisseemNum;
    }

    public int getSisdiagnoseNum() {
        return sisdiagnoseNum;
    }

    @Override
    public String toString() {
        return "WebStu{" +
                "sdept='" + sdept + '\'' +
                ", sishotNum=" + sishotNum +
                ", siscoughNum=" + siscoughNum +
                ", sstatusNum=" + sstatusNum +
                ", sisseemNum=" + sisseemNum +
                ", sisdiagnoseNum=" + sisdiagnoseNum +
                '}';
    }
}
