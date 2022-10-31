package com.voltsoft.dev.lecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.voltsoft.dev.lecture.model.AppMember;

import java.io.Serializable;

public class EmailLoginPage extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_login);

        View loginButton = findViewById(R.id.loginButton);
        View joinButton = findViewById(R.id.joinButton);

        // ------------------------------ 구분선 ------------------------------
        // loginButton 야 누가 널 누르면 , 이렇게 행동해 알았지 ?
        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 명령어를 만들자 , EmailLoginPage 에서 MainPage 으로 이동하는 명령어 !
                Intent intent = new Intent(EmailLoginPage.this, MainPage.class);
                // 명령어를 실행해줘
                startActivity(intent);
            }
        });
        // ------------------------------ 구분선 ------------------------------

        // ------------------------------ 구분선 ------------------------------
        // joinButton 야 누가 널 누르면 , 이렇게 행동해 알았지 ?
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 명령어를 만들자 , EmailLoginPage 에서 MainPage 으로 이동하는 명령어 !
                Intent intent = new Intent(EmailLoginPage.this, MainPage.class);

                // startActivity(intent);
                // 회원 가입 화면아 ! 너가 하는일 끝나면 , 꼭 나한테 결과를 알려줘 'onActivityResult' 으로 알았지 ?
                int requestCode = 100;
                startActivityForResult(intent, requestCode);
            }
        });
        // ------------------------------ 구분선 ------------------------------
    }

    // 여기에서 해결못했던 일들 다른 액티비티에 맡기고 , 'onActivityResult' 에서 결과만 챙기세요!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) { // requestCode 가 100 인 것을 보니 .. 회원가입에서 온 결과이군

            if (resultCode == RESULT_OK) { // 결과 코드가 'RESULT_OK' 인 것을보니 .. 정상적으로 회원가입 했나보네!

                // 분명히 나한테 'member' 라는 이름으로 주기로 했으니까 .. 한번 꺼내볼까
                Serializable serializable = data.getSerializableExtra("member");

                if (serializable != null) { // 내용물을 확인해볼까 ..? 흠
                    // 오 있네 ! 다행히 내용물이 있었어
                    // Serializable 라는 포장지에 있지만 분명 AppMember 일테니 , 일단 강제로 까보자
                    AppMember appMember = (AppMember) serializable;

                    Log.d("woozie", appMember.id); // 오 다행히 로그가 잘 찍히는 것을 보니. 잘 넘어왔네. OK!
                }
            }
        }
    }
}
