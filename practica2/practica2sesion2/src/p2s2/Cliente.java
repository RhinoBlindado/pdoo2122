package p2s2;

import java.util.ArrayList;

/**
 *
 * @author valentino
 */
public class Cliente 
{
    private String dni;
    private String nombre;
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    
    public Cliente(String dni, String nombre)
    {
        this.dni = dni;
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void addReserva(Reserva reserva)
    {
        this.reservas.add(reserva);
    }
    
    public ArrayList<Reserva> getReservas()
    {
        return this.reservas;
    }
}
