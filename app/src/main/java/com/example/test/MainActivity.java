package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.util.OKHttpUtil;

public class MainActivity extends AppCompatActivity {
    private EditText name_et;
    private EditText password_et;
    private Button submitBtn;

    private OKHttpUtil okHttpUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHttpUtil = new OKHttpUtil();
        name_et = findViewById(R.id.name);
        password_et = findViewById(R.id.password);
        submitBtn = findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                get请求
//                okHttpUtil.getDatasync();
//                okHttpUtil.getDataAsync();

//                post请求
                String name = name_et.getText().toString();
                String password = password_et.getText().toString();
                System.out.println(name+password);
//                okHttpUtil.postSync(name,password);
                String jsonStr = "{\"name\":\""+name+"\",\"password\":\""+password+"\"}";
                okHttpUtil.postAsyn(jsonStr);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        okHttpUtil.getDatasync();
//                        okHttpUtil.getDataAsync();
//                    }
//                }).start();
            }
        });
    }
}