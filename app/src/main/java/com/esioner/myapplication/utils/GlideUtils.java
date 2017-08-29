package com.esioner.myapplication.utils;


import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;

public class GlideUtils {

    public static void showImage(String url, View view) {
        RequestOptions mOptions = new RequestOptions()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                ;
        Glide.with(MyApplication.getContext()).load(url)
                .apply(mOptions)
                .transition(new DrawableTransitionOptions().crossFade(500))
//                .transition(new DrawableTransitionOptions().crossFade(R.anim.rota))
                .into((ImageView) view);

    }

}
