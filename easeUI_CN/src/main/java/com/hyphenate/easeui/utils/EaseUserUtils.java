package com.hyphenate.easeui.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hyphenate.easeui.R;
import com.hyphenate.easeui.controller.EaseUI;
import com.hyphenate.easeui.controller.EaseUI.EaseUserProfileProvider;
import com.hyphenate.easeui.domain.EaseUser;

import java.util.ArrayList;
import java.util.List;

public class EaseUserUtils {

    static EaseUserProfileProvider userProvider;

    private static LayoutInflater inflater;
    private static View tempView;
    private static Context context;

    static {
        userProvider = EaseUI.getInstance().getUserProfileProvider();
    }

    /**
     * get EaseUser according username
     *
     * @param username
     * @return
     */
    public static EaseUser getUserInfo(String username) {
        if (userProvider != null)
            return userProvider.getUser(username);

        return null;
    }

    /**
     * set user avatar
     *
     * @param username
     */
    public static void setUserAvatar(Context context, String username, ImageView imageView) {
        EaseUser user = getUserInfo(username);
        if (user != null && user.getAvatar() != null) {
            try {
//                int avatarResId = Integer.parseInt(user.getAvatar());
//                Glide.with(context).load(avatarResId).into(imageView);

                String avatarUrl = user.getAvatar();
                Glide.with(context).load(avatarUrl).into(imageView);
            } catch (Exception e) {
                //use default avatar
                Glide.with(context).load(user.getAvatar()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.fx_default_useravatar).into(imageView);
            }
        } else {
            Glide.with(context).load(R.drawable.fx_default_useravatar).into(imageView);
        }
    }

    /**
     * set user's nickname
     */
    public static void setUserNick(String username, TextView textView) {
        if (textView != null) {
            EaseUser user = getUserInfo(username);
            if (user != null && user.getNickname() != null) {
                textView.setText(user.getNickname());
            } else {
                textView.setText(username);
            }
        }
    }

    /**
     * set group's nickname
     */
    public static void setGroupNick(String username, TextView textView) {
        if (textView != null) {
            EaseUser user = getUserInfo(username);
            if (user != null && user.getNickname() != null) {
                textView.setText(user.getNickname());
//                textView.setText(user.getNickname());
//                textView.setText("群聊");
            } else {
                textView.setText("群聊");
            }
        }
    }


    /**
     * set group's avatar
     *
     * @param username
     */
    public static void setGroupAvatar(Context ctx, String username, RelativeLayout groupAvatar) {
        EaseUser user = getUserInfo(username);

        context = ctx;
        inflater = LayoutInflater.from(ctx);
        ArrayList<String> avatarList = new ArrayList();

        if (user != null && user.getAvatar() != null && user.getAvatar().contains(",")) {
            String avatar = user.getAvatar();
            String[] split = avatar.split(",");

            for (int i = 0; i < split.length; i++) {
                avatarList.add(split[i]);
            }

            int size = avatarList.size();
            try {
                if (size > 9) {
                    tempView = creatAvatarView(9, avatarList);
                    groupAvatar.addView(tempView);
                } else {
                    tempView = creatAvatarView(size, avatarList);
                    groupAvatar.addView(tempView);
                }

            } catch (Exception e) {
                //use default avatar
                tempView = creatAvatarView(0, avatarList);
                groupAvatar.addView(tempView);
            }
        } else {
            tempView = creatAvatarView(0, avatarList);
            groupAvatar.addView(tempView);
        }

    }

