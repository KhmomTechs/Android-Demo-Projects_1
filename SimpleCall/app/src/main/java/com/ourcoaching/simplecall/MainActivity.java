package com.ourcoaching.simplecall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    // downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallFunction();
            }
        });
    }

    private void CallFunction() {
        String number=editText.getText().toString();

        if (number.length()==10){
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + number));
            startActivity(call);
        }else Toast.makeText(this,"Incorrect mobile number",Toast.LENGTH_SHORT).show();
    }
}
