package com.hz.hzvlayoutexample.utils;

import android.content.Context;
import android.widget.ImageView;

import com.hz.hzvlayoutexample.R;
import com.squareup.picasso.Picasso;

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

public class ImageUtils {

    /**
     * 加载图片
     */
    public static void loadImgByPicasso(Context context , String path, ImageView target) {
        if(target==null){
            return;
        }
        if(path!=null && path.length()>0){
            Picasso.with(context)
                    .load(path)
                    .into(target);
        }
    }

    /**
     * 加载图片
     */
    public static void loadImgByPicasso(Context context , int path, ImageView target) {
        if(target==null){
            return;
        }
        if(path!=0){
            Picasso.with(context)
                    .load(path)
                    .placeholder(path)
                    .into(target);
        }
    }


    /**
     * 加载本地图片
     * @param context       上下文
     * @param path          路径
     * @param target        view
     */
    public static void loadImgByPicassoWithCircle(Context context , int path, ImageView target) {
        if(target==null){
            return;
        }
        if(path>0){
            Picasso.with(context)
                    .load(path)
                    .placeholder(R.mipmap.ic_launcher)
                    .transform(new CircleTransform())
                    .into(target);
        }
    }


    /**
     * 加载人物，机构logo时，加载失败时显示默认图片
     * @param path          路径
     * @param resId         加载失败时，默认图片
     * @param target        控件
     */
    public static void loadImgByPicassoPerson(Context context , String path, int resId, ImageView target) {
        if(target==null){
            return;
        }
        if(path!=null && path.length()>0){
            Picasso.with(context)
                    .load(path)
                    .error(resId)
                    .placeholder(resId)
                    .transform(new CircleTransform())
                    .into(target);
        }
    }

    /**
     * 加载图片
     * @param resId         string
     * @param target        控件
     */
    public static void loadImgByPicasso(Context context , String path , int resId, ImageView target) {
        if(target==null){
            return;
        }
        if(path!=null && path.length()>0){
            Picasso.with(context)
                    .load(path)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        }else {
            Picasso.with(context)
                    .load(resId)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        }
    }

    /**
     * 加载图片
     * @param resId         int
     * @param target        控件
     */
    public static void loadImgByPicasso(Context context , int path , int resId, ImageView target) {
        if(target==null){
            return;
        }
        if(path>0){
            Picasso.with(context)
                    .load(path)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        }else {
            Picasso.with(context)
                    .load(resId)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        }
    }


    /**
     * 加载图片
     * @param resId
     * @param target        控件
     */
    public static void loadImgByPicassoError(Context context , String path , int resId, ImageView target) {
        if(target==null){
            return;
        }
        if(path!=null && path.length()>0){
            Picasso.with(context)
                    .load(path)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        }else {
            Picasso.with(context)
                    .load(resId)
                    .placeholder(resId)
                    .error(resId)
                    .into(target);
        }
    }

}
