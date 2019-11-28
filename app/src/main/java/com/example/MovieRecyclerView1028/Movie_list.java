package com.example.MovieRecyclerView1028;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Movie_list extends AppCompatActivity {
    Bundle get_bag;
    TextView m_name,m_date,m_plot;
    ImageView m_img;
    Button btn,btn1;
    String id_ticket = "ticket";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        btn = findViewById(R.id.button);
        btn1 = findViewById(R.id.button1);
        m_name = findViewById(R.id.name);
        m_date = findViewById(R.id.date);
        m_plot = findViewById(R.id.plot);
        m_img = findViewById(R.id.img);

        get_bag = getIntent().getExtras();
        int i =get_bag.getInt("img");
        m_img.setImageResource(i);
        String n = get_bag.getString("name");
        m_name.setText(n);
        String d = get_bag.getString("date");
        m_date.setText(d);
        String p = get_bag.getString("plot");
        m_plot.setText(p);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Movie_list.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通知設定
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationChannel channelTicket = new NotificationChannel(
                        id_ticket,
                        "movie_ticket",
                        NotificationManager.IMPORTANCE_HIGH);
                        channelTicket.setDescription("電影購票系統");
                        channelTicket.enableLights(true);
                        channelTicket.enableVibration(true);
                //依設定建立通知
                notificationManager.createNotificationChannel(channelTicket);
                //第一個訊息
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Movie_list.this, id_ticket)
                        .setSmallIcon(R.mipmap.ticket)
                        .setContentTitle("電影購票系統通知：")
                        .setContentText("您已購票成功!!")
                        .setAutoCancel(true);

                //啟動通知
                notificationManager.notify(0,builder.build());
            }
        });
    }
}
