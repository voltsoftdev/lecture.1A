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
        loginButton.setOnClickListener(new View.OnClickListener() {
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
            }
        }
    }
}
