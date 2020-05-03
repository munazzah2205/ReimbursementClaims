package com.example.reimbursementclaims;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class Main3Activity<editText> extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button button1;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText1 = findViewById(R.id.location);
        editText2 = findViewById(R.id.note);
        editText3 = findViewById(R.id.amt);
        button1 = findViewById(R.id.save);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = editText1.getText().toString();
                String notes = editText2.getText().toString();
                String enter = editText3.getText().toString();

                Intent intent = new Intent(Main3Activity.this, Main5Activity.class);
                intent.putExtra("Name", city);
                intent.putExtra("Name1",notes);
                intent.putExtra("Name2",enter);
                startActivity(intent);
            }
        });

        Button addreceipt = findViewById(R.id.addreceipt);
        addreceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this, Pop.class));
            }
        });
        final Spinner spinner = (Spinner) findViewById(R.id.category);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String it=(String)parent.getItemAtPosition(position);
                Toast t = Toast.makeText(getApplicationContext(),it + "Selected",Toast.LENGTH_LONG);
                //t.setGravity(Gravity.BOTTOM|Gravity.RIGHT,0,0);
                t.show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "No Selection", Toast.LENGTH_LONG).show();
            }
        });

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Main3Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }
}










