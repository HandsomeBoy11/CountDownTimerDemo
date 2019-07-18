package com.xrd.countdowntimerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_time)
    TextView tvTime;
    private long timesTemp = 8000/*6400000*/;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CountDownTimerUtil.getInstance().doTimer(timesTemp, new CountDownTimerUtil.TimerCallBack() {
            @Override
            public void onTick(long day, long hour, long minute, long second) {
                tvTime.setText(day+":"+hour+":"+minute+":"+second);
            }

            @Override
            public void onFinish() {
                tvTime.setText("已结束");
            }
        });
    }
}
