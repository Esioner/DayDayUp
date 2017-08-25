package com.esioner.myapplication.neihan.neihanbean.commonBean;


public class NeedBean {
    public String userTextPrefix;
    public String userName;
    public String userText;
    public String userHeadImg;
    public String commentName;
    public String commentHeadImg;
    public String commentText;
    public int mediaType;
    /**
     * 图片 URL
     */
    public String imageLargeUrl;
    public String imageMiddleImage;

    public String getImageLargeUrl() {
        return imageLargeUrl;
    }

    public void setImageLargeUrl(String imageLargeUrl) {
        this.imageLargeUrl = imageLargeUrl;
    }

    public String getImageMiddleImage() {
        return imageMiddleImage;
    }

    public void setImageMiddleImage(String imageMiddleImage) {
        this.imageMiddleImage = imageMiddleImage;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public String getUserTextPrefix() {
        return userTextPrefix;
    }

    public void setUserTextPrefix(String userTextPrefix) {
        this.userTextPrefix = userTextPrefix;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentHeadImg() {
        return commentHeadImg;
    }

    public void setCommentHeadImg(String commentHeadImg) {
        this.commentHeadImg = commentHeadImg;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}

