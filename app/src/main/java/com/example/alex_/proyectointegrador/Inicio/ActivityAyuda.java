package com.example.alex_.proyectointegrador.Inicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.alex_.proyectointegrador.MisEventos;
import com.example.alex_.proyectointegrador.Perfil.Perfil;
import com.example.alex_.proyectointegrador.R;

public class ActivityAyuda extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//NAV_DRAWER
    public Toolbar mToolbar;
    public ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(mToggle);
        mToggle.syncState();


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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            Intent i = new Intent(this,ActivityPrinc.class);
            startActivity(i);
        } else if (id == R.id.nav_eventos) {
            Intent i = new Intent(this,MisEventos.class);
            startActivity(i);
        } else if (id == R.id.nav_perfil) {
            Intent i = new Intent(this,Perfil.class);
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
}
