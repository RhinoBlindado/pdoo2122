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
     /*  Casilla casilla = new Casilla("Pillar of Autumn");
        CasillaCalle casCalle = new CasillaCalle("Kiwami");
        
        casCalle.recibeJugador();
        casilla.recibeJugador();

        
        ArrayList<Casilla> tablero = new ArrayList<>();
        
        tablero.add(casilla);
        tablero.add(casCalle);
        
        ((CasillaCalle) tablero.get(1)).construirCasa();
    */
        CasillaCalle casilla1 = new CasillaCalle("High Charity");
        Casilla casilla2;
        
        casilla2 = (Casilla) casilla1;
        
        casilla1.recibeJugador();
        ((Casilla) casilla2).recibeJugador();
        
        casilla1.construirCasa();
        ((CasillaCalle) casilla2).construirCasa();
       
    }
    
}
