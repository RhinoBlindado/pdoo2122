package villanos;

import esbirros.Mayordomo;
import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class Villano {
    
    private String nombre;
    String esconditeSecreto;
    private int fortuna;
    
    ArrayList<Plan> planes;
    Mayordomo mayordomo;
    
    public Villano(String nombre, String escondite, int fortuna, Mayordomo mayordoo)
    {
        this.nombre = nombre;
        this.esconditeSecreto = escondite;
        this.fortuna = fortuna;
        this.planes = null;
        this.mayordomo = mayordomo;
    }

    public void setFortuna(int cantidad)
    {
        this.fortuna = cantidad;
    }
    
    public boolean seguirPlanPrioritario()
    {
        throw new UnsupportedOperationException("No implementado");
    }
    
    public Plan primerPlanActivo()
    {
        return this.planes.get(0);
    }
}
