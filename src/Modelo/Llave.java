/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Llave extends Objeto {
    private String nombre;
    public Llave(String nombre) {
        super(nombre);
    }
    public Boolean Abrir(Personaje Ganador){
        Boolean bandera = false;
        if (Ganador.getVida()>0){
            bandera = true;
        }
        return bandera;
    }   

    @Override
    int usar() {
        return 1;
    }
}
