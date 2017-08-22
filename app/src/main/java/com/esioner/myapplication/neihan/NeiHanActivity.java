package com.esioner.myapplication.neihan;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan.adapter.MyFragmentPageAdapter;
import com.esioner.myapplication.neihan.fragment.FriendFragment;
import com.esioner.myapplication.neihan.fragment.JokeFragment;
import com.esioner.myapplication.neihan.fragment.PictureFragment;
import com.esioner.myapplication.neihan.fragment.RecommendFragment;
import com.esioner.myapplication.neihan.fragment.VideoFragment;
import com.esioner.myapplication.utils.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Esioner on 2017/8/21.
 */

public class NeiHanActivity extends AppCompatActivity {

    private TabLayout tabLayoutNeiHan;
    private ViewPager viewPagerNeiHan;
    private TextView tvJokeContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nei_han_main_pager_layout);
//        ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("请稍等");
//        progressDialog.show();
        initView();

        //加载contentType
        initContentType();


    }

    public void initContentType() {
        OkHttpUtils.asyncGet(_URL.URL_CONTENT_TYPE, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonBody = response.body().string();

            }
        });
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tabLayoutNeiHan = (TabLayout) findViewById(R.id.tab_layout_nei_han);
        viewPagerNeiHan = (ViewPager) findViewById(R.id.viewpager_nei_han_content);
        JokeFragment jokeFragment = new JokeFragment();
        FriendFragment friendFragment = new FriendFragment();
        PictureFragment pictureFragment = new PictureFragment();
        VideoFragment videoFragment = new VideoFragment();
        RecommendFragment recommendFragment = new RecommendFragment();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(recommendFragment);
        fragments.add(jokeFragment);
        fragments.add(pictureFragment);
        fragments.add(videoFragment);
        fragments.add(friendFragment);

        MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(getSupportFragmentManager(),
                fragments);
        viewPagerNeiHan.setOffscreenPageLimit(5);
        viewPagerNeiHan.setAdapter(adapter);

        TabLayout.Tab tabRecommend = tabLayoutNeiHan.getTabAt(0);
        TabLayout.Tab tabJoke = tabLayoutNeiHan.getTabAt(1);
        TabLayout.Tab tabPicture = tabLayoutNeiHan.getTabAt(2);
        TabLayout.Tab tabVideo = tabLayoutNeiHan.getTabAt(3);
        TabLayout.Tab tabFriend = tabLayoutNeiHan.getTabAt(4);

        tabLayoutNeiHan.setupWithViewPager(viewPagerNeiHan);


    }
}
