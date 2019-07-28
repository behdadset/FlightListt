package com.example.flightlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);

        Bundle bundle = getIntent().getExtras();
        int index = bundle.getInt("idx");
        Flight selectedFlight = MainActivity.flightList.get(index);

        TextView tdeparture_airport2 = (TextView) findViewById(R.id.departure_airport2);
        TextView tarrival_airport2 = (TextView) findViewById(R.id.arrival_airport2);
        TextView tdeparture_city2 = (TextView) findViewById(R.id.departure_city2);
        TextView tarrival_city2= (TextView) findViewById(R.id.arrival_city2);
        TextView tflight_number2= (TextView) findViewById(R.id.flight_number2);


        if (tdeparture_airport2 != null) {
            tdeparture_airport2.setText(selectedFlight.departure_airport);
        }

        if (tarrival_airport2 != null) {
            tarrival_airport2.setText(selectedFlight.arrival_airport);
        }

        if (tflight_number2 != null) {
            tflight_number2.setText(selectedFlight.flight_number);
        }

        if (tdeparture_city2 != null) {
            String currentString = selectedFlight.departure_city;
            String[] separated = currentString.split(",");
            tdeparture_city2.setText(separated[0]);
        }

        if (tarrival_city2 != null) {
            String currentString = selectedFlight.arrival_city;
            String[] separated = currentString.split(",");
            tarrival_city2.setText(separated[0]);        }
    }
}
