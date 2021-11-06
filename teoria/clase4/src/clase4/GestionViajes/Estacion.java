package clase4.GestionViajes;

import java.util.ArrayList;

/**
 * Revisado - OK
 * @author Lugli, Valentino Glauco
 */
class Estacion 
{
    private String nombre;
    private String direccion;
    private String ciudad;
    
    private ArrayList<Parada> paradas;
    
    Estacion(String nombre, String direccion, String ciudad)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.paradas = new ArrayList<>();
    }
    
    public void incluirParada(Parada parada)
    {
        this.paradas.add(parada);
    }
}
