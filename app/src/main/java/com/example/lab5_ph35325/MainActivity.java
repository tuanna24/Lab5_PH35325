package com.example.lab5_ph35325;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String KEY_USERNAME = "user_name";
    public static String KEY_HOMETOWN = "home_town";
    public static String KEY_PLACE = "place";
    public static String KEY_STUDENT = "student";
    public static String BUTTON_UPDATE_CLICK = "";
    public static String KEY_SUBMIT = "";
    public static int MY_REQUEST_CODE = 10;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spn = findViewById(R.id.spinner_list);
        ArrayList<PlacesModel> arrayList = new ArrayList<>();
        arrayList.add(new PlacesModel(R.mipmap.img1, "Fpoly Hà Nội"));
        arrayList.add(new PlacesModel(R.mipmap.img2, "Fpoly Đà Nẵng"));
        arrayList.add(new PlacesModel(R.mipmap.img4, "Fpoly Tây Nguyên"));
        arrayList.add(new PlacesModel(R.mipmap.img3, "Fpoly Hồ Chí Minh"));
        arrayList.add(new PlacesModel(R.mipmap.img5, "Fpoly Cần Thơ"));

        ChoosePlaces choosePlaces = new ChoosePlaces(this, arrayList);
        spn.setAdapter(choosePlaces);

        EditText edtPlace = findViewById(R.id.edt_address);


        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                place = arrayList.get(position).getNamePlace();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EditText edtUsername = findViewById(R.id.edt_name);
        EditText edtAddress = findViewById(R.id.edt_address);

        Button btnSubmit = findViewById(R.id.btn_submit);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                place = arrayList.get(position).getNamePlace();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KEY_SUBMIT = "submit";
                String getUser = edtUsername.getText().toString();
                String getAddress = edtAddress.getText().toString();

                if (getUser.length() == 0 || getUser.trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Bạn phải nhập tên để thêm !", Toast.LENGTH_SHORT).show();
                } else if (getAddress.length() == 0 || getAddress.trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Bạn phải nhập quê quán để thêm !", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivityHome.class);
                    intent.putExtra(KEY_PLACE, place);
                    intent.putExtra(KEY_USERNAME, getUser);
                    intent.putExtra(KEY_HOMETOWN, getAddress);
                    startActivity(intent);
                }
            }
        });

        // Nhận dữ liệu khi click update
        String getPlaceUpdate = getIntent().getStringExtra("place");
        String getUserUpdate = getIntent().getStringExtra("name");
        String getAddressUpdate = getIntent().getStringExtra("home");
        edtUsername.setText(getUserUpdate);
        edtAddress.setText(getAddressUpdate);
    }
}