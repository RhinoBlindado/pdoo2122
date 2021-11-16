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
