package Modelo;

public class Arma extends Objeto {
    private String nombre;
    private int dano;

    public Arma(String nombre, int dano) {
        super(nombre);
        this.nombre = nombre;
        this.dano = dano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    @Override
    public String toString() {
        return "Arma{" + "nombre=" + nombre + ", dano=" + dano + '}';
    }

    @Override
    int usar() {
        return getDano();
    }
}
