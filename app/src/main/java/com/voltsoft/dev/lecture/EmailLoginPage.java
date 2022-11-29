package com.voltsoft.dev.lecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.voltsoft.dev.lecture.model.AppMember;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

public class EmailLoginPage extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_login);

        EditText idForm = findViewById(R.id.idInsertForm);
        EditText passwordForm = findViewById(R.id.passwordInsertForm);

        View loginButton = findViewById(R.id.loginButton);
        View joinButton = findViewById(R.id.joinButton);

        // ------------------------------ 구분선 ------------------------------
        // loginButton 야 누가 널 누르면 , 이렇게 행동해 알았지 ?
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idForm.getText().toString();
                String password = passwordForm.getText().toString();

                login(id, password);
            }
        });
        // ------------------------------ 구분선 ------------------------------

        // ------------------------------ 구분선 ------------------------------
        // joinButton 야 누가 널 누르면 , 이렇게 행동해 알았지 ?
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 명령어를 만들자 , EmailLoginPage 에서 MainPage 으로 이동하는 명령어 !
                Intent intent = new Intent(EmailLoginPage.this, MemberJoinPage.class);

                intent.putExtra("message", "안녕 회원가입 화면? 반가워");
                intent.putExtra("value", 100);

                // 명령어를 실행해줘
                // startActivity(intent);
                startActivityForResult(intent, 200);
            }
        });
        // ------------------------------ 구분선 ------------------------------
    }

    // 여기에서 해결못했던 일들 다른 액티비티에 맡기고 , 'onActivityResult' 에서 결과만 챙기세요!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200) { // requestCode 가 200 인 것을 보니 .. 회원가입에서 온 결과이군

            if (resultCode == RESULT_OK) { // 결과 코드가 'RESULT_OK' 인 것을보니 .. 정상적으로 회원가입 했나보네!

                // data 에 분명 'number' 라는 이름으로 숫자 값이 동봉 되어 있을거야. 없으면 -1 이라고 하지 뭐
                // int resultValue = data.getIntExtra("number", -1);
                // data 에 분명 'text' 라는 이름으로 숫자 값이 동봉 되어 있을거야.
                // String message = data.getStringExtra("text");

                // data 에 분명 'member' 라는 이름으로 'Serializable' 이 동봉 되어 있을거야.
                Serializable serializable = data.getSerializableExtra("member");

                AppMember appMember = (AppMember) serializable;

                Intent intent = new Intent(EmailLoginPage.this, MainPage.class);
                intent.putExtra("member", appMember);
                startActivity(intent);
            }
        }
    }

    private void login(String id, String password) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String result = connection(id, password);

                try
                {
                    Gson gson = new Gson();
                    AppMember appMember = gson.fromJson(result, AppMember.class);

                    if (!TextUtils.isEmpty(appMember.id)) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(EmailLoginPage.this, "로그인에 성공 하였습니다", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(EmailLoginPage.this, MainPage.class);
                                intent.putExtra("member", appMember);
                                startActivity(intent);
                            }
                        });
                    }
                    else
                    {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(EmailLoginPage.this, "로그인에 실패하였습니다", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(EmailLoginPage.this, "로그인에 실패하였습니다", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        thread.start();
    }

    public String connection(String id, String password) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://voltsoftware.co.kr/edu/sampleLoginMember?");
        stringBuilder.append("id=").append(id);
        stringBuilder.append("&password=").append(password);

        try {
            URL url = new URL(stringBuilder.toString());
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
