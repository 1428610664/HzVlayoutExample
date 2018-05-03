package com.hz.hzvlayoutexample;

import android.app.Activity;

import com.hz.hzvlayoutexample.entity.HomeBlogEntity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

public class NewsData {

    public static void cacheFindNewsData(Activity activity) {
        List<HomeBlogEntity> findNews = new ArrayList<>();
        try {
            InputStream in = activity.getAssets().open("findNews.config");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            String jsonStr = new String(buffer, "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray jsonArray = jsonObject.optJSONArray("result");
            if (null != jsonArray) {
                int len = jsonArray.length();
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < len; i++) {
                        JSONObject itemJsonObject = jsonArray.getJSONObject(i);
                        HomeBlogEntity itemEntity = new HomeBlogEntity(itemJsonObject);
                        findNews.add(itemEntity);
                        Constant.findNews.add(itemEntity);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //cacheFindNews(findNews);
        }
    }

    public static void cacheFindBottomNewsData(Activity activity) {
        List<HomeBlogEntity> findBottomNews = new ArrayList<>();
        try {
            InputStream in = activity.getAssets().open("findBottomNews.config");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            String jsonStr = new String(buffer, "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray jsonArray = jsonObject.optJSONArray("result");
            if (null != jsonArray) {
                int len = jsonArray.length();
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < len; i++) {
                        JSONObject itemJsonObject = jsonArray.getJSONObject(i);
                        HomeBlogEntity itemEntity = new HomeBlogEntity(itemJsonObject);
                        findBottomNews.add(itemEntity);
                        Constant.findBottomNews.add(itemEntity);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //cacheFindBottomNews(findBottomNews);
        }
    }

}
