package com.example.tablayout.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.example.tablayout.fragment.FragmentOne;
import com.example.tablayout.fragment.FragmentThree;
import com.example.tablayout.fragment.FragmentTwo;
import com.example.tablayout.fragment.PageFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
    private String[] titles=new String[]{"TabOne","TabTwo","TabThree"};//页卡标题数组

    public MyFragmentPagerAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        //根据位置显示Fragment
        switch (position){
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                return null;
        }

        //return PageFragment.newInstance(position + 1);//只用一个Fragment
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];//页卡标题
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);//官方推荐写法
    }

}
