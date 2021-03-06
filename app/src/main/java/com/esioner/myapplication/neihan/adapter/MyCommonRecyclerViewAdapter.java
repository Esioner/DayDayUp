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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan.neihanbean.neiHanBean.NeiHanDataBean;
import com.esioner.myapplication.utils.GlideUtils;
import com.esioner.myapplication.utils.LogUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import me.xiaopan.sketch.SketchImageView;


public class MyCommonRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NeiHanDataBean> dataBeanList;

    /**
     * 段子 0
     * 图片 1
     * GIF 2
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
        private final TextView tvDiggCount;
        private final TextView tvBuryCount;
        private final ImageButton btnShare;

        public JokeViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.card_view);
            tvDiggCount = (TextView) itemView.findViewById(R.id.tv_nei_han_digg);
            tvBuryCount = (TextView) itemView.findViewById(R.id.tv_nei_han_bury);
            tvJokeUserName = (TextView) itemView.findViewById(R.id.tv_joke_user_name);
            tvJokeContent = (TextView) itemView.findViewById(R.id.tv_joke_content);
            ivUserHeadImage = (CircleImageView) itemView.findViewById(R.id.user_head_image);
            btnShare = (ImageButton) itemView.findViewById(R.id.btn_share);
        }
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvPictureUserName;
        private final TextView tvPictureUserContent;
        private final SketchImageView ivPictureUserImage;
        private final CircleImageView ivPictureUserHeadImage;
        private final TextView tvDiggCount;
        private final TextView tvBuryCount;

        public PictureViewHolder(View itemView) {
            super(itemView);
            tvPictureUserName = (TextView) itemView.findViewById(R.id.tv_picture_user_name);
            tvPictureUserContent = (TextView) itemView.findViewById(R.id.tv_picture_content);
            ivPictureUserImage = (SketchImageView) itemView.findViewById(R.id.iv_picture_image);
            ivPictureUserHeadImage = (CircleImageView) itemView.findViewById(R.id
                    .iv_picture_user_head_image);
            tvDiggCount = (TextView) itemView.findViewById(R.id.tv_nei_han_digg);
            tvBuryCount = (TextView) itemView.findViewById(R.id.tv_nei_han_bury);
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private final JCVideoPlayerStandard jcVideoPlayer;
        private final CircleImageView ivUserHeadImage;
        private final TextView tvVideoUserContent;
        private final TextView tvVideoUserName;
        private final TextView tvDiggCount;
        private final TextView tvBuryCount;

        public VideoViewHolder(View itemView) {
            super(itemView);
            tvVideoUserName = (TextView) itemView.findViewById(R.id.tv_video_user_name);
            tvVideoUserContent = (TextView) itemView.findViewById(R.id.tv_video_content);
            ivUserHeadImage = (CircleImageView) itemView.findViewById(R.id
                    .iv_video_user_head_image);
            jcVideoPlayer = (JCVideoPlayerStandard) itemView.findViewById(R.id
                    .nei_han_video_player);
            tvDiggCount = (TextView) itemView.findViewById(R.id.tv_nei_han_digg);
            tvBuryCount = (TextView) itemView.findViewById(R.id.tv_nei_han_bury);
        }
    }

    public MyCommonRecyclerViewAdapter(List<NeiHanDataBean> list) {
        dataBeanList = list;
//        mediaType = dataBeanList.get(0).getGroup().getMediaType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        LogUtil.i("ViewType", "viewType = " + viewType);
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
                Toast.makeText(MyApplication.getContext(), "Type未知", Toast.LENGTH_SHORT).show();
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final NeiHanDataBean dataBean = dataBeanList.get(position);
        String text = "#" + dataBean.getGroup().getCategoryName() + "#" + dataBean.getGroup()
                .getText();
        SpannableStringBuilder styled = new SpannableStringBuilder(text);
        styled.setSpan(new ForegroundColorSpan(Color.RED), text.indexOf("#"), text.indexOf("#",
                2) + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String userName = dataBean.getGroup().getUserInfo().getName();
        String userHeaderUrl = dataBean.getGroup().getUserInfo().getAvatarUrl();
        String diggCount = String.valueOf(dataBean.getGroup().getDiggCount());
        String buryCount = String.valueOf(dataBean.getGroup().getBuryCount());

        if (holder instanceof JokeViewHolder) {
            ((JokeViewHolder) holder).tvJokeUserName.setText(userName);
            ((JokeViewHolder) holder).tvJokeContent.setText(styled);
            ((JokeViewHolder) holder).tvBuryCount.setText(buryCount);
            ((JokeViewHolder) holder).tvDiggCount.setText(diggCount);
            GlideUtils.showImage(userHeaderUrl, ((JokeViewHolder) holder).ivUserHeadImage);
            ((JokeViewHolder) holder).btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent textIntent = new Intent(Intent.ACTION_SEND);
                    textIntent.setType("text/plain");
                    textIntent.putExtra(Intent.EXTRA_TEXT, dataBean.getGroup()
                            .getText());
                    MyApplication.getContext().startActivity(Intent.createChooser(textIntent,
                            "分享"));
                }
            });

        } else if (holder instanceof PictureViewHolder) {
            ((PictureViewHolder) holder).tvPictureUserName.setText(userName);
            ((PictureViewHolder) holder).tvPictureUserContent.setText(styled);
            //加载头像
            GlideUtils.showImage(userHeaderUrl, ((PictureViewHolder) holder)
                    .ivPictureUserHeadImage);
            //加载图片
            if (dataBean.getGroup().getIsGif() == 1) {
                LogUtil.i("GIF_URL", "Url : " + dataBean.getGroup().getLargeImage().getUrlLists()
                        .get(0).getUrl());
                GlideUtils.showGifImage(dataBean.getGroup().getLargeImage()
                                .getUrlLists().get(0).getUrl(),
                        ((PictureViewHolder) holder)
                                .ivPictureUserImage);
            } else if (dataBean.getGroup().getIsGif() == 0) {
                GlideUtils.showImage(dataBean.getGroup().getLargeImage().getUrlLists().get(0).getUrl
                        (), ((PictureViewHolder) holder)
                        .ivPictureUserImage);
                LogUtil.i("PNG_URL", "Url : " + dataBean.getGroup().getLargeImage().getUrlLists()
                        .get(0).getUrl());
            }

//            Glide.with(MyApplication.getContext()).load(dataBean.getGroup().getLargeImage()
// .getUrlLists().get(0).getUrl
//                    ()).into( ((PictureViewHolder) holder)
//                    .ivPictureUserImage);
            ((PictureViewHolder) holder).tvBuryCount.setText(buryCount);
            ((PictureViewHolder) holder).tvDiggCount.setText(diggCount);
            //设置图片点击事件
            ((PictureViewHolder) holder).ivPictureUserImage.setOnClickListener(new View
                    .OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyApplication.getContext(), ShowImageView.class);
                    intent.putExtra("IMAGE_URL", dataBean.getGroup().getLargeImage().getUrlLists
                            ().get(0).getUrl());
                    intent.putExtra("IMAGE_TITLE", dataBean.getGroup().getText());
                    MyApplication.getContext().startActivity(intent);
                }
            });
        } else if (holder instanceof VideoViewHolder) {
            ((VideoViewHolder) holder).tvVideoUserName.setText(userName);
            ((VideoViewHolder) holder).tvVideoUserContent.setText(styled);
            GlideUtils.showImage(userHeaderUrl, ((VideoViewHolder) holder).ivUserHeadImage);
            ((VideoViewHolder) holder).jcVideoPlayer.setUp(dataBean.getGroup().getMp4Url(),
                    JCVideoPlayerStandard.SYSTEM_UI_FLAG_HIDE_NAVIGATION, dataBean.getGroup()
                            .getText());
            GlideUtils.showImage(dataBean.getGroup().getLargeCover().getUrlLists().get(0).getUrl
                    (), ((VideoViewHolder)
                    holder).jcVideoPlayer.thumbImageView);

            ((VideoViewHolder) holder).tvBuryCount.setText(buryCount);
            ((VideoViewHolder) holder).tvDiggCount.setText(diggCount);

        }

    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        mediaType = dataBeanList.get(position).getGroup().getMediaType();
        int viewType = JOKE_TYPE;
        switch (mediaType) {
            case 0:
                viewType = JOKE_TYPE;
                break;
            case 1:
                viewType = PICTURE_TYPE;
                break;
            case 2:
                viewType = PICTURE_TYPE;
                break;
            case 3:
                viewType = VIDEO_TYPE;
                break;
        }
        return viewType;
    }

    private void setItemBar(RecyclerView.ViewHolder holder, NeiHanDataBean dataBean) {

    }

}

