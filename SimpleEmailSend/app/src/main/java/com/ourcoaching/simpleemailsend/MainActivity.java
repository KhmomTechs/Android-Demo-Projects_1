package com.ourcoaching.simpleemailsend;

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

    // downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmailFunction();
            }
        });
    }

    private void EmailFunction() {
        String Email=editText.getText().toString();
        String Message=editText2.getText().toString();

        if (Email.length()>3 && (Email.contains("@") && Email.contains("."))){
            if (Message!=null){
                Intent EmailIntent = new Intent(Intent.ACTION_SENDTO);
                EmailIntent.setData(Uri.parse("mailto:"));
                EmailIntent.putExtra(Intent.EXTRA_EMAIL, Email);
                EmailIntent.putExtra(Intent.EXTRA_SUBJECT,Message);
                if (EmailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(EmailIntent);
                }else Toast.makeText(this,"There was a problem",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Message cannot be empty",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Invalid Email ID",Toast.LENGTH_SHORT).show();
        }
    }

}
