package com.example.intent_user1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Liên kết với giao diện activity_second.xml
        // Laays gia tri A tu Intent
        String A2 = getIntent().getStringExtra("A");
        // Tìm nút "Quay lại trang đầu"  
        EditText kq = findViewById(R.id.kq);
        

        Button htA = findViewById(R.id.htA);
        // Xử lý sự kiện khi bấm nút "Quay lại trang đầu"
        htA.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                kq.setText(A2); // Hiển thị giá trị A2 vào EditText kq
            }
        });

        //Xu ly su kien khi nhan nut binh phuong
        Button bp = findViewById(R.id.bp);
        bp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
               int number = Integer.parseInt(A2);
               int result = number*number;
               kq.setText(String.valueOf(result));
            }
        });


        //Xu ly su kien khi nhan nut lap phuong
        Button lp = findViewById(R.id.lp);
        lp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                int number = Integer.parseInt(A2); //convert string to int
                int result = number*number*number;
                kq.setText(String.valueOf(result));
            }
        });


        //Xu ly su kien khi nhan nut quay ve trang 1
        Button btBack = findViewById(R.id.btback);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển về MainActivity
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("save_value", A2);
                startActivity(intent);
                finish(); // Kết thúc SecondActivity để không quay lại bằng nút Back
            }
        });

    }
}
