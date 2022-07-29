package com.example.retrofitexample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.retrofitexample.Models.Person;
import com.example.retrofitexample.R;

import java.util.ArrayList;

public class PeopleAdapter extends BaseAdapter {

    private ArrayList<Person> people;
    private LayoutInflater inflater;

    public PeopleAdapter(Context context, ArrayList<Person> people){
        this.people = people;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int position) {
        return people.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.item, parent, false);
        }

        Person person = (Person) getItem(position);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(person.getName());
        TextView surname = (TextView) view.findViewById(R.id.surname);
        surname.setText(person.getSurname());

        return view;
    }
}
