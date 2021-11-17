/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4s1;

import java.util.ArrayList;

/**
 *
 * @author valentino
 */
public class P4s1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /*
        Casilla casilla = new Casilla("Pillar of Autumn");
        CasillaCalle casCalle = new CasillaCalle("Kiwami");
        
        casilla.recibeJugador();
        casCalle.recibeJugador();
        
        // 1. Llama el del padre, porque no hay redefinición.
        // 2. Llama el suyo propio.
        // 3. Ejecuta su método propio.
        // 4. Creando el arrayList 
        
        ArrayList<Casilla> tablero = new ArrayList<>();
        
        tablero.add(casilla);
        tablero.add(casCalle);
        // - Si no se hace el casting da error, independientemente de que cassila sea.
        // - No se puede construir una casa en la casilla Casilla
        // - En una de tipo calle, sí
        // - Para que funcione, se debe de hacer un casting.
        ((CasillaCalle) tablero.get(1)).construirCasa();
        */
        
        CasillaCalle casilla1 = new CasillaCalle("High Charity");
        Casilla casilla2;
        
        casilla2 = (Casilla) casilla1;
        
        // - Ambos métodos llaman al del hijo, porque ambas variables apuntan a una CasillaCalle.
        casilla1.recibeJugador();
        casilla2.recibeJugador();
        
        // - Se tiene que hacer casting. Se tienen dos casas porque son dos variables que apuntan al mismo objeto.
        casilla1.construirCasa();
        ((CasillaCalle) casilla2).construirCasa();
    }
    
}
