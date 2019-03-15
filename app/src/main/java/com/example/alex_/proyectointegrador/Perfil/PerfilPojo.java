package com.example.alex_.proyectointegrador.Perfil;

public class PerfilPojo {

    private String usuario;
    private String fotoUrl;
    private String idusuario;

    public PerfilPojo(String usuario, String fotoUrl, String idusuario) {
        this.usuario = usuario;
        this.fotoUrl = fotoUrl;
        this.idusuario = idusuario;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public PerfilPojo() {

    }



    public PerfilPojo(String usuario, String fotoUrl) {
        this.usuario = usuario;
        this.fotoUrl = fotoUrl;
    }



    public String getFotoUrl() {
        return fotoUrl;
    }

    public String getUsuario() {
        return usuario;
    }
}
