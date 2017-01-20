package com.example.shaoyiwei.mymovie.ui.activity;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.PopupWindow;

import com.example.shaoyiwei.mymovie.R;
import com.example.shaoyiwei.mymovie.ui.fagment.BaseFragment;
import com.example.shaoyiwei.mymovie.ui.fagment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final int EXIT_APP_DELAY = 1000;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    private FloatingActionButton mFab;

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private int currentIndex;
    private SwitchCompat mThemeSwitch;
    private PopupWindow mPopupWindow;
    private long lastTime = 0;
    private BaseFragment currentFragment;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        if (savedInstanceState == null) {
            currentFragment = HomeFragment.newInstance();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fl_content, currentFragment).commit();
        }
    }
}
