package org.techtown.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101; // 인텐트 요청 코드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml 객체 생성

        Button button_check = findViewById(R.id.check); // 버튼 객체 생성
        button_check.setOnClickListener(new View.OnClickListener() { // 버튼을 눌렀을 경우 실행되는 함수 구현
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class); // 인텐트 객체 생성
                startActivityForResult(intent, REQUEST_CODE_MENU); // 인텐트 객체와 요청 코드를 MenuActvitiy.class에 전달
                finish(); // activity_main.xml 객체 삭제

                Toast.makeText(getApplicationContext(), "Moblie CV를 불러옵니다.", Toast.LENGTH_SHORT).show(); // 토스트 메세지 출력
            }
        });
    }
}