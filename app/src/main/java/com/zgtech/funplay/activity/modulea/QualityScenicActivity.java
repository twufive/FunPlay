package com.zgtech.funplay.activity.modulea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.CoreOrderDetailActivity;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.QualityScenicModel;
import com.zgtech.funplay.model.RecommendModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QualityScenicActivity extends BaseActivity {

    @Bind(R.id.rv_quality_scenic)
    RecyclerView rv;
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;

    List<QualityScenicModel.ListBean> scenicList = new ArrayList<>();
    QualityScenicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_scenic);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        llBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvToolbar.setText("精华景点");
    }

    @Override
    public void initData() {

        LinearLayoutManager linearLayoutManagerSite = new LinearLayoutManager(this);
        linearLayoutManagerSite.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManagerSite);
        adapter = new QualityScenicAdapter(R.layout.fp_item_quality_senic,scenicList);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int viewId = scenicList.get(position).getViewId();
                Intent intent = new Intent(QualityScenicActivity.this, QualityScenicDetailActivity.class);
                intent.putExtra("viewId", String.valueOf(viewId));
                startActivity(intent);
            }
        });

        HashMap<Object, Object> map = new HashMap<>();
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.getQualityScenicData(body).enqueue(new Callback<QualityScenicModel>() {
            @Override
            public void onResponse(Call<QualityScenicModel> call, Response<QualityScenicModel> response) {
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

            private void handleServerData(QualityScenicModel model) {
                List<QualityScenicModel.ListBean> list = model.getList();
                L.e("dataCount----" + list.size());
                scenicList.clear();
                scenicList.addAll(list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<QualityScenicModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
