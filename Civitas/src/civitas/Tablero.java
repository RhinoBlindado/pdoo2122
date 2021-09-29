/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author valentino
 */
public class Tablero 
{
    /* ATRIBUTOS:
    *************/
    
    // - Contenedor de las casillas del juego
    ArrayList<Casilla> casillas;
    
    // - Booleano que representa si el jugador que tiene el turno ha pasado por la salida o no en dicho turno
    boolean porSalida;
    
    // CONSTRUCTORES
    // - Constructor con visibilidad de paquetes sin parámetros.
    Tablero()
    {
        this.casillas = new ArrayList<Casilla>();
        this.casillas.add(new Casilla(TipoCasilla.CALLE, "Salida", 0, 0, 0));
        this.porSalida = false;
    }

    /* METODOS:
    *************/
    
    boolean correcto(int numCasilla)
    {
        return (numCasilla < this.casillas.size());
    }
    
    boolean computarPasoPorSalida()
    {
        boolean estatusActualporSalida = this.porSalida;
        this.porSalida = false;
        return estatusActualporSalida;
    }
    
    // - Añade la casilla pasada por parámetro.
    void añadeCasilla(Casilla casilla)
    {
        this.casillas.add(casilla);
    }
    
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
    
    int nuevaPosicion(int actual, int tirada)
    {
        int newPos = (actual + tirada) % casillas.size(); 
        
        if(newPos != actual + tirada)
        {
            this.porSalida = true;
        }
        
        return newPos;
    }
}
