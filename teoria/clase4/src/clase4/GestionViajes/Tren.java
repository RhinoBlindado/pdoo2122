package clase4.GestionViajes;

import Maquinaria.Asiento;
import Maquinaria.Convoy;
import java.util.ArrayList;
import java.util.Date;

/**
 * Revisado - OK
 * @author Lugli, Valentino Glauco
 */
public class Tren 
{
    private int numero;
    private String nombre;
    private ArrayList<Parada> paradas;
    private ArrayList<Billete> billetes;
    private Convoy convoy;
    
    Tren(int numero, String nombre)
    {
        this.numero = numero;
        this.nombre = nombre;
        this.paradas = new ArrayList<>();
        this.billetes = new ArrayList<>();
    }
    
    public Asiento reservarAsiento()
    {
        return null;
    }
    
    public void liberarBillete(Billete billete)
    {
        
    }
    
    public void nuevaParada(Estacion estacion, Date horaLlegada, Date horaSalida)
    {
        
    }

}
