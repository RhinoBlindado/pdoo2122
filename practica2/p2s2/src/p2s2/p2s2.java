/*
 * [CASTELLANO]
 * Ejercicios - Practica 2, Sesion 2
 * Asignatura: Programación y Diseño Orientado a Objetos
 * Autor: Valentino Lugli (Github: @RhinoBlindado)
 * Fecha: Octubre 2021
 */

/*
 * [ENGLISH]
 * Exercises - Practice 2, Sesion 2
 * Course: Object Oriented Programming and Design
 * Author: Valentino Lugli (Github: @RhinoBlindado)
 * Date: October 2021
 */
package p2s2;

import java.util.ArrayList;

public class p2s2 
{

    public static void main(String[] args) 
    {

        System.out.println("PRACTICA 2 SESION 2:");
        
        /* SESION 1 */
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
        
        /* SESION 2 */
        Empleado e1 = new Empleado("Solaire de Astora");
        System.out.println("EJ 2.1");
        System.out.println("- Añadiendo empleado "+e1.getNombre()+" al primer Hotel.");
        System.out.println("- ¿Se puede? "+h1.addEmpleado(e1));
        System.out.println("- Este hotel tiene "+h1.getEmpleado().size()+" total de empleado(s).");
        
        System.out.println("EJ 2.2");
        
        h1.addHabitacion(69, 3);
        h1.addHabitacion(420, 10);
        
        System.out.println("- Se añade una habicacion con capacidad de 10 personas y otra de 3.");
     
        System.out.println("- Buscando la primera habitacion que tenga al menos 4 personas de capacidad: "+h1.buscarHabitacionCapacidad(4));
        System.out.println("- Ahora de 1: "+h1.buscarHabitacionCapacidad(1));
        System.out.println("- Ahora de 11: "+h1.buscarHabitacionCapacidad(11));     

    }
    
}
