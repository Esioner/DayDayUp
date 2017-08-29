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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class JokeFragment extends Fragment {

    private List<NeiHanDataBean> neiHanDataList = new ArrayList<>();
    private RecyclerView recyclerViewJoke;
    private SmartRefreshLayout smartRefreshLayout;
    private MyCommonRecyclerViewAdapter mAdapter;
    private double mineTime = MyApplication.getUnixTime() - 1000000;
    private String refreshTips;
    private boolean isFirst = true;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_han_joke_fragment, null);
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smart_refresh_layout);
        recyclerViewJoke = (RecyclerView) view.findViewById(R.id.recycler_view_joke);

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
        loadJokeData();
    }

    @Override
    public void onResume() {
        super.onResume();
//        loadJokeData();
    }

    public void refresh() {
        neiHanDataList.clear();
        loadJokeData();
    }

    public void loadMore() {
        loadJokeData();
    }

    private void loadJokeData() {

        String urlJoke = "http://is.snssdk.com/neihan/stream/mix/v1/?content_type=-102&" + _URL
                .getJokeJointUrlParameter(10 + "", mineTime + "");

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
                refreshTips = neiHanBean.getData().getRefreshTip();
                //遍历JokeBean
                traverseData(neiHanBean);
            }
        });
    }

    //遍历JokeData
    private void traverseData(NeiHanBean neiHanBean) {

        mineTime = neiHanBean.getData().getMinTime() - 1000000;
        List<NeiHanDataBean> list = new ArrayList<>();
        for (NeiHanDataBean dataBean : neiHanBean.getData().getData()) {
            if (dataBean.getGroup() != null) {
                list.add(dataBean);
            }
        }
        neiHanDataList.addAll(list);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showText(neiHanDataList);
            }
        });
    }

    private void showText(List<NeiHanDataBean> list) {
        if (mAdapter == null) {
            mAdapter = new MyCommonRecyclerViewAdapter(list);
            recyclerViewJoke.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewJoke.setAdapter(mAdapter);
            isFirst = false;
        } else {
            mAdapter.notifyDataSetChanged();
        }
        Toast.makeText(getActivity().getApplicationContext(), "已加载" + refreshTips, Toast
                .LENGTH_SHORT).show();
    }
}


