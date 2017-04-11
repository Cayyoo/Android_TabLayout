package com.example.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tablayout.adapter.MyFragmentPagerAdapter;
import com.example.tablayout.utils.CustomTabIndicator;

/**
 * 自定义TabLayout Indicator大小
 * Tab项中Fragment可滑动
 */
public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private FragmentManager fgManager;
    private MyFragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //实例化View
        mViewPager= (ViewPager) findViewById(R.id.viewPager);
        mTabLayout= (TabLayout) findViewById(R.id.tabLayout);

        //实例化适配器
        fgManager=getSupportFragmentManager();
        mAdapter=new MyFragmentPagerAdapter(fgManager,getApplicationContext());

        //给ViewPager设置适配器
        mViewPager.setAdapter(mAdapter);

        //关联ViewPager和TabLayout
        mTabLayout.setupWithViewPager(mViewPager);

        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
        });

        CustomTabIndicator.setIndicator(this,mTabLayout,15,15);//自定义indicator大小
    }

}
