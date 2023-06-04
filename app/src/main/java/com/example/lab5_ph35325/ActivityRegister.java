package com.example.lab5_ph35325;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {
    public static String KEY_USERNAME_DK ="user";
    public static String KEY_PASSWORD_DK="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText edtUserDK = findViewById(R.id.edt_usernamdangky);
        EditText edtPassWordDK = findViewById(R.id.edt_passworddangky);
        EditText edtPassWordAgain = findViewById(R.id.edt_passwordagain);


        Button btnDk = findViewById(R.id.btn_dangkyConfirm);
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUserDK = edtUserDK.getText().toString();
                String getPass = edtPassWordDK.getText().toString();
                String getPassAgain = edtPassWordAgain.getText().toString();

                if (getUserDK.length() == 0 || getUserDK.trim().equals("")){
                    Toast.makeText(getApplicationContext(), "Bạn phải nhâp tên !", Toast.LENGTH_SHORT).show();
                }else if(getPass.length() == 0 || getPass.trim().equals("")){
                    Toast.makeText(getApplicationContext(), "Bạn phải nhâp mật khẩu", Toast.LENGTH_SHORT).show();
                }else if(getPassAgain.length() == 0 || getPassAgain.trim().equals("") ){
                    Toast.makeText(getApplicationContext(), "Bạn phải xác nhận lại mật khẩu", Toast.LENGTH_SHORT).show();
                }else if ( !getPassAgain.equals(getPass)){
                    Toast.makeText(getApplicationContext(), "Mật khẩu xác nhận chưa đúng", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_USERNAME_DK,getUserDK);
                    bundle.putString(KEY_PASSWORD_DK,getPass);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}