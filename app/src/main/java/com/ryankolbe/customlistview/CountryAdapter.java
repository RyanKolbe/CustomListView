package com.ryankolbe.customlistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    private Context mContext;
    private List<Country> countryList;

    @SuppressLint("SupportAnnotationUsage")
    public CountryAdapter(@NonNull Context context, @LayoutRes ArrayList<Country> list) {
        super(context, 0, list);
        mContext = context;
        countryList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View custom_list_view = convertView;
        if (custom_list_view == null)
            custom_list_view = LayoutInflater.from(mContext).inflate(R.layout.custom_list_view, parent, false);

        Country currentCountry = countryList.get(position);

        ImageView image = (ImageView) custom_list_view.findViewById(R.id.imageView_country);
        image.setImageResource(currentCountry.getImageDrawable());

        TextView name = (TextView) custom_list_view.findViewById(R.id.textView_name);
        name.setText(currentCountry.getCountryName());

        return custom_list_view;

    }
}