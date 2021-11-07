package com.example.intentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pendingIntent,activity,site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pendingIntent=findViewById(R.id.pendingIntentButton);
        activity=findViewById(R.id.openSecActButton);
        site=findViewById(R.id.openSiteButton);

        pendingIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();

            }
        });
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("text","Hello world");
                startActivity(intent);


            }
        });
        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Nataliia15?tab=repositories"));
                 startActivity(intent);
            }
        });

    }

public void sendNotification(){
        Intent intent=new Intent(this,SecondActivity.class);
    PendingIntent pendingIntent=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
    Notification builder=new NotificationCompat.Builder(this,App.CHANNEL_1)
            .setSmallIcon(R.drawable.ic_attention)
            .setContentTitle("Title")
            .setContentText("This is text of notification")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build();
    NotificationManagerCompat manager= NotificationManagerCompat.from(this);
    manager.notify(1,builder);



}

}