package com.example.apppickimage25042022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity2 extends AppCompatActivity {
    TableLayout mTableLayout;
    String[] mArrNameImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTableLayout=findViewById(R.id.tableLayout);

        mArrNameImage=getResources().getStringArray(R.array.arr_image);
        //so cot: 3
        //so dong: 6

        DisplayMetrics displayMetrics=new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width=displayMetrics.widthPixels;

        for(int i=0;i<=6;i++)
        {
            TableRow tableRow=new TableRow(this);
            for(int y=0;y<=3;y++)
            {
                TableRow.LayoutParams layoutParams=new TableRow.LayoutParams(width/3, width/3);
                ImageView imageView=new ImageView(this);
                imageView.setImageResource(R.drawable.bocanhcung);
                layoutParams.gravity= Gravity.CENTER;
                imageView.setLayoutParams(layoutParams);
                tableRow.addView(imageView);
            }

            mTableLayout.addView(tableRow);
        }
    }
}