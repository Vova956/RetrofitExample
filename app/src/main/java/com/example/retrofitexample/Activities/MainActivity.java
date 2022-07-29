package com.example.retrofitexample.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;

import com.example.retrofitexample.Adapters.PeopleAdapter;
import com.example.retrofitexample.Conections.ServerConection;
import com.example.retrofitexample.Models.Person;
import com.example.retrofitexample.Parsers.JSONPersonParser;
import com.example.retrofitexample.R;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ListView listView = findViewById(R.id.main_listView);

        ServerConection serverConection = new ServerConection();
        ArrayList<Person> peopleFromServer = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Vova", "Varga"));

        try {
            peopleFromServer = JSONPersonParser.getPeopleByServerResponse(serverConection.getConn());

            for (int i = 0; i < peopleFromServer.size(); i++) {
                people.add(peopleFromServer.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PeopleAdapter adapter = new PeopleAdapter(this, people);
        listView.setAdapter(adapter);
    }
}