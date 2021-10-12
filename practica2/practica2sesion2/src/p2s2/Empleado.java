package p2s2;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class Empleado 
{
    private String nombre;
    private ArrayList<Hotel> trabaja;
    
    public Empleado(String nombre)
    {
        this.nombre = nombre;
        this.trabaja = new ArrayList<Hotel>();
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public boolean addTrabajo(Hotel hotel)
    {
        boolean canWork = false;
        
        // Controlando si sobrepasa o no el número de hoteles permitido para trabajar.
        if(this.trabaja.size() < 2)
        {
            this.trabaja.add(hotel);
            canWork = true;
        }
        
        return canWork;
    }
    
}
