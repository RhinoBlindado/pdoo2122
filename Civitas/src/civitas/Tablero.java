package civitas;

import java.util.ArrayList;

/**
 * @author valentino
 */
public class Tablero 
{
    /* Atributos */

    // - Contenedor de las casillas del juego
    private ArrayList<Casilla> casillas;
    
    // - Booleano que representa si el jugador que tiene el turno ha pasado por la salida o no en dicho turno
    private boolean porSalida;
    
    /* Metodos */
    
    /**
     * Constructor sin parámetros.
     */
    Tablero()
    {
        this.casillas = new ArrayList<Casilla>();
        this.casillas.add(new Casilla("SALIDA"));
        this.porSalida = false;
    }

    /**
     * Verificar que el índice numCasilla es válido.
     * @param numCasilla    Índice
     * @return Verdadero si es un índice válido, Falso en caso contrario.
     */
    private boolean correcto(int numCasilla)
    {
        return (0 <= numCasilla && numCasilla < this.casillas.size());
    }
    
    /**
     * Devuelve el estado del atributo porSalida y luego lo pone a Falso.
     * @return Atributo porSalida 
     */
    boolean computarPorSalida()
    {
        boolean estatusActualporSalida = this.porSalida;
        this.porSalida = false;
        return estatusActualporSalida;
    }
    
    /**
     * Añade una casilla al tablero.
     * @param casilla
     */
    void añadeCasilla(Casilla casilla)
    {
        this.casillas.add(casilla);
    }
    
    /**
     * Devuelve la casilla en el índice indicado
     * @param numCasilla    Índice del tablero
     * @return Si el indice es correcto, la casilla, en caso contrario, null.
     */
    public Casilla getCasilla(int numCasilla)
    {
        if (correcto(numCasilla))
        {
            return this.casillas.get(numCasilla);
        }
        else
        {
           return null; 
        }
    }
    
    /**
     * @return Devuelve la lista de casillas del tablero.
     */
    public ArrayList<Casilla> getCasillas()
    {
        return this.casillas;
    }
    
    /**
     * Calcula la nueva posición en el tablero
     * @param actual Posición actual
     * @param tirada Resultado de una tirada
     * @return Nueva posición
     */
    int nuevaPosicion(int actual, int tirada)
    {
        int newPos = (actual + tirada) % casillas.size(); 
        
        if(newPos != actual + tirada)
        {
            this.porSalida = true;
        }
        
        return newPos;
    }
    
    // [?] No aparece en UML, ¿Se borra?
    int getNumCasillas()
    {
        return this.casillas.size();
    }
}
