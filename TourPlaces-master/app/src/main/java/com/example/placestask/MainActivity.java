package com.example.placestask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Place> placeList = new ArrayList<Place>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView placesListView = findViewById(R.id.placesListView);
        placeList.add(new Place("Omboudou's Home" , R.drawable.omboudou_home));
//        placeList.add(new Place("Ambele's Home" , R.drawable.ambele_home));
        placeList.add(new Place("Faculty of Engineering" , R.drawable.faculty_eng));
        placeList.add(new Place("Staff's Housing" , R.drawable.esteraha));

        PlacesAdapter adapter = new PlacesAdapter(this,R.layout.place_icon, placeList);
        placesListView.setAdapter(adapter);

        //Clicking actions :
        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int placeIndex, long l) {
                if (placeIndex == 0){
                    Intent choice = new Intent(MainActivity.this, OmboudouActivity.class);
                    startActivity(choice);
                }
                else if (placeIndex == 10){
//                    Intent choice = new Intent(MainActivity.this, AmbeleActivity.class);
//                    startActivity(choice);
                }
                else if (placeIndex == 1){
                    Intent choice = new Intent(MainActivity.this, FacultyEngActivity.class);
                    startActivity(choice);
                }
                else if (placeIndex == 2){
                    Intent choice = new Intent(MainActivity.this, EsterahaActivity.class);
                    startActivity(choice);
                }
            }
        });
    }
}