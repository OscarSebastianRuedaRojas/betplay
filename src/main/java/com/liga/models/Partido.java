package com.liga.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Partido {
    Equipo equipoLocal;
    Equipo equipoVisitante;
    String fecha;
    int golesLocal;
    int golesVisitante;
    public Partido() {
    }
    public Partido(Equipo equipoLocal, Equipo equipoVisitante, String fecha, int golesLocal, int golesVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }
    public void registrarGoles(Scanner input){
        System.out.println(String.format("Ingresa la cantidad de goles de %s", this.equipoLocal.getNombreEquipo()));
        this.golesLocal = input.nextInt();
        System.out.println(String.format("Ingresa la cantidad de goles de %s", this.equipoVisitante.getNombreEquipo()));
        this.golesVisitante = input.nextInt();
        if (golesLocal>golesVisitante) {
            this.equipoLocal.setPuntos(this.equipoLocal.getPuntos()+3);
            this.equipoLocal.setPG(this.equipoLocal.getPG()+1);
            this.equipoVisitante.setPP(this.equipoVisitante.getPP()+1);
        }else if(golesLocal==golesVisitante){
            this.equipoLocal.setPuntos(this.equipoLocal.getPuntos()+1);
            this.equipoVisitante.setPuntos(this.equipoVisitante.getPuntos()+1);
            this.equipoLocal.setPE(this.equipoLocal.getPE()+1);
            this.equipoVisitante.setPE(this.equipoVisitante.getPE()+1);
        }else{
            this.equipoVisitante.setPuntos(this.equipoVisitante.getPuntos()+3);
            this.equipoVisitante.setPG(this.equipoVisitante.getPG()+1);
            this.equipoLocal.setPP(this.equipoLocal.getPP()+1);
        }
        this.equipoLocal.setPJ(this.equipoLocal.getPJ()+1);
        this.equipoVisitante.setPJ(this.equipoVisitante.getPJ()+1);
        this.equipoLocal.setGF(this.equipoLocal.getGF()+golesLocal);
        this.equipoLocal.setGC(this.equipoLocal.getGC()+golesVisitante);
        this.equipoVisitante.setGF(this.equipoVisitante.getGF()+golesVisitante);
        this.equipoVisitante.setGC(this.equipoVisitante.getGC()+golesLocal);
    }
    public void registrarPartido(ArrayList<Equipo> equipoTemporal, Scanner input, ArrayList<Partido> partidos, ArrayList<Equipo> equipos){
        System.out.println("Elige el equipo que es local");
        for (int i = 0; i < equipoTemporal.size(); i++) {
            System.out.println(String.format("%d. %s", i+1, equipoTemporal.get(i).getNombreEquipo()));
        }
        int elegidoLocal = input.nextInt()-1;
        this.setEquipoLocal(equipoTemporal.get(elegidoLocal));
        equipoTemporal.remove(elegidoLocal);
        System.out.println("Elige el equipo que es visitante");
        for (int i = 0; i < equipoTemporal.size(); i++) {
            System.out.println(String.format("%d. %s", i+1, equipoTemporal.get(i).getNombreEquipo()));
        }
        int elegidoVisitante = input.nextInt()-1;
        input.nextLine();
        this.setEquipoVisitante(equipoTemporal.get(elegidoVisitante));
        System.out.println("Ingresa la fecha en la que se realizo el partido (DD/MM/AAAA)");
        String fecha = input.nextLine();
        this.setFecha(fecha);
        this.registrarGoles(input);
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getNombreEquipo().equals(this.getEquipoLocal().getNombreEquipo())) {
                equipos.set(i, this.getEquipoLocal());
            }
            if (equipos.get(i).getNombreEquipo().equals(this.getEquipoVisitante().getNombreEquipo())) {
                equipos.set(i, this.getEquipoVisitante());
            }
        }
        partidos.add(this);
    }
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getGolesLocal() {
        return golesLocal;
    }
    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }
    public int getGolesVisitante() {
        return golesVisitante;
    }
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
}
