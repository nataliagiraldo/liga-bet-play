package com.natalia;

import java.util.Scanner;
import java.util.ArrayList;

import com.natalia.juego.Equipo;
import com.natalia.juego.Partido;

public class Main {
    private ArrayList<Equipo> listaEquipos = new ArrayList<>();
    private ArrayList<Partido> listaPartidos = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú Liga BetPlay ---");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Registrar partido");
            System.out.println("3. Reporte equipo con más goles");
            System.out.println("4. Reporte equipo con más puntos");
            System.out.println("5. Reporte equipo con más partidos ganados");
            System.out.println("6. Reporte total de goles anotados");
            System.out.println("7. Reporte promedio de goles anotados");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarEquipo(scanner);
                    break;
                case 2:
                    registrarPartido(scanner);
                    break;
                case 3:
                    reporteEquipoMasGoles();
                    break;
                case 4:
                    reporteEquipoMasPuntos();
                    break;
                case 5:
                    reporteEquipoMasGanados();
                    break;
                case 6:
                    reporteTotalGoles();
                    break;
                case 7:
                    reportePromedioGoles();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);
    }

    private void registrarEquipo(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = new Equipo(nombreEquipo);
        listaEquipos.add(equipo);
        System.out.println("Equipo registrado exitosamente.");
    }

    private void registrarPartido(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo local: ");
        String nombreLocal = scanner.nextLine();
        Equipo local = buscarEquipo(nombreLocal);

        System.out.print("Ingrese el nombre del equipo visitante: ");
        String nombreVisitante = scanner.nextLine();
        Equipo visitante = buscarEquipo(nombreVisitante);

        if (local != null && visitante != null) {
            System.out.print("Ingrese los goles del equipo local: ");
            int golesLocal = scanner.nextInt();
            System.out.print("Ingrese los goles del equipo visitante: ");
            int golesVisitante = scanner.nextInt();
            scanner.nextLine(); 

            Partido partido = new Partido(local, visitante, golesLocal, golesVisitante);
            listaPartidos.add(partido);

            System.out.println("Partido registrado exitosamente.");
        } else {
            System.out.println("Uno o ambos equipos no están registrados.");
        }
    }

    private Equipo buscarEquipo(String nombre) {
        for (Equipo equipo : listaEquipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    private void reporteEquipoMasGoles() {
        // Implementación del reporte de equipo con más goles
        int maximo = -1;
        String equipoMaximo = "";
        for(int i=0; i< listaEquipos.size();i++){
            if (listaEquipos.get(i).getGf()> maximo){
                maximo = listaEquipos.get(i).getGf();
                equipoMaximo = listaEquipos.get(i).getNombre();
            };
        }
        System.out.println(equipoMaximo); 
        
        
    }

    private void reporteEquipoMasPuntos() {
        // Implementación del reporte de equipo con más puntos
        int maximo = -1;
        String equipoMaximo = "";
        for(int i=0; i< listaEquipos.size();i++){
            if (listaEquipos.get(i).getTp()> maximo){
                maximo = listaEquipos.get(i).getTp();
                equipoMaximo = listaEquipos.get(i).getNombre();
            };
        }
        System.out.println(equipoMaximo); 
       
        
    }

    private void reporteEquipoMasGanados() {
        // Implementación del reporte de equipo con más partidos ganados
        int maximo = -1;
        String equipoMaximo = "";
        for(int i=0; i< listaEquipos.size();i++){
            if (listaEquipos.get(i).getPg()> maximo){
                maximo = listaEquipos.get(i).getPg();
                equipoMaximo = listaEquipos.get(i).getNombre();
            };
        }
        System.out.println(equipoMaximo); 
    }


    private void reporteTotalGoles() {
        // Implementación del reporte de total de goles anotados
        int suma = 0;
        for(Equipo equipo: listaEquipos){
            suma += equipo.getGf(); 
        }
        System.out.println(suma);

    }

    private void reportePromedioGoles() {
        // Implementación del reporte de promedio de goles anotados
        int suma = 0;
        for(Equipo equipo: listaEquipos){
            suma += equipo.getGf(); 
        }
        System.out.println(suma/listaPartidos.size());

    }
}
