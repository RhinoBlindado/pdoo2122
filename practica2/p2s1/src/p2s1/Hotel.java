/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2s1;

import java.util.ArrayList;

/**
 *
 * @author valentino
 */
public class Hotel 
{
    private static int NUM_HOTELES = 0;
    private String nombre;
    private String ciudad;
    private int estrellas;
    
    private Director director;
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    
    public Hotel(String nombre, String ciudad, int estrellas)
    {
        NUM_HOTELES++;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        this.director = null;
    }
    
    public int getNUM_HOTELES()
    {
        return NUM_HOTELES;
    }
    
    public void setDirector(Director director)
    {
        this.director = director;
    }
    
    public Director getDirector()
    {
        return this.director;
    }
    
    public void addReserva(Cliente cliente, String fchaEntrada, String fchaSalida)
    {
        this.reservas.add(new Reserva(fchaEntrada, fchaSalida, cliente, this));
    }
    
    public ArrayList<Reserva> getReservas()
    {
        return this.reservas;
    }
}
