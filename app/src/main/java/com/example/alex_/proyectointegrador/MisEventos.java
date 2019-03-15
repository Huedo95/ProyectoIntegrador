package com.example.alex_.proyectointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alex_.proyectointegrador.javabean.PojoCrearEventos;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MisEventos extends AppCompatActivity {
    private RecyclerView miRecyclerView;//Llamando al atributo
    private LinearLayoutManager miLayoutManager;
    private Adaptador miAdapter;
    private ArrayList<PojoCrearEventos> datos;//Creando una Array de la lista
    private DatabaseReference dbR;
    private ChildEventListener cel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_eventos);

        miRecyclerView=findViewById(R.id.my_recycler_view);
        datos=new ArrayList<>();
        miLayoutManager=new LinearLayoutManager(this);

        miRecyclerView.setAdapter(miAdapter);
        miRecyclerView.setLayoutManager(miLayoutManager);
        miRecyclerView.setItemAnimator(new DefaultItemAnimator());

        dbR= FirebaseDatabase.getInstance().getReference().child("Uploads");
        addChildEventListener();



    }

    private void addChildEventListener() {
        if(cel == null) {
            cel = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    PojoCrearEventos pce = dataSnapshot.getValue(PojoCrearEventos.class);
                    datos.add(pce);
                    miAdapter.notifyItemChanged(datos.size()-1);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };

            dbR.addChildEventListener(cel);
        }
    }
    public void crearEventos(View v){
        Intent i = new Intent( MisEventos.this, CrearEventos.class );
        startActivity(i);
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(cel != null) {
            dbR.removeEventListener(cel);
            cel = null;
        }
        miAdapter.clear();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(miAdapter == null) {
            miAdapter = new Adaptador(datos, this);
            miRecyclerView.setAdapter(miAdapter);
        }
        else {
            datos.clear();

        }
        miAdapter.notifyDataSetChanged();
        addChildEventListener();
    }



}