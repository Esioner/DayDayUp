package com.esioner.myapplication.neihan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan.adapter.MyFragmentPageAdapter;
import com.esioner.myapplication.neihan.fragment.FriendFragment;
import com.esioner.myapplication.neihan.fragment.JokeFragment;
import com.esioner.myapplication.neihan.fragment.PictureFragment;
import com.esioner.myapplication.neihan.fragment.RecommendFragment;
import com.esioner.myapplication.neihan.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;


public class NeiHanFragment extends Fragment {
    private TabLayout tabLayoutNeiHan;
    private ViewPager viewPagerNeiHan;
    private TextView tvJokeContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_han_main_pager_layout, container, false);
        tabLayoutNeiHan = (TabLayout) view.findViewById(R.id.tab_layout_nei_han);
        viewPagerNeiHan = (ViewPager) view.findViewById(R.id.viewpager_nei_han_content);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {

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

        MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(getChildFragmentManager(),
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
