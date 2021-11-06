package Maquinaria;

import java.util.ArrayList;

/**
 * Revisado - OK
 * @author Lugli, Valentino Glauco
 */
public class Convoy 
{
    private static final int MAXVAGONES = 20;
    private ArrayList<Maquina> maquinas;
    private ArrayList<Vagon> vagones;
    
    
    public Convoy()
    {
        this.maquinas = new ArrayList<>(2);
        this.vagones = new ArrayList<>(MAXVAGONES);
    }
    
    public static int obtenerMaximoVagones()
    {
        return MAXVAGONES;
    }

}
