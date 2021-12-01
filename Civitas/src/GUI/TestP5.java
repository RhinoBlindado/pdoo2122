package GUI;

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class TestP5 
{
     public static void main(String[] args) 
    {
        CivitasView civ = new CivitasView();
        CapturaNombres capt = new CapturaNombres(civ, true);
        ArrayList<String> names = capt.getNombres();
        CivitasJuego vidya = new CivitasJuego(names, true);
        Controlador controller = new Controlador(vidya, civ);
        civ.setCitivasJuego(vidya);
        controller.juega();
    }

}
