package com.example.alex_.proyectointegrador.Inicio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.alex_.proyectointegrador.MisEventos;
import com.example.alex_.proyectointegrador.Perfil.Perfil;
import com.example.alex_.proyectointegrador.R;


import java.util.ArrayList;

public class ActivityPrinc extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//NAV_DRAWER
    public Toolbar mToolbar;
    public ActionBarDrawerToggle mToggle;

    //RECYCLERVIEW
 private RecyclerView miRecyclerView;
    private LinearLayoutManager miLayoutManager;
    private Adaptador miAdapter;
    private ArrayList<ItemLista> datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princ);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(mToggle);
        mToggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //RECYCLERVIEW
        datos = (new Datos()).getLista();
        miRecyclerView = (RecyclerView)findViewById(R.id.my_recy_view);

        miRecyclerView.setHasFixedSize(true);

        miLayoutManager = new LinearLayoutManager(this);
        miRecyclerView.setLayoutManager(miLayoutManager);

        miAdapter = new Adaptador(datos);
        miAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente(v);
            }
        });

        miRecyclerView.setAdapter(miAdapter);
    }
    @SuppressLint("StringFormatInvalid")
    public void siguiente(View v){
        Intent i = new Intent(this, ActivityLast.class);
        i.putExtra(getString(R.string.clave_playa), ((Adaptador.MiViewHolder)miRecyclerView.getChildViewHolder(v)).getTextoNombreP().getText());
        startActivity(i);
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
        getMenuInflater().inflate(R.menu.navigation_menuset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
/*
    //TABS
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.content_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            return rootView;
        }
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            Intent i = new Intent(this,ActivityPrinc.class);
             startActivity(i);
        } else if (id == R.id.nav_eventos) {
            Intent i = new Intent(this, MisEventos.class);
            startActivity(i);
        } else if (id == R.id.nav_perfil) {
            Intent i = new Intent(this, Perfil.class);
            startActivity(i);
        }else if (id == R.id.nav_contactanos) {
            Intent i = new Intent(this,ActivityContactanos.class);
            startActivity(i);
        } else if (id == R.id.nav_nosotros) {
            Intent i = new Intent(this,ActivityNosotros.class);
            startActivity(i);
        } else if (id == R.id.nav_ayuda) {
            Intent i = new Intent(this,ActivityAyuda.class);
            startActivity(i);
        } else if (id == R.id.nav_cerrarSesion) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
/*
    //TABS
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Tab1Notica tab1 = new Tab1Notica();
                    return tab1;
                case 1:
                    Tab2Evento tab2 = new Tab2Evento();
                    return tab2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        public CharSequence getPageTitle(int position){
            switch (position) {
                case 0:
                    return "NOTICIA";
                case 1:
                    return "EVENTO";
            }
            return  null;
        }
    }*/

}
