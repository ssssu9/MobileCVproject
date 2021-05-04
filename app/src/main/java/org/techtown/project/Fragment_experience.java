package org.techtown.project;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment_experience extends Fragment {

    MenuActivity menuActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        menuActivity = (MenuActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        menuActivity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_experience, container, false);

        final ScrollView scrollView = (ScrollView)rootview.findViewById(R.id.scrollView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(scrollView.FOCUS_UP);
            }
        });

        Button button_back = (Button)rootview.findViewById(R.id.back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuActivity.onChangeFragment(0);
            }
        });

        return rootview;
    }
}