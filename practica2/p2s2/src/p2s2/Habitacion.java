package p2s2;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class Habitacion 
{
    private int numero;
    private int capacidad;
    
    // [?] ¿Navegabilidad? ¿Debería tener un atributo Hotel?
    public Habitacion(int numero, int capacidad)
    {
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
    public int getCapacidad()
    {
        return this.capacidad;
    }
    
    public int getNumero()
    {
        return this.numero;
    }
}
