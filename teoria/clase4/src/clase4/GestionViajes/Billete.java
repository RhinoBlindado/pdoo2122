package clase4.GestionViajes;

import Maquinaria.Asiento;
import java.util.Date;

/**
 * Revisado - OK
 * @author Lugli, Valentino Glauco
 */
class Billete 
{
    private static float recaudacion = 0;
    private static int billetesVendidos = 0;
    
    private Date fecha;
    private float precio;
    
    private Asiento asiento;
    private Parada inicio, fin;
    private Tren tren;
    private Pasajero pasajero;
    
    Billete()
    {
        
    }
    
    public static float getRecaudacion()
    {
        return recaudacion;
    }
            
    public static int getNumBilletes()
    {
        return billetesVendidos;
    }
    
    public Date getFecha()
    {
        return this.fecha;
    }
    
    public float getPrecio()
    {
        return this.precio;
    }
    
    public void liberar()
    {
        
    }

}
