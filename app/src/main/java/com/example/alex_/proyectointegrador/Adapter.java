package com.example.alex_.proyectointegrador;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alex_.proyectointegrador.javabean.PojoCrearEventos;

import java.util.ArrayList;


class Adaptador extends RecyclerView.Adapter<Adaptador.EventoViewHolder> {
    private ArrayList<PojoCrearEventos> datos;
    private MisEventos activity_mis_eventos;
    String url;
    public Adaptador(ArrayList<PojoCrearEventos> datos, MisEventos activity_mis_eventos) {
        this.datos = datos;
        this.activity_mis_eventos = activity_mis_eventos;
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from( viewGroup.getContext()).inflate( R.layout.item_evento,viewGroup,false );
        EventoViewHolder evh=new EventoViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder eventoViewHolder, int posicion) {
            final PojoCrearEventos eventoactual=datos.get(posicion);
            String eventito=(eventoactual.getIdEvento());
        eventoViewHolder.tvNombre.setText(eventoactual.getNombre() );
        eventoViewHolder.tvDescripcion.setText(eventoactual.getDescripcion() );
         url=eventoactual.getUrl();
       /* Glide.with(eventoViewHolder.imageView.getContext())
                .load(url)
                .into(eventoViewHolder.imageView);*/




    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
    public void clear() {
        datos.clear();
    }

    public class EventoViewHolder extends RecyclerView.ViewHolder{
        private Context context;

        private TextView tvNombre,tvDescripcion;
        private ImageView imageView;

        public EventoViewHolder(View itemView){
            super(itemView);
            tvNombre=itemView.findViewById( R.id.tvTituloEvento );
            tvDescripcion=itemView.findViewById( R.id.tvTextoEvento );
            imageView=itemView.findViewById( R.id.imgvFotoEvento );
          //  Glide.with(imageView.getContext()).load(url).into(imageView);
        }
        public void bindViaje(PojoCrearEventos pce) {
            tvNombre.setText(String.format(context.getString(R.string.tvvNombre1), pce.getNombre()));
            tvDescripcion.setText(String.format(context.getString(R.string.tvvDescripcion1), pce.getDescripcion()));


        }

    }
}