
package clase5.GestionViajes;

import java.util.ArrayList;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
class Estacion {

    //Atributos básicos:
    private String nombre;
    private String direccion;
    private String ciudad;
 
    //Atributos de referencia
    private ArrayList<Parada> paradas = new ArrayList(); 
                        //Se puede navegar de Estacion hacia Parada y la
                        //multiplicidad en Parada es 1..*
    
    //No hay más atributos de referencia:
    // * No se puede navegar de Estacion a GestorViajes
    
    public void incluirParada(Parada parada){
    
    }
    
}
