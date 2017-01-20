package com.example.shaoyiwei.mymovie.ui.fagment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by shaoyiwei on 2016/12/14.
 */

public class DiscoverFragment extends BaseFragment {

    public static DiscoverFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData(boolean isSavedNull) {

    }
}
