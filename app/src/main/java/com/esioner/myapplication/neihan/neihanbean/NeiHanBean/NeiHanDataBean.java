package com.esioner.myapplication.neihan.neihanbean.NeiHanBean;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NeiHanDataBean {

    private List<?> comments;
    private NeiHanGroupBean group;
    private int type;
    @SerializedName("display_time")
    private float displayTime;
    @SerializedName("online_time")
    private float onlineTime;

    public List<?> getComments() {
        return comments;
    }

    public void setComments(List<?> comments) {
        this.comments = comments;
    }

    public NeiHanGroupBean getGroup() {
        return group;
    }

    public void setGroup(NeiHanGroupBean group) {
        this.group = group;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(float displayTime) {
        this.displayTime = displayTime;
    }

    public float getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(float onlineTime) {
        this.onlineTime = onlineTime;
    }
}
