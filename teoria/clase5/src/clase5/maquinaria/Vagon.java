
package maquinaria;

import java.util.ArrayList;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
class Vagon {

    //Atributos básicos:
    private int numero;
    private int categoria;
    private float precioAsientos;
    
    //Atributos de referencia:
    private ArrayList<Asiento> asientos = new ArrayList();
    
    //Cabecera de los métodos:
    public void limpiar(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void asociarAsiento(int fila, char letra){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
