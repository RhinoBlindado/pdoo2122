package civitas;

import java.util.ArrayList;

/**
 * Práctica 4
 * @author Lugli, Valentino Glauco
 */
public class CasillaSorpresa extends Casilla
{
    
    /* Atributos */

    // Mazo de la casilla
    MazoSorpresas mazo;
    
    //  Sorpresa
    Sorpresa sorpresa;
    
    
    /* Métodos */
    
    /**
     * Constructor para casillas tipo SORPRESA
     * @param tipo      Tipo de casilla.
     * @param nombre    Nombre de la casilla.
     * @param mazo      Objeto de tipo MazoSorpresas
     */
    CasillaSorpresa(String nombre, MazoSorpresas mazo)
    {
        super(nombre);
        this.mazo = mazo;
        this.sorpresa = null;
    }

    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos)
    {
        // 1
        this.sorpresa = this.mazo.siguiente();
        
        // 2
        this.informe(iactual, todos);
        
        // 3
        this.sorpresa.aplicarAJugador(iactual, todos);
    }  
    
    @Override
    public String toString()
    {
        String info;
             
        info = ("SORPRESA ("+ this.Nombre + ")");
        
        return info;
    }
    
}
