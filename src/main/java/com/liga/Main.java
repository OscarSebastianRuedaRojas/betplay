package com.liga;

import java.util.ArrayList;
import java.util.Scanner;
import com.liga.models.Equipo;
import com.liga.models.Partido;

import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
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
            int opcion = input.nextInt();
            input.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarEquipos(input, equipos);
                    break;
                case 2:
                    agregarPartido(input, equipos, partidos);
                    break;
                case 3:
                    mostrarReportes(input, equipos, partidos);
                    break;
                case 4:
                    mostrarTablaPosiciones(equipos);
                    break;
                case 5:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }
        input.close();
    }

    private static void agregarEquipos(Scanner input, ArrayList<Equipo> equipos) {
        boolean agregarOtroEquipo;
        do {
            System.out.print("Ingresa el nombre del equipo que deseas registrar: ");
            String nombreEquipoNuevo = input.nextLine();
            Equipo equipoNuevo = new Equipo(nombreEquipoNuevo);
            equipoNuevo.registrarEquipo(equipos);
            agregarOtroEquipo = confirmacionFuncion("¿Quieres agregar otro equipo?", input);
        } while (agregarOtroEquipo);
    }

    private static void agregarPartido(Scanner input, ArrayList<Equipo> equipos, ArrayList<Partido> partidos) throws CloneNotSupportedException {
        ArrayList<Equipo> equipoTemporal = new ArrayList<>();
        for (Equipo equipo : equipos) {
            equipoTemporal.add((Equipo) equipo.clone());
        }
        Partido partido1 = new Partido();
        partido1.registrarPartido(equipoTemporal, input, partidos, equipos);
    }

    private static void mostrarReportes(Scanner input, ArrayList<Equipo> equipos, ArrayList<Partido> partidos) throws CloneNotSupportedException {
        System.out.println("Submenú de Reportes:");
        System.out.println("1. Nombre del equipo que más goles anotó");
        System.out.println("2. Nombre del equipo que más puntos tiene");
        System.out.println("3. Nombre del equipo que más partidos ganó");
        System.out.println("4. Total de goles anotados por todos los equipos");
        System.out.println("5. Promedio de goles anotados en el torneo");
        System.out.print("Seleccione una opción: ");
        int opcionReportes = input.nextInt();
        input.nextLine();  // Consumir el salto de línea

        switch (opcionReportes) {
            case 1:
                reportarEquipoConMas("goles", equipos, (e1, e2) -> Integer.compare(e1.getGF(), e2.getGF()));
                break;
            case 2:
                reportarEquipoConMas("puntos", equipos, (e1, e2) -> Integer.compare(e1.getPuntos(), e2.getPuntos()));
                break;
            case 3:
                reportarEquipoConMas("partidos ganados", equipos, (e1, e2) -> Integer.compare(e1.getPG(), e2.getPG()));
                break;
            case 4:
                int totalGoles = equipos.stream().mapToInt(Equipo::getGF).sum();
                System.out.println(String.format("La cantidad de goles marcados en el torneo son %d", totalGoles));
                break;
            case 5:
                totalGoles = equipos.stream().mapToInt(Equipo::getGF).sum();
                double promedio = (double) totalGoles / partidos.size();
                System.out.println(String.format("El promedio de goles en el torneo es %.2f", promedio));
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private static void mostrarTablaPosiciones(ArrayList<Equipo> equipos) throws CloneNotSupportedException {
        ArrayList<Equipo> equiposPuntos = new ArrayList<>();
        copiaArrayList(equipos, equiposPuntos);
        quicksort(equiposPuntos, 0, equiposPuntos.size() - 1, (e1, e2) -> Integer.compare(e1.getPuntos(), e2.getPuntos()));

        System.out.println(String.format("%-20s %4s %4s %4s %4s %4s %4s %4s %4s", "Club", "PJ", "PG", "PE", "PP", "GF", "GC", "DG", "Pts"));
        for (int i = equiposPuntos.size() - 1; i >= 0; i--) {
            Equipo equipo = equiposPuntos.get(i);
            System.out.println(String.format("%-20s %4d %4d %4d %4d %4d %4d %4d %4d",
                    equipo.getNombreEquipo(), equipo.getPJ(), equipo.getPG(), equipo.getPE(),
                    equipo.getPP(), equipo.getGF(), equipo.getGC(), equipo.getGF() - equipo.getGC(),
                    equipo.getPuntos()));
        }
    }

    private static boolean confirmacionFuncion(String mensaje, Scanner input) {
        System.out.println(mensaje);
        System.out.println("1. Sí");
        System.out.println("2. No");
        int confirmar = input.nextInt();
        input.nextLine();  // Consumir el salto de línea
        return confirmar == 1;
    }

    private static void quicksort(ArrayList<Equipo> equipos, int izq, int der, Comparator<Equipo> comparador) {
        if (izq < der) {
            int pivoteIndex = particionar(equipos, izq, der, comparador);
            quicksort(equipos, izq, pivoteIndex - 1, comparador);
            quicksort(equipos, pivoteIndex + 1, der, comparador);
        }
    }

    private static int particionar(ArrayList<Equipo> equipos, int izq, int der, Comparator<Equipo> comparador) {
        Equipo pivote = equipos.get(izq);
        int i = izq;
        int j = der;

        while (i < j) {
            while (i < j && comparador.compare(equipos.get(i), pivote) <= 0) i++;
            while (comparador.compare(equipos.get(j), pivote) > 0) j--;
            if (i < j) {
                Collections.swap(equipos, i, j);
            }
        }
        Collections.swap(equipos, izq, j);
        return j;
    }

    private static void reportarEquipoConMas(String atributo, ArrayList<Equipo> equipos, Comparator<Equipo> comparador) throws CloneNotSupportedException {
        ArrayList<Equipo> equiposCopia = new ArrayList<>();
        copiaArrayList(equipos, equiposCopia);
        quicksort(equiposCopia, 0, equiposCopia.size() - 1, comparador);
        System.out.println(String.format("El equipo con más %s en el torneo es %s", atributo, equiposCopia.get(equiposCopia.size() - 1).getNombreEquipo()));
    }

    private static void copiaArrayList(ArrayList<Equipo> equipos, ArrayList<Equipo> equipoCopia) throws CloneNotSupportedException {
        for (Equipo equipo : equipos) {
            equipoCopia.add((Equipo) equipo.clone());
        }
    }
}