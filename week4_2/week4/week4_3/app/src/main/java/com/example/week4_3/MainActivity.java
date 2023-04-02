package com.example.week4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtMessage;
    Button btnSend, btnCancle;
    TextView txtCount;

    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMessage = findViewById(R.id.edtMessage);
        txtCount = findViewById(R.id.txtCount);
        btnSend = findViewById(R.id.btnSend);
        btnCancle = findViewById(R.id.btnCancle);


        edtMessage.addTextChangedListener(new TextWatcher() {
            String temp = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력란에 변화가 생길 있을 시 조치
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력이 끝났을 때  조치
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //입력하기 전 조치
                txtCount.setText(editable.length()+"");

                if(editable.length() > 80)
                {
                    Toast.makeText(getApplicationContext(), "글은 80자 까지 입력 가능합니다.", Toast.LENGTH_SHORT).show();
                    edtMessage.setText(temp);
                }
                else if(editable.length() == 80) {
                    txtCount.setTextColor(Color.RED);
                }
                else {
                    temp = editable.toString();
                    txtCount.setTextColor(Color.BLUE);
                }

                content = editable.toString();

            }

        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), content+" 메시지가 전송되었습니다.", Toast.LENGTH_SHORT).show();
                edtMessage.setText("");
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}