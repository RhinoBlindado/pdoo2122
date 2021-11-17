package civitas;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class SorpresaPagarCobrar extends Sorpresa
{
    /**
     * Constructor con parámetros
     * @param texto Descripción de la Sopresa.
     * @param valor Valor de la sorpresa.
     */
    public SorpresaPagarCobrar(String texto, int valor) 
    {
        super(texto, valor);
    }
    
    /**
     * @brief Aplicar la sorpresa "PAGARCOBRAR"
     * @param actual    Índice del jugador actual.
     * @param todos     Lista de todos los jugadores.
     */
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos)
    {
        todos.get(actual).modificaSaldo(this.valor);
        informe(actual, todos);
    }

}
