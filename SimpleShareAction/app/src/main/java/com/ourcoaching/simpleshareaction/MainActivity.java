package com.ourcoaching.simpleshareaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String Website_url="www.ourcoaching.com";
    private Button button;
    // downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareWebPage();
            }
        });
    }

    private void ShareWebPage() {
        Intent share=new Intent(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_TEXT,Website_url);
        share.setType("text/plain");
        startActivity(share);
    }
}
