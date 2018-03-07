package com.example.droal.pruebafragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by droal_ara on 5/03/18.
 */

public class ListFragmentCustom extends ListFragment {

    ListCustomInterface listCustomInterface;
    private ListAdapter listAdapter;

    public interface ListCustomInterface{
        //Metod of callback
        void itmeSelectecIs(int positionItem);
    };


    static ListFragmentCustom getInstance(){
        ListFragmentCustom listFragmentCustom = new ListFragmentCustom();
       return listFragmentCustom;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<ListCountriesPOJO> listCountryPOJOS =  ListCountriesPOJO.listCountryPOJOS;

       listAdapter = new ListAdapter(listCountryPOJOS, this.getContext());
       setListAdapter(listAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listCustomInterface = (ListCustomInterface) context;

        }catch(ClassCastException e){

        }
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        TextView tv = (TextView)v.findViewById(R.id.item_list_name_country_tv);


        Toast.makeText(getActivity(),"Seleccionaste: "+tv.getText().toString().trim(), Toast.LENGTH_SHORT).show();

        if(listCustomInterface != null){
            listCustomInterface.itmeSelectecIs(position);
        }

    }


}
