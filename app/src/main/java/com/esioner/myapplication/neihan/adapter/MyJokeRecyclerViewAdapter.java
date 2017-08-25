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


public class MyJokeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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

        public JokeViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.card_view);
            tvJokeUserName = (TextView) itemView.findViewById(R.id.tv_joke_user_name);
            tvJokeContent = (TextView) itemView.findViewById(R.id.tv_joke_content);
            ivUserHeadImage = (CircleImageView) itemView.findViewById(R.id.user_head_image);
        }
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvPictureUserName;
        private final TextView tvPictureUserContent;
        private final ImageView ivPictureUserImage;
        private final CircleImageView ivUserHeadImage;

        public PictureViewHolder(View itemView) {
            super(itemView);
            tvPictureUserName = (TextView) itemView.findViewById(R.id.tv_picture_user_name);
            tvPictureUserContent = (TextView) itemView.findViewById(R.id.tv_picture_content);
            ivPictureUserImage = (ImageView) itemView.findViewById(R.id.iv_picture_image);
            ivUserHeadImage = (CircleImageView) itemView.findViewById(R.id
                    .iv_picture_user_head_image);
        }
    }

    public MyJokeRecyclerViewAdapter(List<NeedBean> list) {
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
        } else if (holder instanceof PictureViewHolder) {
            ((PictureViewHolder) holder).tvPictureUserName.setText(needBean.getUserName());
            ((PictureViewHolder) holder).tvPictureUserContent.setText(styled);
            Glide.with(MyApplication.getContext()).load(needBean.getUserHeadImg()).into((
                    (PictureViewHolder) holder).ivUserHeadImage);
            Glide.with(MyApplication.getContext()).load(needBean.getImageMiddleImage()).into((
                    (PictureViewHolder) holder).ivPictureUserImage);
            ((PictureViewHolder) holder).ivPictureUserImage.setOnClickListener(new View
                    .OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyApplication.getContext(), ShowImageView.class);
                    intent.putExtra("IMAGE_URL", needBean.getImageLargeUrl());
                    intent.putExtra("IMAGE_TITLE",needBean.getUserText());
                    MyApplication.getContext().startActivity(intent);

                }
            });
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
//            case 3:
//                viewType = VIDEO_TYPE;
//                break;
        }
        return viewType;
    }

}

