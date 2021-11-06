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
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    protected static int HotelesMax = 4;
    protected static float PasoPorSalida = 1000;
    private final float SaldoInicial = 7500;

    // De instancia
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    
    ArrayList<Casilla> propiedades = new ArrayList<>();
    
    /* Metodos */
    
    Jugador(String nombre)
    {
        this.nombre = nombre;
        
        this.casillaActual = 0;
        this.puedeComprar = false;
        this.saldo = SaldoInicial;
    }
    
    protected Jugador(Jugador otro)
    {
        this.nombre = otro.nombre;
        this.casillaActual = otro.casillaActual;
        this.propiedades = otro.propiedades;
        this.puedeComprar = otro.puedeComprar;
        this.saldo = otro.saldo;
    }

    /**
     * 
     * @return 
     */
    int cantidadCasasHoteles()
    {
        int total = 0;
        
        for(int i=0; i<this.propiedades.size(); i++)
        {
            total += this.propiedades.get(i).cantidadCasasHoteles();
        }
        return total;
    }
    
    /**
     * 
     * @param otro
     * @return 
     */
    @Override
    public int compareTo(Jugador otro)
    {
        int comparator = 0;
        
        if(this.saldo < otro.saldo)
        {
            comparator = 1;
        }
        
        if(this.saldo > otro.saldo)
        {
            comparator = -1;
        }
        
        return comparator;
    }
    
    /**
     * Comprar una propiedad 
     * @param titulo    La propiedad a comprar
     * @return true si se compra la propiedad, false en caso contrario.
     */
    boolean comprar(Casilla titulo)
    {
        boolean result = false;
        
        if(this.getPuedeComprar())
        {
            // 1
            float precio = titulo.getPrecioCompra();
            
            if(this.puedoGastar(precio))
            {
                // 2
                result = titulo.comprar(this);
                
                // 3
                this.propiedades.add(titulo);
                
                // 4
                Diario.getInstance().ocurreEvento("El jugador "+this.nombre+ " compra la propiedad "+titulo.getNombre());
                
                // 5 
                this.puedeComprar = false;
            }
            else
            {
                // 6
                Diario.getInstance().ocurreEvento("El jugador "+this.nombre+" no tiene saldo para comprar la propiedad "+titulo.getNombre());
            }
        }
        return result;
    }
    
    /**
     * Construye una casa en una propiedad
     * @see Practica 3, /docs/P3_diagramas.pdf
     * @param ip    Número de propiedad
     * @return true si se construye una casa, false en caso contrario.
     */
    boolean construirCasa(int ip)
    {
        // 1
        boolean result = false;
        // 2
        boolean existe = this.existeLaPropiedad(ip);
        
        if(existe)
        {
            // 3
            Casilla propiedad = this.propiedades.get(ip);
            
            // 4
            if(this.puedoEdificarCasa(propiedad))
            {
                // 5
                result = propiedad.construirCasa(this);
                
                // 6
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " construye una casa en " + propiedad.getNombre() + " ("+ip+")");
            }
            else
            {
                // No aparece en UML, pero se añade para informar.
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " no puede construir una casa en " + propiedad.getNombre() + " ("+ip+")");
            }

        }
        return result;
    }
    
    /**
     * Construye un hotel en una propiedad.
     * @see Practica 3, /docs/P3_diagramas.pdf
     * @param ip    Número de la propiedad.
     * @return true si se construye un hotel, falso en caso contrario.
     */
    boolean construirHotel(int ip)
    {
        boolean result = false;
        
        if(this.existeLaPropiedad(ip))
        {
            // 1
            Casilla propiedad = this.propiedades.get(ip);
            
            // 2
            if(this.puedoEdificarHotel(propiedad))
            {
                // 3
                result = propiedad.construirHotel(this);
                
                // 4
                propiedad.derruirCasas(this.getCasasPorHotel(), this);
                
                // 5
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " construye hotel en la propiedad " + propiedad.getNombre() +" (" + ip + ")");
            }
            else
            {
                // No aparece en UML, añadida para dar más información-
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " no puede construir hotel en la propiedad " + propiedad.getNombre() +" (" + ip + ")");
            }
            
        }
        
        return result;
    }
    
    /**
     * @return true si el saldo del jugador es negativo, falso en caso contrario. 
     */
    boolean enBancarrota()
    {
        return this.saldo < 0;
    }
    
    /**
     * @brief Comprueba que la propiedad existe
     * @param ip    Índice de la propiedad
     * @return true si el índice se encuentra dentro de la lista de propiedades, false en caso contrario.
     */
    private boolean existeLaPropiedad(int ip)
    {
        boolean doesExist = false;
        if(0<= ip && ip < this.propiedades.size())
        {
            doesExist = true;
        }
        return doesExist;
    }
    
    /**
     * @return  Retorna la cantidad máxima de casas.
     */
    private int getCasasMax()
    {
        return this.CasasMax;
    }
    
    /**
     * 
     * @return Retorna las casas que se tienen que derruir para construir un hotel.
     */
    int getCasasPorHotel()
    {
        return this.CasasPorHotel;
    }
    
    /**
     * @return Retorna la casilla actual donde está el jugador.
     */
    int getCasillaActual()
    {
        return this.casillaActual;
    }
    
    /**
     * @return Retorna la cantidad máxima de hoteles.
     */
    private int getHotelesMax()
    {
        return this.HotelesMax;
    }
    
    /**
     * @return Retorna el nombre del Jugador.
     */
    protected String getNombre()
    {
        return this.nombre;
    }
    
    /**
     * 
     * @return 
     */
    private float getPremioPasoPorSalida()
    {
        return this.PasoPorSalida;
    }
    
    /**
     * @return Devuelve la lista de propiedades del Jugador.
     */
    ArrayList<Casilla> getPropiedades()
    {
        return this.propiedades;
    }
    
    /**
     * 
     * @return 
     */
    boolean getPuedeComprar()
    {
        return this.puedeComprar;
    }
    
    /**
     * 
     * @return 
     */
    protected float getSaldo()
    {
        return this.saldo;
    }
    
    /**
     * @param cantidad
     * @return 
     */
    boolean modificaSaldo(float cantidad)
    {
        Diario.getInstance().ocurreEvento("[Jugador] "+this.nombre +": Saldo "+ this.saldo +" + (" + cantidad + ") = " + (this.saldo + cantidad));
        this.saldo += cantidad;
        
        return true;
    }
    
    /**
     * @param numCasilla
     * @return 
     */
    boolean moverACasilla(int numCasilla)
    {
        Diario.getInstance().ocurreEvento("[Jugador] " + this.nombre + ": Casilla [" + this.casillaActual + "] ->  [" + numCasilla+"]");
        this.casillaActual = numCasilla;
        this.puedeComprar = false;
        
        return true;
    }
    
    /**
     * @brief Realiza un pago a un jugador y se reduce la cantidad de saldo.
     * @param cantidad Valor a pagar
     * @return Siempre retorna true.
     */
    boolean paga(float cantidad)
    {
        this.modificaSaldo(cantidad * -1);
        return true;
    }
    
    /**
     * 
     * @param cantidad
     * @return 
     */
    boolean pagaAlquiler(float cantidad)
    {
        return(paga(cantidad));
    }
    
    /**
     * @brief Se recibe el premio de pasar por la salida, se suma al saldo actual.
     * @return Siempre devuelve true
     */
    boolean pasaPorSalida()
    {
        Diario.getInstance().ocurreEvento("[Jugador] "+this.nombre+": Paso por salida");
        recibe(getPremioPasoPorSalida());
        return true;
    }
    
    /**
     * Indica al jugador que puede comprar la casilla
     * @return Siempre devuelve true
     */
    boolean puedeComprarCasilla()
    {
        // Fija el atributo puedeComprar a true...
        this.puedeComprar = true;
        // ...y devuelve el valor de este atributo.
        return this.puedeComprar;
    }
    
    /**
     * @brief Indica si se puede edificar una casa en la casilla.
     * @param propiedad Casilla donde se quiere edificar una casa.
     * @return true si se puede, false en caso contrario.
     */
    private boolean puedoEdificarCasa(Casilla propiedad)
    {
        boolean canBuild = false;
        
        float housePrice = propiedad.getPrecioEdificar();
        int numHouses = propiedad.getNumCasas();
        
        if(puedoGastar(housePrice) && numHouses < getCasasMax())
        {
            canBuild = true;
        }
        
        return canBuild;
    }
    
    /**
     * @brief Indica si se puede edificar un hotel en la casilla.
     * @param propiedad Casilla donde se quiere edificar un hotel.
     * @return true si se cumplen las condiciones necesarias: tiene el dinero suficiente, no ha superado el numero de hoteles y tiene la cantidad de casas necesarias, falso en caso contrario.
     */
    private boolean puedoEdificarHotel(Casilla propiedad)
    {
        boolean canBuild = false;
        
        float hotelPrice = propiedad.getPrecioEdificar();
        int numHouses = propiedad.getNumCasas();
        int numHotels = propiedad.getNumHoteles();
        
        if(puedoGastar(hotelPrice) && numHotels < getHotelesMax() && numHouses >= getCasasPorHotel())
        {
            canBuild = true;
        }
        
        return canBuild;
    }
    
    /**
     * @brief Indica si se puede afrontar el precio
     * @param precio    
     * @return true si el saldo es mayor o igual que el precio, false en caso contrario.
     */
    private boolean puedoGastar(float precio)
    {
        return (this.saldo >= precio);
    }
    
    /**
     * @param cantidad
     * @return 
     */
    boolean recibe(float cantidad)
    {
        return (modificaSaldo(cantidad));
    }
    
    /**
     * @return true si tiene propiedades, false en caso contrario.
     */
    boolean tieneAlgoQueGestionar()
    {
        return (!this.propiedades.isEmpty());
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        String canBuy;
        
        if(this.puedeComprar)
            canBuy = "Sí";
        else
            canBuy = "No";
        
        return ("Nombre: "+this.nombre+", Casilla actual: "+this.casillaActual+", ¿Puede comprar? "+ canBuy +", Saldo: "+this.saldo+"€");
    }
    
}
    
