package com.zgtech.funplay.activity.tabcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.NewsModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnnouncementActivity extends BaseActivity {

    @Bind(R.id.rv_news)
    RecyclerView rv;
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;

    List<NewsModel.ListBean> newsList = new ArrayList<>();
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
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
        tvToolbar.setText("系统公告");
    }

    @Override
    public void initData() {

        LinearLayoutManager linearLayoutManagerSite = new LinearLayoutManager(this);
        linearLayoutManagerSite.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManagerSite);
        adapter = new NewsAdapter(R.layout.fp_item_news, newsList);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int viewId = newsList.get(position).getNewsId();
                Intent intent = new Intent(AnnouncementActivity.this, NewsDetailActivity.class);
                intent.putExtra("newsId", String.valueOf(viewId));
                startActivity(intent);
            }
        });

        HashMap<Object, Object> map = new HashMap<>();
        map.put("row",5);
        map.put("page",0);
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.getNewsData(body).enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
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

            private void handleServerData(NewsModel model) {
                List<NewsModel.ListBean> list = model.getList();
                L.e("dataCount----" + list.size());
                newsList.clear();
                newsList.addAll(list);
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
