package com.zgtech.funplay.activity.moduled;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.MainActivity;
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
 * 我的举报
 * Created by Administrator on 2017/8/14.
 */

public class MyReportActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.et_report)
    EditText etReport;
    @Bind(R.id.tv_commit)
    TextView tvCommit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_report);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("我的举报");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_commit:
                String strReport = etReport.getText().toString();
                if (TextUtils.isEmpty(strReport)) {
                    T.showShort("请输入举报内容");
                } else {
                    HashMap map = new HashMap();
                    map.put("reportType", "0");
                    map.put("reportContent", strReport);
                    RequestBody body = RequestBodyBuilder.build(map);
                    mApiStores.pushReport(body).enqueue(new Callback<BaseResultModel>() {
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
                            T.showShort("举报成功!");
                            Intent intent = new Intent(MyReportActivity.this, MainActivity.class);
                            intent.putExtra("whichFragment",4);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<BaseResultModel> call, Throwable t) {

                        }
                    });
                }

                break;
        }
    }
}
