package com.esioner.myapplication.neihan.neihanbean.commonBean;


import com.esioner.myapplication.neihan.neihanbean.imgBean.LargeImage;
import com.esioner.myapplication.neihan.neihanbean.imgBean.MiddleImage;
import com.google.gson.annotations.SerializedName;

public class GroupBean {
    @SerializedName("category_name")
    public String prefix;
    @SerializedName("text")
    public String content;
    @SerializedName("user")
    public UserInfo userInfo;
    @SerializedName("media_type")
    public int mediaType;

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {

        this.userInfo = userInfo;
    }


    //图片字段
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