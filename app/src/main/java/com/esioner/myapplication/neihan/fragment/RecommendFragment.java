package com.esioner.myapplication.neihan.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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


public class RecommendFragment extends BaseFragment {

    private List<NeiHanDataBean> neiHanDataList = new ArrayList<>();
    private RecyclerView recyclerViewRecommend;
    private SmartRefreshLayout smartRefreshLayout;
    private MyCommonRecyclerViewAdapter mAdapter;
    private double mineTime = MyApplication.getUnixTime() - 1000000;
    private String refreshTips;
    private boolean isFirst = true;



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

    public void loadMore() {
        loadRecommendData();
    }


    @Override
    public void onRefresh() {
        neiHanDataList.clear();
        loadRecommendData();
    }


    private void loadRecommendData() {

        String urlJoke = "http://is.snssdk.com/neihan/stream/mix/v1/?content_type=-101&" + _URL
                .getRecommendJointUrlParameter(20 + "", mineTime + "");

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

    private void showText(List<NeiHanDataBean> list) {
        if (mAdapter == null) {
            mAdapter = new MyCommonRecyclerViewAdapter(list);
            recyclerViewRecommend.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewRecommend.setAdapter(mAdapter);
            isFirst = false;
        } else {
            mAdapter.notifyDataSetChanged();
        }
        Toast.makeText(getActivity().getApplicationContext(), "已加载" + refreshTips, Toast
                .LENGTH_SHORT).show();
    }

    @Override
    public void initView(View view) {
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id
                .smart_refresh_layout_recommend);
        recyclerViewRecommend = (RecyclerView) view.findViewById(R.id.recycler_view_recommend);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                RecommendFragment.this.onRefresh();
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

    }

    @Override
    protected void loadData() {
        loadRecommendData();
    }


    @Override
    protected void releaseData() {

    }

    @Override
    protected int getResId() {
        return R.layout.nei_han_recommend_fragment;
    }
}
