package com.esioner.myapplication.neihan.neihanbean;


import com.esioner.myapplication.neihan.neihanbean.imgBean.ImageUrl;


import java.util.List;

public class OriginVideo {
    public int height;
    public String uri;
    public int width;
    public List<ImageUrl> urlList;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<ImageUrl> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<ImageUrl> urlList) {
        this.urlList = urlList;
    }
}
