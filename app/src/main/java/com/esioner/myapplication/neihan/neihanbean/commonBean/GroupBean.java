package com.esioner.myapplication.neihan.neihanbean.commonBean;


import com.esioner.myapplication.neihan.neihanbean.OriginVideo;
import com.esioner.myapplication.neihan.neihanbean.imgBean.LargeImage;
import com.esioner.myapplication.neihan.neihanbean.imgBean.MiddleImage;
import com.google.gson.annotations.SerializedName;

public class GroupBean {
    @SerializedName("category_name")
    public String prefix;
    @SerializedName("text")
    public String content;
    @SerializedName("user")
    public UserInfo userInfo;
    @SerializedName("media_type")
    public int mediaType;
    @SerializedName("bury_count")
    public int dislikeCount;
    @SerializedName("digg_count")
    public int likeCount;

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

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


    //图片字段
    @SerializedName("large_image")
    public LargeImage largeImage;
    @SerializedName("middle_image")
    public MiddleImage middleImage;

    public LargeImage getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(LargeImage largeImage) {
        this.largeImage = largeImage;
    }

    public MiddleImage getMiddleImage() {
        return middleImage;
    }

    public void setMiddleImage(MiddleImage middleImage) {
        this.middleImage = middleImage;
    }

    //视频字段
    @SerializedName("origin_video")
    public OriginVideo originVideo;
    @SerializedName("medium_cover")
    public MediumCover mediumCover;
    @SerializedName("mp4_url")
    public String videoUrl;

    public OriginVideo getOriginVideo() {
        return originVideo;
    }

    public void setOriginVideo(OriginVideo originVideo) {
        this.originVideo = originVideo;
    }

    public MediumCover getMediumCover() {
        return mediumCover;
    }

    public void setMediumCover(MediumCover mediumCover) {
        this.mediumCover = mediumCover;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
