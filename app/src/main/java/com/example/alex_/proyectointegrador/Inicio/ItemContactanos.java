package com.example.alex_.proyectointegrador.Inicio;

/**
 * Created by PilarMarGom on 12/12/2017.
 */

public class ItemContactanos {
    private String textoTitulo;
    private String textoSup;
    private String textoInf;

    public ItemContactanos(String textoTitulo, String textoSup, String textoInf) {
        this.textoTitulo = textoTitulo;
        this.textoSup = textoSup;
        this.textoInf = textoInf;
    }

    public String getTextoTitulo() {
        return textoTitulo;
    }

    public String getTextoSup() {
        return textoSup;
    }

    public String getTextoInf() {
        return textoInf;
    }
}
