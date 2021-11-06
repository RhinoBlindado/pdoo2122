
package clase5.GestionViajes;

import java.util.Date;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
class Parada {

    //Atributos básicos:
    private Date horaLlegada;
    private Date horaSalida;
    
    //Atributos de referencia:
    private Estacion estacion; //Se puede navegar de Parada a Estacion y la multiplicidad
                            //en estación es 1
    
    //No hay más atributos de referencia:
    // * No se puede navegar de Parada a Tren
    // * No se puede navegar de Parada a Billete a través de ninguna de las 2 asociaciones

    Parada(Estacion estacion, Date horaLlegada, Date horaSalida) {
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.estacion = estacion;
    }
    
    
}
