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

public class PictureFragment extends BaseFragment {
    private List<NeiHanDataBean> dataBeanList = new ArrayList<>();
    private RecyclerView recyclerViewPicture;
    private SmartRefreshLayout smartRefreshLayout;
    private MyCommonRecyclerViewAdapter mAdapter;
    private double mineTime = MyApplication.getUnixTime() - 1000000;


    @Override
    public void onRefresh() {
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
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void initView(View view) {
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id
                .smart_refresh_layout_picture);
        recyclerViewPicture = (RecyclerView) view.findViewById(R.id.nei_han_picture_recycler_view);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                PictureFragment.this.onRefresh();
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

    }

    @Override
    protected void releaseData() {

    }

    @Override
    protected int getResId() {
        return R.layout.nei_han_picture_fragment;
    }
}
