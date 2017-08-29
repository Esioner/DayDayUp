package com.esioner.myapplication.neihan.neihanbean.neiHanBean;


import com.google.gson.annotations.SerializedName;

public class NeiHanGifVideo {
    @SerializedName("360p_video")
    public NeiHanVideoBean video$360;
    @SerializedName("480p_video")
    public NeiHanVideoBean video$480;
    @SerializedName("720p_video")
    public NeiHanVideoBean video$720;
    @SerializedName("origin_video")
    public NeiHanVideoBean originVideo;
    @SerializedName("cover_image_uri")
    public String coverImageUri;
    public double duration;
    @SerializedName("mp4_url")
    public String mp4Url;
    @SerializedName("video_id")
    public String videoId;
    @SerializedName("video_height")
    public String videoHeight;
    @SerializedName("video_width")
    public String videoWidth;


    public NeiHanVideoBean getVideo$360() {
        return video$360;
    }

    public void setVideo$360(NeiHanVideoBean video$360) {
        this.video$360 = video$360;
    }

    public NeiHanVideoBean getVideo$480() {
        return video$480;
    }

    public void setVideo$480(NeiHanVideoBean video$480) {
        this.video$480 = video$480;
    }

    public NeiHanVideoBean getVideo$720() {
        return video$720;
    }

    public void setVideo$720(NeiHanVideoBean video$720) {
        this.video$720 = video$720;
    }

    public NeiHanVideoBean getOriginVideo() {
        return originVideo;
    }

    public void setOriginVideo(NeiHanVideoBean originVideo) {
        this.originVideo = originVideo;
    }

    public String getCoverImageUri() {
        return coverImageUri;
    }

    public void setCoverImageUri(String coverImageUri) {
        this.coverImageUri = coverImageUri;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getMp4Url() {
        return mp4Url;
    }

    public void setMp4Url(String mp4Url) {
        this.mp4Url = mp4Url;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(String videoHeight) {
        this.videoHeight = videoHeight;
    }

    public String getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(String videoWidth) {
        this.videoWidth = videoWidth;
    }
}
