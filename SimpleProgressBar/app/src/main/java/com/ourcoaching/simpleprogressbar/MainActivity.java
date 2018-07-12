package com.ourcoaching.simpleprogressbar;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private SeekBar seekBar;
    private TextView textView;
    // Downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        textView=(TextView)findViewById(R.id.textview);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();

        progressBar.setMax(30);
        seekBar.setMax(30);
//        seekBar.setMin(1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(i+"");
                progressBar.setProgress(i);
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
