package com.esioner.myapplication.neihan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan._URL;
import com.esioner.myapplication.neihan.adapter.MyCommonRecyclerViewAdapter;
import com.esioner.myapplication.neihan.neihanbean.commonBean.Datas;
import com.esioner.myapplication.neihan.neihanbean.commonBean.NeedBean;
import com.esioner.myapplication.neihan.neihanbean.commonBean.NeiHanBean;
import com.esioner.myapplication.utils.LogUtil;
import com.esioner.myapplication.utils.OkHttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Create: 2017/8/22
 * Writer: liurui
 * Phone:  13554142421
 * Email:  16801630@qq.com
 */

public class VideoFragment extends Fragment {

    private List<NeedBean> needBeanList = new ArrayList<>();
    private RecyclerView recyclerViewVideo;
    private SmartRefreshLayout smartRefreshLayout;
    private MyCommonRecyclerViewAdapter mAdapter;
    private double mineTime = MyApplication.getUnixTime() - 1000000;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_han_video_fragment, container,false);
        recyclerViewVideo = (RecyclerView) view.findViewById(R.id.recycler_view_nei_han_video);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        loadJokeData();
    }

    public void refresh() {
        needBeanList.clear();
        loadJokeData();
    }

    public void loadMore() {
        loadJokeData();
    }

    private void loadJokeData() {
        String urlJoke = "http://is.snssdk.com/neihan/stream/mix/v1/?content_type=-104&" + _URL
                .getVideoJointUrlParameter(30 + "", mineTime + "");
        LogUtil.d("Video_URL", urlJoke);
        OkHttpUtils.getInstance().asyncGet(urlJoke.replace(" ", ""), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jokeBody = response.body().string();
                LogUtil.d("JOKE_BODY", jokeBody);
                Gson gson = new Gson();
                NeiHanBean neiHanBean = gson.fromJson(jokeBody, new TypeToken<NeiHanBean>() {
                }.getType());
                LogUtil.d("", neiHanBean.getMessage());
                LogUtil.d("", neiHanBean.getData().getTip());

                //遍历JokeBean
                traverseData(neiHanBean);
//
            }
        });
    }

    //遍历JokeData
    private void traverseData(NeiHanBean mNeiHanBean) {
        NeedBean needBean;
        mineTime = mNeiHanBean.getData().getMin_time() - 1000000;
        LogUtil.i("MineTime", mineTime + "");
        List<Datas> datases = mNeiHanBean.getData().getDatas();
        List<NeedBean> lists = new ArrayList<>();
        for (Datas datas : datases) {
            if (datas.getGroup() != null) {
                needBean = new NeedBean();
                needBean.setUserName(datas.getGroup().getUserInfo().getName());
                needBean.setUserHeadImg(datas.getGroup().getUserInfo()
                        .getHeadImage());
                needBean.setUserText(datas.getGroup().getContent());
                needBean.setUserTextPrefix(datas.getGroup().getPrefix());
                needBean.setMediaType(datas.getGroup().getMediaType());

                needBean.setVideoUrl(datas.getGroup().getVideoUrl());
//                needBean.setVideoCoverUrl(datas.getGroup().getMediumCover().getUrlLists().get(0)
//                        .getUrl());
                lists.add(needBean);
            }
        }
        needBeanList.addAll(lists);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showText(needBeanList);
            }
        });


    }

    private void showText(List<NeedBean> list) {
        if (mAdapter == null) {
            mAdapter = new MyCommonRecyclerViewAdapter(list);
            recyclerViewVideo.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewVideo.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

}
