package com.liga.models;

public class CTecnico extends Team{
    String rol;
    String idFederacion;
    
    
    public CTecnico(int id, String nombres, String apellidos, int edad, Equipo equipo, String rol,
            String idFederacion) {
        super(id, nombres, apellidos, edad, equipo);
        this.rol = rol;
        this.idFederacion = idFederacion;
    }
    public CTecnico(int id, String nombres, String apellidos, int edad, Equipo equipo) {
        super(id, nombres, apellidos, edad, equipo);
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getIdFederacion() {
        return idFederacion;
    }
    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }
    
}
