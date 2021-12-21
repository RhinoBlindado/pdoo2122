package civitas;

import java.util.ArrayList;

public class Civitas {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) 
    {
        Jugador jug = new Jugador("Solaire");
        Casilla cas = new CasillaCalle("Bruh", 10, 10, 10),
                cas1 = new CasillaCalle("B", 10, 10, 10);
        
        
        jug.puedeComprarCasilla();
        jug.comprar(cas1);
        jug.puedeComprarCasilla();
        jug.comprar(cas);
        
        System.out.println(jug.toString());
        JugadorEspeculador jugNew = jug.convertir();
        System.out.println(jugNew.toString());
        System.out.println(cas.toString());
        System.out.println(cas1.toString());
    }
}
