package com.example.startactivityforresultdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 *
 * @author wangzhichao
 * @since 2019/12/17
 */
public class FirstFragmentActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_SECOND = 1;

    public static void start(Context context) {
        Intent starter = new Intent(context, FirstFragmentActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_fragment_first);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstFragmentActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SECOND);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_SECOND) {
            Toast.makeText(this, "FirstFragmentActivity 收到 SecondActivity 的结果", Toast.LENGTH_SHORT).show();
        }
    }
}
