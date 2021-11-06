package clase4.GestionViajes;

import java.util.ArrayList;
import java.util.Date;

/**
 * Revisado - OK
 * @author Lugli, Valentino Glauco
 */
public class GestorViajes 
{
   private ArrayList<Tren> trenes = new ArrayList();
   private ArrayList<Estacion> estaciones = new ArrayList();
   private ArrayList<Pasajero> pasajeros = new ArrayList();
   
   public ArrayList<String> obtenerHorarios(String origen, String destino)
   {
       return null;
   }
   
   public int comprarBillete(Date fecha, String origen, String destino, int pasajero)
   {
       return 0;
   }
   
   public float obtenerRecaudacion()
   {
       return 0;
   }
   
   public void anularBillete(int numeroTren, String nombreEstacion, Date horaLlegada, Date horaSalida)
   {
       
   }
   
   private Tren buscarTren(int numero)
   {
       return null;
   }
   
   private Estacion buscarEstacion(String nombreEstacion)
   {
       return null;
   }

}
