package com.esioner.myapplication.neihan.neihanbean.commonBean;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataBean {
    @SerializedName("data")
    public List<Datas> datas;
    public String has_more;
    public String has_new_message;
    public double max_time;
    public double min_time;
    public String tip;
    //
    public List<GroupBean> imgData;

    public double getMax_time() {
        return max_time;
    }

    public void setMax_time(double max_time) {
        this.max_time = max_time;
    }

    public double getMin_time() {
        return min_time;
    }

    public void setMin_time(double min_time) {
        this.min_time = min_time;
    }

    public List<Datas> getDatas() {
        return datas;
    }

    public void setDatas(List<Datas> datas) {
        this.datas = datas;
    }

    public String getHas_more() {
        return has_more;
    }

    public void setHas_more(String has_more) {
        this.has_more = has_more;
    }

    public String getHas_new_message() {
        return has_new_message;
    }

    public void setHas_new_message(String has_new_message) {
        this.has_new_message = has_new_message;
    }
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
