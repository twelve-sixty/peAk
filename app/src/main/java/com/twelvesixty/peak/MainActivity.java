package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

    public void dropWeather() {
        findViewById(R.id.weatherDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.weather);

                if (textView.getVisibility() == View.VISIBLE) {
                    // make textview disappear
                    textView.setVisibility(View.GONE);
                } else {
                    // make textview visible
                    findViewById(R.id.Filters).setVisibility(View.GONE);
                    findViewById(R.id.resortsInfo).setVisibility(View.GONE);
                   textView.setVisibility(View.VISIBLE);

                }
            }
        });
    }

    public void dropGroups() {
        findViewById(R.id.groupsDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (findViewById(R.id.Filters).getVisibility() == View.VISIBLE){
                    Log.i("testing", "tests");
                    findViewById(R.id.Filters).setVisibility(View.GONE);
                }else{
                    findViewById(R.id.weather).setVisibility(View.GONE);
                    findViewById(R.id.resortsInfo).setVisibility(View.GONE);
                    findViewById(R.id.Filters).setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void dropResorts() {
        findViewById(R.id.resortsInfoDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView2 = findViewById(R.id.resortsInfo);

                if (textView2.getVisibility() == View.VISIBLE) {
                    textView2.setVisibility(View.GONE);
                }else {
                    findViewById(R.id.weather).setVisibility(View.GONE);
                    findViewById(R.id.Filters).setVisibility(View.GONE);
                    textView2.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
