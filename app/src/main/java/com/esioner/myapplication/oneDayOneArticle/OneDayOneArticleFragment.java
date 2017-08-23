package com.esioner.myapplication.oneDayOneArticle;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.esioner.myapplication.utils.ConstantValue;
import com.esioner.myapplication.Datebase.MySQLiteOpenHelper;
import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.utils.OkHttpUtils;
import com.esioner.myapplication.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OneDayOneArticleFragment extends Fragment implements View.OnClickListener {

    private TextView tvArticleAuthor;
    private TextView tvArticleContent;
    private TextView tvArticleCurrentDay;
    private TextView tvArticlePreviousDay;
    private TextView tvArticleNextDay;
    private TextView tvArticleTitle;
    private Context mContext;

    private int date = Integer.valueOf(MyApplication.getDate());

    private ProgressDialog progressDialog;
    private MySQLiteOpenHelper helper;
    private SQLiteDatabase db;
    /**
     * 请求数据成功
     */
    public final int GET_ARTICLE_SUCCESSFUL = 0;
    public final int GET_ARTICLE_FAIL = 1;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GET_ARTICLE_SUCCESSFUL:
                    show();
                    break;
                case GET_ARTICLE_FAIL:
                    Snackbar.make(view, "获取文章内容失败，请重试", 3000).setAction("重试", new View
                            .OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getArticleFromInternet(date + "");
                        }
                    }).show();
                    break;
                default:
            }
        }
    };
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = inflater.getContext();
        view = inflater.inflate(R.layout.one_day_one_articale_fragment_layout, container,false);
        helper = new MySQLiteOpenHelper(mContext);
        db = helper.getReadableDatabase();
        tvArticleAuthor = (TextView) view.findViewById(R.id.tv_one_article_author);
        tvArticleTitle = (TextView) view.findViewById(R.id.tv_one_article_title);
        tvArticleContent = (TextView) view.findViewById(R.id.tv_one_article_content);
        tvArticleCurrentDay = (TextView) view.findViewById(R.id.tv_one_article_current_day);
        tvArticlePreviousDay = (TextView) view.findViewById(R.id.tv_one_article_previous_day);
        tvArticleNextDay = (TextView) view.findViewById(R.id.tv_one_article_next_day);
        tvArticlePreviousDay.setOnClickListener(this);
        tvArticleNextDay.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    public void show() {
        OneDayArticle article = dbQuery(date + "");
        if (article == null) {
            getArticleFromInternet(date + "");
        } else {
            showText(article);
        }
    }

    /**
     * 将内容显示在控件上
     *
     * @param article
     */
    private void showText(OneDayArticle article) {

        String prev = Integer.valueOf(article.getData().getDate().getCurr()) - 1 + "";
        String next = Integer.valueOf(article.getData().getDate().getCurr()) + 1 + "";
        tvArticleAuthor.setText("作者 ： " + article.getData().getAuthor());
        tvArticleTitle.setText(article.getData().getTitle());
        tvArticleContent.setText(parseText(article.getData().getContent()));
//        tvArticleContent.setText(Html.fromHtml(article.getData().getContent()));
        tvArticleCurrentDay.setText(article.getData().getDate().getCurr());
        tvArticlePreviousDay.setText(prev);
        tvArticleNextDay.setText(next);

    }


    /**
     * 将获得的文章中的
     * <p> 转换为一个 tab
     * </p> 转换为一个回车
     * @param text
     * @return
     */
    public String parseText(String text) {
        String tex = text.replace("<p>", "\t"+" "+"\t");
        String te = tex.replace("</p>", "\n");
        return te;
    }

    /**
     * @param date 传入当前的日期来查询表中数据
     * @return
     */
    public OneDayArticle dbQuery(String date) {
        OneDayArticle article = null;
        Cursor cursor = db.query(ConstantValue.ONE_DAY_ONE_ARTICLE_TABLE_NAME, null, "date = ?",
                new String[]{date}, null, null, null);
        if (cursor == null) {
            return null;
        } else {
            while (cursor.moveToNext()) {
                article = new OneDayArticle();
                OneDayArticle.Data data = article.new Data();
                OneDayArticle.Data.Date articleDate = data.new Date();

                data.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
                articleDate.setCurr(cursor.getString(cursor.getColumnIndex("date")));
                data.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                data.setContent(cursor.getString(cursor.getColumnIndex("content")));

                data.setDate(articleDate);
                article.setData(data);

//                Log.d("Tag", "dbQuery: "+cursor.getString(cursor.getColumnIndex("author")));
//                Log.d("Tag", "dbQuery: "+cursor.getString(cursor.getColumnIndex("date")));
//                Log.d("Tag", "dbQuery: "+cursor.getString(cursor.getColumnIndex("title")));
//                Log.d("Tag", "dbQuery: "+cursor.getString(cursor.getColumnIndex("content")));
            }
            cursor.close();
            return article;
        }
    }

    public void getArticleFromInternet(String date) {
//        final String url = "https://interface.meiriyiwen.com/article/today?dev=1";
        String url = "https://interface.meiriyiwen.com/article/day?dev=1&date=" + date;
        OkHttpUtils.getInstance().asyncGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.sendEmptyMessage(GET_ARTICLE_FAIL);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonBody = response.body().string();
                if (jsonBody != null) {
                    Gson gson = new Gson();
                    try {
                        Log.d("article", "onResponse: " + jsonBody);
                        final OneDayArticle article = gson.fromJson(jsonBody, OneDayArticle.class);
                        long stateCode = dbInsert(article);
                        Log.e("stateCode", "onResponse: " + stateCode);
                        Message msg = new Message();
                        msg.what = GET_ARTICLE_SUCCESSFUL;
                        mHandler.sendMessage(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    mHandler.sendEmptyMessage(GET_ARTICLE_FAIL);
                }
            }
        });
    }

    /**
     * db 添加数据
     *
     * @param article
     * @return
     */
    private long dbInsert(OneDayArticle article) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("date", article.getData().getDate().getCurr());
        value.put("title", article.getData().getTitle());
        value.put("content", article.getData().getContent());
        value.put("author", article.getData().getAuthor());
        long code = db.insert(ConstantValue.ONE_DAY_ONE_ARTICLE_TABLE_NAME, null, value);
        return code;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_one_article_previous_day:
                date = date - 1;
                show();
                break;
            case R.id.tv_one_article_next_day:
                date = date + 1;
                if (date < Integer.valueOf(MyApplication.getDate())) {
                    show();
                }else {
                    Toast.makeText(getActivity().getApplicationContext(),"已经最后一天",Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

    }
}
