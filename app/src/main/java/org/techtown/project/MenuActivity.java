package org.techtown.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MAIN = 102; // activity_main.xml로 이동하는 인텐트 요청 코드
    public static final int REQUEST_CODE_MENU2 = 103; // activity_menu.xml로 이동하는 인텐트 요청 코드

    // 각각의 프래그먼트 xml 파일 변수 선언
    Fragment_profile fragment_profile;
    Fragment_experience fragment_experience;
    Fragment_skill fragment_skill;
    Fragment_etc fragment_etc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); // xml 객체 생성

        // 각각의 프래그먼트 생성
        fragment_profile = new Fragment_profile();
        fragment_experience = new Fragment_experience();
        fragment_skill = new Fragment_skill();
        fragment_etc = new Fragment_etc();

        Button button_profile = findViewById(R.id.profile); //버튼 객체 생성
        button_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // 버튼을 눌렀을 경우 실행되는 함수 작성
                Toast.makeText(getApplicationContext(), "[PROFILE]", Toast.LENGTH_SHORT).show(); // 어떤 버튼이 눌렸는지에 따른 토스트 메세지 출력

                Fragment selected; // 프래그먼트 변수를 설정하여 어떤 프래그먼트 xml 파일이 선택되었는지 나타내는 역할을 함
                selected = fragment_profile;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit(); // selected 된 프래그먼트 xml파일을 프레임 레이아웃인 container에 중첩하여 보여주는 메소드
            }
        });

        /* 이후 버튼에 대한 설명은 button_profile 에서의 설명과 동일하므로 생략함. */
        Button button_experience = findViewById(R.id.experience);
        button_experience.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "[EXPERIENCE]", Toast.LENGTH_SHORT).show();

                Fragment selected;
                selected = fragment_experience;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }
        });

        Button button_skill = findViewById(R.id.skill);
        button_skill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "[SKILL]", Toast.LENGTH_SHORT).show();

                Fragment selected;
                selected = fragment_skill;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }
        });

        Button button_etc = findViewById(R.id.etc);
        button_etc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "[ETC]", Toast.LENGTH_SHORT).show();

                Fragment selected;
                selected = fragment_etc;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }
        });

        Button button_back_main = findViewById(R.id.back_main); // 버튼 객체 생성
        button_back_main.setOnClickListener(new View.OnClickListener() { // 버튼을 눌렀을 경우 실행되는 함수 작성
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); // 인텐트 객체 생성
                startActivityForResult(intent, REQUEST_CODE_MAIN); // 인텐트 객체와 요청 코드를 MainActivity.class에 전달
                finish(); // activity_menu.xml 객체 삭제

                Toast.makeText(getApplicationContext(), "처음 화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show(); // 토스트 메세지 출력
            }
        });
    }

    public void onChangeFragment(int index) { // 각각의 프래그먼트 java 파일에서 사용되는 함수 구현
        if (index == 0) { // index가 0일 경우에만 실행
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class); // 인텐트 객체 생성
            startActivityForResult(intent, REQUEST_CODE_MENU2); // 인텐트 객체와 요청 코드를 MenuActivity.class에 전달
            finish(); // 해당 프래그먼트 xml 객체 삭제

            Toast.makeText(getApplicationContext(), "메뉴 화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show(); // 토스트 메세지 출력
        }
    }
}