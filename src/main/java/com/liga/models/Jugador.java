package com.liga.models;
import java.util.Date;

public class Jugador extends Team{
    int dorsal;
    String posicion;
    int goles;
    String nacionalidad;
    Date fechaIngreso;
    int ta = 0;
    int tr = 0;

    public Jugador(int id, String nombres, String apellidos, int edad, Equipo equipo) {
        super(id, nombres, apellidos, edad, equipo);
    }

    public Jugador(int id, String nombres, String apellidos, int edad, Equipo equipo, int dorsal, String posicion,
            int goles, String nacionalidad, Date fechaIngreso, int ta, int tr) {
        super(id, nombres, apellidos, edad, equipo);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.ta = ta;
        this.tr = tr;
    }
    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getTa() {
        return ta;
    }

    public void setTa(int ta) {
        this.ta = ta;
    }

    public int getTr() {
        return tr;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }
}
