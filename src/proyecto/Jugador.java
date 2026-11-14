package proyecto;

public class Jugador {
    public String nombre;
    private int puntos = 0;
    public int numeroFicha;

    public Jugador(String nombre, int numeroFicha) {
        this.nombre = nombre;

        this.numeroFicha = numeroFicha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    private void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(int numeroFicha) {
        this.numeroFicha = numeroFicha;
    }
}
