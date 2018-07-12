package com.ourcoaching.simplecalender;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private TextView textView;
    private Button button;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    // downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textview);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDatePickerDialog();
            }
        });
    }

    private void OpenDatePickerDialog() {

        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.date_dialog,null);

        datePicker=(DatePicker) view.findViewById(R.id.datePicker);

        builder=new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setTitle("Select a date");
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ExtractDate(datePicker);
            }
        });
        builder.setNegativeButton("Discard", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.cancel();
            }
        });

        alertDialog=builder.create();
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    private void ExtractDate(DatePicker datePicker) {
        String Date=datePicker.getDayOfMonth() +" / " + (datePicker.getMonth()+1) + " / " + datePicker.getYear();
        textView.setText(Date);
    }
}
