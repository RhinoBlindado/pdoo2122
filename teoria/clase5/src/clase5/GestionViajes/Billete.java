
package clase5.GestionViajes;

import java.util.Date;
import maquinaria.Asiento;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
class Billete {
    
    //Atributos básicos:
    private static float recaudacion;
    private static int billetesVendidos;
    private Date fecha;
    private float precio;
    
    //Atributos de referencia
    
    private Parada inicio; //mantenemos el nombre de la variable que indica el rol de la asociación
    private Parada fin; //idem
    
    private Pasajero pasajero;
    private Tren tren;
            /** La clase asociación queda:
             * Tren -1-----1..*- Billete -1..*----1- Pasajero
            */
    
    private Asiento asiento; //Hemos añadido import
    
    
    //Métodos - Además de indicar las cabeceras, se han implementado los consultores básicos
    public static float getRecaudacion(){
        return recaudacion;
    }
    
    public static int getNumBilletesVendidos(){
        return billetesVendidos;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public Tren getTren()
    {
        return this.tren;
    }
    
    public void liberar(){
        //2.2.1
        this.tren.eliminar(this);
    }
}
