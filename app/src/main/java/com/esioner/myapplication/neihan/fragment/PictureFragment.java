package com.esioner.myapplication.neihan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan._URL;
import com.esioner.myapplication.neihan.adapter.MyCommonRecyclerViewAdapter;
import com.esioner.myapplication.neihan.neihanbean.commonBean.Datas;
import com.esioner.myapplication.neihan.neihanbean.commonBean.NeedBean;
import com.esioner.myapplication.neihan.neihanbean.commonBean.NeiHanBean;
import com.esioner.myapplication.neihan.neihanbean.imgBean.ImageUrl;
import com.esioner.myapplication.utils.LogUtil;
import com.esioner.myapplication.utils.OkHttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PictureFragment extends Fragment {
    private List<NeedBean> needBeanList = new ArrayList<>();
    private RecyclerView recyclerViewPicture;
    private SmartRefreshLayout smartRefreshLayout;
    private MyCommonRecyclerViewAdapter mAdapter;
    private double mineTime = MyApplication.getUnixTime() - 1000000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_han_picture_fragment, container, false);
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id
                .smart_refresh_layout_picture);
        recyclerViewPicture = (RecyclerView) view.findViewById(R.id.nei_han_picture_recycler_view);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh();
                Toast.makeText(getActivity().getApplicationContext(), "正在刷新", Toast.LENGTH_SHORT)
                        .show();
                if (smartRefreshLayout.isRefreshing()) {
                    smartRefreshLayout.finishRefresh();
                }
            }
        });

        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                loadMore();
                Toast.makeText(getActivity().getApplicationContext(), "正在加载更多", Toast
                        .LENGTH_SHORT).show();
                if (smartRefreshLayout.isLoading()) {
                    smartRefreshLayout.finishLoadmore();
                }
            }
        });

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
        String urlJoke = "http://is.snssdk.com/neihan/stream/mix/v1/?content_type=-103&" + _URL
                .getImageJointUrlParameter(30 + "", mineTime + "");
        LogUtil.d("URL", urlJoke);
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

                ImageUrl largeImageUrl = datas.getGroup().getLargeImage().getUrlLists().get(0);
                needBean.setImageLargeUrl(largeImageUrl.getUrl());
                ImageUrl middleImageUrl = datas.getGroup().getMiddleImage().getUrlLists().get(0);
                needBean.setImageMiddleImage(middleImageUrl.getUrl());
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
            recyclerViewPicture.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewPicture.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }
}
