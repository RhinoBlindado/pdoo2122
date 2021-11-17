package civitas;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public abstract class Sorpresa 
{
    /* Atributos */
    protected String texto;
    protected int valor;
    
    /* Métodos */
    
    /**
     * @brief Aplicar la sorpresa a un jugador.
     * @param actual Índice del jugador actual.
     * @param todos  Lista de todos los jugadores.
     */
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);
    
    /**
     * @brief Informa al diario del jugador al que se le aplica una sorpresa al jugador.
     * @param iactual Indice de la lista de jugadores.
     * @param todos   Lista de todos los jugadores.
     */
    void informe(int iactual, ArrayList<Jugador> todos)
    {
        if(0 <= iactual && iactual < todos.size())
        {
            Jugador temp = todos.get(iactual);
            String evento = ("[Sorpesa] " + temp.getNombre()+" se le aplica " + this.toString());
            Diario.getInstance().ocurreEvento(evento);
        }
    }
    
    /**
     * @brief Constructor con parámetros de Sorpresa
     * @param texto
     * @param valor 
     */
    Sorpresa(String texto, int valor)
    {
        this.texto = texto;
        this.valor = valor;
    }
    
    /**
     * @return Lista el texto de Sorpresa.
     */
    public String toString()
    {
        return ("["+this.texto+"]");
    }
}
