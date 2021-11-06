package clase4.GestionViajes;

import java.util.Date;

/**
 * Revisado - OK
 * @author Lugli, Valentino Glauco
 */
class Parada 
{
    private Date horaLlegada, horaSalida;
    
    private Estacion estacion;
    
    Parada(Estacion estacio, Date horaLlegada, Date horaSalida)
    {
        this.estacion = estacio;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
    }
}
