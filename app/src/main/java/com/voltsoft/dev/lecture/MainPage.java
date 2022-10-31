package com.voltsoft.dev.lecture;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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
    }
}
