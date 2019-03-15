package com.example.alex_.proyectointegrador.Inicio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alex_.proyectointegrador.R;

import java.util.ArrayList;

/**
 * Created by PilarMarGom on 12/12/2017.
 */

public class AdaptadorContactanos extends RecyclerView.Adapter<AdaptadorContactanos.MiViewHolder>
implements View.OnClickListener {
    private ArrayList<ItemContactanos> datos;
    private View.OnClickListener listener;

    public static class MiViewHolder extends RecyclerView.ViewHolder {
        private TextView textoTitulo;
        private TextView textoSup;
        private TextView textoInf;

        public MiViewHolder(View itemView) {
            super(itemView);
            textoTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            textoSup = (TextView) itemView.findViewById(R.id.tvSuperior);
            textoInf = (TextView) itemView.findViewById(R.id.tvInferior);
        }

        public void bindItemLista(ItemContactanos li) {
            textoTitulo.setText(li.getTextoTitulo());
            textoSup.setText(li.getTextoSup());
            textoInf.setText(li.getTextoInf());
        }

        public TextView getTextoTitulo() {
            return textoTitulo;
        }

        public TextView getTextoSup() {
            return textoSup;
        }

        public TextView getTextoInf() {
            return textoInf;
        }
    }

    public AdaptadorContactanos(ArrayList<ItemContactanos> datos) {
        this.datos = datos;
    }

    @Override
    public MiViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contacto, parent, false);
        v.setOnClickListener(this);
        MiViewHolder vh = new MiViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(MiViewHolder holder, int position) {
       /* holder.getTextoTitulo().setText(datos.get(position).getTextoTitulo());
        holder.getTextoSup().setText(datos.get(position).getTextoSup());
        holder.getTextoInf().setText(datos.get(position).getTextoInf()); */
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
