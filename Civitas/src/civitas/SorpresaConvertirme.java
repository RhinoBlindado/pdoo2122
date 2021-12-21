package civitas;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class SorpresaConvertirme extends Sorpresa
{

    public SorpresaConvertirme(String texto, int valor) 
    {
        super(texto, valor);
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) 
    {
        Jugador jugador = todos.get(actual);
        JugadorEspeculador gangster = jugador.convertir();

        if(gangster != null)
        {
            todos.remove(actual);
            todos.add(actual, gangster);
        
            this.informe(actual, todos);
        }
    }
    
}
