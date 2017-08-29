package com.esioner.myapplication.neihan.neihanbean.NeiHanBean;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NeiHanBean {

    private String message;
    private NeiHanRootDataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NeiHanRootDataBean getData() {
        return data;
    }

    public void setData(NeiHanRootDataBean data) {
        this.data = data;
    }
}