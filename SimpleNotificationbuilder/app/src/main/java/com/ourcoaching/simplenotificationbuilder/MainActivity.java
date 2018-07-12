package com.ourcoaching.simplenotificationbuilder;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    // Downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
    }


    @Override
    protected void onResume() {
        super.onResume();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Create_Notification(view);
            }
        });
    }

    public void Create_Notification(View view){
        builder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        // Set ID for the notification
        int mNotificationId = 001;
        // Get an instance of the NotificationManager service
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Build the notification and issues it.
        notificationManager.notify(mNotificationId, builder.build());
    }
}
