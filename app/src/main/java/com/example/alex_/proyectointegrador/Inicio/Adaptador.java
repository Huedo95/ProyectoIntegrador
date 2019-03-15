package com.example.alex_.proyectointegrador.Inicio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex_.proyectointegrador.R;

import java.util.ArrayList;

/**
 * Created by aaa on 03/02/2019.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.MiViewHolder>
        implements View.OnClickListener {
    private ArrayList<ItemLista> datos;
    private ArrayList<ItemLista> datosfiltrado;

    private View.OnClickListener listener;

    public static class MiViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView textoNombreP;
     //   private TextView textoDescripcionP;
        private TextView textoContamP;

        public MiViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imageView);
            textoNombreP = (TextView) itemView.findViewById(R.id.tvNombreP);
          //  textoDescripcionP = (TextView) itemView.findViewById(R.id.tvDescripcionP);
            textoContamP = (TextView) itemView.findViewById(R.id.tvContaminacionP);
        }

        public void bindItemLista(ItemLista li) {
            imagen.setImageResource(li.getImagen());
            textoNombreP.setText(li.getTextoNombreP());
        //    textoDescripcionP.setText(li.getTextoDescripcionP());
            textoContamP.setText(String.valueOf("Contaminacion: "+li.getNumContaminacion() + " %"));
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getTextoNombreP() {
            return textoNombreP;
        }

      //  public TextView getTextoDescripcionP() {
        //    return textoDescripcionP;
   //     }

        public TextView getTextoContamP() {
            return textoContamP;
        }
    }
        public Adaptador(ArrayList<ItemLista> datos) {
            this.datos = datos;
        }

        @Override
        public Adaptador.MiViewHolder onCreateViewHolder(
                ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_noticias, parent, false);
            v.setOnClickListener(this);
            MiViewHolder vh = new MiViewHolder(v);
            return vh;
        }

        public void onBindViewHolder(MiViewHolder holder, int position) {
        /*holder.getImagen().setImageResource(datos.get(position).getImagen());
        holder.getTextoSup().setText(datos.get(position).getTextoSup());
        holder.getTextoInf().setText(datos.get(position).getTextoInf());*/
            holder.bindItemLista(datos.get(position));
        }
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }


}
