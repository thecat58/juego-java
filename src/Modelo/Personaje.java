/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;


public abstract class Personaje {
    private String nombre;
    private int vida;
    private int energia;
    private ArrayList<Objeto> inventario;

    public Personaje(String nombre, int vida, int energia){
        this.nombre = nombre;
        this.vida = vida;
        this.energia = energia;
        this.inventario = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public ArrayList<Objeto> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Objeto> inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", vida=" + vida + ", energia=" + energia + ", inventario=" + inventario + '}';
    }

    

    public void Agregar_Objeto(Objeto obj){
        inventario.add(obj);
    }
    
    abstract void Usar_Objeto(Objeto obj);  
}
