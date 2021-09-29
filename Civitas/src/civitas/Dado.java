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
    /* ATRIBUTOS:
    *************/
    
    /* INSTANCIA */
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    
    /* CLASE */
    static final private Dado instance = new Dado();
    
    /* METODOS:
    *************/
    
    /* INSTANCIA */
    
    // CONSTRUCTORES
    // - Constructor sin parámetros 
    Dado()
    {
        this.ultimoResultado = -1;
        this.debug = false;
    }

    // CONSULTORES
    
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
        
        return result;
    }
    
    int quienEmpieza(int n)
    {
        return random.nextInt(n);
    }
    
    void setDebug(boolean d)
    {
     //   Diario di = Diario.getInstance();
        
        if (d)
            Diario.getInstance().ocurreEvento("Dado: Debug activado");
        else
            Diario.getInstance().ocurreEvento("Dado: Debug desactivado");

        this.debug = d;

    }
    
    int getUltimoResultado()
    {
        return this.ultimoResultado;
    }
    
    /* CLASE */
    
    // CONSULTORES
    static Dado getInstance()
    {
        return instance;
    }
}
