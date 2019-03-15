package com.example.alex_.proyectointegrador.Inicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex_.proyectointegrador.R;

import java.util.ArrayList;

/**
 * Created by aaa on 15/02/2019.
 */

public class ActivityLast extends AppCompatActivity {
    TextView tvPlaya;
    TextView tvDescrip;
    ImageView img;
    private ArrayList<ItemLista> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_activity);

       String playa = getIntent().getStringExtra(getString(R.string.clave_playa));
       img = findViewById(R.id.imgPlaya);
        tvPlaya = findViewById(R.id.tvPlaya);
        tvDescrip = findViewById(R.id.tvDescripcion);

        tvPlaya.setText(playa);
        lista = (new Datos()).getLista();
        String contenido;

        ItemLista li;


        for (int i=0; i<lista.size(); i++){
            li = lista.get(i);
            if(li.getTextoNombreP().equals(playa)){

                contenido = li.getTextoDescripcionP();
                int id = getResources().getIdentifier(String.valueOf(li.getImagen()), "drawable", getPackageName());
                img.setImageResource(id);
                tvDescrip.setText(String.format(contenido));
                break;
            }
        }

    }
    public void volver(View v){
    Intent i = new Intent(this, ActivityPrinc.class);
    startActivity(i);
}

}
