package com.esioner.myapplication.oneDayOneArticle;


import com.google.gson.annotations.SerializedName;

public class JsonBean {
    public String author;
    public String content;

    /**
     * 首段
     */
    public String digest;
    public String title;
    public int wc;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWc() {
        return wc;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

}
