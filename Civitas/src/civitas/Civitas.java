package civitas;

/**
 *
 * @author valentino
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Casilla c1 = new Casilla(TipoCasilla.CALLE, "Arabial", 100, 100, 200);
        System.out.println(c1.toString());
    }
    
}
