package com.esioner.myapplication.neihan.adapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.esioner.myapplication.R;
import com.esioner.myapplication.utils.GlideUtils;

import java.io.File;

import me.xiaopan.sketch.Sketch;
import me.xiaopan.sketch.SketchImageView;
import me.xiaopan.sketch.request.CancelCause;
import me.xiaopan.sketch.request.DownloadListener;
import me.xiaopan.sketch.request.DownloadResult;
import me.xiaopan.sketch.request.ErrorCause;

public class ShowImageView extends AppCompatActivity implements View.OnClickListener {

    private SketchImageView iv;
    private String url;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //实现透明状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }

        setContentView(R.layout.nei_han_show_image_layout);
        iv = (SketchImageView) findViewById(R.id.iv_show_image);
        iv.setZoomEnabled(true);
        url = getIntent().getStringExtra("IMAGE_URL");
        title = getIntent().getStringExtra("IMAGE_TITLE");
//        Glide.with(this).load(url).into(iv);

        GlideUtils.showImage(url,iv);
        findViewById(R.id.btn_return_show_image).setOnClickListener(this);
        findViewById(R.id.btn_save_show_image).setOnClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 0:
                if (grantResults.length > 0 && grantResults[0] == PackageManager
                        .PERMISSION_GRANTED) {
                    Toast.makeText(this, "获取权限成功，请重新下载", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "权限获取失败，请重新授权", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_return_show_image:
                finish();
                break;
            case R.id.btn_save_show_image:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission
                        .WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission
                            .WRITE_EXTERNAL_STORAGE}, 0);
                } else {
                    download(url, title = title.length() > 10 ? SystemClock
                            .currentThreadTimeMillis()
                            + "" : title);
                }
                break;
        }
    }

    public void download(final String url, final String imageName) {
        File file = null;
        file = new File(Environment.getExternalStoragePublicDirectory(Environment
                .DIRECTORY_PICTURES).getAbsolutePath(), imageName + ".png");
        final File finalFile = file;
        Sketch.with(ShowImageView.this).download(url, new DownloadListener() {
            @Override
            public void onCompleted(DownloadResult result) {
                Toast.makeText(ShowImageView.this, "下载成功，请到相册查看", Toast.LENGTH_SHORT)
                        .show();
                // 最后通知图库更新
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        Uri.fromFile(new File(finalFile.getPath()))));
            }

            @Override
            public void onStarted() {
                Toast.makeText(ShowImageView.this, "正在下载，请稍后", Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onError(ErrorCause errorCause) {
                Snackbar.make(null, "下载失败，请重新下载", 3000)
                        .setAction("重新下载", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                download(url, imageName);
                            }
                        }).show();
            }

            @Override
            public void onCanceled(CancelCause cancelCause) {
            }
        }).commit();
    }
}
