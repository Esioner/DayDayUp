package com.esioner.myapplication.neihan.neihanbean.commonBean;


import com.esioner.myapplication.neihan.neihanbean.imgBean.ImageUrl;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MediumCover {
    public String uri;
    @SerializedName("url_list")
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
