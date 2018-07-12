package com.ourcoaching.simplesms;

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
    private EditText editText,editText2;
    // Downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        editText2=(EditText)findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMSFunction();
            }
        });
    }

    private void SMSFunction() {
        String number=editText.getText().toString();
        String textSMS=editText2.getText().toString();
        if (number.length()==10){
            if (textSMS!=null){

                Uri sms_uri = Uri.parse("smsto:"+number);
                Intent sms_intent = new Intent(Intent.ACTION_SENDTO);
                sms_intent.setData(sms_uri);
                sms_intent.putExtra("sms_body", textSMS);

                if (sms_intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sms_intent);
                }else Toast.makeText(this,"There was a problem",Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(this,"Text Empty",Toast.LENGTH_SHORT).show();
            }
        }else Toast.makeText(this,"Incorrect mobile number",Toast.LENGTH_SHORT).show();
    }
}
