package com.raspi.pisecurity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;


public class MainActivity extends AppCompatActivity {

    private Button openStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Common.currentToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("MY TOKEN ", Common.currentToken);

        setContentView(R.layout.activity_main);

        openStream = (Button)findViewById(R.id.viewcambtn);
        openStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, camView.class);
                startActivity(i);
            }
        });
    }

}