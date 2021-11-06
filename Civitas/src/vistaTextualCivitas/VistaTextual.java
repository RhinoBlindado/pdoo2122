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

    opcion = leeEntero
        (
            lista.size(),
            "\n"+tab+"Elige una opción: ",
            tab+"Valor erróneo"
        );
    
    return opcion;
  }
  
  @Override
  public void actualiza()
  {
    System.out.println(VistaTextual.separador);
    if(!this.juegoModel.finalDelJuego())
    {
        System.out.println("Jugador actual: ");
        System.out.println(juegoModel.getJugadorActual().toString());
        System.out.println("Casilla actual: ");
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
    Jugador player = this.juegoModel.getJugadorActual();
    ArrayList<Casilla> properties = this.juegoModel.getPropiedadesJugadorAct();
    String title = ">>>¿Que propiedad quieres gestionar?";
    ArrayList<String> ansTitle = new ArrayList<>();

    for (int i=0; i<properties.size(); i++) 
    {
        ansTitle.add(properties.get(i).toString());
    }
    
    return menu(title,ansTitle);
  }

  @Override
  public OperacionInmobiliaria elegirOperacion()
  {
      
      String title = ">>>¿Qué quieres hacer?";
      ArrayList<String> ansTitle = new ArrayList<>(Arrays.asList
      (
                "Construir una casa.",
                "Construir un hotel", 
                "Terminar de gestionar y pasar turno."
      ));
      
      return OperacionInmobiliaria.values()[menu(title, ansTitle)];
  }
  
  @Override
  public Respuesta comprar()
  {
      String title = ">>>¿Quieres comprar esta calle?";
      ArrayList<String> ansTitle = new ArrayList<>(Arrays.asList("NO", "SI"));
      
      return Respuesta.values()[menu(title, ansTitle)];
  }
}
