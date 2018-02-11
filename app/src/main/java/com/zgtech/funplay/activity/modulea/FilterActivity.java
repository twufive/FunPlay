package com.zgtech.funplay.activity.modulea;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.view.RangeSeekBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 筛选 页面
 * Created by Administrator on 2017/8/8.
 */

public class FilterActivity extends BaseActivity {
    @Bind(R.id.rsb_age)
    RangeSeekBar rsbAge;
//    @Bind(R.id.rsb_price)
//    RangeSeekBar rsbPrice;
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.tv_age_range)
    TextView tvAgeRange;
//    @Bind(R.id.tv_range_price)
//    TextView tvRangePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ButterKnife.bind(this);

        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.VISIBLE);
        tvToolbar.setText("筛选");
        tvRight.setText("确定");

        rsbAge.setRules(18, 70, 1, 1);
//        rsbPrice.setRules(50, 1000, 1, 1);

        rsbAge.setValue(18, 22);
//        rsbPrice.setValue(50, 160);


        rsbAge.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max) {
                L.i("min", "" + min);
                L.i("max", "" + max);

                tvAgeRange.setText(Integer.valueOf((int) min) + "~" + Integer.valueOf((int) max));
            }
        });

//        rsbPrice.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
//            @Override
//            public void onRangeChanged(RangeSeekBar view, float min, float max) {
//                L.i("min", "" + min);
//                L.i("max", "" + max);

//                tvRangePrice.setText(min + "~" + max);
//                tvRangePrice.setText(Integer.valueOf((int) min) + "~" + Integer.valueOf((int) max));
//            }
//        });
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_right:
                break;
            default:
        }
    }
}
