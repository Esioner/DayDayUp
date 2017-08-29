package com.esioner.myapplication.neihan.neihanbean.NeiHanBean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NeiHanVideoBean {
    public int height;
    public int width;
    public String uri;
    @SerializedName("url_list")
    public List<UrlList> urlLists;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<UrlList> getUrlLists() {
        return urlLists;
    }

    public void setUrlLists(List<UrlList> urlLists) {
        this.urlLists = urlLists;
    }
}
