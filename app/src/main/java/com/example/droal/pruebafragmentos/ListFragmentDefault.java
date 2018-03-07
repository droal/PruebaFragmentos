package com.example.droal.pruebafragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by droal_ara on 5/03/18.
 */

public class ListFragmentDefault extends ListFragment implements AdapterView.OnItemClickListener{


    static ListFragmentDefault getInstance(){

        ListFragmentDefault listFragmentDefault = new ListFragmentDefault();

        return listFragmentDefault;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //get data list, in this case data resource correspond to string array form strings file
        ArrayAdapter datos = ArrayAdapter.createFromResource(getActivity(),R.array.list_countries, android.R.layout.simple_list_item_1);
        //set data to adapter, as this clas extends from ListFragmentDefault so:
        this.setListAdapter(datos);

        //Set listener to select every item
        getListView().setOnItemClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

       return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getActivity(),"Seleccionaste: "+getListView().getItemAtPosition(position).toString().trim(), Toast.LENGTH_SHORT).show();
    }
}
