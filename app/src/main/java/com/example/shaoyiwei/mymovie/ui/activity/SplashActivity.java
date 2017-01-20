package com.example.shaoyiwei.mymovie.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.shaoyiwei.mymovie.R;

import me.wangyuwei.particleview.ParticleView;

/**
 * Created by shaoyiwei on 2016/12/11.
 */

public class SplashActivity extends AppCompatActivity {
    private ParticleView pv_logo;
    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        pv_logo = (ParticleView) findViewById(R.id.pv_logo);
        pv_logo.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(SplashActivity.this, TestActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        });
        pv_logo.startAnim();
    }



}
