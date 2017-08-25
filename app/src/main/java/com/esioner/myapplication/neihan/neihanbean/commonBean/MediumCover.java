package com.esioner.myapplication.neihan.neihanbean.commonBean;


import com.esioner.myapplication.neihan.neihanbean.imgBean.ImageUrl;

import java.util.List;

public class MediumCover {
    public String uri;
    public List<ImageUrl> urlLists;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<ImageUrl> getUrlLists() {
        return urlLists;
    }

    public void setUrlLists(List<ImageUrl> urlLists) {
        this.urlLists = urlLists;
    }
}
