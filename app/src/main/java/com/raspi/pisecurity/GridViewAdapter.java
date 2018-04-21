package com.raspi.pisecurity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.List;



public class GridViewAdapter extends BaseAdapter {
    List<GridViewModel> m;
    Context c;
    LayoutInflater inflter;

    public GridViewAdapter(List<GridViewModel> m, Context c)
    {
        this.m=m;
        this.c=c;

        inflter = (LayoutInflater.from(c));
    }

    @Override
    public int getCount() {
        return m.size();
    }

    @Override
    public Object getItem(int i) {
        return m.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.row, null);


        ImageView image = (ImageView) view.findViewById(R.id.image);
        Glide.with(c).load(m.get(i).getUrl()).into(image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("url", m.get(i).getUrl());

                Intent intent = new Intent(c, Image.class);
                intent.putExtra("url", m.get(i).getUrl());
                c.startActivity(intent);

            }
        });

        return view;
    }
}
