package com.zgtech.funplay.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.PhotoViewActivity;
import com.zgtech.funplay.model.FriendTalkData;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.utils.FunPlayUtils;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 测试适配器
 * Created by Administrator on 2017/6/14.
 */

public class QuickAdapter extends BaseQuickAdapter<FriendTalkData.ListBean, BaseViewHolder> {
    private Activity context;

    public QuickAdapter(Activity context, int layoutResId, List<FriendTalkData.ListBean> data) {
        super(layoutResId, data);
        this.context = context;

    }

    @Override
    protected void convert(BaseViewHolder helper, FriendTalkData.ListBean individualModel) {
        CircleImageView ivAvatar = helper.getView(R.id.iv_avatar);
        TextView tvTitle = helper.getView(R.id.tv_title);
        TextView tvContent = helper.getView(R.id.tv_content);
        TextView tvTime = helper.getView(R.id.tv_time);


        initAvatar(ivAvatar, ApiStores.API_SERVER_URL + individualModel.getUserIcon());
        tvTitle.setText(individualModel.getUserNick());
        tvContent.setText(individualModel.getSpaceContent());
        tvTime.setText(FunPlayUtils.long2str(individualModel.getModifyTime()));

        List<String> imgUrlList = new ArrayList<>();
        List<String> originPics = individualModel.getPictures();
        for (String singleImgUrl : originPics) {
            imgUrlList.add(ApiStores.API_SERVER_URL + singleImgUrl);
        }

        initImgsUI(helper, individualModel, imgUrlList);
    }


    private void initAvatar(ImageView ivAvatar, String avatarImgUrl) {
        loadImg(avatarImgUrl, ivAvatar);
    }

