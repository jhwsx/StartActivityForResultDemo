package com.example.startactivityforresultdemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import static com.example.startactivityforresultdemo.FirstActivity.REQUEST_CODE_SECOND;


/**
 * @author wangzhichao
 * @since 2019/12/17
 */
public class FirstFragment extends Fragment {

    private View btn1;
    private View btn3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn1 = view.findViewById(R.id.btn1);
        btn3 = view.findViewById(R.id.btn3);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                getActivity().startActivityForResult(intent, REQUEST_CODE_SECOND);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SECOND);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_SECOND) {
            Toast.makeText(getActivity(), "FirstFragment 收到 SecondActivity 的结果", Toast.LENGTH_SHORT).show();
        }
    }
}
