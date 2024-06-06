package com.liga;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.liga.models.CTecnico;
import com.liga.models.Equipo;
import com.liga.models.Jugador;
import com.liga.models.Partido;
import com.liga.models.CMedico;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        ArrayList<Equipo> equipos = new ArrayList<>();
        ArrayList<Partido> partidos = new ArrayList<>();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<CTecnico> equipoTecnico = new ArrayList<>();
        ArrayList<CMedico> equipoMedico = new ArrayList<>();
        boolean seguir = true;
        while (seguir) {
            System.out.println("Bienvenido a la Liga Betplay");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Agregar partido");
            System.out.println("3. Reportes");
            System.out.println("4. Tabla de posiciones");
            System.out.println("5. Añadir team");
            System.out.println("6. Salir");
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
                        equipoNuevo.registrarEquipo(equipos);
                        agregarOtroEquipo = confirmacionFuncion("Quieres agregar otro equipo?", input);
                        input.nextLine();
                    } while (agregarOtroEquipo);
                    break; 
                case 2:
                ArrayList<Equipo> equipoTemporal = new ArrayList<>();
                for (Equipo equipo : equipos) {
                    equipoTemporal.add((Equipo) equipo.clone());
                }
                    Partido partido1 = new Partido();
                    partido1.registrarPartido(equipoTemporal, input, partidos, equipos, jugadores);
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
                            ArrayList<Equipo> equiposGoles = new ArrayList<>();
                            copiaArrayList(equipos, equiposGoles);
                            quicksortGF(equiposGoles, 0, equiposGoles.size()-1);
                            System.out.println(String.format("el equipo con mas goles en el torneo es %s", equiposGoles.get(equiposGoles.size()-1).getNombreEquipo()));
                            break;
                        case 2:
                            ArrayList<Equipo> equiposPuntos = new ArrayList<>();
                            copiaArrayList(equipos, equiposPuntos);
                            quicksortPuntos(equiposPuntos, 0, equiposPuntos.size()-1);
                            System.out.println(String.format("el equipo con mas puntos en el torneo es %s", equiposPuntos.get(equiposPuntos.size()-1).getNombreEquipo()));
                            break;
                        case 3:
                            ArrayList<Equipo> equiposPG = new ArrayList<>();
                            copiaArrayList(equipos, equiposPG);
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
                    ArrayList<Equipo> equiposPuntos = new ArrayList<>();
                    copiaArrayList(equipos, equiposPuntos);
                    quicksortPuntos(equiposPuntos, 0, equiposPuntos.size()-1);
                    for (int i = 0; i < equiposPuntos.size(); i++) {
                        System.out.println(equiposPuntos.get(i).getNombreEquipo());
                    }
                    System.out.println(String.format("%-20s %4s %4s %4s %4s %4s %4s %4s %4s", "Club", "PJ", "PG", "PE", "PP", "GF", "GC", "DG", "Pts"));
                    for (int i = equiposPuntos.size()-1; i >= 0 ; i--) {
                        System.out.println(String.format("%-20s %4d %4d %4d %4d %4d %4d %4d %4d", equiposPuntos.get(i).getNombreEquipo(), equiposPuntos.get(i).getPJ(), equiposPuntos.get(i).getPG(), equiposPuntos.get(i).getPE(), equiposPuntos.get(i).getPP(), equiposPuntos.get(i).getGF(), equiposPuntos.get(i).getGC(), equiposPuntos.get(i).getGF()-equiposPuntos.get(i).getGC(), equiposPuntos.get(i).getPuntos()) );
                    }
                    input.nextLine();
                    break;
                case 5:
                    ArrayList<Equipo> equipoTemporal2 = new ArrayList<>();
                    for (Equipo equipo : equipos) {
                        equipoTemporal2.add((Equipo) equipo.clone());
                    }
                    System.out.println("Elige el equipo que deseas agregar personal");
                    for (int i = 0; i < equipoTemporal2.size(); i++) {
                        System.out.println(String.format("%d. %s", i+1, equipoTemporal2.get(i).getNombreEquipo()));
                    }
                    int elegido = input.nextInt()-1;
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Agregar Jugador");
                    System.out.println("2. Agregar Cuerpo Técnico (Ctecnico)");
                    System.out.println("3. Agregar Cuerpo Médico (Cmedico)");
                    System.out.println("4. Salir");
                    switch (input.nextInt()) {
                        case 1:
                            input.nextLine();
                            System.out.println("Ingresa los nombres del jugador");
                            String nombres = input.nextLine();
                            System.out.println("Ingresa los apellidos del jugador");
                            String apellidos = input.nextLine();
                            System.out.println("Ingresa el id del jugador");
                            int id = input.nextInt();
                            System.out.println("Ingresa la edad del jugador");
                            int edad = input.nextInt();
                            Jugador jugador = new Jugador(id, nombres, apellidos, edad, equipoTemporal2.get(elegido));
                            System.out.println("Ingresa el dorsal del jugador");
                            jugador.setDorsal(input.nextInt());
                            System.out.println("Ingresa la posicion del jugador");
                            jugador.setPosicion(input.nextLine());
                            System.out.println("Ingresa la nacionalidad del jugador");
                            jugador.setNacionalidad(input.nextLine());
                            Date current = new Date();
                            jugador.setFechaIngreso(current);
                            jugadores.add(jugador);
                            
                            break;
                        case 2:
                            input.nextLine();
                            System.out.println("Ingresa los nombres del CTecnico");
                            nombres = input.nextLine();
                            System.out.println("Ingresa los apellidos del CTecnico");
                            apellidos = input.nextLine();
                            System.out.println("Ingresa el id del CTecnico");
                            id = input.nextInt();
                            System.out.println("Ingresa la edad del CTecnico");
                            edad = input.nextInt();
                            CTecnico CTecnico = new CTecnico(id, nombres, apellidos, edad, equipoTemporal2.get(elegido));
                            System.out.println("Ingresa el rol del CTecnico");
                            CTecnico.setRol(input.nextLine());
                            System.out.println("Ingresa el id de la federacion");
                            CTecnico.setIdFederacion(input.nextLine());
                            equipoTecnico.add(CTecnico);
                            break;
                        case 3:
                            input.nextLine();
                            System.out.println("Ingresa los nombres del CMedico");
                            nombres = input.nextLine();
                            System.out.println("Ingresa los apellidos del CMedico");
                            apellidos = input.nextLine();
                            System.out.println("Ingresa el id del CMedico");
                            id = input.nextInt();
                            System.out.println("Ingresa la edad del CMedico");
                            edad = input.nextInt();
                            CMedico CMedico = new CMedico(id, nombres, apellidos, edad, equipoTemporal2.get(elegido));
                            System.out.println("Ingresa el titulo del CMedico");
                            CMedico.setTitulacion(input.nextLine());
                            System.out.println("Ingresa la experiencia del CMedico en este rol");
                            CMedico.setExperiencia(input.nextInt());
                            equipoMedico.add(CMedico);
                            break;
                        case 4:
                            
                            break;
                    
                        default:
                            break;
                    }
                    break;
                case 6:
                    seguir = false;
                    break;
                default:
                    break;
        }
        }
        input.close();
    }
    public static boolean confirmacionFuncion(String mensaje, Scanner input){
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
    public static void copiaArrayList(ArrayList<Equipo> equipos, ArrayList<Equipo> equipoCopia) throws CloneNotSupportedException{
        for (Equipo equipo : equipos) {
            equipoCopia.add((Equipo) equipo.clone());
        }
    }
}
