package proyecto;

import java.util.Scanner;

public class Proyecto {

    public static void main(String[] args) {
        int ficha1, ficha2;
        Tablero tablero = new Tablero();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos del primer jugador");

        System.out.println("Ingrese el nombre del jugador 1");

        String nombre1 = scan.nextLine();
        System.out.println("Seleccione ficha 1 o 2");
        do {
            ficha1 = scan.nextInt();
            if (ficha1 < 1 || ficha1 > 2) {
                System.out.println("Numero invalido, ingresar 1 o 2");
            }
        } while (ficha1 > 2 || ficha1 < 1);

        Jugador jugador1 = new Jugador(nombre1, ficha1);

        scan.nextLine();

        System.out.println("Ingrese los datos del segundo jugador");
        System.out.println("Ingrese el nombre del jugador 2");
        String nombre2 = scan.nextLine();
        ficha2 = Math.abs(ficha1 - 3);
        System.out.println("Tu ficha es " + ficha2);

        Jugador jugador2 = new Jugador(nombre2, ficha2);

        Jugador actual = jugador1;
        while (!tablero.tableroLleno()) {
            tablero.mostrarTablero();
            System.out.println("Ingresar fila");
            int fila;
            do {
                fila = scan.nextInt();
                if (fila < 0 || fila > 2) {
                    System.out.println("Numero invalido, ingresar numero del 0 al 2");
                }
            } while (fila > 2 || fila < 0);

            System.out.println("Ingresar columna");
            int columna;
            do {
                columna = scan.nextInt();
                if (columna < 0 || columna > 2) {
                    System.out.println("Numero invalido, ingresar numero del 0 al 2");
                }
            } while (columna > 2 || columna < 0);
            
            tablero.colocarFicha(fila, columna, actual.getNumeroFicha());
            if (tablero.verificarLinea(actual.getNumeroFicha()) == true) {
                break;
            }
            if (actual == jugador1) {
                actual = jugador2;
            } else {
                actual = jugador1;
            }
        }
        if (tablero.tableroLleno() == true) {
            System.out.println("No hay ganador, el tablero se llenó");
        } else if (tablero.verificarLinea(actual.getNumeroFicha()) == true) {
            System.out.println("El ganador es " + actual.getNombre());
        }

    }

}
