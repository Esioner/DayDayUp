package com.esioner.myapplication.neihan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan.MessageEvent;
import com.esioner.myapplication.neihan.NeiHanFragment;
import com.esioner.myapplication.neihan._URL;
import com.esioner.myapplication.neihan.adapter.MyCommonRecyclerViewAdapter;
import com.esioner.myapplication.neihan.neihanbean.neiHanBean.NeiHanBean;
import com.esioner.myapplication.neihan.neihanbean.neiHanBean.NeiHanDataBean;
import com.esioner.myapplication.utils.LogUtil;
import com.esioner.myapplication.utils.OkHttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PictureFragment extends Fragment {
    private List<NeiHanDataBean> dataBeanList = new ArrayList<>();
    private RecyclerView recyclerViewPicture;
    private SmartRefreshLayout smartRefreshLayout;
    private MyCommonRecyclerViewAdapter mAdapter;
    private double mineTime = MyApplication.getUnixTime() - 1000000;

    public static boolean PICTURE_IS_OK = false;

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

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadJokeData();
    }

    public void refresh() {
        dataBeanList.clear();
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
                LogUtil.d("", neiHanBean.getData().getRefreshTip());
                //遍历JokeBean
                traverseData(neiHanBean);
            }
        });
    }

    //遍历JokeData
    private void traverseData(NeiHanBean neiHanBean) {
        NeiHanDataBean dataBean;
        mineTime = neiHanBean.getData().getMinTime() - 1000000;
        LogUtil.i("MineTime", mineTime + "");
        List<NeiHanDataBean> lists = new ArrayList<>();
        for (NeiHanDataBean neiHanDataBean : neiHanBean.getData().getData()) {
            if (neiHanDataBean.getGroup() != null) {
                lists.add(neiHanDataBean);
//                LogUtil.i("gif", neiHanDataBean.getGroup().getIsGif() + "");
//                if (neiHanDataBean.getGroup().getIsGif()==1){
//                    LogUtil.i("GIF_URL",neiHanDataBean.getGroup().getLargeImage().getUrlLists().get(0).getUrl());
//                }
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
            recyclerViewPicture.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewPicture.setAdapter(mAdapter);
            EventBus.getDefault().post(new MessageEvent(NeiHanFragment.PICTURE_TASK,true));

        } else {
            mAdapter.notifyDataSetChanged();
        }
    }
}
