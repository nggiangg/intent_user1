package com.example.intent_user1;

import android.content.Intent;
import android.os.Bundle; // Import necessary classes
import android.view.View; // Import necessary classes
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Xử lý sự kiện khi nhấn nút htA
        //Kiem tra va lay gia tri da luu
        EditText A = findViewById(R.id.NhapSoA); // Tìm EditText "A" trong layout
        String savedValue = getIntent().getStringExtra("save_value");
        if(savedValue != null){
            A.setText(savedValue);
        }

        //xu ly su kien khi nhan nut clear
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A.setText("");
            }
        });
        // Thêm xử lý sự kiện cho nút "Tới trang 2"
        Button btGo = findViewById(R.id.btgo);// Tìm nút "Tới trang 2" trong layout
        btGo.setOnClickListener(new View.OnClickListener() {// Xử lý sự kiện khi bấm nút "Tới trang 2"
            @Override
            
            public void onClick(View v) {// Thực hiện chuyển đổi trang
                String A2 = A.getText().toString(); // Lấy giá trị từ EditText "A"
                // Chuyển sang SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);// Tạo Intent để chuyển sang SecondActivity
                intent.putExtra("A", A2); // Truyền giá trị "A" đến SecondActivity
                startActivity(intent); // Bắt đầu SecondActivity
            }
        });
    }
}