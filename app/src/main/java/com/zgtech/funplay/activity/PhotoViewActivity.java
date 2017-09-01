package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.utils.L;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 点击朋友圈图片之后的图片显示页
 * Created by Administrator on 2017/3/25.
 */
public class PhotoViewActivity extends BaseActivity {
    @Bind(R.id.vp_photo)
    ViewPager vpPhoto;

    private ArrayList<View> viewList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        ButterKnife.bind(this);

        final ArrayList<String> urllist = getIntent().getStringArrayListExtra("imgurllist");
        int positon = getIntent().getIntExtra("position", 0);

        initImageViews(urllist);
        initPagerAdapter(urllist);
        vpPhoto.setCurrentItem(positon);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    private void initImageViews(ArrayList<String> urllist) {
        for (int i = 0; i < urllist.size(); i++) {
            ImageView iv = new ImageView(this);
//            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with(this)
                    .load(urllist.get(i))
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(iv);
//            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            iv.setScaleType(ImageView.ScaleType.CENTER);
//            iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//            iv.setScaleType(ImageView.ScaleType.FIT_XY);
//            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            viewList.add(iv);

            /**监听按一下退出去PhotoViewActivity，回到相册*/
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }


    private void initPagerAdapter(final ArrayList<String> urllist) {
        vpPhoto.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return urllist.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        L.d("shishi", "click");
                    }
                });
                return viewList.get(position);

            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));

            }
        });
    }


}
