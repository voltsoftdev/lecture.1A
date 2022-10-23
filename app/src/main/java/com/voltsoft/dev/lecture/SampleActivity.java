package com.voltsoft.dev.lecture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_sample7);

        View helloWorldView = findViewById(R.id.helloWorldView);
        // helloWorldView.setBackground(ContextCompat.getDrawable());
        // helloWorldView.setBackground(ContextCompat.getColor());
        // helloWorldView.setBackgroundColor(Color.parseColor("#ffffff"));

        Button memberLoginButton = findViewById(R.id.loginButton);
        memberLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SampleActivity.this, "로그인 !", Toast.LENGTH_LONG).show();
            }
        });

        Button memberJoinButton = findViewById(R.id.memberJoinButton);
        memberJoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(IntroActivity.this, RegistrationActivity.class);
//                startActivityForResult(intent, 0);

                Intent intent = new Intent(SampleActivity.this, SampleOperation.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int number = data.getIntExtra("number", 0);
        String text = data.getStringExtra("text");

        Toast.makeText(SampleActivity.this, "숫자는:" + number + " 문자는 : " + text, Toast.LENGTH_LONG).show();
    }
}
