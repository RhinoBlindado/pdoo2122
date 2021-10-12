package p2s1;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class Director 
{
    private String nombre;
    private long telefono;
    
    public Director(String nombre, long telefono)
    {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
}
