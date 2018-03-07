package com.example.droal.pruebafragmentos;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by droal_ara on 7/03/18.
 */

public class ListCountriesPOJO {

    private String name;
    private String capital;
    private String wikiUrl;

    public static ArrayList<ListCountriesPOJO> listCountryPOJOS = new ArrayList<>();

    private ListCountriesPOJO(String name, String capital, String wikiUrl){
        this.name = name;
        this.capital = capital;
        this.wikiUrl = wikiUrl;
    }

    public static void createData(Activity activity){

        String[] countries = activity.getResources().getStringArray(R.array.list_countries);
        String[] capitals = activity.getResources().getStringArray(R.array.list_capitals);
        String[] urls = activity.getResources().getStringArray(R.array.list_wiki_urls);

        for (int i = 0; i<countries.length; i++) {
            listCountryPOJOS.add(new ListCountriesPOJO(countries[i],capitals[i], urls[i]));
        }
        int a = 0;
        a++;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }
}
