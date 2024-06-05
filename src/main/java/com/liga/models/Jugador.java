package com.liga.models;

public class Jugador extends Team{
    int dorsal;
    String posicion;
    int goles;
    int ta;
    int tr;
    public Jugador(int id, String nombres, String apellidos, int edad, int dorsal, String posicion, int goles, int ta,
            int tr) {
        super(id, nombres, apellidos, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.goles = goles;
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
