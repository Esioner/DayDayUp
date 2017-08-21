package com.esioner.myapplication.oneDayOneArticle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Esioner on 2017/8/21.
 */

public abstract class ArticleActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {

                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if ((e2.getX() - e1.getX()) > 100) {
                    showNextPage();
                } else if((e2.getX()-e1.getX())<-100){
                    showPreviousPage();
                }else {
                    Toast.makeText(ArticleActivity.this,"左右滑动有惊喜",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    private void showNextPage() {
        toRight();
    }

    protected void showPreviousPage() {
        toLeft();
    }

    public abstract void toLeft();


    public abstract void toRight();


}
