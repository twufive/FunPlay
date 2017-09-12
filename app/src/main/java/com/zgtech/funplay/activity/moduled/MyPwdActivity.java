package com.zgtech.funplay.activity.moduled;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.MainActivity;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.SPUtils;
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
 * 修改密码
 * Created by Administrator on 2017/8/14.
 */

public class MyPwdActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.et_pwd_origin)
    EditText etPwdOrigin;
    @Bind(R.id.et_pwd_new)
    EditText etPwdNew;
    @Bind(R.id.et_pwd_new_confirm)
    EditText etPwdNewConfirm;
    @Bind(R.id.btn_save)
    Button btnSave;

    private String myMobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pwd);
        ButterKnife.bind(this);


        myMobile = SPUtils.getString(MyPwdActivity.this,"myMobile","");
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("修改密码");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.btn_save:
                String pwdOrigin = etPwdOrigin.getText().toString();
                String pwdNew = etPwdNew.getText().toString();
                String pwdNewConfirm = etPwdNew.getText().toString();

                if (!TextUtils.isEmpty(pwdOrigin) && !TextUtils.isEmpty(pwdNew) && !TextUtils.isEmpty(pwdNewConfirm)) {
                    if (pwdNew.equals(pwdNewConfirm)) {
                        doModifyPwd(pwdNew);
                    } else {
                        T.showShort("两次输入密码不一致！");
                    }
                } else {
                    T.showShort("请补全资料");
                }
                break;
        }
    }

    private void doModifyPwd(String pwdNew) {
        HashMap map = new HashMap();
        map.put("userPhone", myMobile);
        map.put("userPwd", pwdNew);
        map.put("verifyPwd", pwdNew);
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.modifyPwd(body).enqueue(new Callback<BaseResultModel>() {
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
                T.showShort("恭喜您！修改密码成功！");
                Intent intent = new Intent(MyPwdActivity.this, MainActivity.class);
                intent.putExtra("whichFragment",4);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
