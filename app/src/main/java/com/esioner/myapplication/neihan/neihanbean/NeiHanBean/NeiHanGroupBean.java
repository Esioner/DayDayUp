package com.esioner.myapplication.neihan.neihanbean.NeiHanBean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Create: 2017/8/29
 * Writer: liurui
 * Phone:  13554142421
 * Email:  16801630@qq.com
 */

public class NeiHanGroupBean {
    //num
    public NeiHanVideoBean video$360;
    public NeiHanVideoBean video$480;
    public NeiHanVideoBean video$720;

    //A
    @SerializedName("allow_dislike")
    private boolean allowDislike;
    //B
    @SerializedName("bury_count")
    private int buryCount;
    //C
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("category_name")
    private String categoryName;
    //Picture
    @SerializedName("category_type")
    private int categoryType;

    @SerializedName("category_visible")
    private boolean categoryVisible;

    private String content;
    @SerializedName("comment_count")
    private int commentCount;
    @SerializedName("cover_image_uri")
    public String coverImageUri;
    @SerializedName("cover_image_url")
    public String coverImageUrl;
    @SerializedName("create_time")
    private int createTime;
    //D
    /**
     * Video
     */
    @SerializedName("danmaku_attrs")
    public DanmakuAttrs danmakuAttrs;
    @SerializedName("download_url")
    public String downloadUrl;
    public double duration;

    @SerializedName("digg_count")
    private int diggCount;
    //    @SerializedName("dislike_reason")
//    private List<NeiHanDislikeReasonBean> dislikeReasonBeen;
    @SerializedName("display_type")
    private int displayType;

    //E
    //F
    @SerializedName("favorite_count")
    private int favoriteCount;

    /**
     * video
     */
    @SerializedName("flash_url")
    public String flashUrl;
    //G
    @SerializedName("go_detail_count")
    public long goDetailCount;
    @SerializedName("group_id")
    private long groupId;
    //H
    @SerializedName("has_comments")
    private int hasComments;
    @SerializedName("has_hot_comments")
    private int hasHotComments;
    //I
    private long id;
    @SerializedName("id_str")
    private String idStr;

    /**
     * Pic
     */
    @SerializedName("image_status")
    private int imageStatus;
    @SerializedName("is_gif")
    private int isGif;

    @SerializedName("is_can_share")
    private int isCanShare;
    @SerializedName("is_anonymous")
    private boolean isAnonymous;
    @SerializedName("is_neihan_hot")
    private boolean isNeihanHot;
    @SerializedName("is_personal_show")
    private boolean isPersonalShow;
    /**
     * Video
     */
    @SerializedName("is_public_url")
    private int isPublicUrl;
    @SerializedName("is_video")
    private int isVideo;
    //J
    //K
    private String keywords;
    //L
    private int label;
    /**
     * Pic
     */
    @SerializedName("large_image")
    private NeiHanImageBean largeImage;

    /**
     * Video
     */
    @SerializedName("large_cover")
    private NeiHanImageBean largeCover;
    @SerializedName("m3u8_url")
    private String m3u8Url;

    //M
    @SerializedName("media_type")
    private int mediaType;
    /**
     * Video
     */
    @SerializedName("medium_cover")
    private NeiHanImageBean mediumCover;
    @SerializedName("mp4_url")
    private String mp4Url;
    /**
     * Pic
     */
    @SerializedName("max_screen_width_percent")
    private float maxScreenWidthPercent;
    @SerializedName("middle_image")
    private NeiHanImageBean middleImage;
    @SerializedName("min_screen_width_percent")
    private float minScreenWidthPercent;
    //N
    //Picture
    private NeiHanGifVideo neiHanGifVideo;

    @SerializedName("neihan_hot_start_time")
    private String neiHanHotStartTime;
    @SerializedName("neihan_hot_end_time")
    private String neiHanHotEndTime;
    @SerializedName("neihan_hot_link")
    private NeihanHotLinkBean neiHanHotLinkBean;
    //O
    @SerializedName("online_time")
    private int onlineTime;

    @SerializedName("origin_video")
    private NeiHanVideoBean originVideo;

