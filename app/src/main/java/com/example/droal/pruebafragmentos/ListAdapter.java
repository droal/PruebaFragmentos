package com.example.droal.pruebafragmentos;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by droal_ara on 7/03/18.
 */

public class ListAdapter extends BaseAdapter {

    private List<ListCountriesPOJO> listCountryPOJOS;
    private Context context;

    public ListAdapter (List<ListCountriesPOJO> listCountryPOJOS, Context context){
        this.listCountryPOJOS = listCountryPOJOS;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCountryPOJOS.size();
    }

    @Override
    public Object getItem(int position) {
        return listCountryPOJOS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listCountryPOJOS.indexOf(getItem(position));
    }

    private class AdapterViewHolder{
        TextView nameTexView;
        TextView capitalTextView;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        AdapterViewHolder adapterViewHolder = null;
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        ListCountriesPOJO country = listCountryPOJOS.get(position);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.fragment_list_item, null);

            adapterViewHolder = new AdapterViewHolder();
            adapterViewHolder.nameTexView = (TextView) convertView.findViewById(R.id.item_list_name_country_tv);
            adapterViewHolder.capitalTextView = (TextView)convertView.findViewById(R.id.item_list_capital_tv);

            convertView.setTag(adapterViewHolder);
        }
        else{
            adapterViewHolder = (AdapterViewHolder)convertView.getTag();
        }

        adapterViewHolder.nameTexView.setText(country.getName());
        adapterViewHolder.capitalTextView.setText(country.getCapital());

        return convertView;
    }
}
