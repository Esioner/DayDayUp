package com.esioner.myapplication.neihan.neihanbean.neiHanBean;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NeiHanImageBean {
    public String height;
    public String width;
    @SerializedName("r_height")
    public String rHeight;
    @SerializedName("r_width")
    public String rWidth;

    public String uri;
    @SerializedName("url_list")
    public List<UrlList> urlLists;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getrHeight() {
        return rHeight;
    }

    public void setrHeight(String rHeight) {
        this.rHeight = rHeight;
    }

    public String getrWidth() {
        return rWidth;
    }

    public void setrWidth(String rWidth) {
        this.rWidth = rWidth;
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
