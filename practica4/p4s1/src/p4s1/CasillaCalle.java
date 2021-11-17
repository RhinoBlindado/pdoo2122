package p4s1;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class CasillaCalle extends Casilla
{

    private int numCasas;
    
    CasillaCalle(String nombre)
    {
        super(nombre);
    }
    
    /* 2
    boolean recibeJugador()
    {
        System.out.println("Soy una casilla calle y recibo un jugador");
        return true;
    }
    */

    // 3
    // Reutilizando código del padre.
    @Override
    boolean recibeJugador()
    {
        if(super.recibeJugador())
        {
            System.out.println("y soy una casilla calle.");
            return true;
        }
        else
        {
            return false;
        }
        
    }
 
    void construirCasa()
    {
        this.numCasas++;
        System.out.println("Numero de casas: "+this.numCasas);
    }
}
