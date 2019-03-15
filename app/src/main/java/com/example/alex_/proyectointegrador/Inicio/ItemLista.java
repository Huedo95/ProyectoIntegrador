package com.example.alex_.proyectointegrador.Inicio;

/**
 * Created by aaa on 03/02/2019.
 */

public class ItemLista {
    private int imagen;
    private String textoNombreP;
    private String textoDescripcionP;
    private int numContaminacion;

    public ItemLista(int imagen, String textoNombreP, String textoDescripcionP, int numContaminacion) {
        this.imagen = imagen;
        this.textoNombreP = textoNombreP;
        this.textoDescripcionP = textoDescripcionP;
        this.numContaminacion = numContaminacion;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTextoNombreP() {
        return textoNombreP;
    }

    public String getTextoDescripcionP() {
        return textoDescripcionP;
    }

    public int getNumContaminacion() {
        return numContaminacion;
    }
}