    private void initImgsUI(BaseViewHolder helper, FriendTalkData.ListBean individuallModel, List<String> imgUrlList) {
        ImageView iv1 = helper.getView(R.id.image_1);
        ImageView iv2 = helper.getView(R.id.image_2);
        ImageView iv3 = helper.getView(R.id.image_3);
        ImageView iv4 = helper.getView(R.id.image_4);
        ImageView iv5 = helper.getView(R.id.image_5);
        ImageView iv6 = helper.getView(R.id.image_6);
        ImageView iv7 = helper.getView(R.id.image_7);
        ImageView iv8 = helper.getView(R.id.image_8);
        ImageView iv9 = helper.getView(R.id.image_9);

        setIVClickListener(imgUrlList, iv1, 0);
        setIVClickListener(imgUrlList, iv2, 1);
        setIVClickListener(imgUrlList, iv3, 2);
        setIVClickListener(imgUrlList, iv4, 3);
        setIVClickListener(imgUrlList, iv5, 4);
        setIVClickListener(imgUrlList, iv6, 5);
        setIVClickListener(imgUrlList, iv7, 6);
        setIVClickListener(imgUrlList, iv8, 7);
        setIVClickListener(imgUrlList, iv9, 8);

        if (imgUrlList.size() == 0 || individuallModel.getPictures() == null) {
            //易用APP目前所能看到的朋友圈，通常不存在纯文本类型，至少会有一张图片，所以先暂时不予以修改，放这里吧暂时。
        } else if (imgUrlList.size() == 1) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.GONE);
            iv3.setVisibility(View.GONE);
            iv4.setVisibility(View.GONE);
            iv5.setVisibility(View.GONE);
            iv6.setVisibility(View.GONE);
            iv7.setVisibility(View.GONE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            loadImg(imgUrlList.get(0), iv1);
        } else if (imgUrlList.size() == 2) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.GONE);
            iv4.setVisibility(View.GONE);
            iv5.setVisibility(View.GONE);
            iv6.setVisibility(View.GONE);
            iv7.setVisibility(View.GONE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            loadImg(imgUrlList.get(0), iv1);
            loadImg(imgUrlList.get(1), iv2);
        } else if (imgUrlList.size() == 3) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.GONE);
            iv5.setVisibility(View.GONE);
            iv6.setVisibility(View.GONE);
            iv7.setVisibility(View.GONE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            loadImg(imgUrlList.get(0), iv1);
            loadImg(imgUrlList.get(1), iv2);
            loadImg(imgUrlList.get(2), iv3);
        } else if (imgUrlList.size() == 4) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.VISIBLE);
            iv5.setVisibility(View.GONE);
            iv6.setVisibility(View.GONE);
            iv7.setVisibility(View.GONE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            loadImg(imgUrlList.get(0), iv1);
            loadImg(imgUrlList.get(1), iv2);
            loadImg(imgUrlList.get(2), iv3);
            loadImg(imgUrlList.get(3), iv4);
        } else if (imgUrlList.size() == 5) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.VISIBLE);
            iv5.setVisibility(View.VISIBLE);
            iv6.setVisibility(View.GONE);
            iv7.setVisibility(View.GONE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            loadImg(imgUrlList.get(0), iv1);
            loadImg(imgUrlList.get(1), iv2);
            loadImg(imgUrlList.get(2), iv3);
            loadImg(imgUrlList.get(3), iv4);
            loadImg(imgUrlList.get(4), iv5);
        } else if (imgUrlList.size() == 6) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.VISIBLE);
            iv5.setVisibility(View.VISIBLE);
            iv6.setVisibility(View.VISIBLE);
            iv7.setVisibility(View.GONE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            loadImg(imgUrlList.get(0), iv1);
            loadImg(imgUrlList.get(1), iv2);
            loadImg(imgUrlList.get(2), iv3);
            loadImg(imgUrlList.get(3), iv4);
            loadImg(imgUrlList.get(4), iv5);
            loadImg(imgUrlList.get(5), iv6);
        } else if (imgUrlList.size() == 7) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.VISIBLE);
            iv5.setVisibility(View.VISIBLE);
            iv6.setVisibility(View.VISIBLE);
            iv7.setVisibility(View.VISIBLE);
            iv8.setVisibility(View.GONE);
            iv9.setVisibility(View.GONE);
            loadImg(imgUrlList.get(0), iv1);
            loadImg(imgUrlList.get(1), iv2);
            loadImg(imgUrlList.get(2), iv3);
            loadImg(imgUrlList.get(3), iv4);
            loadImg(imgUrlList.get(4), iv5);
            loadImg(imgUrlList.get(5), iv6);
            loadImg(imgUrlList.get(6), iv7);
        } else if (imgUrlList.size() == 8) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.VISIBLE);
            iv5.setVisibility(View.VISIBLE);
            iv6.setVisibility(View.VISIBLE);
            iv7.setVisibility(View.VISIBLE);
            iv8.setVisibility(View.VISIBLE);
            iv9.setVisibility(View.GONE);
            loadImg(imgUrlList.get(0), iv1);
            loadImg(imgUrlList.get(1), iv2);
            loadImg(imgUrlList.get(2), iv3);
            loadImg(imgUrlList.get(3), iv4);
            loadImg(imgUrlList.get(4), iv5);
            loadImg(imgUrlList.get(5), iv6);
            loadImg(imgUrlList.get(6), iv7);
            loadImg(imgUrlList.get(7), iv8);
        } else if (imgUrlList.size() == 9) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.VISIBLE);
            iv5.setVisibility(View.VISIBLE);
            iv6.setVisibility(View.VISIBLE);
            iv7.setVisibility(View.VISIBLE);
            iv8.setVisibility(View.VISIBLE);
            iv9.setVisibility(View.VISIBLE);
            loadImg(imgUrlList.get(0), iv1);
            loadImg(imgUrlList.get(1), iv2);
            loadImg(imgUrlList.get(2), iv3);
            loadImg(imgUrlList.get(3), iv4);
            loadImg(imgUrlList.get(4), iv5);
            loadImg(imgUrlList.get(5), iv6);
            loadImg(imgUrlList.get(6), iv7);
            loadImg(imgUrlList.get(7), iv8);
            loadImg(imgUrlList.get(8), iv9);
        }
    }

    private void setIVClickListener(final List<String> imgUrlList, ImageView iv, final int position) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPhotoViewActivity(imgUrlList, position);
            }
        });
    }

    private void toPhotoViewActivity(List<String> imgUrlList, int position) {
        ArrayList<String> urlList = new ArrayList<>();
        urlList.addAll(imgUrlList);
        Intent intent1 = new Intent(mContext, PhotoViewActivity.class);
        intent1.putStringArrayListExtra("imgurllist", urlList);
        intent1.putExtra("position", position);

        slideNextActivity(intent1);
    }

    private void loadImg(String imgUrl, ImageView iv) {
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(mContext)
                .load(imgUrl)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(iv);
    }

    /**
     * 左边滑出，右边滑入的进入下一个Activity动画
     */
    public void slideNextActivity(Intent intent) {
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

}
