package com.esioner.myapplication.neihan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.esioner.myapplication.R;
import com.esioner.myapplication.utils.OkHttpUtils;

import de.hdodenhof.circleimageview.CircleImageView;

public class JokeFragment extends Fragment {

    private RecyclerView recyclerViewJoke;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_han_joke_fragment, null);
        recyclerViewJoke = (RecyclerView) view.findViewById(R.id.recycler_view_joke);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}


//        tvJokeContent = (TextView) findViewById(R.id.tv_joke_content);
//        SpannableStringBuilder styled = new SpannableStringBuilder(tvJokeContent.getText());
//
//// i 未起始字符索引，j 为结束字符索引
//        styled.setSpan(new ForegroundColorSpan(Color.RED),"#", "#", Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        tvJokeContent.setText(styled);
////        tvJokeContent.setText(Html.fromHtml("<font color=\"#ff0000\">"+"#内涵段子#"+"</font>"+"别人问我 32的胸为什么一定要穿36的胸罩 ……废话 房子大看着也硬气啊"));

