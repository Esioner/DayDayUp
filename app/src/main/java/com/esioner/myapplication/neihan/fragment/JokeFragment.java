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
import android.widget.TextView;


import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.R;
import com.esioner.myapplication.neihan._URL;
import com.esioner.myapplication.neihan.adapter.MyJokeRecyclerViewAdapter;
import com.esioner.myapplication.neihan.neihanbean.jokeBean.GroupBean;
import com.esioner.myapplication.neihan.neihanbean.jokeBean.JokeBean;
import com.esioner.myapplication.neihan.neihanbean.jokeBean.JokeData;
import com.esioner.myapplication.neihan.neihanbean.jokeBean.NeedBean;
import com.esioner.myapplication.utils.LogUtil;
import com.esioner.myapplication.utils.OkHttpUtils;
import com.esioner.myapplication.utils.SPUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class JokeFragment extends Fragment {

    private List<NeedBean> needBeanList = new ArrayList<>();
    private RecyclerView recyclerViewJoke;
    private JokeBean mJokeBean;
    private final int PARSE_JSON_SUCCESS = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case PARSE_JSON_SUCCESS:
                    mJokeBean = (JokeBean) msg.obj;
                    NeedBean needBean;
                    List<JokeData> jokeDatas = mJokeBean.getData().getJokeDatas();
                    for (JokeData jokeData : jokeDatas) {
                        if (jokeData.getGroup() != null) {
                            needBean = new NeedBean();
                            needBean.setUserName(jokeData.getGroup().getUserInfo().getName());
                            needBean.setUserHeadImg(jokeData.getGroup().getUserInfo().getHeadImage());
                            needBean.setUserText(jokeData.getGroup().getContent());
                            needBean.setUserTextPrefix(jokeData.getGroup().getPrefix());
                            needBeanList.add(needBean);
                        }
                    }
                    showText(needBeanList);
                    break;
                default:
            }
        }
    };

    private void showText(List<NeedBean> list) {
        MyJokeRecyclerViewAdapter mAdapter = new MyJokeRecyclerViewAdapter(list);
        recyclerViewJoke.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewJoke.setAdapter(mAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_han_joke_fragment, null);
        recyclerViewJoke = (RecyclerView) view.findViewById(R.id.recycler_view_joke);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initJokeData();
    }

    private void initJokeData() {
        String mimeTime = MyApplication.getUnixTime() + "";
//        String urlJoke = "http://is.snssdk.com/neihan/stream/mix/v1/?" + _URL.getJokeJointUrlParameter(30 + "", mimeTime);
        //TODO  ：URL 拼接依旧有问题
        String urlJoke = "http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-102&message_cursor=-1&am_longitude=110&am_latitude=120&am_city=%E5%8C%97%E4%BA%AC%E5%B8%82&am_loc_time=1489226058493&count=30&min_time=1489205901&screen_width=1450&do00le_col_mode=0&iid=3216590132&device_id=32613520945&ac=wifi&channel=360&aid=7&app_name=joke_essay&version_code=612&version_name=6.1.2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi&os_api=28&os_version=6.10.1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612&resolution=1450*2800&dpi=620&update_version_code=6120";
        LogUtil.d("URL", urlJoke);
        OkHttpUtils.getInstance().asyncGet(urlJoke, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jokeBody = response.body().string();
                LogUtil.d("JOKE_BODY", jokeBody);
                Gson gson = new Gson();
                JokeBean jokeBean = gson.fromJson(jokeBody, new TypeToken<JokeBean>() {
                }.getType());
                LogUtil.d("", jokeBean.getMessage());
                LogUtil.d("", jokeBean.getData().getTip());

                Message msg = new Message();
                msg.what = PARSE_JSON_SUCCESS;
                msg.obj = jokeBean;
                mHandler.sendMessage(msg);
            }
        });
    }

}


