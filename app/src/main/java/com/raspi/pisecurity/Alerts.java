package com.raspi.pisecurity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Alerts extends AppCompatActivity {

    GridView gridView;
    List<GridViewModel> ls_data;
    GridViewAdapter adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
        }
        else{
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        }

        setContentView(R.layout.activity_alerts);

        gridView = (GridView) findViewById(R.id.gridview);
        myRef = database.getReference("users");
        ls_data = new ArrayList<>();
        pd = new ProgressDialog(Alerts.this);
        pd.setCancelable(false);
        pd.setTitle("Loading...");
        pd.show();

        myRef.child("wlQ1tt056jWznyszDGj3cNUo7GD3").child("images").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                    GridViewModel m = new GridViewModel();
                    m.setUrl(postSnapshot.getValue().toString());
                    ls_data.add(m);

                }

                adapter = new GridViewAdapter(ls_data, Alerts.this);
                gridView.setAdapter(adapter);
                pd.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
