package com.esioner.myapplication.neihan.neihanbean.jokeBean;


import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("avatar_url")
    public String headImage;
    public String name;

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
