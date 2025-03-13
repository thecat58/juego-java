/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Control.Ataque;

public class Guerrero extends Personaje implements Ataque{
  
    public Guerrero(String nombre){
        super(nombre, 100, 50);
   
    }
    @Override
    public int atacar(Personaje enemigo, Objeto obj) {
        int cont=5;
        int dano=0;
        int curacion=0;
        if(enemigo.getVida()>0){
            dano=obj.usar();
            enemigo.setVida(enemigo.getVida()-dano);
            if(this.getEnergia()<20){
                System.out.println("\n!!! No tienes energia. Debes usar la pocion !!!");
            }else{
                this.setEnergia(getEnergia()-20);
            }
        }else{
            if(enemigo.getVida()>0 && enemigo.getEnergia()<20){
                curacion=obj.usar();
                enemigo.setVida(enemigo.getVida()+curacion);
            }    
        }
        cont-=1;
        System.out.println("\nHas atacado a " + enemigo.getNombre());
        return cont;
        
    } 

    @Override
    public void Usar_Objeto(Objeto obj) {
        int cont=0;
        int curacion=0;
        int open=0;
        if(cont<=1){
            if(obj.getNombre()== "Pocion"){
            curacion = obj.usar();
            this.setEnergia(getEnergia()+curacion);
            }
            else{
               open=obj.usar();
               if(open==1){
                   System.out.println("FELICITACIONES!!! HAS PASADO AL SIGUIENTE NIVEL!!! ");
               }
            }
        }else{
            System.out.println("No tienes mas pocion");
        }
    }
}