    //P
    @SerializedName("play_count")
    private int playCount;
    @SerializedName("publish_time")
    private String publishTime;
    //Q
    @SerializedName("quick_comment")
    private boolean quickComment;
    //R
    /**
     * 转发数
     */
    @SerializedName("repin_count")
    private int repinCount;
    //S
    @SerializedName("share_count")
    private int shareCount;
    @SerializedName("share_type")
    private int shareType;
    @SerializedName("share_url")
    private String shareUrl;
    private int status;
    @SerializedName("status_desc")
    private String statusDesc;
    //T
    private String text;
    private int type;
    //U
    @SerializedName("user")
    private NeiHanUserBean userInfo;
    @SerializedName("user_bury")
    private int userBury;
    @SerializedName("user_digg")
    private int userDigg;
    @SerializedName("user_favorite")
    private int userFavorite;
    @SerializedName("user_repin")
    private int userRepin;
    //V
    @SerializedName("video_height")
    private int videoHeight;
    @SerializedName("video_id")
    private String videoId;
    @SerializedName("video_wh_ratio")
    private int videoWhRatio;
    @SerializedName("video_width")
    private int videoWidth;
    //W
    //X
    //Y
    //Z


    public static class ActivityBean {
    }

    public static class NeihanHotLinkBean {
    }

    private static class DanmakuAttrs {
        @SerializedName("allow_send_danmaku")
        private int allowSendDanmaku;
        @SerializedName("allow_show_danmaku")
        private int allowShowDanmaku;

        public int getAllowSendDanmaku() {
            return allowSendDanmaku;
        }

        public void setAllowSendDanmaku(int allowSendDanmaku) {
            this.allowSendDanmaku = allowSendDanmaku;
        }

        public int getAllowShowDanmaku() {
            return allowShowDanmaku;
        }

        public void setAllowShowDanmaku(int allowShowDanmaku) {
            this.allowShowDanmaku = allowShowDanmaku;
        }
    }

    public boolean isAllowDislike() {
        return allowDislike;
    }

    public void setAllowDislike(boolean allowDislike) {
        this.allowDislike = allowDislike;
    }

    public int getBuryCount() {
        return buryCount;
    }

