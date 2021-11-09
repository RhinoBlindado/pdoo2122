/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.Random;

/**
 *
 * @author valentino
 */
public class Dado 
{
    
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    
    static final private Dado instance = new Dado();
    
    
    /**
     * @brief Constructor sin parámetros.
     */
    Dado()
    {
        this.ultimoResultado = -1;
        this.debug = false;
    }

    /**
     * @brief Realizar una tirada de un dado de 6 caras.
     * @return Resultado de la tirada.
     */
    int tirar()
    {
        int result;
        
        if(debug)
        {
            result = 1;
        }
        else
        {
            result = random.nextInt(6) + 1;
        }
        
     //   Diario.getInstance().ocurreEvento("[Dado] Tirada ["+result+"]");

        this.ultimoResultado = result;
        
        return result;
    }
    
    /**
     * @brief Determinar que jugador empieza.
     * @param n     Número de jugadores
     * @return Jugador seleccionado al azar.
     */
    int quienEmpieza(int n)
    {
        return random.nextInt(n);
    }
    
    /**
     * @brief Activar o Desactivar el modo debug
     * @param d     Booleano indicado el estado a que se desea poner el Dado.
     */
    void setDebug(boolean d)
    {
        Diario di = Diario.getInstance();
        
        if (d)
            di.ocurreEvento("[Dado] Debug activado");
        else
            di.ocurreEvento("[Dado] Debug desactivado");

        this.debug = d;
    }
    
    /**
     * @see Practica 1
     * @return Ultimo resultado de la tirada del dado.
     */
    int getUltimoResultado()
    {
        return this.ultimoResultado;
    }
    
    /**
     * @return Instancia de la clase Dado.
     */
    static Dado getInstance()
    {
        return instance;
    }
}
