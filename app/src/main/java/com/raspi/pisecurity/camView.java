package com.raspi.pisecurity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class camView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_view);
    }


    public void PlayVideo(View v) {
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);


        //add controls to a MediaPlayer like play, pause.
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

        //Set the path of Video or URI
        videoView.setVideoURI(Uri.parse("rtsp://192.168.1.233:8554/h264"));
        //

        //Set the focus
        videoView.requestFocus();

        videoView.start();
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
