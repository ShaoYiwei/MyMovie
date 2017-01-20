package com.example.shaoyiwei.mymovie.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.shaoyiwei.mymovie.MyApplication;
import com.example.shaoyiwei.mymovie.R;
import com.example.shaoyiwei.mymovie.common.Constant;
import com.example.shaoyiwei.mymovie.utils.SystemBarTintManager;
import com.example.shaoyiwei.mymovie.utils.common.SPUtils;
import com.example.shaoyiwei.mymovie.utils.common.UIUtils;

/**
 * Created by shaoyiwei on 2016/12/11.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = getClass().getSimpleName();

    public static BaseActivity activity;

    protected Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        activity = this;
        ((MyApplication) UIUtils.getContext()).addActivity(this);
        init();
    }

    private void init() {
        initData();
        initEvents();
        if (isInitSystemBar()) {
            initSystemBar(this);
        }
    }


    /**
     *  初始化数据
     */
    protected abstract void initEvents();

    /**
     *  绑定数据
     */
    protected void initData() {
    }

    /**
     * 获取toolbar
     *
     * @return
     */
    public Toolbar getToolbar() {
        return mToolbar;
    }

    /**
     * 初始化系统栏
     * @param activity
     */
    private void initSystemBar(BaseActivity activity){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setTranslucentStatus(activity, true);
            }
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            tintManager.setStatusBarTintEnabled(true);
            // 使用颜色资源
            tintManager.setStatusBarTintResource(getStatusColor());
        }
    }

    /**
     * 状态栏的颜色
     * 子类可以通过复写这个方法来修改状态栏颜色
     *
     * @return ID
     */
    protected int getStatusColor() {
        //TODO
        if (SPUtils.getPrefBoolean(Constant.THEME_MODEL, false)) {
            return R.color.colorPrimaryDarkNight;
        } else {
            return R.color.colorPrimaryDark;
        }
    }

    @TargetApi(19)
    protected void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();

        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    /**
     * 菜单按钮初始化
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(getMenuID(), menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /***
     * 默认toolbar不带menu，复写该方法指定menu
     *
     * @return
     */
    protected int getMenuID() {
        return R.menu.menu_empty;
    }

    /**
     * 是否初始化状态栏
     *
     * @return
     */
    protected boolean isInitSystemBar() {
        return true;
    }

    /**
     * 是否显示菜单  默认显示
     *
     * @return
     */
    protected boolean showMenu() {
        return true;
    }

    /**
     * activity退出时将activity移出栈
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((MyApplication) UIUtils.getContext()).removeActivity(this);
    }
}
