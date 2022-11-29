package com.voltsoft.dev.lecture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.voltsoft.dev.lecture.model.Animal;
import com.voltsoft.dev.lecture.model.AppMember;
import com.voltsoft.dev.lecture.model.DaySelection;
import com.voltsoft.dev.lecture.model.Lion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainPage extends AppCompatActivity
{
    private DaySelectionAdapter daySelectionAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_main2);

        TextView idView = findViewById(R.id.memberIdView);
        TextView passwordView = findViewById(R.id.memberPasswordView);
        TextView phoneView = findViewById(R.id.memberPhoneView);

        AppMember appMember = (AppMember) getIntent().getSerializableExtra("member");

        idView.setText("아이디는: " + appMember.id);
        passwordView.setText("패스워드: " + appMember.password);
        phoneView.setText("핸드폰번호: " + appMember.phone);

        TextView tabView1 = findViewById(R.id.tab1);
        TextView tabView2 = findViewById(R.id.tab2);
        TextView tabView3 = findViewById(R.id.tab3);

        Button settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

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

                selectList(100400);
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

                selectList(100500);
            }
        });

        tabView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabView3.setTextColor(Color.parseColor("#ffffff"));
                tabView3.setBackground(ContextCompat.getDrawable(MainPage.this, R.drawable.shape_box27));

                tabView1.setTextColor(Color.parseColor("#80ffffff"));
                tabView1.setBackground(null);
                tabView1.setTypeface(ResourcesCompat.getFont(c, R.font.notosanscjkkr_light));
                tabView2.setTextColor(Color.parseColor("#80ffffff"));
                tabView2.setBackground(null);
                tabView2.setTypeface(ResourcesCompat.getFont(c, R.font.notosanscjkkr_light));

                selectList(100600);
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
        for (int i = 0 ; i <= 10 ; i += 2) {
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
            ViewGroup frameLayout = (ViewGroup) LayoutInflater.from(c).inflate(R.layout.view_item_friend, null,false);

            scrollViewFrame.addView(frameLayout);
        }

        // (8) for 문 배우기 + addView('xml' 에서 만든 아이템 레이아웃 통째로) , ('xml' 에서 만든 아이템 레이아웃 통째로) 에서 이미지뷰 불러오고 썸네일 세팅하기
        for (int i = 0 ; i < 10 ; i++) {
            // 버튼을 만들자
            ViewGroup frameLayout = (ViewGroup) LayoutInflater.from(c).inflate(R.layout.view_item_friend, null,false);
            // 만든 버튼을 리니어 레이아웃에 넣어봅시다!
            ImageView thumbnailView = frameLayout.findViewById(R.id.imageView);

            Glide.with(c).load("https://voltsoftware.co.kr/cardengword/thumnail/lion"+i+".png").centerCrop().into(thumbnailView);

            scrollViewFrame.addView(frameLayout);
        }

        // ================================================================================
        // 6주차. 리싸이클러뷰 배우기 과정
        // (1) 리싸이클러뷰를 가져오기
        RecyclerView recyclerView = findViewById(R.id.sampleListView);
        // (2) 리싸이클러뷰에 필요한 '레이아웃매니저' 생성해서 '리싸이클러뷰' 에 넣는다
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); // 방향은 수직으로 , 수평은 'HORIZONTAL'
        recyclerView.setLayoutManager(layoutManager);
        // LinearLayoutManager 은 리싸이클러뷰를 화면에 노출하고 난 이후에 , 우리가 필요할 수 있는 API를 제공하는 똑똑한 녀석
        // 예: 화면에 보이는 첫번쨰 아이템뷰 포지션 가져오기 , N번째에 해당하는 아이템뷰 가져오기 (이를 통해 가져온 특정 아이템뷰만 우리가 수정할 수 있음)

        // (3) 리싸이클러뷰에 필요한 '어댑터'를 생성해서 '리싸이클러뷰' 에 넣는다
        daySelectionAdapter = new DaySelectionAdapter(this);
        recyclerView.setAdapter(daySelectionAdapter);
        // 어댑터에는 우리가 스크롤뷰에서 했던 'inflate' 와 'findViewById' 그리고 데이터를 뷰에 넣어줬던 일을 하게 된다
        selectList(100400);
    }

    public void selectList(int examCode) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("https://voltsoftware.co.kr/edu/v2/memberDaySelections?");
                stringBuilder.append("ExamCode=").append(examCode);
                stringBuilder.append("&WordKind=1");
                String result = connection(stringBuilder.toString());

                try
                {
                    JSONObject jsonObject = new JSONObject(result);

                    JSONArray jsonArray = jsonObject.getJSONArray("DaySelections");

                    Gson gson = new Gson();

                    ArrayList<DaySelection> itemList = new ArrayList<>();

                    for (int i = 0 ; i < jsonArray.length(); i ++) {
                        JSONObject itemJson = jsonArray.getJSONObject(i);

                        DaySelection daySelection = gson.fromJson(itemJson.toString(), DaySelection.class);
                        itemList.add(daySelection);
                    }

                    runOnUiThread(new Runnable() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void run() {
                            daySelectionAdapter.itemList = itemList;
                            daySelectionAdapter.notifyDataSetChanged();
                        }
                    });
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public String connection(String urlStr) {

        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(10000);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            InputStream is = conn.getInputStream();
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String result;
            while ((result = br.readLine()) != null) {
                sb.append(result + '\n');
            }
            result = sb.toString();

            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
