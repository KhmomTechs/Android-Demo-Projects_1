package com.ourcoaching.simplebuttonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button Button_1,Button_2;
    private String text1="I Clicked first button";
    private String text2="I Clicked second button";
    private String text3="I clicked textview";

    // downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        Button_1=(Button)findViewById(R.id.button);
        Button_2=(Button)findViewById(R.id.button2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast();
            }
        });

        Button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeText(text1);
            }
        });

        Button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeText(text2);
            }
        });

    }

    private void ShowToast() {
        Toast.makeText(this,text3,Toast.LENGTH_SHORT).show();
    }


    private void ChangeText(String Newtext) {
        textView.setText(Newtext);
    }

}
