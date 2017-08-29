package com.esioner.myapplication.neihan.neihanbean.NeiHanBean;

import com.google.gson.annotations.SerializedName;


public class NeiHanUserBean {

    @SerializedName("avatar_url")
    private String avatarUrl;
    private String followers;
    private String followings;
    @SerializedName("is_following")
    private String isFollowing;
    @SerializedName("is_pro_user")
    private String isProUser;
    private String name;
    @SerializedName("ugc_count")
    private String ugcCount;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_verified")
    private String userVerified;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowings() {
        return followings;
    }

    public void setFollowings(String followings) {
        this.followings = followings;
    }

    public String getIsFollowing() {
        return isFollowing;
    }

    public void setIsFollowing(String isFollowing) {
        this.isFollowing = isFollowing;
    }

    public String getIsProUser() {
        return isProUser;
    }

    public void setIsProUser(String isProUser) {
        this.isProUser = isProUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUgcCount() {
        return ugcCount;
    }

    public void setUgcCount(String ugcCount) {
        this.ugcCount = ugcCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserVerified() {
        return userVerified;
    }

    public void setUserVerified(String userVerified) {
        this.userVerified = userVerified;
    }
}
