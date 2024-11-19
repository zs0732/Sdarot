package com.example.sdarot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Intent gi;
    TextView tV1 , tV2 , tV3 , tV4;
    double[] arr2 = new double[20];

    String [] arr = new String[20];
    double x1 , x2;
    boolean x3;
    ListView lV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gi = getIntent();
        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        lV = findViewById(R.id.lV);
        tV3 = findViewById(R.id.tV3);
        tV4 = findViewById(R.id.tV4);
        x1 = gi.getDoubleExtra("first" , -1);
        x2 = gi.getDoubleExtra("mult" , -1);
        x3 = gi.getBooleanExtra("seriesChoice",true);
        tV1.setText("" + x1);
        tV2.setText("" + x2);

        lV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lV.setOnItemClickListener(this);
        arrFill();

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        lV.setAdapter(adp);

    }
    public void arrFill() {
        double sum ;
        sum = x1 ;
        arr[0] = String.valueOf(x1);;
        if (x3) {
            for (int i = 1; i < arr.length; i++) {
                sum  = sum *  x2;
                arr[i]=String.valueOf(sum);
            }
        }
        else{
            for (int j = 1; j < arr.length; j++)
            {
                sum = sum + x2;
                arr[j]=String.valueOf(sum);
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
    {

        tV4.setText(" " + arr[pos]);
        tV3.setText(" " + pos);
    }


    public void prev3(View view)
    {
        finish();
    }
    }
