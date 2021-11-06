package villanos;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
class ObjetivoMaligno 
{
    private String descripcion;
    
    ObjetivoMaligno(String descripcion)
    {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion()
    {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

}
