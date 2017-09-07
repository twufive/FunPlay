package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.T;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 注册第二页面
 * Created by Administrator on 2017/8/9.
 */

public class RegistBActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_avatar)
    ImageView ivAvatar;
    @Bind(R.id.et_nick)
    EditText etNick;
    @Bind(R.id.et_wx_user)
    EditText etWxUser;
    @Bind(R.id.et_vocation)
    EditText etVocation;
    @Bind(R.id.btn_next)
    Button btnNext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_b);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("个人资料");

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.iv_avatar, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.iv_avatar:
                break;
            case R.id.btn_next:
                toNextActivity(RegistCActivity.class);
//                doModify();
                break;
        }
    }

    private void doModify() {
        String nick = etNick.getText().toString();
        String wxUser = etWxUser.getText().toString();
        String vocation = etVocation.getText().toString();

        if (TextUtils.isEmpty(nick)) {
            T.showShort("请填写您的昵称");
        } else if (TextUtils.isEmpty(wxUser)) {
            T.showShort("请填写您的微信账号");
        } else if (TextUtils.isEmpty(vocation)) {
            T.showShort("请填写您的职业");
        } else {

            HashMap map = new HashMap();
            map.put("userRegisterProgress", "0");
            map.put("userNick", nick);
//                    map.put("userNick", nick);
            map.put("userVocation", nick);
            RequestBody body = RequestBodyBuilder.build(map);

            mApiStores.modifyPersonal(body).enqueue(new Callback<BaseResultModel>() {
                @Override
                public void onResponse(Call<BaseResultModel> call, Response<BaseResultModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode() == 2) {
                            handleServerData(response.body());
                        } else {
                            T.showShort(response.body().getMsg());
                        }
                    } else {
                        T.showShort(response.toString());
                    }
                }

                private void handleServerData(BaseResultModel model) {
                    toNextActivity(RegistCActivity.class);
                }

                @Override
                public void onFailure(Call<BaseResultModel> call, Throwable t) {
                    T.showShort(t.toString());
                }
            });
        }
    }

}
