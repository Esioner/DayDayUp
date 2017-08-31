package com.esioner.myapplication.neihan.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esioner.myapplication.MyApplication;


public abstract class BaseFragment extends Fragment {
    /**
     * 判断 view 是否初始化成功
     */
    protected boolean isViewPrepared = false;
    /**
     * 判断 fragment 是否可见
     */
    protected boolean isFragmentVisible = false;
    private ProgressDialog mDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {

        View view = inflater.inflate(getResId(), container, false);
        initView(view);
        return view;
    }


    protected void showProgressDialog(Context context) {
        mDialog = new ProgressDialog(context);
        mDialog.setMessage("正在加载数据，请稍后");
        mDialog.setCancelable(false);
        mDialog.show();
    }

    protected void dismissDialog() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isFragmentVisible = true;
            onVisible();
        } else {
            isFragmentVisible = false;
            onUnVisible();

        }
    }


    protected void onVisible() {
        lazyLoad();
    }

    private void onUnVisible() {
        releaseData();
    }

    //加载View
    public abstract void initView(View view);

    protected void lazyLoad() {
        if (isFragmentVisible && isViewPrepared) {
            loadData();
        }
    }

    protected abstract void loadData();


    protected abstract void releaseData();

    protected abstract int getResId();

    protected abstract void onRefresh();
}
