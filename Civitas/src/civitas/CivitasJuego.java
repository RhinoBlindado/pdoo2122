package civitas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author Lugli, Valentino Glauco
 */
class CivitasJuego 
{
    private int indiceJugadorActual;
    private ArrayList<Jugador> jugadores;
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
        this.gestor.estadoInicial();
        
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
            new Casilla(TipoCasilla.CALLE, "Avenida Andrés Eloy Blanco", 7500, 250, 750),
            new Casilla(TipoCasilla.CALLE, "Avenida San José de Tarbes", 1337, 666, 777),
            new Casilla(TipoCasilla.SORPRESA, "Sorpresa #1"),
            new Casilla(TipoCasilla.CALLE, "Avenida Salvador Feo La Cruz", 1492, 1010, 1212),
            new Casilla(TipoCasilla.CALLE, "Avenida 106", 1000, 500, 300),
            new Casilla(TipoCasilla.CALLE, "Callejón Mañongo", 25000, 300, 500),
            new Casilla(TipoCasilla.SORPRESA, "Sorpresa #2"),
            new Casilla(TipoCasilla.CALLE, "Avenida Universidad", 1825, 3000, 2),
            new Casilla(TipoCasilla.CALLE, "Avenida Bolívar", 45000, 4000, 1500),
            new Casilla(TipoCasilla.DESCANSO, "Parking"),
            new Casilla(TipoCasilla.CALLE, "Las 4 Avenidas", 5000, 1250, 2000),
            new Casilla(TipoCasilla.CALLE, "Avenida Río Orinoco", 250, 3000, 780),
            new Casilla(TipoCasilla.SORPRESA, "Sorpresa #3"),
            new Casilla(TipoCasilla.CALLE, "Calle 137", 100, 50, 1000),
            new Casilla(TipoCasilla.CALLE, "Avenida Carlos Sanda", 6969, 420, 111),
            new Casilla(TipoCasilla.CALLE, "Avenida Principal Guayabal", 1, 2, 3),
            new Casilla(TipoCasilla.SORPRESA, "Sorpresa #4"),
            new Casilla(TipoCasilla.CALLE, "Avenida Don Julio Centeno", 1234, 4567, 7890),
            new Casilla(TipoCasilla.CALLE, "Avenida Este-Oeste 2", 2000, 1420, 3240)
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
            new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Consigues 10000€ de un banco sin consentimiento", 1000),
            new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Consigues 1000€ tirados en la acera", 500),
            new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Te cae una moneda de 1€ del cielo", 1),
            new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Una moneda de 1€ se va volando al cielo", -1),
            new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Ves todo rojo y pierdes 666€", -666),
            new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Alguien te pide con consentimiento 10000€", -10000),
            /* 4 PORCASAHOTEL, 2 positivas y 2 negativas*/
            new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Cobra por cada casa y hotel 200€", 200),
            new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Cobra por cada casa y hotel 1000€", 1000),
            new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Paga por cada casa y hotel 420€", -420),
            new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Paga por cada casa y hotel 1000€", -1000)
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
    
    private ArrayList<Jugador> ranking()
    {
        ArrayList<Jugador> gamerRanking = new ArrayList<>(this.jugadores);
        Collections.sort(gamerRanking);
        return gamerRanking;
    }
    
    private void contabilizarPasosPorSalida()
    {
        if(tablero.computarPorSalida())
        {
            this.jugadores.get(this.indiceJugadorActual).pasaPorSalida();
        }
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion)
    {
        this.gestor.siguienteEstado(this.jugadores.get(indiceJugadorActual), estado, operacion);
    }
    
    private void avanzaJugador()
    {
        this.indiceJugadorActual = (this.indiceJugadorActual+1) % this.jugadores.size();
    }
    
    public boolean comprar()
    {
        return true;
    }
    
    private void pasarTurno()
    {
        
    }
    
    public OperacionJuego siguientePaso()
    {
        return null;
    }
}
