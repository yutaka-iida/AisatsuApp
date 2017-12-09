package com.example.iiday.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView m_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 追加
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        m_textview = (TextView)findViewById(R.id.textview);
    }

    @Override
    public void onClick(View v){
        showTimePickerDialog();
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                    aisatu(hourOfDay, minute);
                }}, 0, 0, true);
        timePickerDialog.show();
    }

    private void aisatu(int hourOfDay, int minute){
        if(2 <= hourOfDay && hourOfDay <= 9){
            m_textview.setText("おはよう");
        }
        else if(10 <= hourOfDay && hourOfDay <= 17){
            m_textview.setText("こんにちは");
        }
        else {
            m_textview.setText("こんばんは");
        }
    }
}
