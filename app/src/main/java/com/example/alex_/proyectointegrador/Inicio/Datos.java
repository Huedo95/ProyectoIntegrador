package com.example.alex_.proyectointegrador.Inicio;

import com.example.alex_.proyectointegrador.R;

import java.util.ArrayList;

/**
 * Created by aaa on 03/02/2019.
 */

public class Datos {
    private ArrayList<ItemLista> lista;

    public Datos() {
        lista = new ArrayList<ItemLista>();
        cargarDatos();
    }

    private void cargarDatos() {
        lista.add(new ItemLista(R.drawable.ibiza, "IBIZA",
                " La naturaleza ibicenca constituye, sin duda el atractivo más importante de la isla. Ibiza cuenta con una extensión de 572 kilómetros cuadrados y 210 kilómetros de playas que se pueden disfrutar en cualquier época del año gracias a sus cálidas temperaturas y casi 3.000 horas de sol al año. Ibiza ofrece múltiples posibilidades de disfrutar de un baño en el mar en playas que cuentan con una amplia gama de servicios y diferentes ambientes.",10));
        lista.add(new ItemLista(R.drawable.mallorca, "PALMA",
                " es la porción de costa de mayores dimensiones de la capital del archipiélago balear (4,6 kilómetros de longitud, divididos en 15 balnearios), situada a 14 kilómetros al este de esta localidad, aunque su último tramo pertenece al municipio de Llucmajor. fue establecido por la sociedad Mar de Mallorca que se encargaba de la explotación de la playa (hamacas, sombrillas, bares y chiringuitos) para unificar bajo una denominación a Cala Estància, Can Pastilla y s’Arenal. ",20));
        lista.add(new ItemLista(R.drawable.taganana, "TAGANANA",
                "es una entidad de población del municipio de Santa Cruz de Tenerife, en la isla de Tenerife —Canarias, España—, perteneciente administrativamente al distrito de Anaga y que posee la consideración de pueblo.Es la localidad más importante del interior del macizo de Anaga y una de las poblaciones más antiguas de la isla, habiendo sido además un municipio independiente a lo largo del siglo xix.",18));
        lista.add(new ItemLista(R.drawable.tossa, "TOSSA DE MAR",
                "es un municipio español perteneciente a la provincia de Gerona, Cataluña. Está situado en la comarca de la Selva, y su ubicación en la Costa Brava hace que sea un destino turístico importante. Contaba con 5.976 habitantes según el censo del INE de 2010.",30));
        lista.add(new ItemLista(R.drawable.menorca, "MENORCA",
                "se pueden encontrar más de medio centenar de playas, desde completamente vírgenes y de difícil acceso a pie, hasta algunas con urbanizaciones junto a ellas. Se pueden distinguir fácilmente las playas de la costa norte y las de la costa sur.",12));
        lista.add(new ItemLista(R.drawable.playameron, "PLAYA MERON",
                "es una playa situada en el municipio de San Vicente de la Barquera, en la Comunidad Autónoma de Cantabria, España.Dispone de acceso a minusválidos.",10));
        lista.add(new ItemLista(R.drawable.playateresitas, "PLAYA TERESITAS",
                "es una playa situada en el pueblo de San Andrés del municipio de Santa Cruz de Tenerife, en la isla de Tenerife (España). Es la playa más conocida y turística de la ciudad de Santa Cruz, ofreciendo equipamientos y servicios hosteleros",13));

    }
    public ArrayList<ItemLista> getLista() {
        return lista;
    }
    }