    private static View creatAvatarView(int size, List<String> avatarList) {
        View tempView = null;
        switch (size) {
            case 0:
                tempView = inflater.inflate(R.layout.fx_group_avatar9, null, false);
                break;
            case 1:
                tempView = inflater.inflate(R.layout.fx_group_avatar1, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                break;
            case 2:
                tempView = inflater.inflate(R.layout.fx_group_avatar2, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                loadImg(avatarList.get(1), (ImageView) tempView.findViewById(R.id.iv_avatar2));

                break;
            case 3:
                tempView = inflater.inflate(R.layout.fx_group_avatar3, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                loadImg(avatarList.get(1), (ImageView) tempView.findViewById(R.id.iv_avatar2));
                loadImg(avatarList.get(2), (ImageView) tempView.findViewById(R.id.iv_avatar3));
                break;
            case 4:
                tempView = inflater.inflate(R.layout.fx_group_avatar4, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                loadImg(avatarList.get(1), (ImageView) tempView.findViewById(R.id.iv_avatar2));
                loadImg(avatarList.get(2), (ImageView) tempView.findViewById(R.id.iv_avatar3));
                loadImg(avatarList.get(3), (ImageView) tempView.findViewById(R.id.iv_avatar4));
                break;
            case 5:
                tempView = inflater.inflate(R.layout.fx_group_avatar5, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                loadImg(avatarList.get(1), (ImageView) tempView.findViewById(R.id.iv_avatar2));
                loadImg(avatarList.get(2), (ImageView) tempView.findViewById(R.id.iv_avatar3));
                loadImg(avatarList.get(3), (ImageView) tempView.findViewById(R.id.iv_avatar4));
                loadImg(avatarList.get(4), (ImageView) tempView.findViewById(R.id.iv_avatar5));
                break;
            case 6:
                tempView = inflater.inflate(R.layout.fx_group_avatar6, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                loadImg(avatarList.get(1), (ImageView) tempView.findViewById(R.id.iv_avatar2));
                loadImg(avatarList.get(2), (ImageView) tempView.findViewById(R.id.iv_avatar3));
                loadImg(avatarList.get(3), (ImageView) tempView.findViewById(R.id.iv_avatar4));
                loadImg(avatarList.get(4), (ImageView) tempView.findViewById(R.id.iv_avatar5));
                loadImg(avatarList.get(5), (ImageView) tempView.findViewById(R.id.iv_avatar6));
                break;
            case 7:
                tempView = inflater.inflate(R.layout.fx_group_avatar7, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                loadImg(avatarList.get(1), (ImageView) tempView.findViewById(R.id.iv_avatar2));
                loadImg(avatarList.get(2), (ImageView) tempView.findViewById(R.id.iv_avatar3));
                loadImg(avatarList.get(3), (ImageView) tempView.findViewById(R.id.iv_avatar4));
                loadImg(avatarList.get(4), (ImageView) tempView.findViewById(R.id.iv_avatar5));
                loadImg(avatarList.get(5), (ImageView) tempView.findViewById(R.id.iv_avatar6));
                loadImg(avatarList.get(6), (ImageView) tempView.findViewById(R.id.iv_avatar7));
                break;
            case 8:
                tempView = inflater.inflate(R.layout.fx_group_avatar8, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                loadImg(avatarList.get(1), (ImageView) tempView.findViewById(R.id.iv_avatar2));
                loadImg(avatarList.get(2), (ImageView) tempView.findViewById(R.id.iv_avatar3));
                loadImg(avatarList.get(3), (ImageView) tempView.findViewById(R.id.iv_avatar4));
                loadImg(avatarList.get(4), (ImageView) tempView.findViewById(R.id.iv_avatar5));
                loadImg(avatarList.get(5), (ImageView) tempView.findViewById(R.id.iv_avatar6));
                loadImg(avatarList.get(6), (ImageView) tempView.findViewById(R.id.iv_avatar7));
                loadImg(avatarList.get(7), (ImageView) tempView.findViewById(R.id.iv_avatar8));
                break;
            case 9:
                tempView = inflater.inflate(R.layout.fx_group_avatar9, null, false);
                loadImg(avatarList.get(0), (ImageView) tempView.findViewById(R.id.iv_avatar1));
                loadImg(avatarList.get(1), (ImageView) tempView.findViewById(R.id.iv_avatar2));
                loadImg(avatarList.get(2), (ImageView) tempView.findViewById(R.id.iv_avatar3));
                loadImg(avatarList.get(3), (ImageView) tempView.findViewById(R.id.iv_avatar4));
                loadImg(avatarList.get(4), (ImageView) tempView.findViewById(R.id.iv_avatar5));
                loadImg(avatarList.get(5), (ImageView) tempView.findViewById(R.id.iv_avatar6));
                loadImg(avatarList.get(6), (ImageView) tempView.findViewById(R.id.iv_avatar7));
                loadImg(avatarList.get(7), (ImageView) tempView.findViewById(R.id.iv_avatar8));
                loadImg(avatarList.get(8), (ImageView) tempView.findViewById(R.id.iv_avatar9));
                break;
            default:
                break;
        }

        return tempView;
    }

    private static void loadImg(String imgUrl, ImageView iv) {
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context)
                .load(imgUrl)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(iv);
    }
}
