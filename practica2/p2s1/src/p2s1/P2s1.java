/*
 * [CASTELLANO]
 * Ejercicios - Practica 2, Sesion 1
 * Asignatura: Programación y Diseño Orientado a Objetos
 * Autor: Valentino Lugli (Github: @RhinoBlindado)
 * Fecha: Septiembre, Octubre 2021
 */

/*
 * [ENGLISH]
 * Exercises - Practice 2, Sesion 1
 * Course: Object Oriented Programming and Design
 * Author: Valentino Lugli (Github: @RhinoBlindado)
 * Date: September, October 2021
 */
package p2s1;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class P2s1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("PRACTICA 2 SESION 1:");
        
        System.out.println("EJ 1.1");
        
        Hotel h1 = new Hotel("Undead Asylum", "North of Lodran", 1);
        System.out.println("- Hotel creado. Contador: " + h1.getNUM_HOTELES());
        Hotel h2 = new Hotel("Anor Londo", "Lodran", 5);
        System.out.println("- Segundo Hotel creado. Contador: " + h1.getNUM_HOTELES());
        
        System.out.println("EJ 1.2");
        
        Director d1 = new Director("Oscar de Astora", 003472321234);
        h1.setDirector(d1);
        
        System.out.println("- El director del primer hotel es " + h1.getDirector().getNombre());
                
        System.out.println("EJ 1.3");
        
        Cliente c1 = new Cliente("X1234567Z", "Gwynevere");
        h1.addReserva(c1, "05/10/2021", "31/10/2021");
        ArrayList<Reserva> r1 = h1.getReservas(), r2 = c1.getReservas();
        
        System.out.println("- Reservas del 2do Hotel: ");
        
        for(int i = 0; i<r1.size(); i++)
        {
            System.out.println("-- Reserva "+i+" - Cliente: " + r1.get(i).getCliente().getNombre() + " - Fecha de Entrada: " + r1.get(i).getFechaEntrada());
        }
        
        System.out.println("- Reservas del Cliente: ");
        
        for(int i = 0; i<r1.size(); i++)
        {
            System.out.println("-- Reserva "+i+" - Cliente: " + r2.get(i).getCliente().getNombre() + " - Fecha de Entrada: " + r2.get(i).getFechaEntrada());
        }

    }
    
}
