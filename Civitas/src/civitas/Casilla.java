package civitas;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco.
 */
public class Casilla 
{   
    // Nombre de la casilla
    protected String Nombre;
    
    
    /* Metodos */
   
    /**
     * Constructor para casillas tipo DESCANSO
     * @param tipo      Tipo de casilla.
     * @param nombre    Nombre de la casilla.
     */
    Casilla(String nombre)
    {
        this.Nombre = nombre;
    }
    
    /** [?] No aparece en UML; ¿se borra?
     * @return Nombre de la casilla.
     */
    String getNombre()
    {
        return this.Nombre;
    }
    
    
    /**
     * @brief Informa al diario del jugador que ha caido en la casilla actual.
     * @param iactual Indice de la lista de jugadores.
     * @param todos   Lista de todos los jugadores.
     */
    void informe(int iactual, ArrayList<Jugador> todos)
    {
        if(0 <= iactual && iactual < todos.size())
        {
            Jugador temp = todos.get(iactual);
            String evento = ("[Casilla] " + temp.getNombre()+" ha caido en " + this.Nombre);
            Diario.getInstance().ocurreEvento(evento);
        }
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos)
    {           
        this.informe(iactual, todos);
    }
    
    /**
     * Obtener el estado actual del objeto.
     * @return Lista con los atributos y su estado.
     */
    public String toString()
    {
        String info;
 
        info = ("DESCANSO ("+ this.Nombre +")");

        return info;
    }
    

    
}
