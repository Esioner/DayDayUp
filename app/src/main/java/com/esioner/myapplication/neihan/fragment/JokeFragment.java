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
                        needBean = new NeedBean();
                        needBean.setUserName(jokeData.getGroup().getUserInfo().getName());
                        needBean.setUserHeadImg(jokeData.getGroup().getUserInfo().getHeadImage());
                        needBean.setUserText(jokeData.getGroup().getContent());
                        needBeanList.add(needBean);
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
        String urlJoke = _URL.URL_RECOMMEND + _URL.getJokeJointUrlParameter(30 + "", mimeTime);
        OkHttpUtils.getInstance().asyncGet(urlJoke, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jokeBody = response.body().string();
                LogUtil.d("JOKE_BODY", jokeBody);
                Gson gson = new Gson();
                JokeBean jokeBean = gson.fromJson(jokeBody, new TypeToken<JokeBean>() {}.getType());
                LogUtil.d("", jokeBean.getMessage());
                LogUtil.d("",jokeBean.getData().getTip());

                Message msg = new Message();
                msg.what = PARSE_JSON_SUCCESS;
                msg.obj = jokeBean;
                mHandler.sendMessage(msg);
            }
        });
    }

}


//        tvJokeContent = (TextView) findViewById(R.id.tv_joke_content);
//        SpannableStringBuilder styled = new SpannableStringBuilder(tvJokeContent.getText());
//
//// i 未起始字符索引，j 为结束字符索引
//        styled.setSpan(new ForegroundColorSpan(Color.RED),"#", "#", Spannable
// .SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        tvJokeContent.setText(styled);
////        tvJokeContent.setText(Html.fromHtml("<font
// color=\"#ff0000\">"+"#内涵段子#"+"</font>"+"别人问我 32的胸为什么一定要穿36的胸罩 ……废话 房子大看着也硬气啊"));

