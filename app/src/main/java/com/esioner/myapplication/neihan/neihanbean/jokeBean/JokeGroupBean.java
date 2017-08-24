package com.esioner.myapplication.neihan.neihanbean.jokeBean;


import com.esioner.myapplication.neihan.neihanbean.commonBean.GroupBean;
import com.esioner.myapplication.neihan.neihanbean.commonBean.UserInfo;
import com.google.gson.annotations.SerializedName;

public class JokeGroupBean extends GroupBean {
    @SerializedName("category_name")
    public String prefix;
    @SerializedName("text")
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
