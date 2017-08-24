package com.esioner.myapplication.neihan.neihanbean.imgBean;


import com.esioner.myapplication.neihan.neihanbean.commonBean.GroupBean;
import com.google.gson.annotations.SerializedName;

public class ImageGroupBean extends GroupBean {
    @SerializedName("large_image")
    public LargeImage largeImage;
    @SerializedName("middle_image")
    public MiddleImage middleImage;

    public LargeImage getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(LargeImage largeImage) {
        this.largeImage = largeImage;
    }

    public MiddleImage getMiddleImage() {
        return middleImage;
    }

    public void setMiddleImage(MiddleImage middleImage) {
        this.middleImage = middleImage;
    }
}
