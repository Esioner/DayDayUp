package com.esioner.myapplication.neihan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esioner.myapplication.R;

/**
 * Create: 2017/8/22
 * Writer: liurui
 * Phone:  13554142421
 * Email:  16801630@qq.com
 */

public class PictureFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.nei_han_picture_fragment,null);
        return view;
    }
}
