/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package Modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
    protected String nombre;
    protected int vida;
    protected int energia;
    protected List<Objeto> inventario;

    public Personaje(String nombre, int vida, int energia) {
        this.nombre = nombre;
        this.vida = vida;
        this.energia = energia;
        this.inventario = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
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

    public List<Objeto> getInventario() {
        return inventario;
    }

    public void Agregar_Objeto(Objeto obj) {
        inventario.add(obj);
    }

    public abstract void usarObjeto(Objeto obj);
}