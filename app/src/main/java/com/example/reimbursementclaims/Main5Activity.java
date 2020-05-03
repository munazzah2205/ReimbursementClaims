package com.example.reimbursementclaims;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main5Activity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        textView1 = findViewById(R.id.loctext);
        textView2 = findViewById(R.id.nottext);
        textView3 = findViewById(R.id.amount);
        textView1.setText(getIntent().getStringExtra("Name"));
        textView2.setText(getIntent().getStringExtra("Name1"));
        textView3.setText(getIntent().getStringExtra("Name2"));
    }

}
