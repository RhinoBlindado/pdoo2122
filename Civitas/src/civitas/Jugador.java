/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author valentino
 */
public class Jugador implements Comparable<Jugador>
{
    /* Atributos */
    
    // Constantes
    protected final int CasasMax = 4;
    protected final int CasasPorHotel = 4;
    protected final int HotelesMax = 4;
    protected final float PasoPorSalida = 1000;
    
    // De instancia
    int casillaActual;
    String nombre;
    boolean puedeComprar;
    float saldo;
    final float SaldoInicial = 7500;
    
    ArrayList<Casilla> propiedades;
    
    /* Metodos */
    
    Jugador(String nombre)
    {
        this.nombre = nombre;
        
        this.casillaActual = 0;
        this.puedeComprar = false;
        this.saldo = 0;
    }
    
    protected Jugador(Jugador otro)
    {
        this.nombre = otro.nombre;
        this.casillaActual = otro.casillaActual;
        this.propiedades = otro.propiedades;
        this.puedeComprar = otro.puedeComprar;
        this.saldo = otro.saldo;
    }
    
    // WIP
    int cantidadCasasHoteles()
    {
        
    }
    
    // WIP
    @Override
    public int compareTo(Jugador otro)
    {
        return 0;
    }
    
    // WIP
    boolean comprar(Casilla titulo)
    {
        
    }
    
    // WIP
    boolean construirCasa(int ip)
    {
        
    }
    
    // WIP
    boolean construirHotel(int ip)
    {
        
    }
    
    // WIP
    boolean enBancarrota()
    {
        
    }
    
    // WIP
    private boolean existeLaPropiedad(int ip)
    {
        
    }
    
    // WIP
    private int getCasasMax()
    {
        
    }
    
    // WIP
    int getCasasPorHotel()
    {
        
    }
    
    // WIP
    int getCasillaActual()
    {
        
    }
    
    // WIP
    private int getHotelesMax()
    {
        
    }
    
    // WIP
    protected String getNombre()
    {
        
    }
    
    // WIP
    private float getPremioPasoPorSalida()
    {
        
    }
    
    // WIP
    protected ArrayList<Casilla> getPropiedades()
    {
        
    }
    
    // WIP
    boolean getPuedeComprar()
    {
        
    }
    
    // WIP
    protected float getSaldo()
    {
        
    }
    
    // WIP
    boolean modificarSaldo(float cantidad)
    {
        
    }
    
    // WIP
    boolean moverACasilla(int numCasilla)
    {
        
    }
    
    // WIP
    boolean paga(float cantidad)
    {
        
    }
    
    // WIP
    boolean pagaAlquiler(float cantidad)
    {
        
    }
    
    // WIP
    boolean pasaPorSalida()
    {
        
    }
    
    // WIP
    boolean puedeComprarCasilla()
    {
        
    }
    
    // WIP
    private boolean puedoEdificarCasa(Casilla propiedad)
    {
        
    }
    
    // WIP
    private boolean puedoEdificarHotel(Casilla propiedad)
    {
        
    }
    
    // WIP
    private boolean puedoGastar(float precio)
    {
        
    }
    
    // WIP
    boolean recibe(float cantidad)
    {
        
    }
    
    // WIP
    boolean tieneAlgoQueGestionar()
    {
        
    }
    
    // WIP
    String toString()
    {
        
    }
    
}
    
