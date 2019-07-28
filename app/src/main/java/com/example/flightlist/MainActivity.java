package com.example.flightlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

    public static ArrayList<Flight> flightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView1 = (ListView) findViewById(R.id.listView1);


        //Gson library
        PostResponseAsyncTask task = new PostResponseAsyncTask(this);

        //Download Json
        task.execute("https://bit.ly/2MBaibj");
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, FlightActivity.class);
                intent.putExtra("idx", i);
                startActivity(intent);
            }
        });

    }

    @Override
    public void processFinish(String result) {
        ListView listView1 = (ListView) findViewById(R.id.listView1);
        //Trying to convert the date format
//        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
//        JsonConverter<Flight> jsonConverter = new JsonConverter<Flight>(){
//            DateFormat = "yyyy-mm-ddT:HH:mm:ss.sss";
//        }
//        jsonConverter.d
//        gsonConverter =new GsonBuilder().setDateFormat("yyyy-mm-ddT:HH:mm:ss.sss").create();

        flightList = new JsonConverter<Flight>().toArrayList(result, Flight.class);
        ArrayList<String> titles = new ArrayList<String>();

        for (Flight value:flightList){
            titles.add(value.departure_city);
        }

        //Custom adapter for listview
        FlightListAdapter adapter = new FlightListAdapter(this, R.layout.layout_listitem, flightList);
        listView1.setAdapter(adapter);

    }
}


