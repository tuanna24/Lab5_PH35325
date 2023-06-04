package com.example.lab5_ph35325;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edtUserName = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);
        Button btnDangNhap = findViewById(R.id.btn_dangnhap);
        Button btnDangKy = findViewById(R.id.btn_dangky);

        String getUserDk = getIntent().getStringExtra(ActivityRegister.KEY_USERNAME_DK);
        String getPassDk = getIntent().getStringExtra(ActivityRegister.KEY_PASSWORD_DK);

        edtUserName.setText(getUserDk);
        edtPassword.setText(getPassDk);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean u = edtUserName.getText().toString().equals(getUserDk);
                boolean p = edtPassword.getText().toString().equals(getPassDk);
                if (edtUserName.getText().length()==0 && edtPassword.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "Bạn phải nhập tài khoản và mật khẩu để đăng nhập", Toast.LENGTH_SHORT).show();
                }else if (u && p) {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivityHome.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityRegister.class);
                startActivity(intent);
            }
        });

    }
}