package com.esioner.myapplication.neihan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esioner.myapplication.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyJokeRecyclerViewAdapter extends RecyclerView.Adapter<MyJokeRecyclerViewAdapter.ViewHolder> {
    //        private List<>
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

    public MyJokeRecyclerViewAdapter() {
    }

    @Override
    public MyJokeRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyJokeRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

