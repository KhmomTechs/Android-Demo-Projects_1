package com.ourcoaching.simplemapsdirections;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText2;
    // downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        editText2=(EditText)findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPSFunction();
            }
        });
    }

    private void GPSFunction() {
        String location = editText2.getText().toString();

        if (location!=null){

            String GeoLocation="0,0?q="+location;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:"+GeoLocation));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
}
