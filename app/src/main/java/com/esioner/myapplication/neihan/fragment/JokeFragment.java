package com.esioner.myapplication.neihan.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.esioner.myapplication.neihan.neihanbean.commonBean.NeiHanBean;
import com.esioner.myapplication.neihan.neihanbean.commonBean.Datas;
import com.esioner.myapplication.neihan.neihanbean.commonBean.NeedBean;
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

    private List<NeedBean> needBeanList = new ArrayList<>();
    private RecyclerView recyclerViewJoke;
    private SmartRefreshLayout smartRefreshLayout;
    private MyCommonRecyclerViewAdapter mAdapter;
    //    private final int PARSE_JSON_SUCCESS = 0;
    private double mineTime = MyApplication.getUnixTime()-1000000;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
//                case PARSE_JSON_SUCCESS:
//                    mJokeBean = (NeiHanBean) msg.obj;
//                    break;
                default:
            }
        }
    };


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
//        loadJokeData();
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
        String urlJoke = "http://is.snssdk.com/neihan/stream/mix/v1/?content_type=-102&" + _URL
                .getJokeJointUrlParameter(20 + "", mineTime + "");
        //TODO  ：URL 拼接依旧有问题
//        String urlJoke = "http://is.snssdk" +
//                ".com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-102" +
//                "&message_cursor=-1&am_longitude=110&am_latitude=120&am_city=%E5%8C%97%E4%BA%AC" +
//                "%E5%B8%82&am_loc_time=1489226058493&count=30&min_time=1489205901&screen_width" +
//                "=1450&do00le_col_mode=0&iid=3216590132&device_id=32613520945&ac=wifi&channel
// =360" +
//                "&aid=7&app_name=joke_essay&version_code=612&version_name=6.1" +
//                ".2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi" +
//                "&os_api=28&os_version=6.10" +
//                ".1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612" +
//                "&resolution=1450*2800&dpi=620&update_version_code=6120";
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
//                Message msg = new Message();
//                msg.what = PARSE_JSON_SUCCESS;
//                msg.obj = neiHanBean;
//                mHandler.sendMessage(msg);
            }
        });
    }

    //遍历JokeData
    private void traverseData(NeiHanBean mNeiHanBean) {
        NeedBean needBean;
        mineTime = mNeiHanBean.getData().getMin_time()-1000000;
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
            recyclerViewJoke.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewJoke.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }
}