    public void setBuryCount(int buryCount) {
        this.buryCount = buryCount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public boolean isCategoryVisible() {
        return categoryVisible;
    }

    public void setCategoryVisible(boolean categoryVisible) {
        this.categoryVisible = categoryVisible;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getDiggCount() {
        return diggCount;
    }

    public void setDiggCount(int diggCount) {
        this.diggCount = diggCount;
    }


    public int getDisplayType() {
        return displayType;
    }

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public NeiHanGifVideo getNeiHanGifVideo() {
        return neiHanGifVideo;
    }

    public void setNeiHanGifVideo(NeiHanGifVideo neiHanGifVideo) {
        this.neiHanGifVideo = neiHanGifVideo;
    }

    public long getGoDetailCount() {
        return goDetailCount;
    }

    public void setGoDetailCount(long goDetailCount) {
        this.goDetailCount = goDetailCount;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public int getHasComments() {
        return hasComments;
    }

    public void setHasComments(int hasComments) {
        this.hasComments = hasComments;
    }

    public int getHasHotComments() {
        return hasHotComments;
    }

    public void setHasHotComments(int hasHotComments) {
        this.hasHotComments = hasHotComments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public int getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(int imageStatus) {
        this.imageStatus = imageStatus;
    }

    public int getIsGif() {
        return isGif;
    }

    public void setIsGif(int isGif) {
        this.isGif = isGif;
    }

    public int getIsCanShare() {
        return isCanShare;
    }

    public void setIsCanShare(int isCanShare) {
        this.isCanShare = isCanShare;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public boolean isNeihanHot() {
        return isNeihanHot;
    }

    public void setNeihanHot(boolean neihanHot) {
        isNeihanHot = neihanHot;
    }

    public boolean isPersonalShow() {
        return isPersonalShow;
    }

    public void setPersonalShow(boolean personalShow) {
        isPersonalShow = personalShow;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public NeiHanImageBean getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(NeiHanImageBean largeImage) {
        this.largeImage = largeImage;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public NeiHanImageBean getMiddleImage() {
        return middleImage;
    }

    public void setMiddleImage(NeiHanImageBean middleImage) {
        this.middleImage = middleImage;
    }

    public float getMinScreenWidthPercent() {
        return minScreenWidthPercent;
    }

    public void setMinScreenWidthPercent(float minScreenWidthPercent) {
        this.minScreenWidthPercent = minScreenWidthPercent;
    }

    public String getNeiHanHotStartTime() {
        return neiHanHotStartTime;
    }

    public void setNeiHanHotStartTime(String neiHanHotStartTime) {
        this.neiHanHotStartTime = neiHanHotStartTime;
    }

    public String getNeiHanHotEndTime() {
        return neiHanHotEndTime;
    }

    public void setNeiHanHotEndTime(String neiHanHotEndTime) {
        this.neiHanHotEndTime = neiHanHotEndTime;
    }

    public NeihanHotLinkBean getNeiHanHotLinkBean() {
        return neiHanHotLinkBean;
    }

    public void setNeiHanHotLinkBean(NeihanHotLinkBean neiHanHotLinkBean) {
        this.neiHanHotLinkBean = neiHanHotLinkBean;
    }

    public int getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(int onlineTime) {
        this.onlineTime = onlineTime;
    }

    public boolean isQuickComment() {
        return quickComment;
    }

    public void setQuickComment(boolean quickComment) {
        this.quickComment = quickComment;
    }

    public int getRepinCount() {
        return repinCount;
    }

    public void setRepinCount(int repinCount) {
        this.repinCount = repinCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getShareType() {
        return shareType;
    }

    public void setShareType(int shareType) {
        this.shareType = shareType;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public NeiHanUserBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(NeiHanUserBean userInfo) {
        this.userInfo = userInfo;
    }

    public int getUserBury() {
        return userBury;
    }

    public void setUserBury(int userBury) {
        this.userBury = userBury;
    }

    public int getUserDigg() {
        return userDigg;
    }

    public void setUserDigg(int userDigg) {
        this.userDigg = userDigg;
    }

    public int getUserFavorite() {
        return userFavorite;
    }

    public void setUserFavorite(int userFavorite) {
        this.userFavorite = userFavorite;
    }

    public int getUserRepin() {
        return userRepin;
    }

    public void setUserRepin(int userRepin) {
        this.userRepin = userRepin;
    }

    public float getMaxScreenWidthPercent() {
        return maxScreenWidthPercent;
    }

    public void setMaxScreenWidthPercent(float maxScreenWidthPercent) {
        this.maxScreenWidthPercent = maxScreenWidthPercent;
    }

    public NeiHanVideoBean getVideo$480() {
        return video$480;
    }

    public void setVideo$480(NeiHanVideoBean video$480) {
        this.video$480 = video$480;
    }

    public NeiHanVideoBean getVideo$360() {
        return video$360;
    }

    public void setVideo$360(NeiHanVideoBean video$360) {
        this.video$360 = video$360;
    }

    public NeiHanVideoBean getVideo$720() {
        return video$720;
    }

    public void setVideo$720(NeiHanVideoBean video$720) {
        this.video$720 = video$720;
    }

    public String getCoverImageUri() {
        return coverImageUri;
    }

    public void setCoverImageUri(String coverImageUri) {
        this.coverImageUri = coverImageUri;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public DanmakuAttrs getDanmakuAttrs() {
        return danmakuAttrs;
    }

    public void setDanmakuAttrs(DanmakuAttrs danmakuAttrs) {
        this.danmakuAttrs = danmakuAttrs;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getFlashUrl() {
        return flashUrl;
    }

    public void setFlashUrl(String flashUrl) {
        this.flashUrl = flashUrl;
    }

    public int getIsPublicUrl() {
        return isPublicUrl;
    }

    public void setIsPublicUrl(int isPublicUrl) {
        this.isPublicUrl = isPublicUrl;
    }

    public int getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(int isVideo) {
        this.isVideo = isVideo;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public NeiHanImageBean getLargeCover() {
        return largeCover;
    }

    public void setLargeCover(NeiHanImageBean largeCover) {
        this.largeCover = largeCover;
    }

    public String getM3u8Url() {
        return m3u8Url;
    }

    public void setM3u8Url(String m3u8Url) {
        this.m3u8Url = m3u8Url;
    }

    public NeiHanImageBean getMediumCover() {
        return mediumCover;
    }

    public void setMediumCover(NeiHanImageBean mediumCover) {
        this.mediumCover = mediumCover;
    }

    public String getMp4Url() {
        return mp4Url;
    }

    public void setMp4Url(String mp4Url) {
        this.mp4Url = mp4Url;
    }

    public NeiHanVideoBean getOriginVideo() {
        return originVideo;
    }

    public void setOriginVideo(NeiHanVideoBean originVideo) {
        this.originVideo = originVideo;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(int videoHeight) {
        this.videoHeight = videoHeight;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public int getVideoWhRatio() {
        return videoWhRatio;
    }

    public void setVideoWhRatio(int videoWhRatio) {
        this.videoWhRatio = videoWhRatio;
    }

    public int getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(int videoWidth) {
        this.videoWidth = videoWidth;
    }
}
