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

package civitas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author Lugli, Valentino Glauco
 */
public class CivitasJuego 
{
    private int indiceJugadorActual;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private EstadoJuego estado;
    private GestorEstados gestor;
    private MazoSorpresas mazo;
    private Tablero tablero;
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug)
    {
        for(int i=0; i<nombres.size(); i++)
        {

            this.jugadores.add(new Jugador(nombres.get(i)));
        }
        
        this.gestor = new GestorEstados();
        this.estado = this.gestor.estadoInicial();
        
        Dado.getInstance().setDebug(debug);
        
        this.indiceJugadorActual = Dado.getInstance().quienEmpieza(this.jugadores.size());
        
        this.mazo = new MazoSorpresas(debug);
        
        this.tablero = new Tablero();
        
        inicializaMazoSorpesas();
        
        inicializaTablero(this.mazo);
    }
    
    private void inicializaTablero(MazoSorpresas mazo)
    {
        ArrayList<Casilla> tokens = new ArrayList<>(Arrays.asList
        (
                                         // Nombre, Precio Compra, Edificar, Alquiler
            new CasillaCalle("Avenida Andrés Eloy Blanco", 400, 250, 999),
            new CasillaCalle("Avenida San José de Tarbes", 6000, 666, 777),
            new CasillaSorpresa("Sorpresa #1", mazo),
            new CasillaCalle("Avenida Salvador Feo La Cruz", 192, 1010, 1212),
            new CasillaCalle("Avenida 106", 1000, 500, 300),
            new CasillaCalle("Callejón Mañongo", 2500, 300, 500),
            new CasillaSorpresa("Sorpresa #2", mazo),
            new CasillaCalle("Avenida Universidad", 1825, 3000, 2),
            new CasillaCalle("Avenida Bolívar", 4500, 4000, 1500),
            new Casilla("Estacionamiento Prebo"),
            new CasillaCalle("Las 4 Avenidas", 500, 1250, 2000),
            new CasillaCalle("Avenida Río Orinoco", 250, 3000, 780),
            new CasillaSorpresa("Sorpresa #3", mazo),
            new CasillaCalle("Calle 137", 100, 50, 1000),
            new CasillaCalle("Avenida Carlos Sanda", 699, 420, 111),
            new CasillaCalle("Avenida Principal Guayabal", 1, 2, 3),
            new CasillaSorpresa("Sorpresa #4", mazo),
            new CasillaCalle("Avenida Don Julio Centeno", 1234, 4567, 7890),
            new CasillaCalle("Avenida Este-Oeste 2", 2000, 1420, 3240)
        ));
        
        for(int i = 0; i < tokens.size(); i++)
        {
            this.tablero.añadeCasilla(tokens.get(i));
        }
    }
    
    private void inicializaMazoSorpesas()
    {
        ArrayList<Sorpresa> surpList = new ArrayList<>(Arrays.asList
        (
            /* 10 Cartas */
            /* 6 PAGARCOBRAR, 3 positivas y 3 negativas*/
            new SorpresaPagarCobrar("Consigues 10000€ de un banco sin consentimiento", 10000),
            new SorpresaPagarCobrar("Consigues 1000€ tirados en la calle", 1000),
            new SorpresaPagarCobrar("Te cae una moneda de 1€ del cielo", 1),
            new SorpresaPagarCobrar("Una moneda de 1€ se te va volando al cielo", -1),
            new SorpresaPagarCobrar("Ves todo rojo y pierdes 666€", -666),
            new SorpresaPagarCobrar("Alguien te pide sin consentimiento 10000€", -10000),
            /* 4 PORCASAHOTEL, 2 positivas y 2 negativas */
            new SorpresaPorCasaHotel("Cobra por cada casa y hotel 200€", 200),
            new SorpresaPorCasaHotel("Cobra por cada casa y hotel 1000€", 1000),
            new SorpresaPorCasaHotel("Paga por cada casa y hotel 420€", -420),
            new SorpresaPorCasaHotel("Paga por cada casa y hotel 1000€", -1000)
        ));
        
        for(int i = 0; i < surpList.size(); i++)
        {
            this.mazo.alMazo(surpList.get(i));
        }
    }
    
    public Jugador getJugadorActual()
    {
        return this.jugadores.get(this.indiceJugadorActual);
    }
    
    /**
     * Obtiene la lista de propiedades del Jugador Actual
     * ! Metodo no en UML, pero se necesita para la vista: el jugador debe de poder indicar en que calle quiere gestionar propiedades.
     * @return Lista de Casillas que son propiedad del jugador actual.
     */
    public ArrayList<CasillaCalle> getPropiedadesJugadorAct()
    {
        return this.jugadores.get(this.indiceJugadorActual).getPropiedades();
    }
    
    /**
     * Obtiene la casilla donde se encuentra el jugador actual.
     * ! Metodo no en UML, pero se necesita para la vista: indicar los detalles de la casilla actual donde está el jugador.
     * @return 
     */
    public Casilla getCasillaActual()
    {
        return this.tablero.getCasilla(this.getJugadorActual().getCasillaActual());
    }
    
    public int getIndiceJugadorActual()
    {
        return this.indiceJugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores()
    {
        return this.jugadores;
    }
    
    public Tablero getTablero()
    {
        return this.tablero;
    }
    
    public boolean finalDelJuego()
    {
        boolean isBankrupt = false;
        
        for(int i=0; i<this.jugadores.size(); i++)
        {
            if(this.jugadores.get(i).enBancarrota())
            {
                isBankrupt = true;
                /*
                 * No se especifica pero como se sabe que al final del juego se 
                 * tienen que ordenar los jugadores, tiene sentido esto.
                 */ 
                this.ranking();
                break;
            }
        }
        
        return isBankrupt;
    }
    
    public boolean construirCasa(int ip)
    {
        return this.jugadores.get(this.indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip)
    {
        return this.jugadores.get(this.indiceJugadorActual).construirHotel(ip);
    }    
    
    /**
     * Ordena los jugadores por cantidad de dinero
     * @return Lista ordenada de los jugadores por cantidad de dinero.
     */
    private ArrayList<Jugador> ranking()
    {
        Collections.sort(this.jugadores);
        return this.jugadores;
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual)
    {
        if(tablero.computarPorSalida())
        {
            jugadorActual.pasaPorSalida();
        }
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion)
    {
        this.estado = this.gestor.siguienteEstado(this.jugadores.get(indiceJugadorActual), estado, operacion);
    }
    
    private void avanzaJugador()
    {
        // 1.1
        Jugador jugadorActual = this.getJugadorActual();
        
        // 1.2
        int posicionActual = jugadorActual.getCasillaActual();
        
        // 1.3
        int tirada = Dado.getInstance().tirar();
        
        // 1.4
        int posicionNueva = this.tablero.nuevaPosicion(posicionActual, tirada);
        
        // 1.5
        Casilla casilla = this.tablero.getCasilla(posicionNueva);
        
        // 1.6
        this.contabilizarPasosPorSalida(jugadorActual);
        
        // 1.7
        jugadorActual.moverACasilla(posicionNueva);
        
        // 1.8
        casilla.recibeJugador(this.indiceJugadorActual, jugadores);
    }
    
    public boolean comprar()
    {
        // 1
        Jugador jugadorActual = this.jugadores.get(indiceJugadorActual);
        // 2 y 3
        Casilla casilla = this.tablero.getCasilla(jugadorActual.getCasillaActual());
        // 4
        return jugadorActual.comprar(casilla);
    }
    
    private void pasarTurno()
    {
        this.indiceJugadorActual = (this.indiceJugadorActual + 1) % this.jugadores.size();
    }
    
    public OperacionJuego siguientePaso()
    {
        // 1
        Jugador jugadorActual = this.getJugadorActual();
        // 2
        OperacionJuego operacion = this.gestor.siguienteOperacion(jugadorActual, this.estado);
        
        if(operacion == OperacionJuego.PASAR_TURNO)
        {
            // 3
            this.pasarTurno();
            
            // 4
            this.siguientePasoCompletado(operacion);
        } 
        else if (operacion == OperacionJuego.AVANZAR)
        {
            // 5
            this.avanzaJugador();
            
            // 6
            this.siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
}
