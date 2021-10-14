package civitas;

import java.util.ArrayList;
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
    }
    
    private void inicializaTablero(MazoSorpresas mazo)
    {
        
    }
    
    private void inicializaMazoSorpesas()
    {
        
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
