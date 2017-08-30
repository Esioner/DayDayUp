package com.esioner.myapplication.utils;


import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;
import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;

public class GlideUtils {

    public static void showHeaderImage(String url, View view) {


    }

    public static void showImage(String url, View view) {
        RequestOptions mOptions = new RequestOptions()
                .placeholder(R.drawable.place_holder_image)
                .error(R.drawable.error);
        Glide.with(MyApplication.getContext()).load(url)
                .apply(mOptions)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .into((ImageView) view);
//        Glide.with(MyApplication.getContext()).load(url).placeholder(R.drawable
// .place_holder_image).error(R.drawable.error).into((ImageView) view);
    }

    public static void showGifImage(String url, View view) {
//        RequestBuilder<GifDrawable> builder =Glide.with(MyApplication.getContext()).load(url);
        RequestOptions mOptions = new RequestOptions()
                .placeholder(R.drawable.place_holder_image)
                .error(R.drawable.error);
        Glide.with(MyApplication.getContext()).asGif().load(url)
                .apply(mOptions)
                .transition(new DrawableTransitionOptions()
                        .crossFade(500))
                .into((ImageView) view);
    }

}
