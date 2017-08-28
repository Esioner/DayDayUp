//package com.esioner.myapplication.neihan.neihanbean;
//
//import com.google.gson.annotations.SerializedName;
//
//import java.util.List;
//
///**
// * Created by Esioner on 2017/8/28.
// */
//
//public class dadsad {
//
//
//    private DataBeanX data;
//    private String message;
//
//    public static class DataBeanX {
//
//        private boolean has_more;
//        private boolean has_new_message;
//        private double max_time;
//        private int min_time;
//        private String tip;
//        private List<DataBean> data;
//
//
//        public static class DataBean {
//
//            private int display_time;
//            private GroupBean group;
//            private int online_time;
//            private int type;
//
//            private List<?> comments;
//
//
//            public static class GroupBean {
//
//                private ActivityBean activity;
//                private boolean allow_dislike;
//                private int bury_count;
//                private int category_id;
//                private String category_name;
//                private int category_type;
//                private boolean category_visible;
//                private int comment_count;
//                private String content;
//                private int create_time;
//                private int digg_count;
//                private int display_type;
//                private int favorite_count;
//                private GifvideoBean gifvideo;
//                private int go_detail_count;
//                private long group_id;
//                private int has_comments;
//                private int has_hot_comments;
//                private long id;
//                private String id_str;
//                private int image_status;
//                private boolean is_anonymous;
//                private int is_can_share;
//                private int is_gif;
//                private boolean is_neihan_hot;
//                private boolean is_personal_show;
//                private int label;
//                private LargeImageBean large_image;
//                private double max_screen_width_percent;
//                private int media_type;
//                private MiddleImageBean middle_image;
//                private double min_screen_width_percent;
//                private String neihan_hot_end_time;
//                private NeihanHotLinkBean neihan_hot_link;
//                private String neihan_hot_start_time;
//                private int online_time;
//                private boolean quick_comment;
//                private int repin_count;
//                private int share_count;
//                private int share_type;
//                private String share_url;
//                private int status;
//                private String status_desc;
//                private String text;
//                private int type;
//                private UserBean user;
//                private int user_bury;
//                private int user_digg;
//                private int user_favorite;
//                private int user_repin;
//                private List<DislikeReasonBean> dislike_reason;
//
//
//                public static class ActivityBean {
//                }
//
//                public static class GifvideoBean {
//
//
//                    @SerializedName("360p_video")
//                    private _$360pVideoBean _$360p_video;
//                    @SerializedName("480p_video")
//                    private _$480pVideoBean _$480p_video;
//                    @SerializedName("720p_video")
//                    private _$720pVideoBean _$720p_video;
//                    private String cover_image_uri;
//                    private double duration;
//                    private String mp4_url;
//                    private OriginVideoBean origin_video;
//                    private int video_height;
//                    private String video_id;
//                    private int video_width;
//
//
//                    public static class _$360pVideoBean {
//
//
//                        private int height;
//                        private String uri;
//                        private int width;
//                        private List<UrlListBean> url_list;
//
//
//                        public static class UrlListBean {
//
//
//                            private String url;
//
//
//                    }
//
//                    public static class _$480pVideoBean {
//
//
//                        private int height;
//                        private String uri;
//                        private int width;
//                        private List<UrlListBeanX> url_list;
//
//                        public static class UrlListBeanX {
//
//                            private String url;
//
//
//                    }
//
//                    public static class _$720pVideoBean {
//
//                        private int height;
//                        private String uri;
//                        private int width;
//                        private List<UrlListBeanXX> url_list;
//
//
//                        public static class UrlListBeanXX {
//
//
//                            private String url;
//
//                            public String getUrl() {
//                                return url;
//                            }
//
//                            public void setUrl(String url) {
//                                this.url = url;
//                            }
//                        }
//                    }
//
//                    public static class OriginVideoBean {
//
//
//                        private int height;
//                        private String uri;
//                        private int width;
//                        private List<UrlListBeanXXX> url_list;
//
//
//                        public static class UrlListBeanXXX {
//                            /**
//                             * url : http://ic.snssdk.com/neihan/video/playback/?video_id=0d2549cdf2004e43957a614aa3e5e7ef&quality=origin&line=0&is_gif=1&device_platform=None
//                             */
//
//                            private String url;
//
//                            public String getUrl() {
//                                return url;
//                            }
//
//                            public void setUrl(String url) {
//                                this.url = url;
//                            }
//                        }
//                    }
//                }
//
//                public static class LargeImageBean {
//
//
//                    private int height;
//                    private int r_height;
//                    private int r_width;
//                    private String uri;
//                    private int width;
//                    private List<UrlListBeanXXXX> url_list;
//
//                    public static class UrlListBeanXXXX {
//                        /**
//                         * url : http://p3.pstatp.com/large/38270002649c5f00040a
//                         */
//
//                        private String url;
//
//                        public String getUrl() {
//                            return url;
//                        }
//
//                        public void setUrl(String url) {
//                            this.url = url;
//                        }
//                    }
//                }
//
//                public static class MiddleImageBean {
//                    /**
//                     * height : 217
//                     * r_height : 217
//                     * r_width : 292
//                     * uri : w292/38270002649c5f00040a
//                     * url_list : [{"url":"http://p3.pstatp.com/w292/38270002649c5f00040a.webp"},{"url":"http://pb9.pstatp.com/w292/38270002649c5f00040a.webp"},{"url":"http://pb1.pstatp.com/w292/38270002649c5f00040a.webp"}]
//                     * width : 292
//                     */
//
//                    private int height;
//                    private int r_height;
//                    private int r_width;
//                    private String uri;
//                    private int width;
//                    private List<UrlListBeanXXXXX> url_list;
//
//                    public static class UrlListBeanXXXXX {
//                        /**
//                         * url : http://p3.pstatp.com/w292/38270002649c5f00040a.webp
//                         */
//
//                        private String url;
//
//                        public String getUrl() {
//                            return url;
//                        }
//
//                        public void setUrl(String url) {
//                            this.url = url;
//                        }
//                    }
//                }
//
//                public static class NeihanHotLinkBean {
//                }
//
//                public static class UserBean {
//                    /**
//                     * avatar_url : http://p3.pstatp.com/medium/2c6500125f4a5227c6d8
//                     * followers : 6
//                     * followings : 0
//                     * is_following : false
//                     * is_pro_user : false
//                     * name : 粪姐
//                     * ugc_count : 2
//                     * user_id : 4581167490
//                     * user_verified : false
//                     */
//
//                    private String avatar_url;
//                    private int followers;
//                    private int followings;
//                    private boolean is_following;
//                    private boolean is_pro_user;
//                    private String name;
//                    private int ugc_count;
//                    private long user_id;
//                    private boolean user_verified;
//
//
//                }
//
//                public static class DislikeReasonBean {
//                    /**
//                     * id : 10
//                     * title : 吧:爆笑GIF
//                     * type : 2
//                     */
//
//                    private int id;
//                    private String title;
//                    private int type;
//
//
//                }
//
//
//            }
//        }
//    }
//}
