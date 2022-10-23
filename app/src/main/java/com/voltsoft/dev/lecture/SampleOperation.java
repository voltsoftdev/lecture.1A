package com.voltsoft.dev.lecture;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SampleOperation extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_sample9);

        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        TextView resultView = findViewById(R.id.resultView);

        Button button = findViewById(R.id.confirmButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value1 = Integer.parseInt(editText1.getText().toString());
                int value2 = Integer.parseInt(editText2.getText().toString());

                String result = "";
                result += "덧셈 결과는 : " + (value1 + value2) + "\n";
                result += "뺄셈 결과는 : " + (value1 - value2) + "\n";
                result += "곱하기 결과는 : " + (value1 * value2) + "\n";
                result += "나눗셈 결과는 : " + (value1 / value2) + "\n";
                result += "덧셈 결과는 : " + (value1 + value2) + "\n";
                result += "비교 연산 결과는 : " + (value1 == value2) + "\n";

                resultView.setText(result);
            }
        });
    }
}
