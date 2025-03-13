/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Control.Ataque;
import java.util.ArrayList;


public class Mago extends Personaje implements Ataque{
   
    public Mago(String nombre) {
        super(nombre, 100, 50);
    }

    @Override
    public int atacar(Personaje enemigo, Objeto obj) {
        int cont=5;
        int dano=0;
        System.out.println("\n!!! Oh noo "+getNombre()+ " lanzo un hechizo a tu guerrero!!!");
        if(enemigo.getVida()>0 & enemigo.getEnergia()>0){
            enemigo.setVida(enemigo.getVida()-20);
            this.setEnergia(getEnergia()-20);
        }else{
            if(this.getEnergia()<20){
                System.out.println("!!! Merlin no tiene energia para lanzar un hechizo !!!"); 
            }
        }
        cont-=1;
        return cont;
    }

    @Override
    void Usar_Objeto(Objeto obj) {
        int curacion=0;
        curacion=obj.usar();
        this.setEnergia(getEnergia()+curacion);
    }
}
