package com.example.shaoyiwei.mymovie.ui.widget.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.example.shaoyiwei.mymovie.R;

/**
 * Created by shaoyiwei on 2016/12/15.
 */

public class BitmapView extends SurfaceView implements SurfaceHolder.Callback {

    private Bitmap mBitmap;
    public BitmapView(Context context) {
        this(context,null);
    }

    public BitmapView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BitmapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     *  初始化View
     */
    private void initView() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.plane);
        Log.e("width", "initView");
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),mBitmap.getWidth()+"",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap,0,0,null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e("width", "surfaceCreated");
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        Log.e("width", String.valueOf(i1));
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.e("width", "surfaceDestroyed");
    }
}
