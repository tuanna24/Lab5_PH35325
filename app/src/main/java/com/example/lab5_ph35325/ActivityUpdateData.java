package com.example.lab5_ph35325;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class ActivityUpdateData extends AppCompatActivity {

    Student student;
    Button btnConfirm, btnCancel;
    EditText name, hometown;
    String getPlace;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        Spinner spinner = findViewById(R.id.spinner_update);

        ArrayList<PlacesModel> arrayList = new ArrayList<>();
        arrayList.add(new PlacesModel(R.mipmap.img1, "Fpoly Hà Nội"));
        arrayList.add(new PlacesModel(R.mipmap.img2, "Fpoly Đà Nẵng"));
        arrayList.add(new PlacesModel(R.mipmap.img4, "Fpoly Tây Nguyên"));
        arrayList.add(new PlacesModel(R.mipmap.img3, "Fpoly Hồ Chí Minh"));
        arrayList.add(new PlacesModel(R.mipmap.img5, "Fpoly Cần Thơ"));

        ChoosePlaces choosePlaces = new ChoosePlaces(this, arrayList);
        spinner.setAdapter(choosePlaces);

        name = findViewById(R.id.edt_nameUpdate);
        hometown = findViewById(R.id.edt_addressNew);

        position = getIntent().getIntExtra("vitri", 0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getPlace = arrayList.get(position).getNamePlace();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Student student1 = MainActivityHome.arrayList.get(position);


        name.setText(student1.getNameStd());
        hometown.setText(student1.getHometown());
        btnConfirm = findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(new ConfirmClick());

        btnCancel=findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new CancelClick());

        String place = getIntent().getStringExtra("place");
        spinner.setSelection(getIndex(spinner,place));

    }
    class CancelClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            finish();
        }
    }

    class ConfirmClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Student student1 = new Student(getPlace, name.getText().toString(), hometown.getText().toString());
            MainActivityHome.arrayList.set(position, student1);
            Intent intent = new Intent(getApplicationContext(), MainActivityHome.class);
            startActivity(intent);
        }
    }



    //private method of your class
    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }

        return 0;
    }

}