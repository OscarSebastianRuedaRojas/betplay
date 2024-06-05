package com.liga.models;

public class CMedico extends Team{
    String Titulacion;
    int experiencia;
    public CMedico(int id, String nombres, String apellidos, int edad, String titulacion, int experiencia) {
        super(id, nombres, apellidos, edad);
        Titulacion = titulacion;
        this.experiencia = experiencia;
    }
    public String getTitulacion() {
        return Titulacion;
    }
    public void setTitulacion(String titulacion) {
        Titulacion = titulacion;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
}
