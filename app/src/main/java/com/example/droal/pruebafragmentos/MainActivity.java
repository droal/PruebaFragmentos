package com.example.droal.pruebafragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        int group = item.getGroupId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int itemId = item.getItemId();
        int groupId = item.getGroupId();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (groupId){
            case R.id.group_dialog_fragm:

                Fragment prevfragment = fragmentManager.findFragmentByTag("dialog_frag");

                if(prevfragment != null){
                    fragmentTransaction.remove(prevfragment);
                }

                int dialogType = 0;
                switch (itemId){
                    case R.id.df_type1:
                        showDialog(1,fragmentManager);
                        break;
                    case R.id.df_type2:
                        showDialog(2,fragmentManager);
                        break;
                    case R.id.df_type3:
                        showDialog(3,fragmentManager);
                        break;
                    case R.id.df_type4:
                        showDialog(4,fragmentManager);
                        break;
                    case R.id.df_type5:
                        showDialog(5,fragmentManager);
                        break;
                    case R.id.df_type6:
                        showDialog(6,fragmentManager);
                        break;
                    case R.id.df_type7:
                        showDialog(7,fragmentManager);
                        break;
                    case R.id.df_type8:
                        showDialog(8,fragmentManager);
                        break;
                    case R.id.alert_dialog:
                        showAlert(fragmentManager);
                        break;
                }

                break;

            case R.id.group_list_fragment:
                Boolean listItemCustom = false;

                switch (itemId){
                    case R.id.lf_default:
                         break;
                    case R.id.lf_custom:
                        listItemCustom = true;
                        break;
                }

                Intent intent = new Intent(this,ListActivity.class);
                intent.putExtra("list_item_custom", listItemCustom);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showDialog(int dialogType, FragmentManager fragmentManager){
        DialogFragment dialogFragment = DialogFragment.newInstance(dialogType);
        dialogFragment.show(fragmentManager,"dialog_frag");
    }


    private void showAlert(FragmentManager fragmentManager){
        AlertDialogFragment alertDialogFragment = AlertDialogFragment.getInstance(R.string.alert_dialog_fragment_title);
        alertDialogFragment.show(fragmentManager, "alert_dialog_frag");

    }

    private void showListFragment(int type, FragmentManager fragmentManager){


    }
}
