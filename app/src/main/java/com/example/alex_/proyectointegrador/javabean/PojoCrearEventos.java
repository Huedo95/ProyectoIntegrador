package com.example.alex_.proyectointegrador.javabean;


public class PojoCrearEventos {
    private String idEvento;
    private String Nombre;
    private String FechaInicio;
    private String FechaFin;
    private String Ubicacion;
    private String Descripcion;
    private String url;

    public PojoCrearEventos() {
    }

    public PojoCrearEventos(String idEvento, String nombre, String fechaInicio, String fechaFin, String ubicacion, String descripcion, String url) {
        this.idEvento = idEvento;
        Nombre = nombre;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        Ubicacion = ubicacion;
        Descripcion = descripcion;
        this.url = url;
    }

    public PojoCrearEventos(String nombre, String fechaInicio, String fechaFin, String ubicacion, String descripcion, String url) {
        Nombre = nombre;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        Ubicacion = ubicacion;
        Descripcion = descripcion;
        this.url = url;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public void setDescripcion(String Descripcion) {
        Descripcion = Descripcion;
    }
}

