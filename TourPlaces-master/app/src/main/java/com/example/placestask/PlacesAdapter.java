package com.example.placestask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Place> {
    Context context;
    int resource;
    ArrayList<Place> list;
    public PlacesAdapter(Context context, int resource, ArrayList<Place> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        View checkView = convertView;
        if (checkView == null) {
            checkView = LayoutInflater.from(context).inflate(resource, null, false);
        }
        TextView cat_name = checkView.findViewById(R.id.palcename);
        cat_name.setText(list.get(position).getName());
        ImageView cat_image = checkView.findViewById(R.id.placeimg);
        cat_image.setImageResource(list.get(position).getimageID());
        return checkView;
    }

}
