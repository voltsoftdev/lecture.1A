package com.voltsoft.dev.lecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MemberJoinPage extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_registeration);

        ScrollView scrollView = findViewById(R.id.scrollView);

        EditText editTextId = findViewById(R.id.editTextId);
        EditText editTextPassword1 = findViewById(R.id.editTextPassword1);
        EditText editTextPassword2 = findViewById(R.id.editTextPassword2);
        EditText editTextPhone = findViewById(R.id.editTextPhone);

        editTextPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    scrollView.scrollTo(0, (int) (editTextPhone.getY() + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60f,getResources().getDisplayMetrics())));
                }
            }
        });
        TextView idWarningView = findViewById(R.id.idWarningView);

        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                String password1 = editTextPassword1.getText().toString();
                String password2 = editTextPassword2.getText().toString();
                String phone = editTextPhone.getText().toString();

                if (TextUtils.isEmpty(id)) {
                    Toast.makeText(MemberJoinPage.this, "아이디에 값을 입력해주세요", Toast.LENGTH_LONG).show();

                    idWarningView.setText("아이디에 값을 입력해주세요");
                    idWarningView.setVisibility(View.VISIBLE);
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(id).matches()) {
                    Toast.makeText(MemberJoinPage.this, "아이디에는 이메일 양식을 지켜주세요", Toast.LENGTH_LONG).show();

                    idWarningView.setText("아이디에는 이메일 양식을 지켜주세요");
                    idWarningView.setVisibility(View.VISIBLE);
                }
                else if (TextUtils.isEmpty(password1)) {
                    Toast.makeText(MemberJoinPage.this, "패스워드를 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(password2)) {
                    Toast.makeText(MemberJoinPage.this, "패스워드를 확인해주세요", Toast.LENGTH_LONG).show();
                }
                else if (!password1.equals(password2)) {
                    Toast.makeText(MemberJoinPage.this, "두 패스워드는 일치 해야 합니다", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(MemberJoinPage.this, "핸드폰에 값을 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else if (!Patterns.PHONE.matcher(id).matches()) {
                    Toast.makeText(MemberJoinPage.this, "핸드폰 양식을 지켜주세요", Toast.LENGTH_LONG).show();
                }
                else
                {
                    // Toast.makeText(RegistrationActivity.this, "회원가입 성공", Toast.LENGTH_LONG).show();

                    Intent intent = getIntent();
                    intent.putExtra("number", 100);
                    intent.putExtra("text", "회원가입 성공!");

                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
