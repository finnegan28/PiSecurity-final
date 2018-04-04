package com.raspi.pisecurity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class camView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_view);
    }


    public void PlayVideo(View v) {
        final VideoView videoView = findViewById(R.id.videoView);

        String movieurl = "rtsp://192.168.1.233:8554/h264";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movieurl));
        startActivity(intent);
    }


/*
    public void CamConnect() {
        Button connect = (Button) findViewById(R.id.connectbtn);
        connect.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String link = "http://192.168.1.233/stream.php";
                        new updateData().execute(link);
                        Toast.makeText(camView.this, "Executed", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/

}
