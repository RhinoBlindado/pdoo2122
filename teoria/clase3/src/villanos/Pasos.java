package villanos;

import java.util.Date;

/**
 *
 * @author Lugli, Valentino Glauco
 */
class Pasos {
    private String descripcion;
    private Date fechaLimite;
    private boolean terminado;
    private int inversion;
    private int ganancia;
    
    Pasos(String descripcion, Date fechaLim, int inversion, int ganancia)
    {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLim;
        this.terminado = false;
        this.inversion = inversion;
        this.ganancia = ganancia;
    }
    
    public int getInversion()
    {
        return this.inversion;
    }
    
    public int getGanancia()
    {
        return this.ganancia;
    }
    
    public void setTerminado(boolean estado)
    {
        this.terminado = estado;
    }
}
