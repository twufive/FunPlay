package com.zgtech.funplay.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.CoreUserDetailPageActivity;
import com.zgtech.funplay.activity.PhotoViewActivity;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.model.FriendTalkData;
import com.zgtech.funplay.pop.AddPopWindow;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.retrofit.RetrofitUtil;
import com.zgtech.funplay.utils.FunPlayUtils;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.SP;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 测试适配器
 * Created by Administrator on 2017/6/14.
 */

public class FindAdapter extends BaseQuickAdapter<FriendTalkData.ListBean, BaseViewHolder> {
    private Activity context;
    private ApiStores apiStores;

    private RelativeLayout re_edittext;
    private EditText et_comment;

    private CommentAdapter commentAdapter;
    private RecyclerView recyclerViewComment;
    private List<FriendTalkData.ListBean.CommentsBean> commentOriginList = new ArrayList<>();

    public FindAdapter(Activity context, int layoutResId, List<FriendTalkData.ListBean> data) {
        super(layoutResId, data);
        this.context = context;

        apiStores = RetrofitUtil.initApiStores();
    }

    @Override
    protected void convert(BaseViewHolder helper, FriendTalkData.ListBean individualModel) {
        CircleImageView ivAvatar = helper.getView(R.id.iv_avatar);
        TextView tvTitle = helper.getView(R.id.tv_title);
        TextView tvContent = helper.getView(R.id.tv_content);
        TextView tvTime = helper.getView(R.id.tv_time);
        LinearLayout llZanHeart = helper.getView(R.id.ll_zan_heart);


        initAvatar(ivAvatar, ApiStores.API_SERVER_URL + individualModel.getUserIcon());
        initClickListener(helper, individualModel);

        tvTitle.setText(individualModel.getUserNick());
        tvContent.setText(individualModel.getSpaceContent());
        tvTime.setText(FunPlayUtils.long2strTime(individualModel.getModifyTime()));

        List<String> imgUrlList = new ArrayList<>();
        List<String> originPics = individualModel.getPictures();
        for (String singleImgUrl : originPics) {
            imgUrlList.add(ApiStores.API_SERVER_URL + singleImgUrl);
        }

        initImgsUI(helper, individualModel, imgUrlList);

        commentOriginList = individualModel.getComments();
        initCommentRecyclerView(helper, commentOriginList);

        int goodId = individualModel.getGoodId();
        if (goodId != 0) {
            llZanHeart.setVisibility(View.VISIBLE);
        }
    }


    private void initAvatar(ImageView ivAvatar, String avatarImgUrl) {
        loadImg(avatarImgUrl, ivAvatar);
    }

