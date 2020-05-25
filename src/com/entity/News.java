package com.entity;

import java.util.Date;

public class News {

    private String title;
    private String url;
    private Date pubdate;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Date getPubdate() {
        return pubdate;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", pubdate=" + pubdate +
                '}';
    }
}
