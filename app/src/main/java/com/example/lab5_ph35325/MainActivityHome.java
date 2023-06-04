package com.example.lab5_ph35325;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivityHome extends AppCompatActivity {


    public static ArrayList<Student> arrayList = new ArrayList<>();
    ListStudentAdapter listStudentAdapter;
    ArrayList<Student> arrayListOld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = findViewById(R.id.listview_student);
        String getPlace = getIntent().getStringExtra(MainActivity.KEY_PLACE);
        String getUser = getIntent().getStringExtra(MainActivity.KEY_USERNAME);
        String getAddress = getIntent().getStringExtra(MainActivity.KEY_HOMETOWN);
        Student student = new Student(getPlace, getUser, getAddress);
        if (MainActivity.KEY_SUBMIT.equals("submit")) {
            arrayList.add(student);
        }


        listStudentAdapter = new ListStudentAdapter(this, arrayList, arrayListOld);
        listView.setAdapter(listStudentAdapter);

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getNameStd() == null || arrayList.get(i).getHometown() == null) {
                arrayList.remove(i);

            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);


        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.add_person) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}