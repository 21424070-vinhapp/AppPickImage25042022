package com.example.apppickimage25042022;

import android.os.CountDownTimer;

public class MyCountDownTimer {
    public static MyCountDownTimer instance;
    private CountDownTimer countDownTimer;

    private MyCountDownTimer()
    {

    }

    public static MyCountDownTimer getInstance()
    {
        if(instance==null)
        {
            instance=new MyCountDownTimer();
        }
        return instance;
    }

    public void countDown(long totalTime, long interval,OnListenerMyCountDown onListenerMyCountDown)
    {
        if(countDownTimer!=null)
        {
            countDownTimer.cancel();
            countDownTimer=null;
        }

        countDownTimer=new CountDownTimer(totalTime,interval) {
            @Override
            public void onTick(long milisUntilFinished) {
                if(milisUntilFinished>=1000)
                {
                    if(onListenerMyCountDown!=null)
                    {
                        onListenerMyCountDown.onTick(milisUntilFinished);
                    }
                }
            }

            @Override
            public void onFinish() {
                onListenerMyCountDown.onFinish();
            }
        }.start();
    }

    public void cancelTime()
    {
        if(countDownTimer!=null)
        {
            countDownTimer.cancel();
            countDownTimer=null;
        }
    }


    interface OnListenerMyCountDown{
        void onTick(long currentTime);
        void onFinish();
    }
}
