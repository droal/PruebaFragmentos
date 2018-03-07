package com.example.droal.pruebafragmentos;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by droal_ara on 6/03/18.
 */

public class ListActivity extends AppCompatActivity implements ListFragmentCustom.ListCustomInterface{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_layout);

        if(savedInstanceState == null){
            if(getIntent().getBooleanExtra("list_item_custom", false)){

                if(ListCountriesPOJO.listCountryPOJOS.size() == 0){
                    ListCountriesPOJO.createData(this);
                }

                ListFragmentCustom listFragmentCustom = ListFragmentCustom.getInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.list_fragment_cont, listFragmentCustom, "list_fragment").commit();

               // ListDetailFragment listDetailFragment = ListDetailFragment.getInsance(0);
               // getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_cont, listDetailFragment,"detail_fragment").commit();

            }
            else{

                ListFragmentDefault listFragmentDefault = ListFragmentDefault.getInstance();
                getSupportFragmentManager().beginTransaction().add(R.id.list_fragment_cont, listFragmentDefault, "list_fragment").commit();

            }
        }
    }

    @Override
    public void itmeSelectecIs(int positionItem) {

        String url = ListCountriesPOJO.listCountryPOJOS.get(positionItem).getWikiUrl();

        ListDetailFragment detailFragment = ListDetailFragment.getInsance(url);

        getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_cont, detailFragment,"detail_fragment").commit();
    }
}
