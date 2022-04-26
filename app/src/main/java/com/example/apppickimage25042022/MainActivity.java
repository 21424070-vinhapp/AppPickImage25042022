package com.example.apppickimage25042022;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    TextView mTvPoint;
    ImageView mImgRandom, mImgPick;
    String[] mArrNameImage;
    int mResourceIdRandom;
    Random mRandom;
    MyCountDownTimer mMyCountDown;
    int mTotalTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        event();

    }

    private void event() {
        //Listener
        mMyCountDown.getInstance().countDown(mTotalTime, 1000, new MyCountDownTimer.OnListenerMyCountDown() {
            @Override
            public void onTick(long currentTime) {
                //Toast.makeText(MainActivity.this, currentTime+ "", Toast.LENGTH_SHORT).show();
                //Log.d("BBB", currentTime+"");
                mProgressBar.setProgress((int) currentTime/1000);
            }

            @Override
            public void onFinish() {
                //Log.d("BBB", "onFinish");
                mProgressBar.setProgress(0);
            }
        });
        //handle
        randomImage();

        mImgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                activityResultLauncher.launch(intent);
            }
        });
    }

    private void init()
    {
        mProgressBar=findViewById(R.id.progressBarTime);
        mTvPoint=findViewById(R.id.textViewPoint);
        mImgRandom=findViewById(R.id.imgRandom);
        mImgPick=findViewById(R.id.imgPick);

        //random bat ky
        mRandom=new Random();

        mTotalTime=5000;

        //set MAX progress
        mProgressBar.setMax(mTotalTime/1000);
        mProgressBar.setProgress(mTotalTime/1000);
    }

    private void randomImage()
    {
        mArrNameImage=getResources().getStringArray(R.array.arr_image);
        int index=mRandom.nextInt(mArrNameImage.length);
        mResourceIdRandom=getResources().getIdentifier(mArrNameImage[index],"drawable",getPackageName());
        mImgRandom.setImageResource(mResourceIdRandom);
    }

    //get date from activity
    private ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                }
            });

}