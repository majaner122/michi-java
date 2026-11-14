package proyecto;

public class Tablero {

    private int[][] tablero = new int[3][3];

    public boolean colocarFicha(int fila, int columna, int numeroFicha) {
        verificarLinea(numeroFicha);
        if (tablero[fila][columna] == 0) {
            tablero[fila][columna] = numeroFicha;
            return true;
        } else {
            System.out.println("Casilla llena");
            return false;
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean verificarLinea(int numeroFicha) {
        int fila = 0, columna = 0, conteoFila, conteoColumna;
        boolean verificador = false;
        if (tableroLleno() == true) {
            System.out.println("El tablero se llenó");
            return verificador;
        } else {
            while (fila != 3 || columna != 3) {
                conteoFila = 0;
                for (int j = 0; j < tablero[fila].length; j++) {
                    if (tablero[fila][j] == numeroFicha) {
                        conteoFila++;
                    }
                }
                conteoColumna = 0;
                for (int i = 0; i < tablero[columna].length; i++) {
                    if (tablero[i][columna] == numeroFicha) {
                        conteoColumna++;
                    }
                }
                if (conteoFila == 3 || conteoColumna == 3) {
                    verificador = true;
                    break;
                }
                fila++;
                columna++;
            }
            int conteoDiag1 = 0, conteoDiag2 = 0;

            for (int i = 0; i < 3; i++) {
                if (tablero[i][i] == numeroFicha) {
                    conteoDiag1++;
                }
                if (tablero[i][2 - i] == numeroFicha) {
                    conteoDiag2++;
                }
            }
            if (conteoDiag1 == 3 || conteoDiag2 == 3) {
                verificador = true;
            }
            return verificador;
        }
    }

    public boolean tableroLleno() {
        boolean verificarLlenado = false;
        int conteo = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] != 0) {
                    conteo++;
                }
            }
        }
        if (conteo == 9) {
            verificarLlenado = true;
        }
        return verificarLlenado;
    }
}
