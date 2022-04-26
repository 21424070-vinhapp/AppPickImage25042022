package com.example.apppickimage25042022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    TextView mTvPoint;
    ImageView mImgRandom, mImgPick;
    String[] mArrNameImage;
    int mResourceIdRandom;
    Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        randomImage();
    }

    private void init()
    {
        mProgressBar=findViewById(R.id.progressBarTime);
        mTvPoint=findViewById(R.id.textViewPoint);
        mImgRandom=findViewById(R.id.imgRandom);
        mImgPick=findViewById(R.id.imgPick);

        //random bat ky
        mRandom=new Random();
    }

    private void randomImage()
    {
        mArrNameImage=getResources().getStringArray(R.array.arr_image);

        int index=mRandom.nextInt(mArrNameImage.length);
        mResourceIdRandom=getResources().getIdentifier(mArrNameImage[index],"drawable",getPackageName());
        mImgRandom.setImageResource(mResourceIdRandom);
    }

}