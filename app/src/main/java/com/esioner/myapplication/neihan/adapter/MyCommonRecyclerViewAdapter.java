package com.esioner.myapplication.neihan.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan.neihanbean.commonBean.NeedBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class MyCommonRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NeedBean> needBeanList;

    /**
     * 段子 0
     * 图片 1
     * 段友秀 ，视频 3
     */
    private int mediaType;
    private final int JOKE_TYPE = 100;
    private final int PICTURE_TYPE = 101;
    private final int VIDEO_TYPE = 102;

    public class JokeViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvJokeUserName;
        private final TextView tvJokeContent;
        private final CircleImageView ivUserHeadImage;
        private final View view;
        private final TextView tvJokeLikeCount;
        private final TextView tvJokeDislikeCount;

        public JokeViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.card_view);
            tvJokeLikeCount = (TextView) itemView.findViewById(R.id.tv_nei_han_like);
            tvJokeDislikeCount = (TextView) itemView.findViewById(R.id.tv_nei_han_dislike);
            tvJokeUserName = (TextView) itemView.findViewById(R.id.tv_joke_user_name);
            tvJokeContent = (TextView) itemView.findViewById(R.id.tv_joke_content);
            ivUserHeadImage = (CircleImageView) itemView.findViewById(R.id.user_head_image);
        }
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvPictureUserName;
        private final TextView tvPictureUserContent;
        private final ImageView ivPictureUserImage;
        private final CircleImageView ivPictureUserHeadImage;
        private final TextView tvPictureLikeCount;
        private final TextView tvPictureDislikeCount;

        public PictureViewHolder(View itemView) {
            super(itemView);
            tvPictureUserName = (TextView) itemView.findViewById(R.id.tv_picture_user_name);
            tvPictureUserContent = (TextView) itemView.findViewById(R.id.tv_picture_content);
            ivPictureUserImage = (ImageView) itemView.findViewById(R.id.iv_picture_image);
            ivPictureUserHeadImage = (CircleImageView) itemView.findViewById(R.id
                    .iv_picture_user_head_image);
            tvPictureLikeCount = (TextView) itemView.findViewById(R.id.tv_nei_han_like);
            tvPictureDislikeCount = (TextView) itemView.findViewById(R.id.tv_nei_han_dislike);
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private final JCVideoPlayerStandard jcVideoPlayer;
        private final CircleImageView ivUserHeadImage;
        private final TextView tvVideoUserContent;
        private final TextView tvVideoUserName;
        private final TextView tvVideoLikeCount;
        private final TextView tvVideoDisikeCount;

        public VideoViewHolder(View itemView) {
            super(itemView);
            tvVideoUserName = (TextView) itemView.findViewById(R.id.tv_video_user_name);
            tvVideoUserContent = (TextView) itemView.findViewById(R.id.tv_video_content);
            ivUserHeadImage = (CircleImageView) itemView.findViewById(R.id
                    .iv_video_user_head_image);
            jcVideoPlayer = (JCVideoPlayerStandard) itemView.findViewById(R.id
                    .nei_han_video_player);
            tvVideoLikeCount = (TextView) itemView.findViewById(R.id.tv_nei_han_like);
            tvVideoDisikeCount = (TextView) itemView.findViewById(R.id.tv_nei_han_dislike);
        }
    }

    public MyCommonRecyclerViewAdapter(List<NeedBean> list) {
        needBeanList = list;
        mediaType = needBeanList.get(0).getMediaType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case JOKE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .nei_han_joke_item_layout, parent, false);
                holder = new JokeViewHolder(view);
                break;
            case PICTURE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .nei_han_picture_item_layout, parent, false);
                holder = new PictureViewHolder(view);
                break;
            case VIDEO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .nei_han_video_item, parent, false);
                holder = new VideoViewHolder(view);
                break;
            default:
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final NeedBean needBean = needBeanList.get(position);
        String text = "#" + needBean.getUserTextPrefix() + "#" + needBean.getUserText();
        SpannableStringBuilder styled = new SpannableStringBuilder(text);
        styled.setSpan(new ForegroundColorSpan(Color.RED), text.indexOf("#"), text.indexOf("#",
                2) + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        if (holder instanceof JokeViewHolder) {
            ((JokeViewHolder) holder).tvJokeUserName.setText(needBean.getUserName());
            ((JokeViewHolder) holder).tvJokeContent.setText(styled);
            Glide.with(MyApplication.getContext()).load(needBean.getUserHeadImg()).into((
                    (JokeViewHolder) holder).ivUserHeadImage);
            ((JokeViewHolder) holder).tvJokeLikeCount.setText(needBean.getLikeCount()+"");
            ((JokeViewHolder) holder).tvJokeDislikeCount.setText(needBean.getDislikeCount()+"");
        } else if (holder instanceof PictureViewHolder) {
            ((PictureViewHolder) holder).tvPictureUserName.setText(needBean.getUserName());
            ((PictureViewHolder) holder).tvPictureUserContent.setText(styled);
            Glide.with(MyApplication.getContext()).load(needBean.getUserHeadImg()).into((
                    (PictureViewHolder) holder).ivPictureUserHeadImage);
            Glide.with(MyApplication.getContext()).load(needBean.getImageMiddleImage()).into((
                    (PictureViewHolder) holder).ivPictureUserImage);
            ((PictureViewHolder) holder).tvPictureLikeCount.setText(needBean.getLikeCount()+"");
            ((PictureViewHolder) holder).tvPictureDislikeCount.setText(needBean.getDislikeCount()+"");
            ((PictureViewHolder) holder).ivPictureUserImage.setOnClickListener(new View
                    .OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyApplication.getContext(), ShowImageView.class);
                    intent.putExtra("IMAGE_URL", needBean.getImageLargeUrl());
                    intent.putExtra("IMAGE_TITLE", needBean.getUserText());
                    MyApplication.getContext().startActivity(intent);

                }
            });
        } else if (holder instanceof VideoViewHolder) {
            ((VideoViewHolder) holder).tvVideoUserName.setText(needBean.getUserName());
            ((VideoViewHolder) holder).tvVideoUserContent.setText(styled);
            Glide.with(MyApplication.getContext()).load(needBean.getUserHeadImg()).into((
                    (VideoViewHolder) holder).ivUserHeadImage);
            ((VideoViewHolder) holder).jcVideoPlayer.setUp(needBean.getVideoUrl(),
                    JCVideoPlayerStandard.SYSTEM_UI_FLAG_HIDE_NAVIGATION, needBean
                            .getUserText());
            Glide.with(MyApplication.getContext()).load(needBean.getVideoCoverUrl()).into((
                    (VideoViewHolder) holder).jcVideoPlayer.thumbImageView);
            ((VideoViewHolder) holder).tvVideoLikeCount.setText(needBean.getLikeCount()+"");
            ((VideoViewHolder) holder).tvVideoLikeCount.setText(needBean.getDislikeCount()+"");
        }



    }

    @Override
    public int getItemCount() {
        return needBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = -1;
        switch (mediaType) {
            case 0:
                viewType = JOKE_TYPE;
                break;
            case 1:
                viewType = PICTURE_TYPE;
                break;
            case 3:
                viewType = VIDEO_TYPE;
                break;
        }
        return viewType;
    }

}

