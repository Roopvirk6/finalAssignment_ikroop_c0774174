package com.example.finalassignment_ikroop_c0774174;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listOfFavtPlaces extends AppCompatActivity {


    DBofFavrtPlaces mDatabase;
    List<ClassOfPlaces> listPlace;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_favt_places);
        listView = findViewById(R.id.favrt_places);
        listPlace = new ArrayList<>();
        mDatabase = new DBofFavrtPlaces(this);
        loadPlaces();


        PlacesAdaptor placesAdaptor = new PlacesAdaptor(this,R.layout.list_layout_favrtplaces,listPlace,mDatabase);
        listView.setAdapter(placesAdaptor);



    }


    private void loadPlaces(){

        Cursor cursor = mDatabase.getAllPlaces();
        if(cursor.moveToFirst()){

            do{


                listPlace.add(new ClassOfPlaces(cursor.getString(0),cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3),cursor.getDouble(4)
                ));

            }while (cursor.moveToNext());

            cursor.close();
        }


        // Custom Adaptor
//        PlacesAdaptor placesAdaptor = new PlacesAdaptor(this,R.layout.list_layout_favrtplaces,listPlace,mDatabase);
//        listView.setAdapter(placesAdaptor);

    }
}