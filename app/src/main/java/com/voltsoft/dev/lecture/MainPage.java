package com.voltsoft.dev.lecture;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_main1);

        TextView tabView1 = findViewById(R.id.tab1);
        TextView tabView2 = findViewById(R.id.tab2);
        TextView tabView3 = findViewById(R.id.tab3);

        Context c = MainPage.this;

        tabView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabView1.setTextColor(Color.parseColor("#ffffff"));
                tabView1.setBackground(ContextCompat.getDrawable(c, R.drawable.shape_box27));
                tabView1.setTypeface(ResourcesCompat.getFont(c, R.font.notosanscjkkr_regular));

                tabView2.setTextColor(Color.parseColor("#80ffffff"));
                tabView2.setBackground(null);
                tabView2.setTypeface(ResourcesCompat.getFont(c, R.font.notosanscjkkr_light));
                tabView3.setTextColor(Color.parseColor("#80ffffff"));
                tabView3.setBackground(null);
                tabView3.setTypeface(ResourcesCompat.getFont(c, R.font.notosanscjkkr_light));
            }
        });

        tabView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabView2.setTextColor(Color.parseColor("#ffffff"));
                tabView2.setBackground(ContextCompat.getDrawable(MainPage.this, R.drawable.shape_box27));

                tabView1.setTextColor(Color.parseColor("#80ffffff"));
                tabView1.setBackground(null);
                tabView1.setTypeface(ResourcesCompat.getFont(c, R.font.notosanscjkkr_light));
                tabView3.setTextColor(Color.parseColor("#80ffffff"));
                tabView3.setBackground(null);
                tabView3.setTypeface(ResourcesCompat.getFont(c, R.font.notosanscjkkr_light));
            }
        });

        tabView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabView3.setTextColor(Color.parseColor("#ffffff"));
                tabView3.setBackground(ContextCompat.getDrawable(MainPage.this, R.drawable.shape_box27));
                tabView1.setTextColor(Color.parseColor("#80ffffff"));
                tabView1.setBackground(null);
                tabView2.setTextColor(Color.parseColor("#80ffffff"));
                tabView2.setBackground(null);
            }
        });

        // xml 에서 scrollViewFrame 를 가져오자
        LinearLayout scrollViewFrame = findViewById(R.id.scrollViewFrame);

        // (1) for 문 배우기
        // 순차적으로 1씩 증가하면서 10번 반복
        for (int i = 0 ; i < 10 ; i++) {
           Log.d("woozie", i + "번째 반복문 입니다");
        }
        Log.d("woozie", "-------- 첫번째 반복문 종료 -------- ");

        // (2) for 문 배우기
        // 순차적으로 1씩 감소하면서 10번 반복
        for (int i = 10 ; i > 0 ; i--) {
            Log.d("woozie", i + "번째 반복문 입니다");
        }
        Log.d("woozie", "-------- 두번째 반복문 종료 -------- ");

        // (3) for 문 배우기
        // 순차적으로 2씩 증가하면서 5번 반복
        for (int i = 10 ; i > 0 ; i += 2) {
            Log.d("woozie", i + "번째 반복문 입니다");
        }
        Log.d("woozie", "-------- 세번째 반복문 종료 -------- ");

        // (4) for 문 배우기
        // (1) 에서 마지막 10번 까지 포함 시키기
        for (int i = 0 ; i <= 10 ; i++) {
            Log.d("woozie", i + "번째 반복문 입니다");
        }
        Log.d("woozie", "-------- 네번째 반복문 종료 -------- ");

        // (5) for 문 배우기
        // (2) 에서 마지막 0번 까지 포함 시키기
        for (int i = 10 ; i >= 0 ; i--) {
            Log.d("woozie", i + "번째 반복문 입니다");
        }
        Log.d("woozie", "-------- 네번째 반복문 종료 -------- ");

        // (6) for 문 배우기 + addView(단순버튼)
        for (int i = 0 ; i < 10 ; i++) {
            Button button = new Button(MainPage.this);
            scrollViewFrame.addView(button);
        }

        // (7) for 문 배우기 + addView('xml' 에서 만든 아이템 레이아웃 통째로)
        for (int i = 0 ; i < 10 ; i++) {
            // 버튼을 만들자
            ViewGroup frameLayout = (ViewGroup) LayoutInflater.from(c).inflate(R.layout.view_item_sample, null,false);

            scrollViewFrame.addView(frameLayout);
        }

        // (8) for 문 배우기 + addView('xml' 에서 만든 아이템 레이아웃 통째로) , ('xml' 에서 만든 아이템 레이아웃 통째로) 에서 이미지뷰 불러오고 썸네일 세팅하기
        for (int i = 0 ; i < 10 ; i++) {
            // 버튼을 만들자
            ViewGroup frameLayout = (ViewGroup) LayoutInflater.from(c).inflate(R.layout.view_item_sample, null,false);
            // 만든 버튼을 리니어 레이아웃에 넣어봅시다!
            ImageView thumbnailView = frameLayout.findViewById(R.id.imageView);

            Glide.with(c).load("https://voltsoftware.co.kr/cardengword/thumnail/lion"+i+".png").centerCrop().into(thumbnailView);

            scrollViewFrame.addView(frameLayout);
        }
    }
}
