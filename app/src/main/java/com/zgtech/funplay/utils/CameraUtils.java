package com.zgtech.funplay.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;
import com.zgtech.funplay.global.GlideImageLoader;

import java.util.ArrayList;

import static com.zgtech.funplay.FunPlayApplication.mContext;

/**
 * 拍照或者从相册中选择，抽象出来的工具类
 * Created by Administrator on 2017/7/10.
 */

public class CameraUtils {
    private static final String TAG = "Gallery";
    private static final int REQUEST_CODE = 100;
    private static GalleryConfig galleryConfig;
    private static ArrayList<String> path = new ArrayList<>();//照片存放路径
    private static ArrayList<String> originPhotoList = new ArrayList<>();

    public static void initGalleryConfig(IHandlerCallBack iHandlerCallBack) {
        int existSize = originPhotoList.size();
        int maxSize = 9 - existSize;
        //开启相册
        galleryConfig = new GalleryConfig.Builder()
                .imageLoader(new GlideImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider("com.zgtech.yiyong.fileprovider")   // provider (必填)
                .pathList(path)
                .multiSelect(true)                      // 是否多选   默认：false
                .multiSelect(true, maxSize)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                .maxSize(maxSize)                             // 配置多选时 的多选数量。    默认：9
                .crop(false)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                .crop(false, 1, 1, 500, 500)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                .isShowCamera(false)                     // 是否现实相机按钮  默认：false
                .filePath("/Gallery")// 图片存放路径
                .build();
    }

    public static void initGalleryConfig(IHandlerCallBack iHandlerCallBack,ArrayList<String> originPhotoList) {
        int existSize = originPhotoList.size();
        int maxSize = 9 - existSize;
        //开启相册
        galleryConfig = new GalleryConfig.Builder()
                .imageLoader(new GlideImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider("com.zgtech.yiyong.fileprovider")   // provider (必填)
                .pathList(path)
                .multiSelect(true)                      // 是否多选   默认：false
                .multiSelect(true, maxSize)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                .maxSize(maxSize)                             // 配置多选时 的多选数量。    默认：9
                .crop(false)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                .crop(false, 1, 1, 500, 500)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                .isShowCamera(false)                     // 是否现实相机按钮  默认：false
                .filePath("/Gallery")// 图片存放路径
                .build();
    }

    // 授权管理
    public static void initPermissions(Activity ctx) {
        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(ctx, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.i(TAG, "拒绝过了");
                Toast.makeText(mContext, "请在 设置-应用管理 中开启此应用的储存授权。", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(ctx, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
                T.showShort(ctx,"您已授权，请重新拍照或选择相册");
            }
        } else {
            Log.i(TAG, "不需要授权 ");
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(ctx);
        }
    }

}
