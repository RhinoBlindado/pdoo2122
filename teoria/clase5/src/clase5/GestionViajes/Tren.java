
package clase5.GestionViajes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import maquinaria.Asiento;
import maquinaria.Convoy;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
class Tren {

    //Atributos básicos:
    private int numero;
    private String nombre;
    
    //Atributos de referencia:
    
    private ArrayList<Parada> paradas = new ArrayList();
            //Se puede navegar de Tren a Parada y la multiplicidad es 2..* (varios)
            // en Parada
    
            //{ordenado} significa que la lista es ordenada, eso tendrá implicaciones  
                // al incluir nuevos elementos en el ArrayList
            // 2..* Significa que lo usual es que en esa lista haya 2 o más paradas
    
    private ArrayList<Billete> billetes = new ArrayList();
            /** La clase asociación queda:
             * Tren -1-----1..*- Billete -1..*----1- Pasajero
            */
    
    private Convoy convoy; //Ojo al import
    
    //No hay más atributos de referencia:
    // * No se puede navegar de Tren a GestorViajes
    
    
    //Cabecera de los métodos:
    public Asiento reservarAsiento(){
        throw new UnsupportedOperationException("Not supported yet.");     } 
    
    public void liberarBillete(Billete billete){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void nuevaParada(Estacion estacion, Date horaLlegada, Date horaSalida){
    
       //3.1
       Parada parada = new Parada(estacion, horaLlegada, horaSalida);
       
       //3.2
       estacion.incluirParada(parada);
       
       //3.3
       paradas.add(parada);
       
       //3.4
       //Collections.sort(paradas);
    }
    
    public int getNumero()
    {
        return this.numero;
    }
    
    public void eliminar(Billete billete)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
