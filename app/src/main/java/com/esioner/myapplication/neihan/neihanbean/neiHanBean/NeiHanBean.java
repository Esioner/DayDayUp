package com.esioner.myapplication.neihan.neihanbean.neiHanBean;


public class NeiHanBean {

    /**
     * 成功时为 success
     */
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