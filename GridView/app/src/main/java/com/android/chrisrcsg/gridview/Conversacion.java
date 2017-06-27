package com.android.chrisrcsg.gridview;

/**
 * Created by ChrisRCSG on 26/06/17.
 */

public class Conversacion {
    private String nombre;
    private String mensaje;
    private int imagen;

    public Conversacion(String nombre, String mensaje, int imagen) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getImagen() {
        return imagen;
    }
}
