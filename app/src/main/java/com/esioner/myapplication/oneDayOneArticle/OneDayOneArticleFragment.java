package com.esioner.myapplication.oneDayOneArticle;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.esioner.myapplication.OkHttpUtils;
import com.esioner.myapplication.R;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;

public class OneDayOneArticleFragment extends Fragment {

    private TextView tvArticleAuthor;
    private TextView tvArticleContent;
    private TextView tvArticleCurrentDay;
    private TextView tvArticlePreviousDay;
    private TextView tvArticleNextDay;
    private TextView tvArticleTitle;
    private Context mContext;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            JsonBean article = (JsonBean) msg.obj;
            tvArticleAuthor.setText(article.getAuthor());
            tvArticleTitle.setText(article.getTitle());
            tvArticleContent.setText(article.getContent());
            progressDialog.dismiss();
        }
    };
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mContext = inflater.getContext();
        View view = inflater.inflate(R.layout.one_day_one_articale_fragment_layout, null);
        tvArticleAuthor = (TextView) view.findViewById(R.id.tv_one_article_author);
        tvArticleTitle = (TextView) view.findViewById(R.id.tv_one_article_title);
        tvArticleContent = (TextView) view.findViewById(R.id.tv_one_article_content);
        tvArticleCurrentDay = (TextView) view.findViewById(R.id.tv_one_article_current_day);
        tvArticlePreviousDay = (TextView) view.findViewById(R.id.tv_one_article_previous_day);
        tvArticleNextDay = (TextView) view.findViewById(R.id.tv_one_article_next_day);
        return view;
    }

    private void show() {
        final String url = "https://interface.meiriyiwen.com/article/today?dev=1";
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("请稍等");
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = OkHttpUtils.getResponse(url);
                    String jsonBody = response.body().string();
                    if (jsonBody != null) {
                        JsonBean article = new Gson().fromJson(jsonBody, JsonBean.class);
                        Message msg = new Message();
                        msg.obj = article;
                        mHandler.sendMessage(msg);
                    } else {
                        Toast.makeText(mContext, "没有数据", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    /**
     * 将获得的文章中的
     * <p> 转换为一个 tab
     * </p> 转换为一个回车
     *
     * @param text
     * @return
     */
    public String parseText(String text) {
        String tex = text.replace("<p>", "\t\t");
        String te = tex.replace("</p>", "\n");
        return te;
    }

}
