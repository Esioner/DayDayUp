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
import com.esioner.myapplication.neihan.neihanbean.NeiHanBean.NeiHanBean;
import com.esioner.myapplication.neihan.neihanbean.NeiHanBean.NeiHanDataBean;
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


public class VideoFragment extends Fragment {

    private List<NeiHanDataBean> dataBeanList = new ArrayList<>();
    private RecyclerView recyclerViewVideo;
    private SmartRefreshLayout smartRefreshLayout;
    private MyCommonRecyclerViewAdapter mAdapter;
    private double mineTime = MyApplication.getUnixTime() - 1000000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_han_video_fragment, container, false);
        recyclerViewVideo = (RecyclerView) view.findViewById(R.id.recycler_view_nei_han_video);

        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id
                .smart_refresh_layout_video);

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        loadVideoData();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void refresh() {
        dataBeanList.clear();
        loadVideoData();
    }

    public void loadMore() {
        loadVideoData();
    }

    private void loadVideoData() {
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
                LogUtil.d("视频Json", neiHanBean.getMessage());
                LogUtil.d("视频Tip", neiHanBean.getData().getRefreshTip());

                //遍历JokeBean
                traverseData(neiHanBean);
//
            }
        });
    }

    //遍历JokeData
    private void traverseData(NeiHanBean neiHanBean) {
        mineTime = neiHanBean.getData().getMinTime() - 1000000;
        LogUtil.i("MineTime", mineTime + "");
        List<NeiHanDataBean> lists = new ArrayList<>();
        for (NeiHanDataBean neiHanDataBean : neiHanBean.getData().getData()) {
            if (neiHanDataBean.getGroup() != null) {
                lists.add(neiHanDataBean);
            }
        }
        dataBeanList.addAll(lists);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showText(dataBeanList);
            }
        });


    }

    private void showText(List<NeiHanDataBean> list) {
        if (mAdapter == null) {
            mAdapter = new MyCommonRecyclerViewAdapter(list);
            recyclerViewVideo.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewVideo.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

}
