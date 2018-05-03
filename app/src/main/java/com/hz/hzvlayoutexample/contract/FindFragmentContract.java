package com.hz.hzvlayoutexample.contract;

import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.hz.hzvlayoutexample.MainActivity;
import com.hz.hzvlayoutexample.base.BaseDelegateAdapter;
import com.hz.hzvlayoutexample.base.BasePresenter;
import com.hz.hzvlayoutexample.base.BaseView;

/**
 * Created by hz on 2018/5/2.
 * GitHub：https://github.com/1428610664
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

public interface FindFragmentContract {

    //View(activity/fragment)继承，需要实现的方法
    interface View extends BaseView {
        //设置轮播图
        //void setBanner(BannerView mBanner, List<Object> arrayList);
        void setOnclick(int position);
        void setMarqueeClick(int position);
        void setGridClick(int position);
        void setGridClickThird(int position);
        void setGridClickFour(int position);
        void setNewsList2Click(int position, String url);
        void setNewsList5Click(int position , String url);
    }

    //Presenter控制器
    interface Presenter extends BasePresenter {
        void setActivity(MainActivity activity);
        //初始化
        DelegateAdapter initRecyclerView(RecyclerView recyclerView);
        BaseDelegateAdapter initBannerAdapter();
        BaseDelegateAdapter initGvMenu();
        BaseDelegateAdapter initMarqueeView();
        BaseDelegateAdapter initTitle(String title);
        BaseDelegateAdapter initList1();
        BaseDelegateAdapter initList2();
        BaseDelegateAdapter initList3();
        BaseDelegateAdapter initList4();
        BaseDelegateAdapter initList5();
    }


}

