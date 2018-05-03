package com.hz.hzvlayoutexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.hz.hzvlayoutexample.base.BaseDelegateAdapter;
import com.hz.hzvlayoutexample.contract.FindFragmentContract;
import com.hz.hzvlayoutexample.presenter.FindFragmentPresenter;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements FindFragmentContract.View{

    private long firstTime;
    RecyclerView recyclerView;

    private FindFragmentContract.Presenter presenter = new FindFragmentPresenter(this);
    /** 存放各个模块的适配器*/
    private List<DelegateAdapter.Adapter> mAdapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapters = new LinkedList<>();
        presenter.setActivity(this);
        initData();
        initRecyclerView();
    }

    private void initData() {
        NewsData.cacheFindNewsData(this);
        NewsData.cacheFindBottomNewsData(this);
    }

    private void initRecyclerView(){
        DelegateAdapter delegateAdapter = presenter.initRecyclerView(recyclerView);
        //把轮播器添加到集合
        BaseDelegateAdapter bannerAdapter = presenter.initBannerAdapter();
        mAdapters.add(bannerAdapter);

        //初始化九宫格
        BaseDelegateAdapter menuAdapter = presenter.initGvMenu();
        mAdapters.add(menuAdapter);

        //初始化
        BaseDelegateAdapter marqueeAdapter = presenter.initMarqueeView();
        mAdapters.add(marqueeAdapter);


        //初始化标题
        BaseDelegateAdapter titleAdapter = presenter.initTitle("豆瓣分享");
        mAdapters.add(titleAdapter);
        //初始化list3
        BaseDelegateAdapter girdAdapter3 = presenter.initList3();
        mAdapters.add(girdAdapter3);

        //初始化标题
        titleAdapter = presenter.initTitle("猜你喜欢");
        mAdapters.add(titleAdapter);
        //初始化list1
        BaseDelegateAdapter girdAdapter = presenter.initList1();
        mAdapters.add(girdAdapter);


        //初始化标题
        titleAdapter = presenter.initTitle("热门新闻");
        mAdapters.add(titleAdapter);
        //初始化list2
        BaseDelegateAdapter linearAdapter = presenter.initList2();
        mAdapters.add(linearAdapter);


        //初始化标题
        titleAdapter = presenter.initTitle("为您精选");
        mAdapters.add(titleAdapter);
        //初始化list3
        BaseDelegateAdapter plusAdapter = presenter.initList4();
        mAdapters.add(plusAdapter);

        //初始化折叠式指示器控件
        //initSticky();
        //mAdapters.add(stickyAdapter);

        //初始化list控件
        titleAdapter = presenter.initTitle("优质新闻");
        mAdapters.add(titleAdapter);
        linearAdapter = presenter.initList5();
        mAdapters.add(linearAdapter);

        //设置适配器
        delegateAdapter.setAdapters(mAdapters);
    }

    @Override
    public void setOnclick(int position) {
        Toast.makeText(this, "点击" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setMarqueeClick(int position) {
        Toast.makeText(this, "点击" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setGridClick(int position) {
        Toast.makeText(this, "点击" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setGridClickThird(int position) {
        Toast.makeText(this, "点击" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setGridClickFour(int position) {
        Toast.makeText(this, "点击" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNewsList2Click(int position, String url) {
        Toast.makeText(this, "点击:" + position+", url:"+ url, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNewsList5Click(int position, String url) {
        Toast.makeText(this, "点击:" + position+", url:"+ url, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
