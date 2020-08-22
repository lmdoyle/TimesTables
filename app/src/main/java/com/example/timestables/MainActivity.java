package com.example.timestables;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;


    public void generateTimesTable(int timesTableAmount){
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int i = 1; i <=10; i++){
            numbers.add(i*timesTableAmount);
        }

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,numbers);

        listView.setAdapter(arrayAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        SeekBar slider = (SeekBar)findViewById(R.id.slider);


        slider.setMax(20);


        listView = (ListView)findViewById(R.id.listView);




        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int timesTables = progress;

            generateTimesTable(timesTables);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





    }
}