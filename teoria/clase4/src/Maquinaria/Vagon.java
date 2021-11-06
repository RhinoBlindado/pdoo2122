package Maquinaria;

import java.util.ArrayList;

/**
 * Revisado - OK
 * @author Lugli, Valentino Glauco
 */
class Vagon 
{
    private int numero;
    private int categoria;
    private float precioAsientos;
    private ArrayList<Asiento> asientos;
    
    Vagon(int numero, int categoria, float precioAsientos)
    {
        this.numero = numero;
        this.categoria = categoria;
        this.precioAsientos = precioAsientos;
        this.asientos = new ArrayList<>();
    }
    
    public void limpiar()
    {
        
    }
    
    public void asociarAsiento(int fila, char letra)
    {
        
    }
    
}
