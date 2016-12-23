package com.example.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.startactivityforresult.R.id.tv_main;

public class MainActivity extends AppCompatActivity {

    String str;
    String et;

    TextView tv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tv_main = (TextView) findViewById(R.id.tv_main);
        EditText et_main = (EditText) findViewById(R.id.et_main);

        if(savedInstanceState != null){
            et_main.setText(savedInstanceState.getString("state"));
        }

        et = et_main.getText().toString();
        findViewById(R.id.btn_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Log.d("aaa","onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        tv_main.setText(str);
        Log.d("aaa","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("aaa","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("aaa","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("aaa","onStop");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("aaa","onRestoreInstanceState");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    str = data.getStringExtra("data_return");
                    System.out.println("返回的数据："+str);

                }
                break;
            default:
        }

        Log.d("aaa","onActivityResult");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("state",et);
        Log.d("aaa","onSaveInstanceState");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("aaa","onDestroy");
    }
}
