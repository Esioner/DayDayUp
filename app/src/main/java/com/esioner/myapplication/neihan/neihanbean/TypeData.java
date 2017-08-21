package com.esioner.myapplication.neihan.neihanbean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Esioner on 2017/8/21.
 */

public class TypeData {

    @SerializedName("double_col_mode")
    public boolean doubleColMode;
    @SerializedName("umeng_event")
    public String umengEvent;
    @SerializedName("is_default_tab")
    public boolean isDefaultTab;
    public String url;
    @SerializedName("list_id")
    public int listId;
    @SerializedName("refresh_interval")
    public int refreshInterval;
    public int type;
    public String name;

    public boolean isDoubleColMode() {
        return doubleColMode;
    }

    public void setDoubleColMode(boolean doubleColMode) {
        this.doubleColMode = doubleColMode;
    }

    public String getUmengEvent() {
        return umengEvent;
    }

    public void setUmengEvent(String umengEvent) {
        this.umengEvent = umengEvent;
    }

    public boolean isDefaultTab() {
        return isDefaultTab;
    }

    public void setDefaultTab(boolean defaultTab) {
        isDefaultTab = defaultTab;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(int refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
