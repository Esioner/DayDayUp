package com.esioner.myapplication.neihan.neihanbean.NeiHanBean;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NeiHanBean {

    private String message;
    private RootDataBean data;


    public static class RootDataBean {

        @SerializedName("has_more")
        private boolean hasMore;
        @SerializedName("tip")
        private String refreshTip;
        @SerializedName("has_new_message")
        private boolean hasNewMessage;
        @SerializedName("max_time")
        private double maxTime;
        @SerializedName("min_time")
        private int minTime;
        private List<DataBean> data;

        public static class DataBean {

            private List<?> comments;
            private GroupBean group;
            private int type;
            @SerializedName("display_time")
            private int displayTime;
            @SerializedName("online_time")
            private int onlineTime;

            public static class GroupBean {
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
                @SerializedName("create_time")
                private int createTime;
                private String content;
                @SerializedName("comment_count")
                private int commentCount;
                //D
                @SerializedName("digg_count")
                private int diggCount;
                @SerializedName("dislike_reason")
                private List<DislikeReasonBean> dislikeReasonBeen;
                @SerializedName("display_type")
                private int displayType;
                //E
                //F
                @SerializedName("favorite_count")
                private int favoriteCount;
                //G
                //Picture
                private GitVideo gifVideo;

                @SerializedName("go_detail_count")
                private int goDetailCount;
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

                //J
                //K
                //L
                private int label;
                /**
                 * Pic
                 */
                @SerializedName("large_image")
                private LargeImage largeImage;
                //M
                @SerializedName("media_type")
                private int mediaType;
                /**
                 * Pic
                 */
                @SerializedName("max_screen_width_percent")
                private int mediaType;
                @SerializedName("middle_image")
                private MiddleImage middleImage;
                @SerializedName("min_screen_width_percent")
                private int minScreenWidthPercent;
                //N
                @SerializedName("neihan_hot_start_time")
                private String neiHanHotStartTime;
                @SerializedName("neihan_hot_end_time")
                private String neiHanHotEndTime;
                @SerializedName("neihan_hot_link")
                private NeihanHotLinkBean neiHanHotLinkBean;
                //O
                @SerializedName("online_time")
                private int onlineTime;
                //P
                //Q
                @SerializedName("quick_comment")
                private boolean quickComment;
                //R
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
                private UserBean userInfo;
                @SerializedName("user_bury")
                private int userBury;
                @SerializedName("user_digg")
                private int userDigg;
                @SerializedName("user_favorite")
                private int userFavorite;
                @SerializedName("user_repin")
                private int userRepin;
                //V
                //W
                //X
                //Y
                //Z


                public static class UserBean {
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

                }

                public static class ActivityBean {
                }

                public static class NeihanHotLinkBean {
                }

                public static class DislikeReasonBean {
                    /**
                     * type : 1
                     * id : 440
                     * title : 内涵
                     */
                    private int type;
                    private int id;
                    private String title;
                }
                //TODO
                public static class GitVideo {

                }
                //TODO
                public static class LargeImage{}
                //TODO
                public static class MiddleImage{}
            }
        }
    }
}