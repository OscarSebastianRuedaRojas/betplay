package com.liga.models;

public class Team {
    int id;
    String nombres;
    String apellidos;
    int edad;
    Equipo equipo;
    public void concentrarse(){
        System.out.println(String.format("%s Se esta concentrando ", this.nombres));
    }
    public void viajar(String lugar){
        System.out.println(String.format("%s esta viajando a ", this.nombres, lugar));
    }
    
    public Team(int id, String nombres, String apellidos, int edad, Equipo equipo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.equipo = equipo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
}
