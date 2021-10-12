/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2s1;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class Reserva 
{
    private String fechaEntrada;
    private String fechaSalida;
    private Cliente clienteConReserva;
    private Hotel hotelReservado;
    
    public Reserva(String fechaEntrada, String fechaSalida, Cliente cliente, Hotel hotel)
    {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.clienteConReserva = cliente;
        this.hotelReservado = hotel;
        
        this.clienteConReserva.addReserva(this);
    }
    
    public String getFechaEntrada()
    {
        return this.fechaEntrada;
    }
    
    public Cliente getCliente()
    {
        return this.clienteConReserva;
    }
}
