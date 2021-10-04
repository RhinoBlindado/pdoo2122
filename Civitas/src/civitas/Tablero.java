package civitas;

import java.util.ArrayList;

/**
 * @author valentino
 */
public class Tablero 
{
    /* ATRIBUTOS:
    *************/
    
    /* INSTANCIA */
    // - Contenedor de las casillas del juego
    private ArrayList<Casilla> casillas;
    
    // - Booleano que representa si el jugador que tiene el turno ha pasado por la salida o no en dicho turno
    private boolean porSalida;
    
    /* METODOS:
    *************/
    
    /* INSTANCIA */
    
    /**
     * @brief Constructor sin parámetros.
     */
    Tablero()
    {
        this.casillas = new ArrayList<Casilla>();
        this.casillas.add(new Casilla(TipoCasilla.DESCANSO, "Salida", 0, 0, 0));
        this.porSalida = false;
    }

    /**
     * @brief Verificar que el índice numCasilla es válido.
     * @param numCasilla    Índice
     * @return Verdadero si es un índice válido, Falso en caso contrario.
     */
    private boolean correcto(int numCasilla)
    {
        return (numCasilla < this.casillas.size());
    }
    
    /**
     * @brief Devuelve el estado del atributo porSalida y luego lo pone a Falso.
     * @return Atributo porSalida 
     */
    boolean computarPasoPorSalida()
    {
        boolean estatusActualporSalida = this.porSalida;
        this.porSalida = false;
        return estatusActualporSalida;
    }
    
    /**
     * @brief Añade una casilla al tablero.
     * @param casilla
     */
    void añadeCasilla(Casilla casilla)
    {
        this.casillas.add(casilla);
    }
    
    /**
     * @brief Devuelve la casilla en el índice indicado
     * @param numCasilla    Índice del tablero
     * @return Si el indice es correcto, la casilla, en caso contrario, null.
     */
    Casilla getCasilla(int numCasilla)
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
     * @brief Calcula la nueva posición en el tablero
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
    
    int getNumCasillas()
    {
        return this.casillas.size();
    }
}
