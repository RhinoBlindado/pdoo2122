package civitas;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class GestionInmobiliaria 
{
    private int propiedad;
    private OperacionInmobiliaria operacion;
    
    public GestionInmobiliaria(OperacionInmobiliaria gest, int ip)
    {
        this.propiedad = ip;
        this.operacion = gest;
    }
    
    OperacionInmobiliaria getOperacion()
    {
        return this.operacion;
    }
    
    int getPropiedad()
    {
        return this.propiedad;
    }
}
