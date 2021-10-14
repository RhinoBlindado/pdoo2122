package civitas;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class Sorpresa 
{
    /* Atributos */
    private TipoSorpresa tipo;
    private String texto;
    private int valor;
    
    /* Métodos */
    
    /**
     * @brief Aplicar la sorpresa a un jugador.
     * @param actual Índice del jugador actual.
     * @param todos  Lista de todos los jugadores.
     */
    void aplicarAJugador(int actual, ArrayList<Jugador> todos)
    {
        if(this.tipo == TipoSorpresa.PAGARCOBRAR)
        {
            aplicarAJugador_pagarCobrar(actual, todos);
        }
        else if(this.tipo == TipoSorpresa.PORCASAHOTEL)
        {
            aplicarAJugador_porCasaHotel(actual, todos);
        }
    }
    
    /**
     * @brief Aplicar la sorpresa "PAGARCOBRAR"
     * @param actual    Índice del jugador actual.
     * @param todos     Lista de todos los jugadores.
     */
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos)
    {
        todos.get(actual).modificaSaldo(this.valor);
        informe(actual, todos);
    }
    
    /**
     * @brief Aplicar la sorpresa "PORCASAHOTEL"
     * @param actual    Índice del jugador actual.
     * @param todos     Lista de todos los jugadores.
     */
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos)
    {
        Jugador act = todos.get(actual);
        act.modificaSaldo(this.valor * act.cantidadCasasHoteles());
    }
    
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
            String evento = ("Sorpesa: Jugador" + temp.getNombre()+" se le aplica" + this.toString());
            Diario.getInstance().ocurreEvento(evento);
        }
    }
    
    /**
     * @brief Constructor con parámetros de Sorpresa
     * @param sorpresa
     * @param texto
     * @param valor 
     */
    Sorpresa(TipoSorpresa sorpresa, String texto, int valor)
    {
        this.tipo = sorpresa;
        this.texto = texto;
        this.valor = valor;
    }
    
    /**
     * @return Lista el texto de Sorpresa.
     */
    public String toString()
    {
        return ("Sorpresa (Texto: "+this.texto+")");
    }
}
