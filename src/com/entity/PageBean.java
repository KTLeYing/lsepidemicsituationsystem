package com.entity;

import java.util.ArrayList;

public class PageBean<T> {

    private int totalCount;//总记录数
    private int totalPage;//总页码
    private ArrayList<T> arrayList;//每页的数据
    private int currentPage;//当前页码
    private int rows;//每页的记录数

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setArrayList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "PageBean1{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", arrayList=" + arrayList +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
