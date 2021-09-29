/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author valentino
 */
public class MazoSorpresas 
{
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init()
    {
        this.sorpresas = new ArrayList<Sorpresa>();
        this.barajada = false;
        this.usadas = 0;
    }
    
    MazoSorpresas(boolean debug)
    {
        init();
        this.debug = debug;

        if(debug)
        {
            Diario.getInstance().ocurreEvento("MazoSorpresas: Debug activado");
        }
    }
    
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
        if(!this.debug && (!this.barajada || this.usadas == sorpresas.size()))
        {
            Collections.shuffle(this.sorpresas);
            this.usadas = 0;
            this.barajada = true;
        }
        
        this.usadas++;
        Sorpresa sorpresaActual = this.sorpresas.get(0);
        
        this.sorpresas.add(this.sorpresas.get(0));
        this.sorpresas.remove(0);
        
        return sorpresaActual;
    }
}
