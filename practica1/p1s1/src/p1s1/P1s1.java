/*
 * [CASTELLANO]
 * Ejercicios - Practica 1 Sesión 1 (Java)
 * Asignatura: Programación y Diseño Orientado a Objetos
 * Autor: Valentino Lugli (Github: @RhinoBlindado)
 * Fecha: Septiempre 2021
 */

/*
 * [ENGLISH]
 * Exercises - Practice 1 Session 1 (Java)
 * Course: Object Oriented Programming and Design
 * Author: Valentino Lugli (Github: @RhinoBlindado)
 * Date: September 2021
 */
package p1s1;

public class P1s1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("EJERCICIO 1");
        Parcela p1 = new Parcela("Firelink", 10, 20, 500);
        p1.construirCasa();
        System.out.println(p1.getPrecioAlquilerCompleto());
        Parcela p2 = p1;
        Parcela p3 = new Parcela("Firelink", 10, 20, 500);
        p3.construirCasa();
        System.out.println(p1.igualdadIdentidad(p2));
        System.out.println(p1.igualdadIdentidad(p3));
        System.out.println(p2.igualdadIdentidad(p1));    
    }   
}
