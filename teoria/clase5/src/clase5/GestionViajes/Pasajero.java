
package clase5.GestionViajes;

import java.util.ArrayList;
import java.util.Date;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
class Pasajero {

    //Atributos básicos:
    private int codigo;
    private String nombre;
    private String email;
    
    //Atributos de referencia:
    private ArrayList<Billete> billetes = new ArrayList();
            /** La clase asociación queda:
             * Tren -1-----1..*- Billete -1..*----1- Pasajero
            */
    
        //No hay más atributos de referencia pues no se puede navegar
        // de Pasajero a GestorViajes
    
    
    public void anularBillete(int numeroTren, Date fecha){
        //2.1
        Billete billete = buscarBillete(numeroTren, fecha);

        
        if(billete != null)
        {
            //2.2
            billete.liberar();
            
            //2.3
            this.billetes.remove(billete);
        }
        
    }
    
    private Billete buscarBillete(int numeroTren, Date fecha){
        Billete billete = null;
        
        for(int i=0; i<this.billetes.size(); i++)
        {
            if(this.billetes.get(i).getFecha().equals(fecha) &&
               this.billetes.get(i).getTren().getNumero() == numeroTren)
            {
                billete = this.billetes.get(i);
            }
        }
        return billete;
    }
    
    public int getCodigo()
    {
        return this.codigo;
    }
}
