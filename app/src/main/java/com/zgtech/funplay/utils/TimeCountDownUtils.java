package com.zgtech.funplay.utils;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

/**
 * 验证码重新获取的倒计时工具
 * Create by zayin on 2016/04/21
 * TIME 11:39
 */
public class TimeCountDownUtils extends CountDownTimer {

    public Button btn;
    public TextView tv;

    public TimeCountDownUtils(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public TimeCountDownUtils(long millisInFuture, long countDownInterval, Button btn) {
        super(millisInFuture, countDownInterval);
        this.btn = btn;
    }

    public TimeCountDownUtils(long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.tv = tv;
    }

    @Override
    public void onFinish() {
        if (tv != null) {
            tv.setClickable(true);
            tv.setText("获取验证码");
        } else {
            btn.setClickable(true);
            btn.setText("获取验证码");
        }
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (tv != null) {
            tv.setClickable(true);
            tv.setText("(" + millisUntilFinished / 1000 + ")" + "秒");
        } else {
            btn.setClickable(true);
            btn.setText("(" + millisUntilFinished / 1000 + ")" + "秒");
        }

    }
}
