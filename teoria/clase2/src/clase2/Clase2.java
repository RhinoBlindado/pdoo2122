package clase2;

import ejemploPaquete.ejemploClasePaq2;
import ejemploPaquete.paqueteB.claseInterna;

/**
 *
 * @author valentino
 */
public class Clase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Mesa m1 = new Mesa(15),
            m2 = new Mesa();
            
            m2.setHeight(18);
            System.out.println("Mesa con altura de 18m: "+ m2.getHeight());
            m2.setHeight(-1);
            System.out.println("Cambiandolo a mesa con altura de -1m: "+ m2.getHeight());
            
            ejemploClasePaq2 ejemploAcceso = new ejemploClasePaq2();
            System.out.println("Accediendo a otro paquete: "+ejemploAcceso.getNombre());
            
            claseInterna cInterna = new claseInterna();
            System.out.println("Otro paquete más:"+cInterna.getMensaje());
    }
    
}
