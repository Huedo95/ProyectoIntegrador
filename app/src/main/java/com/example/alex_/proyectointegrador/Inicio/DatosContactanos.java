package com.example.alex_.proyectointegrador.Inicio;

import java.util.ArrayList;

/**
 * Created by PilarMarGom on 12/12/2017.
 */

public class DatosContactanos {
    private ArrayList<ItemContactanos> lista;

    public DatosContactanos() {
        lista = new ArrayList<ItemContactanos>();
        cargarDatos();
    }

    private void cargarDatos() {
        lista.add(new ItemContactanos("Oficina Central GreenBeach SL", "C/ Los angeles,67\n Edificio Amapola \n Urbanizacion Astrozka \n 28049 Madrid",
                "Tel: 91 225 45 33\n Fax: 93 225 44 21"));
        lista.add(new ItemContactanos("Oficina Regional GreenBeach SL", "C/ Aruspiza,67\n Edificio Salitre \n Urbanizacion Reskato \n 28049 Barcelona",
                "Tel: 91 534 43 11\n Fax: 93 643 32 13"));

        lista.add(new ItemContactanos("Oficina Madrid GreenBeach SL", "C/ aa,67\n Edificio Salitre \n Urbanizacion Reskato \n 28049 Madrid",
                "Tel: 91 534 43 11\n Fax: 93 643 32 13"));

        lista.add(new ItemContactanos("Oficina Barcelona GreenBeach SL", "C/ cc,67\n Edificio Salitre \n Urbanizacion Reskato \n 28049 Barcelona",
                "Tel: 91 534 43 11\n Fax: 93 643 32 13"));
    }


    public ArrayList<ItemContactanos> getLista() {
        return lista;
    }
}
