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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.voltsoft.dev.lecture.model.AppMember;

import java.util.regex.Pattern;

public class MemberJoinPage extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_registeration);

        // 날 실행한 명령어를 꺼내와보자 'getIntent'
        Intent intent = getIntent();
        // 명령어에 저장되어 있는 메세지 , 값을 꺼내와 보자 !
        String message = intent.getStringExtra("message"); // "안녕 회원가입 화면? 반가워"
        // intent 에 분명 'value' 라는 이름으로 숫자 값이 동봉 되어 있을거야. 없으면 0
        int number = intent.getIntExtra("value", 0);

        ScrollView scrollView = findViewById(R.id.scrollView);

        EditText editTextId = findViewById(R.id.editTextId);
        EditText editTextPassword1 = findViewById(R.id.editTextPassword1);
        EditText editTextPassword2 = findViewById(R.id.editTextPassword2);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        // editTextPhone 에 커서가 들어왔을때 , 키보드에 editTextPhone 가 가려질 수 있으니. 스크롤해서 당겨질 수 있도록
        editTextPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                // editTextPhone 에 커서가 들어왔네 !?
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

                String id = editTextId.getText().toString(); // 이메일 입력폼에서 가져온 값
                String password1 = editTextPassword1.getText().toString(); // 패스워드 입력폼1 에서 가져온 값
                String password2 = editTextPassword2.getText().toString(); // 패스워드 입력폼2 에서 가져온 값
                String phone = editTextPhone.getText().toString(); // 휴대폰 입력폼 에서 가져온 값

                idWarningView.setVisibility(View.GONE); // 일단 새로 검증해야하니까. 틀렸다고 표시했던 텍스트뷰는 다 가려주고 시작하자

                // 자 이제 검증 터널을 통과 해볼까 ?
                if (TextUtils.isEmpty(id)) { // editTextId 에서 가져온 값이 아무 것 도 없나 ?
                    Toast.makeText(MemberJoinPage.this, "아이디에 값을 입력해주세요", Toast.LENGTH_LONG).show();

                    idWarningView.setText("아이디에 값을 입력해주세요");
                    idWarningView.setVisibility(View.VISIBLE);
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(id).matches()) { // editTextId 에서 가져온 값이 이메일 양식에 맞나 ?
                    Toast.makeText(MemberJoinPage.this, "아이디에는 이메일 양식을 지켜주세요", Toast.LENGTH_LONG).show();

                    idWarningView.setText("아이디에는 이메일 양식을 지켜주세요");
                    idWarningView.setVisibility(View.VISIBLE);
                }
                else if (TextUtils.isEmpty(password1)) { // editTextPassword1 에서 가져온 값이 아무 것 도 없나 ?
                    Toast.makeText(MemberJoinPage.this, "패스워드를 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(password2)) { // editTextPassword2 에서 가져온 값이 아무 것 도 없나 ?
                    Toast.makeText(MemberJoinPage.this, "패스워드를 확인해주세요", Toast.LENGTH_LONG).show();
                }
                else if (!password1.equals(password2)) { // editTextPassword1 과 editTextPassword2 에서 가져온 값이 서로 일치 하나 ?
                    Toast.makeText(MemberJoinPage.this, "두 패스워드는 일치 해야 합니다", Toast.LENGTH_LONG).show();
                }
                else if (!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,16}$", password1)) { // editTextPassword1 의 값이 패스워드 양식에는 맞나 ?

                    Toast.makeText(MemberJoinPage.this, "패스워드 양식을 지켜주세요", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(phone))
                {
                    Toast.makeText(MemberJoinPage.this, "핸드폰에 값을 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else if (!Patterns.PHONE.matcher(id).matches())
                {
                    Toast.makeText(MemberJoinPage.this, "핸드폰 양식을 지켜주세요", Toast.LENGTH_LONG).show();
                }
                else // 위 검증을 다 통과해서 여기 까지 왔구나 ! 수고했어
                {
                    AppMember appMember = new AppMember();
                    appMember.id = id;
                    appMember.password = password1;
                    appMember.phone = phone;

                    Intent intent = getIntent();
                    intent.putExtra("member", appMember);

                    // 이메일 페이지야 많이 기다렸지 ? 여기 너가 기다렸던 데이터 'member' 이름으로 넣었어. 틀리지 말고 잘꺼내가 ~
                    setResult(RESULT_OK, intent);
                    finish(); // 그럼 난 이만
                }
            }
        });
    }
}
