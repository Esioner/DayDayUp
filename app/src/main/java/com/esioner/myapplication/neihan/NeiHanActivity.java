package com.esioner.myapplication.neihan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import com.esioner.myapplication.R;

/**
 * Created by Esioner on 2017/8/21.
 */

public class NeiHanActivity extends AppCompatActivity {

    private TableLayout tableLayout_nei_han;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nei_han_main_pager_layout);
        initView();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        tableLayout_nei_han = (TableLayout) findViewById(R.id.tab_layout_nei_han);

    }
}
