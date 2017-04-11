package com.example.tablayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tablayout.R;

/**
 * 复用一个Fragment时可使用此类
 */
public class PageFragment extends Fragment{
    private static final String ARGS_PAGE="args_page";
    private int mPage;

    /**
     * PageFragment实例方法
     */
    public static PageFragment newInstance(int page){
        Bundle args=new Bundle();

        args.putInt(ARGS_PAGE,page);
        PageFragment fragment=new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage=getArguments().getInt(ARGS_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_page,container,false);
        TextView textView= (TextView) view.findViewById(R.id.textView);
        textView.setText("第"+mPage+"页");
        return view;
    }

}
