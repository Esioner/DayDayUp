package com.esioner.myapplication.neihan.neihanbean.imgBean;

import java.util.List;

public class MiddleImage {

    public int height;
    public int rHeight;
    public int rWidth;
    public String uri;
    public int width;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<UrlList> getUrlLists() {
        return urlLists;
    }

    public void setUrlLists(List<UrlList> urlLists) {
        this.urlLists = urlLists;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getrHeight() {
        return rHeight;
    }

    public void setrHeight(int rHeight) {
        this.rHeight = rHeight;
    }

    public int getrWidth() {
        return rWidth;
    }

    public void setrWidth(int rWidth) {
        this.rWidth = rWidth;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<UrlList> urlLists;

}
