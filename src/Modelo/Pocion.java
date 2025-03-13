/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Pocion extends Objeto{
    private int Curacion;

    public Pocion(String nombre, int Curacion) {
        super(nombre);
        this.Curacion = Curacion;
    }

    public int getCuracion() {
        return Curacion;
    }

    public void setCuracion(int Curacion) {
        this.Curacion = Curacion;
    }

    @Override
    public String toString() {
        return "Posion{" + "Dano=" + Curacion + '}';
    }

    @Override
    public int usar() {
        return Curacion;
    }

    
}
