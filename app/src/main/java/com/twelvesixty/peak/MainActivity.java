package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView map = findViewById(R.id.mapView);
        dropWeather();
        dropResorts();
        dropGroups();
    }

//    public void onClick(View v) {
//        final Handler handler = new Handler();
//
//        R.id.weatherDrop.setOnClickListener(new View.OnClickListener() {
//       @Override
//       public void onClick(View v) {
//           // make textview Gone
//           R.id.weather.setVisibility(View.GONE);
//
//           // perform action
//           System.out.println("perform action");
//
//           // make textview disappear
//           handler.postDelayed(new Runnable() {
//               @Override
//               public void run() {
//                   R.id.weather.setVisibility(View.VISIBLE);
//               }
//           }, 2000);
//       }
//   });
//    }

    public void dropWeather() {
        findViewById(R.id.weatherDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // make textview visible
                findViewById(R.id.weather).setVisibility(View.GONE);

                // perform action
                System.out.println("perform action");

                // make textview disappear
                findViewById(R.id.weather).setVisibility(View.VISIBLE);
            }
        });
    }

    public void dropGroups() {
        findViewById(R.id.groupsDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                findViewById(R.id.Filters).setVisibility(View.GONE);

                System.out.println("perform action");

                findViewById(R.id.Filters).setVisibility(View.VISIBLE);
            }
        });
    }
    public void dropResorts() {
        findViewById(R.id.resortsInfoDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                findViewById(R.id.resortsInfo).setVisibility(View.GONE);

                System.out.println("perform action");

                findViewById(R.id.resortsInfo).setVisibility(View.VISIBLE);
            }
        });
    }


}
