package com.example.auseg.navigationcompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button toggle;
    private Button toggleHeadsUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle = findViewById(R.id.toggle);
        toggleHeadsUp = findViewById(R.id.headsUp);

        Intent intent = new Intent(MainActivity.this, EmptyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0 , intent, 0);

        Intent intent2 = new Intent(MainActivity.this, EmptyActivity2.class);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(getApplicationContext(), 0, intent2, 0);

        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        final NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(this);
        mBuilder
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("EMERGENCY: MISSILE INBOUND")
//                .setContentText("Our sensors have detected an incoming missile. Seek shelter immediately. This is NOT  a drill.")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Our sensors have detected an incoming missile. Seek shelter immediately. This is NOT  a drill."))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        mBuilder2
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("EMERGENCY: MISSILE INBOUND")
//                .setContentText("Our sensors have detected an incoming missile. Seek shelter immediately. This is NOT  a drill.")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Our sensors have detected an incoming missile. Seek shelter immediately. This is NOT  a drill."))
                .setContentIntent(pendingIntent2)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_MAX);






        toggle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                notificationManager.notify(1, mBuilder.build());
            }
        });


        toggleHeadsUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                notificationManager.notify(1, mBuilder2.build());
            }
        });



    }


}
