package com.example.flightlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightListAdapter extends ArrayAdapter<Flight> {

    private int resourceLayout;
    private Context mContext;

    public FlightListAdapter(Context context, int resource, List<Flight> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }
    private Date stringToDate(String str) {
        //Trying to convert the date format

//        try {
//            DateTimeFormatter format = new DateTimeFormatter("yyyy-MM-dd");//2019-11-15T08:44:00.000
//
//            Date date = format.parse(str);
//            return date;
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }

        return Calendar.getInstance().getTime();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Flight p = getItem(position);

        if (p != null) {
            TextView tflight_name = (TextView) v.findViewById(R.id.flight_name);
            TextView tdeparture_city = (TextView) v.findViewById(R.id.departure_city);
            TextView tarrival_city = (TextView) v.findViewById(R.id.arrival_city);
            TextView tdeparture_date = (TextView) v.findViewById(R.id.departure_date);
            TextView tdeparture_airport = (TextView) v.findViewById(R.id.departure_airport);
            TextView tarrival_airport = (TextView) v.findViewById(R.id.arrival_airport);
            TextView tscheduled_duration = (TextView) v.findViewById(R.id.scheduled_duration);
            TextView tarrival_date = (TextView) v.findViewById(R.id.arrival_date);
            TextView tStops = (TextView) v.findViewById(R.id.Stops);

            if (tflight_name != null) {
                String currentString = p.departure_city;
                String[] separated = currentString.split(",");
                tflight_name.setText("Flight to "+separated[0]);

            }

            if (tarrival_city != null) {
                String currentString = p.arrival_city;
                String[] separated = currentString.split(",");
                tarrival_city.setText(separated[0]);
            }

            if (tscheduled_duration != null) {
                tscheduled_duration.setText(p.scheduled_duration);
            }

            if (tarrival_airport != null) {
                tarrival_airport.setText(p.arrival_airport);
            }

            if (tdeparture_airport != null) {
                tdeparture_airport.setText(p.departure_airport);
            }

            if (tdeparture_date != null) {
                //Trying to split the date as a String
//                String currentString = p.departure_date;
//                String[] separated = currentString.split("T"); //2019-12-02T21:20:00.000
//                String[] separated2 = separated[1].split(":");
//                tdeparture_date.setText(separated2[0]+":"+separated2[1]);
                Date date = stringToDate(p.departure_date);
                DateFormat dateFormat = new SimpleDateFormat("hh:mm");
                String strDate = dateFormat.format(date);
                tdeparture_date.setText(strDate);
            }

            if (tarrival_date != null) {
                Date date = stringToDate(p.arrival_date);
                DateFormat dateFormat = new SimpleDateFormat("hh:mm");
                String strDate = dateFormat.format(date);
                tarrival_date.setText(strDate);
            }

            if (tarrival_city != null) {
                String currentString = p.arrival_city;
                String[] separated = currentString.split(",");
                tarrival_city.setText(separated[0]);
            }

            if (tdeparture_city != null) {
                String currentString = p.departure_city;
                String[] separated = currentString.split(",");
                tdeparture_city.setText(separated[0]);
            }

            tStops.setText("Non-Stop");

        }

        return v;
    }

}