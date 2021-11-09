package civitas;

import java.util.ArrayList;

/*
 * [CASTELLANO]
 * Civitas
 * Asignatura: Programación y Diseño Orientado a Objetos
 * Autor: Valentino Lugli (Github: @RhinoBlindado)
 * Fecha: Septiempre 2021 - Diciembre 2021
 */

/*
 * [ENGLISH]
 * Civitas
 * Course: Object Oriented Programming and Design
 * Author: Valentino Lugli (Github: @RhinoBlindado)
 * Date: September 2021 - December 2021
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
       public static void main(/*String[] args*/) 
    {
        
        /*
         * 1. Llama 100 veces al método quienEmpieza() de Dado considerando que hay 4 jugadores, y 
         * calcula cuantas veces se obtiene cada uno de los valores posibles. Comprueba si se cumplen
         * a nivel práctico las probabilidades de cada valor.
         */
        System.out.println("### Prueba 1 ###");
        
        Dado dice = Dado.getInstance();
        int iterations = 100;
        int numPlayers = 4;
        int[] startCounter = {0, 0, 0, 0};
        
        for(int i=0; i<iterations; i++)
        {
            startCounter[dice.quienEmpieza(numPlayers)]++;
        }
        
        for(int i=0; i<numPlayers; i++)
        {
            System.out.println(" - Jugador "+(i+1)+": "+startCounter[i]);
        }
        
        /*
         * 2. Asegúrate de que funciona el modo debug del dado activando y desactivando ese modo, y 
         * realizando varias tiradas en cada modo.
         */
        System.out.println("\n### Prueba 2 ###");
        
        int diceRolls = 5;
        System.out.println(" - " + diceRolls + " tiradas en modo normal");
        
        for(int i = 0; i < diceRolls; i++)
        {
            System.out.print(dice.tirar()+ " ");
        }
        System.out.print("\n");
        
        System.out.println(" - " + diceRolls + " tiradas en modo debug");
        dice.setDebug(true);
        for(int i = 0; i < diceRolls; i++)
        {
            System.out.print(dice.tirar()+ " ");
        }
        System.out.print("\n");

        dice.setDebug(false);
        System.out.println(" - " + diceRolls + " tiradas en modo normal de nuevo");
        for(int i = 0; i < diceRolls; i++)
        {
            System.out.print(dice.tirar()+ " ");
        }
        System.out.print("\n");

        /*
         * 3. Prueba al menos una vez el método getUltimoResultado() de Dado.
         */

        System.out.println("\n### Prueba 3 ###");
        System.out.println(" - Tirada usual: " + dice.tirar());
        System.out.println(" - Ultimo resultado: "+ dice.getUltimoResultado());

        /*
         * 4. Muestra al menos un valor de cada tipo enumerado.
         */
        System.out.println("\n### Prueba 4 ###");

        System.out.println(" - TipoCasilla: " + TipoCasilla.CALLE + ", " + TipoCasilla.DESCANSO);
        System.out.println(" - TipoSorpresa: " + TipoSorpresa.PAGARCOBRAR + ", " + TipoSorpresa.PORCASAHOTEL);
        System.out.println(" - EstadosJuego: " + EstadoJuego.INICIO_TURNO);


        /*
         * 5. Crea un objeto Tablero y haz las siguientes pruebas: añade algunas calles al tablero, obtén 
         * dichas casillas y muestra su estado por consola usando el método toString de la clase Casilla.
         */

        System.out.println("\n### Prueba 5 ###");

        Tablero board = new Tablero();
        Casilla cas1 = new Casilla(TipoCasilla.CALLE, "Arabial", 10, 20, 500);
        Casilla cas2 = new Casilla(TipoCasilla.CALLE, "San Juan de Dios", 20, 1, 480);
        Casilla cas3 = new Casilla(TipoCasilla.CALLE, "El betis", 1, 1, 1);
        Casilla cas4 = new Casilla(TipoCasilla.CALLE, "Firelink", 69, 50, 1000);

        board.añadeCasilla(cas1);
        board.añadeCasilla(cas2);
        board.añadeCasilla(cas3);
        board.añadeCasilla(cas4);

        int numCells = 7;
        Casilla tempCell;
        for(int i = 0; i < numCells; i++)
        {
            tempCell = board.getCasilla(i);
            if (tempCell != null)
                System.out.println(" - Posicion: "+ i +": "+tempCell.toString());
            else
                System.out.println(" - Posicion: "+ i +": Vacio");
        }
        
        tempCell = board.getCasilla(-1);
        
        if (tempCell != null)
            System.out.println(" - Posicion: -1 :"+tempCell.toString());
        else
            System.out.println(" - Posicion: -1" +": Vacio");
        
        /*
         * 6. Crea algunos bucles sobre la totalidad de las calles para calcular y mostrar cuál es la calle
         * más cara (en cuanto a su precio de compra), la más barata y el precio medio de las calles.
         */
    
        
        float maxCost = -1;
        float minCost = Float.MAX_VALUE;
        float avgCost = 0;
        float actCost = 0;
        
        String nameMaxCost = "", nameMinCost = "";
        
        System.out.println("\n### Prueba 6 ###");
        for(int i = 0; i < numCells-3; i++)
        {
            actCost = board.getCasilla(i+1).getPrecioCompra();
            
            if(actCost > maxCost)
            {
                maxCost = actCost;
                nameMaxCost = board.getCasilla(i+1).getNombre();
            }
            
            if(minCost > actCost)
            {
                minCost = actCost;
                nameMinCost = board.getCasilla(i+1).getNombre();
            }
            
            avgCost += actCost;
        }
        avgCost = avgCost / (numCells-3);
        
        System.out.println(" - La calle más costosa es " + nameMaxCost + " ("+maxCost+"€) \n- La calle más barata es "+ nameMinCost +" ("+minCost+"€) \n- El precio medio es " + avgCost +"€");
        
        /*
         * 7. Usa la clase Diario, aprovecha y prueba todos los métodos de Diario.
         */
        
        System.out.println("\n### Prueba 7 ###");

        System.out.println(" - Rellenando entradas...");

        Diario di = Diario.getInstance();
        
        di.ocurreEvento("Añadiendo evento 1...");
        di.ocurreEvento("¡Evento 2!");

        System.out.println(" - ¿Hay eventos pendientes? " + di.eventosPendientes());
        System.out.println(" - Eventos: ");
        while(di.eventosPendientes())
        {
            System.out.println("\t"+di.leerEvento());
        }
        
        /*
         * 8. Finalmente, realiza distintas tiradas con el dado y asegúrate de que se calcula correctamente
         * la posición de destino en el tablero.
         */
        
        System.out.println("\n### Prueba 8 ###");
        
        System.out.println(" - El tablero tiene " + board.getNumCasillas() + " casillas.");
        System.out.println(" - Si está en la posicion 2, y saca un 5... ¡" + board.nuevaPosicion(2, 5)+"! Da la vuelta.");
        int testValue = dice.tirar();
        System.out.println(" - Inicio en posición 3, tirada de "+ testValue +": ¡"+board.nuevaPosicion(3, testValue)+"!");
    }
}
