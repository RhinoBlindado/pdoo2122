package villanos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lugli, Valentino Glauco
 */
class Plan 
{
    private ObjetivoMaligno objetivo;
    
    private String nombre;
    private Date fechaConsecucion;
    private int prioridad;
    private int posicionPasoSiguiente;
    private boolean terminado;
    
    ArrayList<Pasos> pasos;
    
    Plan(String nombre, Date fechaCon, int prioridad)
    {
        this.nombre = nombre;
        this.fechaConsecucion = fechaCon;
        this.prioridad = prioridad;
        this.posicionPasoSiguiente = 0;
        this.terminado = false;
    }
    
    public boolean getTerminado()
    {
        return this.terminado;
    }
    
    public boolean estaActivo()
    {
        throw new UnsupportedOperationException("No implementado");
    }
    
    public void darPasoSiguiente()
    {
        throw new UnsupportedOperationException("No implementado");
    }
    
    public int inversionPasoSiguiente()
    {
        throw new UnsupportedOperationException("No implementado");
    }
}
