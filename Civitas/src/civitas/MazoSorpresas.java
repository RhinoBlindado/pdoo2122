package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class MazoSorpresas 
{
    /* Atributos */

    // Almacenar las cartas Sorpresa
    private ArrayList<Sorpresa> sorpresas;
    // Indica si se ha barajado o no el mazo.
    private boolean barajada;
    // Cuenta el número de cartas del mazo que han sido barajadas.
    private int usadas;
    // Permite activar o desactivar el modo debug.
    private boolean debug;
        
    /* Métodos */
     
    /**
     * @brief Inicializa por defecto el estado del Mazo.
     */
    private void init()
    {
        this.sorpresas = new ArrayList<>();
        this.barajada = false;
        this.usadas = 0;
    }
    
    /**
     * @brief Constuctor con parámetro
     * @param debug     Indica si se desea activar o no el modo debug.
     */
    MazoSorpresas(boolean debug)
    {
        init();
        this.debug = debug;

        if(debug)
        {
            Diario.getInstance().ocurreEvento("[MazoSorpresas]: Debug activado");
        }
    }
    
    /**
     * @brief Constructor sin parámetros
     */
    MazoSorpresas()
    {
        init();
        this.debug = false;
    }
    
    void alMazo(Sorpresa s)
    {
        // Si el mazo no ha sido barajado, se puede añadir una sorpresa.
        if(!this.barajada)
        {
            sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente()
    {
        /* 
         * Si el mazo no ha sido barajado o si el número de cartas usadas es igual al tamaño del mazo, 
         * se baraja el mazo (salvo que el modo debug esté activo), se fija el valor de usadas a cero 
         * y el de barajada a true. 
         */
        if(!this.barajada || this.usadas == sorpresas.size())
        {
            if (!this.debug)
                Collections.shuffle(this.sorpresas);
            
            this.usadas = 0;
            this.barajada = true;
        }
        
        /*
         * Se incrementa el valor de usadas, se quita la primera carta sorpresa de la colección
         * de sorpresas, se añade al final de la misma, se guarda en una variable local de 
         * tipo Sorpresa y se devuelve una referencia a esa carta sorpresa. 
         */
        
        this.usadas++;
        
        Sorpresa sorpresaActual = this.sorpresas.get(0);

        this.sorpresas.add(sorpresaActual);
        this.sorpresas.remove(0);

        return sorpresaActual;
    }
}
