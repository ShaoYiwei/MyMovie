package com.example.shaoyiwei.mymovie.ui.fagment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaoyiwei.mymovie.R;

import org.w3c.dom.Text;

import butterknife.BindView;

/**
 * Created by shaoyiwei on 2016/12/13.
 */

public class BookListFragment extends BaseFragment {

    private String tag = "hot";

    @BindView(R.id.tv_test)
    TextView tv;

    public static BookListFragment newInstance(String tag) {
        
        Bundle args = new Bundle();
        args.putString("tag",tag);
        BookListFragment fragment = new BookListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_booklist,container,false);
        String result = getArguments().getString("tag");
        if(!TextUtils.isEmpty(result)){
            tag = result;
        }
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData(boolean isSavedNull) {
        tv.setText(tag);
    }
}
