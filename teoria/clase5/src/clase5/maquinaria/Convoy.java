
package maquinaria;

import java.util.ArrayList;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
public class Convoy {
    
    //Atributos básicos:
    private static final int MAXVAGONES = 20; //La constante la indicamos como "final"
    
    //Atributos de referencia:
    private ArrayList<Maquina> maquinas = new ArrayList(2); //2 máquinas en la lista
    private ArrayList<Vagon> vagones = new ArrayList(MAXVAGONES);
    
    //Métodos:
    public static int obtenerMaximoVagones(){
        return MAXVAGONES;
    }
    
}
