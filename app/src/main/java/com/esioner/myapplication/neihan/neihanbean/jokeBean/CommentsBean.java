package com.esioner.myapplication.neihan.neihanbean.jokeBean;


import com.google.gson.annotations.SerializedName;

public class CommentsBean {
    @SerializedName("avatar_url")
    public String userHeadImg;
    @SerializedName("user_name")
    public String userName;
    @SerializedName("text")
    public String comment;

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
