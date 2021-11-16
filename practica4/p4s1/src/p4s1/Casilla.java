package p4s1;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class Casilla 
{
    private String nombre;
    
    Casilla(String nombre)
    {
        this.nombre = nombre;
    }
    
    boolean recibeJugador()
    {
        System.out.println("Se ha recibido un jugador");
        return true;
    }
    

}
