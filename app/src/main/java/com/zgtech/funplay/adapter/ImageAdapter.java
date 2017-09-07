package com.zgtech.funplay.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zgtech.funplay.R;

import java.util.List;

/**
 * 发布说说，发布等内容时的大九宫格适配器
 * Created by Administrator on 2017/7/10.
 */

public class ImageAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    List<String> list;

    public ImageAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        int total = list.size();
        if (total < 9)
            total++;
        return total;
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.fx_item_gridview_image, null);
        ImageView iv = (ImageView) convertView.findViewById(R.id.sdv_image);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (position == list.size() && list.size() < 9) {
            iv.setBackgroundResource(R.drawable.fx_icon_add);
            iv.setPadding(5, 5, 5, 5);
        } else {
            String itemPath = getItem(position);
            Glide.with(context)
                    .load(itemPath)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(iv);
        }

        return convertView;
    }

}
