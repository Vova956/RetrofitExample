package com.example.retrofitexample.Parsers;

import com.example.retrofitexample.Models.Person;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class JSONPersonParser {
    public static ArrayList<Person> getPeopleByServerResponse(String str) throws JSONException {
        ArrayList<Person> people = new ArrayList<Person>();

        JSONArray array = new JSONArray(str);
        for(int i=0; i < array.length(); i++)
        {
            JSONObject object = array.getJSONObject(i);
            people.add(new Person(object.getString("name"), object.getString("surname")));
        }

        return people;
    }
}
