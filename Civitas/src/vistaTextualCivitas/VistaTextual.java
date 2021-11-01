package vistaTextualCivitas;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
 public  void pausa() 
 {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
}

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }
  
  @Override
  public void actualiza()
  {
    System.out.println(VistaTextual.separador);
    if(!this.juegoModel.finalDelJuego())
    {
        System.out.println(juegoModel.getJugadorActual().toString());
        // de la casilla actual. ????   
        System.out.println(juegoModel.getCasillaActual().toString());
    }
    else
    {
        System.out.println("¡Fin del juego!");
        System.out.println("Ranking de los jugadores:");
        ArrayList<Jugador> players = this.juegoModel.getJugadores();
        
        for(int i=0; i<players.size(); i++)
        {
            System.out.println("#"+(i+1)+" "+players.get(i).toString());
        }
        System.out.println(VistaTextual.separador);
    }

  }
  
  @Override
  public void mostrarEventos()
  {
      System.out.println(" - Eventos:");
      while(Diario.getInstance().eventosPendientes())
      {
        System.out.println("\t"+Diario.getInstance().leerEvento());
      }
  }
  
  @Override
  public void mostrarSiguienteOperacion(OperacionJuego operacion)
  {
      System.out.println(" - La siguiente operación va a ser: " + operacion);
  }
  
  @Override
  public  int elegirPropiedad()
  {
      Jugador playa = this.juegoModel.getJugadorActual();
      
      return 0;
  }

  @Override
  public OperacionInmobiliaria elegirOperacion()
  {
      
      String title = ">>>¿Quieres comprar esta calle?";
      String ansTitle = "0 - Construir una casa. \n1 - Construir un hotel. \n2 - Terminar de gestionar esta calle. \n>";
      String ansErr = "¡No es una opción correcta! Vuelve a intentar.";
      
      System.out.println(title);
      return OperacionInmobiliaria.values()[leeEntero
        (
                OperacionInmobiliaria.values().length, 
                ansTitle, 
                ansErr
        )];
  }
  
  @Override
  public Respuesta comprar()
  {
      int ansLen = 2;
      String title = ">>>¿Quieres comprar esta calle?";
      String ansTitle = "0 - NO \n1 - SI\n>";
      String ansErr = "¡No es una opción correcta! Vuelve a intentar.";
      
      System.out.println(title);
      return Respuesta.values()[leeEntero
        (
              ansLen,
              ansTitle,
              ansErr
        )];
  }
}
