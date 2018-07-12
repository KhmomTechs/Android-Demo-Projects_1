package com.ourcoaching.simplesharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button SaveButton,ShowButton;
    private TextView textView;
    private EditText editText;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String Data_key="High score";
    // Downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textview);
        SaveButton=(Button)findViewById(R.id.button);
        ShowButton=(Button)findViewById(R.id.button2);
        editText=(EditText)findViewById(R.id.editText);

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveData();
            }
        });

        ShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowData();
            }
        });
    }

    private void SaveData(){
        sharedPreferences=getApplicationContext().getSharedPreferences(Data_key,Context.MODE_PRIVATE);

        String valuetoSave=editText.getText().toString();

        editor = sharedPreferences.edit();
        editor.putString(Data_key, valuetoSave);
        editor.commit();

    }

    private void ShowData(){

        sharedPreferences=getApplication().getSharedPreferences(Data_key, Context.MODE_PRIVATE);
        String read_data=sharedPreferences.getString(Data_key,"NO DATA");
        textView.setText(read_data);
    }
}

