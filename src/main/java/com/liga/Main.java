package com.liga;

import java.util.ArrayList;
import java.util.Scanner;

import com.liga.models.Equipo;
import com.liga.models.Partido;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Equipo> equipos = new ArrayList<>();
        ArrayList<Partido> partidos = new ArrayList<>();
        boolean seguir = true;
        while (seguir) {
            System.out.println("Bienvenido a la Liga Betplay");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Agregar partido");
            System.out.println("3. Reportes");
            System.out.println("4. Tabla de posiciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opción = input.nextInt();
            input.nextLine();
            switch (opción) {
                case 1:
                    boolean agregarOtroEquipo;
                    do {
                        System.out.println("Ingresa el nombre del equipo que deseas registrar");
                        String nombreEquipoNuevo = input.nextLine();
                        Equipo equipoNuevo = new Equipo(nombreEquipoNuevo);
                        equipos.add(equipoNuevo);
                        System.out.println("Equipo agregado exitosamente.");
                        agregarOtroEquipo = confirmacionFuncion("Quieres agregar otro equipo?");
                    } while (agregarOtroEquipo);
                    break; 
                case 2:
                    System.out.println("Elige el equipo que es local");
                    for (int i = 0; i < equipos.size(); i++) {
                        System.out.println(String.format("%d. %s", i+1, equipos.get(i).getNombreEquipo()));
                    }
                    int elegidoLocal = input.nextInt()-1;
                    Partido partido1 = new Partido();
                    partido1.setEquipoLocal(equipos.get(elegidoLocal));
                    System.out.println("Elige el equipo que es visitante");
                    for (int i = 0; i < equipos.size(); i++) {
                        System.out.println(String.format("%d. %s", i+1, equipos.get(i).getNombreEquipo()));
                    }
                    int elegidoVisitante = input.nextInt()-1;
                    input.nextLine();
                    partido1.setEquipoVisitante(equipos.get(elegidoVisitante));
                    System.out.println("Ingresa la fecha en la que se realizo el partido (DD/MM/AAAA)");
                    String fecha = input.nextLine();
                    partido1.setFecha(fecha);
                    partido1.registrarGoles();
                    System.out.println(partido1.getEquipoLocal().getPG());
                    for (int i = 0; i < equipos.size(); i++) {
                        if (equipos.get(i).getNombreEquipo().equals(partido1.getEquipoLocal().getNombreEquipo())) {
                            equipos.set(i, partido1.getEquipoLocal());
                        }
                        if (equipos.get(i).getNombreEquipo().equals(partido1.getEquipoVisitante().getNombreEquipo())) {
                            equipos.set(i, partido1.getEquipoVisitante());
                        }
                    }
                    partidos.add(partido1);
                    break;
                case 3:
                    System.out.println("Submenú de Reportes:");
                    System.out.println("1. Nombre del equipo que más goles anotó");
                    System.out.println("2. Nombre del equipo que más puntos tiene");
                    System.out.println("3. Nombre del equipo que más partidos ganó");
                    System.out.println("4. Total de goles anotados por todos los equipos");
                    System.out.println("5. Promedio de goles anotados en el torneo");
                    System.out.print("Seleccione una opción: ");
                    int opcionReportes = input.nextInt();
                    input.nextLine();
                    switch (opcionReportes) {
                        case 1:
                            ArrayList<Equipo> equiposGoles = equipos;
                            quicksortGF(equiposGoles, 0, equiposGoles.size()-1);
                            System.out.println(String.format("el equipo con mas goles en el torneo es %s", equiposGoles.get(equiposGoles.size()-1).getNombreEquipo()));
                            break;
                        case 2:
                            ArrayList<Equipo> equiposPuntos = equipos;
                            quicksortPuntos(equiposPuntos, 0, equiposPuntos.size()-1);
                            System.out.println(String.format("el equipo con mas puntos en el torneo es %s", equiposPuntos.get(equiposPuntos.size()-1).getNombreEquipo()));
                            break;
                        case 3:
                            ArrayList<Equipo> equiposPG = equipos;
                            quicksortPG(equiposPG, 0, equiposPG.size()-1);
                            System.out.println(String.format("el equipo con mas puntos en el torneo es %s", equiposPG.get(equiposPG.size()-1).getNombreEquipo()));
                            break;
                        case 4:
                            int goles = 0;
                            for (int index = 0; index < equipos.size(); index++) {
                                goles += equipos.get(index).getGF();
                            }
                            System.out.println(String.format("La cantidad de goles marcados en el torneo son %d", goles));
                            break;
                        case 5:
                            goles = 0;
                            for (int index = 0; index < equipos.size(); index++) {
                                goles += equipos.get(index).getGF();
                            }
                            int promedio = goles/partidos.size();
                            System.out.println(String.format("El promedio de goles en el torneo es %d", promedio));
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    ArrayList<Equipo> equiposPuntos = equipos;
                    quicksortPuntos(equiposPuntos, 0, equiposPuntos.size()-1);
                    System.out.println("Club                 PJ    PG   PE   PP   GF   GC   DG    Pts");
                    for (int i = equiposPuntos.size()-1; i >= 0 ; i--) {
                        System.out.println(String.format("%s                 %d    %d    %d    %d    %d    %d    %d    %d    ", equiposPuntos.get(i).getNombreEquipo(), equiposPuntos.get(i).getPJ(), equiposPuntos.get(i).getPG(), equiposPuntos.get(i).getPE(), equiposPuntos.get(i).getPP(), equiposPuntos.get(i).getGF(), equiposPuntos.get(i).getGC(), equiposPuntos.get(i).getGF()-equiposPuntos.get(i).getGC(), equiposPuntos.get(i).getPuntos()) );
                    }
                    break;
                case 5:
                    seguir = false;
                    break;
                default:
                    break;
        }
        }
        
        input.close();
    }
    public static boolean confirmacionFuncion(String mensaje){
        Scanner input = new Scanner(System.in);
        String[] confirmaciones = {"Si", "No"};
        System.out.println("Desea agregar otro equipo?");
            for (int i = 0; i < confirmaciones.length; i++) {
                System.out.println(String.format("%d. %s", i+1, confirmaciones[i]));
            }
            int confirmar = input.nextInt();
            if (confirmar==1) {
                return true;
            }else{
                return false;
            }
    }
    public static void quicksortGF(ArrayList<Equipo> equipos, int izq, int der){
        int pivote = equipos.get(izq).getGF();
        Equipo pivoteEquipo = equipos.get(izq);
        int i = izq;
        int j = der;
        Equipo aux;
        while (i<j) {
            while (equipos.get(i).getGF() <= pivote && i < j) i++;
            while (equipos.get(j).getGF() > pivote) j--;
            if (i < j) {
                aux = equipos.get(i);
                equipos.set(i, equipos.get(j));
                equipos.set(j, aux);
            }
        }
        equipos.set(izq, equipos.get(j));
        equipos.set(j, pivoteEquipo);

        if (izq < j-1) {
            quicksortGF(equipos, izq, j-1);
        }
        if (j+1 < der) {
            quicksortGF(equipos, j+1, der);
        }
    }
    public static void quicksortPuntos(ArrayList<Equipo> equipos, int izq, int der){
        int pivote = equipos.get(izq).getPuntos();
        Equipo pivoteEquipo = equipos.get(izq);
        int i = izq;
        int j = der;
        Equipo aux;
        while (i<j) {
            while (equipos.get(i).getPuntos() <= pivote && i < j) i++;
            while (equipos.get(j).getPuntos() > pivote) j--;
            if (i < j) {
                aux = equipos.get(i);
                equipos.set(i, equipos.get(j));
                equipos.set(j, aux);
            }
        }
        equipos.set(izq, equipos.get(j));
        equipos.set(j, pivoteEquipo);

        if (izq < j-1) {
            quicksortPuntos(equipos, izq, j-1);
        }
        if (j+1 < der) {
            quicksortPuntos(equipos, j+1, der);
        }
    }
    public static void quicksortPG(ArrayList<Equipo> equipos, int izq, int der){
        int pivote = equipos.get(izq).getPG();
        Equipo pivoteEquipo = equipos.get(izq);
        int i = izq;
        int j = der;
        Equipo aux;
        while (i<j) {
            while (equipos.get(i).getPG() <= pivote && i < j) i++;
            while (equipos.get(j).getPG() > pivote) j--;
            if (i < j) {
                aux = equipos.get(i);
                equipos.set(i, equipos.get(j));
                equipos.set(j, aux);
            }
        }
        equipos.set(izq, equipos.get(j));
        equipos.set(j, pivoteEquipo);

        if (izq < j-1) {
            quicksortPG(equipos, izq, j-1);
        }
        if (j+1 < der) {
            quicksortPG(equipos, j+1, der);
        }
    }
}