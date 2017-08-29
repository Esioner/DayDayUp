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
import android.widget.Toolbar;

import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan.adapter.MyFragmentPageAdapter;
import com.esioner.myapplication.neihan.fragment.FriendFragment;
import com.esioner.myapplication.neihan.fragment.JokeFragment;
import com.esioner.myapplication.neihan.fragment.PictureFragment;
import com.esioner.myapplication.neihan.fragment.RecommendFragment;
import com.esioner.myapplication.neihan.fragment.VideoFragment;
import com.esioner.myapplication.neihan.neihanbean.contentTypeBean.ContentTypeBean;
import com.esioner.myapplication.neihan.neihanbean.contentTypeBean.TypeData;
import com.esioner.myapplication.utils.LogUtil;
import com.esioner.myapplication.utils.OkHttpUtils;
import com.esioner.myapplication.utils.SPUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//import com.esioner.myapplication.neihan.fragment.PictureFragment;
//import com.esioner.myapplication.neihan.fragment.VideoFragment;


public class NeiHanFragment extends Fragment {
    private TabLayout tabLayoutNeiHan;
    private ViewPager viewPagerNeiHan;
    private TextView tvJokeContent;
    private List<TypeData> typeDataList;
    private TypeData mRecommendTypeData;
    private TypeData mVideoTypeData;
    private TypeData mFriendShowTypeData;
    private TypeData mPictureTypeData;
    private TypeData mJokeTypeData;
    private Toolbar toolbar;
    //    private TypeData

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_han_main_pager_layout, container, false);

        tabLayoutNeiHan = (TabLayout) view.findViewById(R.id.tab_layout_nei_han);
        viewPagerNeiHan = (ViewPager) view.findViewById(R.id.viewpager_nei_han_content);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }

    @Override
    public void onResume() {
        super.onResume();
        //初始化 contentType
        initContentType();
    }

    private void initContentType() {
        String UrlContentType = _URL.URL_CONTENT_TYPE + _URL.getJointContentTypeParameter();
        OkHttpUtils.getInstance().asyncGet(UrlContentType, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseBody = response.body().string();
                LogUtil.w("RESPONSE_CONTENT_TYPE", responseBody);
                Gson gson = new Gson();
                Type type = new TypeToken<ContentTypeBean>() {}.getType();
                ContentTypeBean contentTypeBean = gson.fromJson(responseBody, type);
                if (contentTypeBean.getMessage().equals("success")) {
                    List<TypeData> typeDataList = contentTypeBean.getTypeDatas();
                    for (TypeData typeData : typeDataList) {
                        switch (typeData.getName()) {
                            case "推荐":
                                mRecommendTypeData = typeData;
                                SPUtils.putString("推荐", mRecommendTypeData.getListId() + "");
                                LogUtil.i("推荐", "name=" + mRecommendTypeData.getName());
                                LogUtil.i("推荐", "url=" + mRecommendTypeData.getUrl());
                                LogUtil.i("推荐", "list_id=" + mRecommendTypeData.getListId());
                                break;
                            case "视频":
                                mVideoTypeData = typeData;
                                SPUtils.putString("视频", mVideoTypeData.getListId() + "");
                                LogUtil.i("视频", "name=" + mVideoTypeData.getName());
                                LogUtil.i("视频", "url=" + mVideoTypeData.getUrl());
                                LogUtil.i("视频", "list_id=" + mVideoTypeData.getListId());
                                break;
                            case "段友秀":
                                mFriendShowTypeData = typeData;
                                LogUtil.i("段友秀", "name=" + mFriendShowTypeData.getName());
                                LogUtil.i("段友秀", "url=" + mFriendShowTypeData.getUrl());
                                LogUtil.i("段友秀", "list_id=" + mFriendShowTypeData.getListId());
                                break;
                            case "图片":
                                mPictureTypeData = typeData;
                                LogUtil.i("图片", "name=" + mPictureTypeData.getName());
                                LogUtil.i("图片", "url=" + mPictureTypeData.getUrl());
                                LogUtil.i("图片", "list_id=" + mPictureTypeData.getListId());
                                break;
                            case "段子":
                                mJokeTypeData = typeData;
                                SPUtils.putString("段子", mJokeTypeData.getListId() + "");
                                LogUtil.i("段子", "name=" + mJokeTypeData.getName());
                                LogUtil.i("段子", "url=" + mJokeTypeData.getUrl());
                                LogUtil.i("段子", "list_id=" + mJokeTypeData.getListId());
                                break;
                            default:
                        }
                    }
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

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
