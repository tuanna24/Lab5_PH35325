package com.example.lab5_ph35325;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChoosePlaces extends BaseAdapter {
    private Context ctx;
    private ArrayList<PlacesModel> list;

    public ChoosePlaces(Context ctx, ArrayList<PlacesModel> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =((Activity)ctx).getLayoutInflater();
        convertView = inflater.inflate(R.layout.edit_spinner,parent,false);

        ImageView img = convertView.findViewById(R.id.icon_place);
        TextView txt = convertView.findViewById(R.id.nameOfPlace);

        img.setImageResource(list.get(position).getIcPlace());
        txt.setText(list.get(position).getNamePlace());
        return convertView;
    }
}
