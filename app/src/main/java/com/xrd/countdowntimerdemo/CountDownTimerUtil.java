package com.xrd.countdowntimerdemo;

import android.os.CountDownTimer;

/**
 * Created by WJ on 2019/7/18.
 */

public class CountDownTimerUtil {
    private static CountDownTimerUtil instance;
    private CountDownTimer timer;

    private CountDownTimerUtil() {
    }

    public static CountDownTimerUtil getInstance(){
        if(instance==null){
            synchronized (CountDownTimerUtil.class){
                if(instance==null){
                    instance=new CountDownTimerUtil();
                }
            }
        }
        return instance;
    }

    public void doTimer(long time, final TimerCallBack callBack){
        timer= new CountDownTimer(time,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                long day=millisUntilFinished/(1000*60*60*24);/*单位天*/
                long hour=(millisUntilFinished-day*(1000*60*60*24))/(1000*60*60);/*单位时*/
                long minute=(millisUntilFinished-day*(1000*60*60*24)-hour*(1000*60*60))/(1000*60);/*单位分*/
                long second=(millisUntilFinished-day*(1000*60*60*24)-hour*(1000*60*60)-minute*(1000*60))/(1000);/*单位秒*/
                if(callBack!=null){
                    callBack.onTick(day,hour,minute,second);
                }
            }

            @Override
            public void onFinish() {
                if(callBack!=null){
                    callBack.onFinish();
                }
            }
        };
        timer.start();
    }

    public interface TimerCallBack{
        void onTick(long day,long hour,long minute,long second);
        void onFinish();
    }
}
