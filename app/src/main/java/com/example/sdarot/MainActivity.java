package com.example.sdarot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sdarot.MainActivity2;
import com.example.sdarot.R;

public class MainActivity extends AppCompatActivity {
    Switch Switch1;
    EditText editTND, editTextNumber;
    Button btn;


    double firstNum, multNum;
    String str1 , str2;
    boolean isCheck;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch1 = findViewById(R.id.switch1);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTND = findViewById(R.id.editTND);
        btn = findViewById(R.id.btn);
    }

    public void next(View view) {
        str1 = editTND.getText().toString();
        if (checkNum(str1)) {
            firstNum = Integer.parseInt(str1);

            str2 = editTextNumber.getText().toString();
            if (checkNum(str2)) {
                multNum = Integer.parseInt(str2);

                isCheck = Switch1.isChecked();

                Toast.makeText(this, "great", Toast.LENGTH_SHORT).show();
                Intent gi = new Intent(this, MainActivity2.class);
                gi.putExtra("first", firstNum);
                gi.putExtra("mult", multNum);
                gi.putExtra("seriesChoice", !isCheck);
                startActivity(gi);
            } else Toast.makeText(this, "Invalid number!", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(this, "Invalid number!", Toast.LENGTH_SHORT).show();
    }

    public boolean checkNum(String x) {
        if (x.equals(".") || x.equals("-")) return false;
        return true;

    }
}