package org.techtown.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;


public class Fragment_profile extends Fragment {

    MenuActivity menuActivity; // MenuActivity 타입의 변수 선언

    @Override
    public void onAttach(Context context) { // 프래그먼트가 처음으로 액티비티에 중첩될 때 호출되는 함수
        super.onAttach(context);
        menuActivity = (MenuActivity)getActivity(); // menuActivity 변수를 통해 프래그먼트가 MenuActivity에 중첩될 것임을 나타냄
    }

    @Override
    public void onDetach() { // 프래그먼트와 액티비티의 연결이 끊길 때 호출되는 함수
        super.onDetach();
        menuActivity = null; // menuActivity가 가리키는 프래그먼트가 null임을 나타냄
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_profile, container, false); // 인플레이터 객체 rootView를 ViewGroup에 추가

        final ScrollView scrollView = (ScrollView)rootview.findViewById(R.id.scrollView); // 스크롤뷰 객체 생성
        scrollView.post(new Runnable() { // 스크롤뷰가 실행될 경우 수행되는 함수
            @Override
            public void run() {
                scrollView.fullScroll(scrollView.FOCUS_UP); // 스크롤뷰의 포커스를 제일 위쪽으로 맞춤
            }
        });

        Button button_back = (Button)rootview.findViewById(R.id.back); // 버튼 객체 생성
        button_back.setOnClickListener(new View.OnClickListener() { // 버튼을 눌렀을 경우 실행되는 함수 작성
            @Override
            public void onClick(View view) {
                menuActivity.onChangeFragment(0); // menuActivity로 파라미터 0을 넘겨주어 MenuActivity의 onChangeFragment 함수를 호출한다.
            }
        });

        return rootview; // 인플레이터 반환
    }
}