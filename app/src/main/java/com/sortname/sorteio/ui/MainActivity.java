package com.sortname.sorteio.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.sortname.sorteio.R;
import com.sortname.sorteio.ui.PrimarySemesterActivity;
import com.sortname.sorteio.ui.SecondarySemesterActivity;

public class MainActivity extends AppCompatActivity {

    private RadioButton primaryRadio, secondaryRadio;
    private Button btChanged;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primaryRadio    = findViewById(R.id.primarySemester);
        secondaryRadio  = findViewById(R.id.secondarySemester);
        btChanged       = findViewById(R.id.bt_changed);
        btChanged.setOnClickListener(view -> {
            if(primaryRadio.isChecked()){
                selectPrimraySemester();
            }else if(secondaryRadio.isChecked()){
                selectSecondarySemester();
            }
            startVibrate();
        });
    }
    private void selectPrimraySemester (){
        Intent intent = new Intent(getApplicationContext(), PrimarySemesterActivity.class);
        startActivity(intent);
       // finish();
    }
    private void selectSecondarySemester(){
        startActivity(new Intent(this, SecondarySemesterActivity.class));
       // finish();
    }
    public void startVibrate() {
        long pattern[] = { 0, 100, 200 };
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(pattern, -1);
    }

}