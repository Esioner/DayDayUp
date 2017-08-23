package com.esioner.myapplication.neihan.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan.neihanbean.jokeBean.NeedBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyJokeRecyclerViewAdapter extends RecyclerView.Adapter<MyJokeRecyclerViewAdapter
        .ViewHolder> {

    private List<NeedBean> needBeanList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvJokeUserName;
        private final TextView tvJokeContent;
        private final CircleImageView ivUserHeadImage;
        private final View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.card_view);
            tvJokeUserName = (TextView) itemView.findViewById(R.id.tv_joke_user_name);
            tvJokeContent = (TextView) itemView.findViewById(R.id.tv_joke_content);
            ivUserHeadImage = (CircleImageView) itemView.findViewById(R.id.user_head_image);
        }
    }

    public MyJokeRecyclerViewAdapter(List<NeedBean> list) {
        needBeanList = list;
    }

    @Override
    public MyJokeRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .nei_han_joke_item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyJokeRecyclerViewAdapter.ViewHolder holder, int position) {
        NeedBean needBean = needBeanList.get(position);
        holder.tvJokeUserName.setText(needBean.getUserName());

        //        tvJokeContent = (TextView) findViewById(R.id.tv_joke_content);
//        SpannableStringBuilder styled = new SpannableStringBuilder(tvJokeContent.getText());
//
//// i 未起始字符索引，j 为结束字符索引
//        styled.setSpan(new ForegroundColorSpan(Color.RED),"#", "#", Spannable
// .SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        tvJokeContent.setText(styled);
////        tvJokeContent.setText(Html.fromHtml("<font
// color=\"#ff0000\">"+"#内涵段子#"+"</font>"+"别人问我 32的胸为什么一定要穿36的胸罩 ……废话 房子大看着也硬气啊"));
        String text = "#"+needBean.getUserTextPrefix()+"#"+needBean.getUserText();
        SpannableStringBuilder styled = new SpannableStringBuilder(text);
        styled.setSpan(new ForegroundColorSpan(Color.RED),text.indexOf("#"),text.indexOf("#",2)+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.tvJokeContent.setText(styled);
        Glide.with(MyApplication.getContext()).load(needBean.getUserHeadImg()).into(holder
                .ivUserHeadImage);
    }

    @Override
    public int getItemCount() {
        return needBeanList.size();
    }
}

