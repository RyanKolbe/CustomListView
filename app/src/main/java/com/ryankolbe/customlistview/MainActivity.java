package com.ryankolbe.customlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.lv_country_list);
        final ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(new Country(R.drawable.south_africa, "South Africa"));
        countryList.add(new Country(R.drawable.south_korea, "South Korea"));
        countryList.add(new Country(R.drawable.sri_lanka, "Sri Lanka"));
        countryList.add(new Country(R.drawable.swaziland, "Swaziland"));
        countryList.add(new Country(R.drawable.switzerland, "Switzerland"));
        countryList.add(new Country(R.drawable.united_kingdom, "United Kingdom"));
        countryList.add(new Country(R.drawable.united_states, "United States"));
        countryList.add(new Country(R.drawable.uruguay, "Uruguay"));
        countryList.add(new Country(R.drawable.yemen, "Yemen"));

        CountryAdapter countryAdapter = new CountryAdapter(this, countryList);
        listView.setAdapter(countryAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You clicked on: " +
                        countryList.get(i).getCountryName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}