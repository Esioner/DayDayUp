package com.esioner.myapplication.neihan.neihanbean.commonBean;


import com.esioner.myapplication.neihan.neihanbean.jokeBean.*;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datas {
    @SerializedName("comments")
    List<CommentsBean> comments;
    @SerializedName("display_time")
    public double displayTime;
    @SerializedName("online_time")
    public double onlineTime;
    public int type;
    public JokeGroupBean group;


    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }


    public double getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(double displayTime) {
        this.displayTime = displayTime;
    }

    public double getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(double onlineTime) {
        this.onlineTime = onlineTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public JokeGroupBean getGroup() {
        return group;
    }

    public void setGroup(JokeGroupBean group) {
        this.group = group;
    }
}
