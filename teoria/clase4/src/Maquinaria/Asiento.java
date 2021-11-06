package Maquinaria;

/**
 * Revisado - OK
 * @author Lugli, Valentino Glauco
 */
public class Asiento 
{
    private int fila;
    private char letra;
    private boolean libre;
    
    private Vagon vagon;
    
    Asiento(int fila, char letra, boolean libre)
    {
        this.fila = fila;
        this.letra = letra;
        this.libre = libre;
    }

}