    private void initClickListener(final BaseViewHolder helper, final FriendTalkData.ListBean individuallModel) {
        ImageView ivAvatar = helper.getView(R.id.iv_avatar);
        final ImageView ivPop = helper.getView(R.id.iv_pop);
        final TextView tvDelete = helper.getView(R.id.tv_delete);

        ivAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = individuallModel.getUserId() + "";

                SP.setString(context, "otherUserId", userId);
                Intent intent = new Intent(mContext, CoreUserDetailPageActivity.class);
                intent.putExtra("userId", userId);
//                mContext.startActivity(intent);
                slideNextActivity(intent);
            }
        });

        ivPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPop(helper, individuallModel, ivPop);

                int adapterPosition = helper.getAdapterPosition();
                L.i("adapterPosition", "目前适配器的位置在" + adapterPosition);
            }
        });
    }

    private void showPop(final BaseViewHolder helper, final FriendTalkData.ListBean individuallModel, ImageView iv_temp) {
        AddPopWindow addPopWindow = new AddPopWindow((Activity) mContext, iv_temp, new AddPopWindow.ClickCallBack() {
            @Override
            public void clicked(int type) {

                String userId = SP.getString(context, "userId", "");

                if (type == 1) { // 这里是点赞
                    String spaceId = individuallModel.getSpaceId() + "";
                    HashMap map = new HashMap<>();
                    map.put("userId", userId);
                    map.put("spaceId", spaceId);
                    final RequestBody body = RequestBodyBuilder.build(map);
                    final LinearLayout llZanHeart = helper.getView(R.id.ll_zan_heart);
                    //点赞或者取消
                    if (llZanHeart.getVisibility() == View.VISIBLE) {
                        cancelZan(body, llZanHeart);
                    } else if (llZanHeart.getVisibility() == View.GONE) {
                        addZan(body, llZanHeart);
                    }
                } else if (type == 2) {// 这里是评论
                    showCommentEditText(helper, individuallModel);
                }
            }

        });
        addPopWindow.showPopupWindow(iv_temp);
    }


    private void cancelZan(RequestBody body, final LinearLayout llZanHeart) {
        apiStores.cancelZan(body).enqueue(new Callback<BaseResultModel>() {
            @Override
            public void onResponse(Call<BaseResultModel> call, Response<BaseResultModel> response) {
                llZanHeart.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {

            }
        });
    }

    private void addZan(RequestBody body, final LinearLayout llZanHeart) {
        apiStores.addZan(body).enqueue(new Callback<BaseResultModel>() {
            @Override
            public void onResponse(Call<BaseResultModel> call, Response<BaseResultModel> response) {
                llZanHeart.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {
            }
        });
    }


    /**
     * 显示发表评论的输入框
     *
     * @param helper
     */
    public void showCommentEditText(final BaseViewHolder helper, final FriendTalkData.ListBean individuallModel) {
        if (re_edittext == null || re_edittext.getVisibility() != View.VISIBLE) {

            final String userId = SP.getString(context, "userId", "");

            re_edittext = (RelativeLayout) context.findViewById(R.id.re_edittext);
            re_edittext.setVisibility(View.VISIBLE);
            et_comment = (EditText) re_edittext.findViewById(R.id.et_comment);
            et_comment.requestFocus();

            InputMethodManager manager = (InputMethodManager) et_comment.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);

            Button btn_send = (Button) re_edittext.findViewById(R.id.btn_send);
            btn_send.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String commentContent = et_comment.getText().toString().trim();
                    if (TextUtils.isEmpty(commentContent)) {
                        Toast.makeText(context, "请输入评论", Toast.LENGTH_SHORT).show();
                    } else {
                        // TODO: 2017/7/5 被回复人id的处理，仅在评论列表中的某一条被选中时才会有receiveId
                        submitComment(individuallModel, userId, individuallModel.getSpaceId(), commentContent, "");
                        et_comment.setText("");
                    }
                    hideCommentEditText();

                }

            });
        }
    }

    /**
     * 隐藏发表评论的输入框
     */
    public void hideCommentEditText() {
        if (re_edittext != null && re_edittext.getVisibility() == View.VISIBLE)
            re_edittext.setVisibility(View.GONE);
        et_comment = (EditText) re_edittext.findViewById(R.id.et_comment);
        et_comment.clearFocus();
        InputMethodManager manager = (InputMethodManager) et_comment.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(et_comment.getWindowToken(), 0);
    }


    /**
     * 提交评论
     *
     * @param talkId
     * @param commentContent
     */
    private void submitComment(final FriendTalkData.ListBean individuallModel, final String userId, final int talkId, final String commentContent, final String receiveId) {
        HashMap map = new HashMap<>();
        map.put("userId", userId);//评论人id
        map.put("spaceId", talkId);//说说id
        map.put("commentContent", commentContent);//评论内容

        if (!TextUtils.isEmpty(receiveId)) {
            map.put("receiveId", receiveId);//被回复人id
        }

        RequestBody body = RequestBodyBuilder.build(map);

        apiStores.addComment(body).enqueue(new Callback<BaseResultModel>() {
            @Override
            public void onResponse(Call<BaseResultModel> call, Response<BaseResultModel> response) {
                if (response.isSuccessful()) {
                    ifSuccess(response);
                } else {
                    T.showShort(response.message());
                }
            }

            public void ifSuccess(Response<BaseResultModel> response) {
                if (response.body().getCode() == 2) {
                    FriendTalkData.ListBean.CommentsBean commentListBean = new FriendTalkData.ListBean.CommentsBean();

                    String userId = SP.getString(context, "userId", "");
                    String myNick = SP.getString(context, "myNick", "");

                    commentListBean.setUserId(Integer.parseInt(userId));
                    commentListBean.setCommentUserNick(myNick);
                    commentListBean.setCommentContent(commentContent);


                    individuallModel.getComments().add(commentListBean);
                    notifyDataSetChanged();
                    SP.setString(context, "YouQuanCache", "");

                } else {
                    T.showShort(context, response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });

    }


    private void initCommentRecyclerView(BaseViewHolder helper, List<FriendTalkData.ListBean.CommentsBean> commentList) {
        recyclerViewComment = helper.getView(R.id.recyclerview_comments);
        commentAdapter = new CommentAdapter(R.layout.item_comment_individual, commentList);
        recyclerViewComment.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerViewComment.setAdapter(commentAdapter);
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
