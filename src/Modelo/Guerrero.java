/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import Control.Ataque;

public class Guerrero extends Personaje implements Ataque {

    public Guerrero(String nombre) {
        super(nombre, 100, 50);
    }

    @Override
    public int atacar(Personaje enemigo, Objeto obj) {
        int cont = 5;
        int dano = 0;
        int curacion = 0;

        // Verificar si el enemigo tiene vida
        if (enemigo.getVida() > 0) {
            dano = obj.usar();
            enemigo.setVida(enemigo.getVida() - dano);

            // Verificar si el guerrero tiene suficiente energía
            if (this.getEnergia() < 20) {
                System.out.println("\n!!! No tienes energía. Debes usar la poción !!!");
            } else {
                this.setEnergia(getEnergia() - 20);
            }
        } else {
            // Curar al enemigo si tiene poca energía
            if (enemigo.getVida() > 0 && enemigo.getEnergia() < 20) {
                curacion = obj.usar();
                enemigo.setVida(enemigo.getVida() + curacion);
            }
        }

        cont -= 1;
        System.out.println("\nHas atacado a " + enemigo.getNombre());
        return cont;
    }

    @Override
    public void usarObjeto(Objeto obj) {
        int cont = 0;
        int curacion = 0;
        int open = 0;

        // Verificar si se puede usar el objeto
        if (cont <= 1) {
            if (obj.getNombre().equals("Pocion")) {
                curacion = obj.usar();
                this.setEnergia(getEnergia() + curacion);
            } else {
                open = obj.usar();
                if (open == 1) {
                    System.out.println("FELICITACIONES!!! HAS PASADO AL SIGUIENTE NIVEL!!! ");
                }
            }
        } else {
            System.out.println("No tienes más poción");
        }
    }

    public void agregarObjeto(Objeto obj) {
        getInventario().add(obj);
        System.out.println(obj.getNombre() + " ha sido agregado al inventario de " + getNombre());
    }

    public void agregarObjeto(Arma ObjArma) {
        getInventario().add(ObjArma);
        System.out.println(ObjArma.getNombre() + " ha sido agregado al inventario de " + getNombre());
    }

    public void agregarObjeto(Pocion ObjPocion) {
        getInventario().add(ObjPocion);
        System.out.println(ObjPocion.getNombre() + " ha sido agregado al inventario de " + getNombre());
    }

    public void agregarObjeto(Llave ObjLlave) {
        getInventario().add(ObjLlave);
        System.out.println(ObjLlave.getNombre() + " ha sido agregado al inventario de " + getNombre());
    }

    // Métodos para editar atributos
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
}