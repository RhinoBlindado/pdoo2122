package JuegoTexto;

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import java.util.Arrays;
import vistaTextualCivitas.VistaTextual;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class JuegoTexto 
{
    public static void main(String[] args) 
    {
        ArrayList<String> players = new ArrayList<>(Arrays.asList(
            "Oscar de Astora",
            "Kazuma Kiryu",
            "Mordred Pendragon",
            "Big Boss"
        ));

        CivitasJuego civitas = new CivitasJuego(players, false);
        VistaTextual frontend = new VistaTextual(civitas);
    //    Controlador gameMaster = new Controlador(civitas, frontend);
    //    gameMaster.juega();
    }

}
