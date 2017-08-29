package com.esioner.myapplication.neihan.neihanbean.neiHanBean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Esioner on 2017/8/29.
 */

public class NeiHanCommentsBean {
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("bury_count")
    private int buryCount;
    @SerializedName("create_time")
    private float createTime;
    @SerializedName("description")
    private String description;
    @SerializedName("digg_count")
    private int diggCount;
    @SerializedName("group_id")
    private long groupId;
    @SerializedName("id")
    private long id;
    @SerializedName("is_digg")
    private int isDigg;
    @SerializedName("is_pro_user")
    private boolean isProUser;
    @SerializedName("platform")
    private String platform;
    @SerializedName("platform_id")
    private String platformId;
    @SerializedName("share_type")
    private int shareType;
    @SerializedName("share_url")
    private String shareUrl;
    @SerializedName("status")
    private int status;
    @SerializedName("text")
    private String text;
    @SerializedName("user_bury")
    private int userBury;
    @SerializedName("user_digg")
    private int userDigg;
    @SerializedName("user_id")
    private long userId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("user_profile_image_url")
    private String userProfileImageUrl;
    @SerializedName("user_profile_url")
    private String userProfileUrl;
    @SerializedName("user_verified")
    private boolean userVerified;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getBuryCount() {
        return buryCount;
    }

    public void setBuryCount(int buryCount) {
        this.buryCount = buryCount;
    }

    public float getCreateTime() {
        return createTime;
    }

    public void setCreateTime(float createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiggCount() {
        return diggCount;
    }

    public void setDiggCount(int diggCount) {
        this.diggCount = diggCount;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIsDigg() {
        return isDigg;
    }

    public void setIsDigg(int isDigg) {
        this.isDigg = isDigg;
    }

    public boolean isProUser() {
        return isProUser;
    }

    public void setProUser(boolean proUser) {
        isProUser = proUser;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }

    public void setUserProfileImageUrl(String userProfileImageUrl) {
        this.userProfileImageUrl = userProfileImageUrl;
    }

    public String getUserProfileUrl() {
        return userProfileUrl;
    }

    public void setUserProfileUrl(String userProfileUrl) {
        this.userProfileUrl = userProfileUrl;
    }

    public boolean isUserVerified() {
        return userVerified;
    }

    public void setUserVerified(boolean userVerified) {
        this.userVerified = userVerified;
    }
}
