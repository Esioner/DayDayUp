package com.esioner.myapplication.neihan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan.MessageEvent;
import com.esioner.myapplication.neihan.NeiHanFragment;
import com.esioner.myapplication.neihan._URL;
import com.esioner.myapplication.neihan.adapter.MyCommonRecyclerViewAdapter;
import com.esioner.myapplication.neihan.neihanbean.neiHanBean.NeiHanBean;
import com.esioner.myapplication.neihan.neihanbean.neiHanBean.NeiHanDataBean;
import com.esioner.myapplication.utils.GlideUtils;
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

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Esioner on 2017/8/29.
 */

public class FriendsFragment extends Fragment {
    private List<NeiHanDataBean> dataBeanList = new ArrayList<>();
    private RecyclerView recyclerViewVideo;
    private SmartRefreshLayout smartRefreshLayout;
    private MyRecyclerViewGridAdapter mAdapter;
    private double mineTime = MyApplication.getUnixTime() - 1000000;

    public static boolean FRIEND_IS_OK = false;

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
        loadVideoData();
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
        String urlJoke = "http://iu.snssdk.com/neihan/stream/mix/v1/?content_type=-301";
//                + _URL.getVideoJointUrlParameter(20 + "", mineTime + "");
//        String urlJoke = "http://iu.snssdk" +
//                ".com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-301" +
//                "&message_cursor=-1&am_longitude=110&am_latitude=120&am_city=%E5%8C%97%E4%BA%AC" +
//                "%E5%B8%82&am_loc_time=1463225362814&count=30&min_time=1489205906&screen_width" +
//                "=1450&do00le_col_mode=1&iid=3216590132&device_id=32613520945&ac=wifi&channel=360" +
//                "&aid=7&app_name=joke_essay&version_code=612&version_name=6.1" +
//                ".2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi" +
//                "&os_api=28&os_version=6.10" +
//                ".1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612" +
//                "&resolution=1450*2800&dpi=620&update_version_code=6120";

        LogUtil.d("Video_URL", urlJoke);
        OkHttpUtils.getInstance().asyncGet(urlJoke.replace(" ", ""), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jokeBody = response.body().string();
                LogUtil.d("Friends", jokeBody);
                Gson gson = new Gson();
                NeiHanBean neiHanBean = gson.fromJson(jokeBody, new TypeToken<NeiHanBean>() {
                }.getType());

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
            mAdapter = new MyRecyclerViewGridAdapter(list);
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager
                    (2, StaggeredGridLayoutManager.VERTICAL);
            recyclerViewVideo.setLayoutManager(manager);
            recyclerViewVideo.setAdapter(mAdapter);
            EventBus.getDefault().post(new MessageEvent(NeiHanFragment.FRIEND_TASK,true));
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    class MyRecyclerViewGridAdapter extends RecyclerView.Adapter<MyRecyclerViewGridAdapter
            .ViewHolder> {
        List<NeiHanDataBean> dataBeenList;

        class ViewHolder extends RecyclerView.ViewHolder {

            private final ImageView neiHanFriendImage;
            private final TextView userContent;
            private final TextView userName;
            private final CircleImageView ivHeaderImage;

            public ViewHolder(View itemView) {
                super(itemView);
                neiHanFriendImage = (ImageView) itemView.findViewById(R.id.nei_han_friends_iv);
                userContent = (TextView) itemView.findViewById(R.id
                        .tv_nei_han_friends_user_content);
                userName = (TextView) itemView.findViewById(R.id.tv_nei_han_friends_user_name);
                ivHeaderImage = (CircleImageView) itemView.findViewById(R.id
                        .iv_nei_han_friends_header_image);
            }
        }

        public MyRecyclerViewGridAdapter(List<NeiHanDataBean> list) {
            dataBeenList = list;
        }

        @Override
        public MyRecyclerViewGridAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
                    .nei_han_friends_item_layout, viewGroup, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyRecyclerViewGridAdapter.ViewHolder holder, int i) {
            NeiHanDataBean dataBean = dataBeenList.get(i);
//            holder.ivHeaderImage
            GlideUtils.showImage(dataBean.getGroup().getLargeCover().getUrlLists().get(0).getUrl
                    (), holder.neiHanFriendImage);
            GlideUtils.showImage(dataBean.getGroup().getUserInfo().getAvatarUrl(), holder
                    .ivHeaderImage);
//            Glide.with(MyApplication.getContext()).load(dataBean.getGroup().getLargeCover()
//                    .getUrlLists().get(0).getUrl()).into(holder
//                    .neiHanFriendImage);
            String content = dataBean.getGroup().getText().equals("") ? "标题由你来起，嘻嘻" : dataBean
                    .getGroup().getText();
            holder.userName.setText(dataBean.getGroup().getUserInfo().getName());
            holder.userContent.setText(content);
        }

        @Override
        public int getItemCount() {
            return dataBeenList.size();
        }

    }


}
