package com.esioner.myapplication.neihan.neihanbean.jokeBean;


import com.google.gson.annotations.SerializedName;

public class GroupBean {
    @SerializedName("category_name")
    public String prefix;
    public String content;
    @SerializedName("user")
    public UserInfo userInfo;


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
}
