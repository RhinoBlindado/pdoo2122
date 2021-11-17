package civitas;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class SorpresaPorCasaHotel extends Sorpresa
{
    /**
     * Constructor con parámetros
     * @param texto Descripción de la Sopresa.
     * @param valor Valor de la sorpresa.
     */
    public SorpresaPorCasaHotel(String texto, int valor) 
    {
        super(texto, valor);
    }

    /**
     * @brief Aplicar la sorpresa "PORCASAHOTEL"
     * @param actual    Índice del jugador actual.
     * @param todos     Lista de todos los jugadores.
     */
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) 
    {
        Jugador act = todos.get(actual);
        act.modificaSaldo(this.valor * act.cantidadCasasHoteles());
        informe(actual, todos);
    }    
}
