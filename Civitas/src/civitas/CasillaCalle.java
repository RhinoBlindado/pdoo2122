package civitas;

import java.util.ArrayList;

/**
 * Práctica 4
 * @author Lugli, Valentino Glauco
 */
public class CasillaCalle extends Casilla
{
    /* Atributos */
    
    // Constantes
    // - Constantes para el precio del alquiler total.
    private static float  FACTORALQUILERCALLE = 1.0f;
    private static float  FACTORALQUILERCASA = 1.0f;
    private static float  FACTORALQUILERHOTEL = 4.0f;
    
    // Precios de compra.
    float precioCompra;
    float precioEdificar;
    float precioBaseAlquiler;
    
    // Propietario de la casilla.
    Jugador propietario;
    
    // Cantidad de casas y hoteles.
    int numCasas;
    int numHoteles;

    /* Métodos */
    
   /**
     * @brief Constructor para casillas tipo CALLE.
     * @param unNombre                  Nombre de la casilla.
     * @param unPrecioCompra            Precio de compra de la casilla.
     * @param unPrecioEdificar          Precio para edificar en la casilla.
     * @param unPrecioAlquilerBase      Precio de alquiler base.
     */
    CasillaCalle(String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase)
    {
        super(unNombre);
        this.precioCompra = unPrecioCompra;
        this.precioEdificar = unPrecioEdificar;
        this.precioBaseAlquiler = unPrecioAlquilerBase;
    }
    
    /** 
     * Suma de casas y hoteles en la casilla.
     * @return Suma de la cantidad de casas y hoteles en la casilla.
     */
    public int cantidadCasasHoteles()
    {
        return this.numCasas + this.numHoteles;
    }
    
    /**
     * Obtener el precio de comprar la casilla.
     * @return  Flotante con dicho precio.
     */
    @Override
    public float getPrecioCompra()
    {
        return this.precioCompra;
    }
    
    /**
     * Obtener el precio de edificar la casilla.
     * @return  Flotante con dicho precio.
     */
    @Override
    public float getPrecioEdificar()
    {
        return this.precioEdificar;
    }
    
    /**
     * Obtener el número de casas que hay en la casilla.
     * @return Número de casas.
     */
    @Override
    public int getNumCasas()
    {
        return this.numCasas;
    }
    
    /**
     * Obtener el número de hoteles que hay en la casilla.
     * @return Número de casas.
     */
    @Override
    public int getNumHoteles()
    {
        return this.numHoteles;
    }
    
    
    @Override
    public String getPropietario()
    {
        if(this.propietario != null)
            return this.propietario.nombre;
        else
            return "N/A";
    }
    
    /**
     * Obtener el precio del alquiler completo del casilla.
     * @return Precio total del alquler.
     */
    float getPrecioAlquilerCompleto()
    {
        return (FACTORALQUILERCALLE * this.precioBaseAlquiler) * (FACTORALQUILERCASA + numCasas + (numHoteles * FACTORALQUILERHOTEL));
    }
    
    @Override
    public float getPrecioAlquilerBase()
    {
        return this.precioBaseAlquiler;
    }
    
    /**
     * Construir una casa.
     * @return "true" en cualquier caso.
     */
    boolean construirCasa()
    {
        //5.1 
        this.propietario.paga(precioEdificar);
        //5.2
        this.numCasas++;
        //5.3
        return true;
    }
    
    /**
     * Construir un hotel.
     * @return "true" en cualquier caso.
     */
    boolean construirHotel()
    {
        // 3.1
        this.propietario.paga(this.precioEdificar);
        // 3.2
        this.numHoteles++;
        // 3.3
        return true;
    }

    /**
     * Quitar un numero de casas.
     * @param n    Cantidad de casas a derruir, tiene que ser un valor menor o igual que el total de casas en la casilla.
     * @param jugador   Jugador propietario de la casilla.
     * @return true si se cumplen las condiciones, se quita el número n especificado de casas, false en caso contrario.
     */
    boolean derruirCasas(int n, Jugador jugador)
    {
        boolean opSuccess = false;
        
        /**
         * Si el jugador pasado como parámetro es el
         * propietario de la casilla y el número de casas construidas es
         * mayor o igual que el parámetro n...
         */
        if(esEsteElPropietario(jugador) && this.numCasas >= n)
        {
            //...Se decrementa el contador de casas construidas en n unidades. 
            this.numCasas -= n;
            opSuccess = true;        
        }
        
        return opSuccess;
    }
    
    /**
     * Indica si el jugador es el propietario de la casilla.
     * @param jugador   Jugador 
     * @return "true" si es el propietario, "false" en caso contrario..
     */
    public boolean esEsteElPropietario(Jugador jugador)
    {
        return this.propietario == jugador;
    }
    
    /**
     * Indica si la casilla tiene propietario.
     * @return "true" si tiene propietario, "false" en caso contrario..
     */
    public boolean tienePropietario()
    {
        return this.propietario != null;
    }
    
        
    /**
     * Tramitar el alquiler de una casilla.
     * @param jugador   Jugador que ha caido en la casilla.
     */
    public void tramitarAlquiler(Jugador jugador)
    {
        //  Si la casilla tiene propietario...
        if(this.tienePropietario())
        {
            // ...Y  el jugador pasado como parámetro no es el propietario de la casilla...
            if(!this.esEsteElPropietario(jugador))
            {
                // ...Ese jugador paga el alquiler completo...
                jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
                // ...Y el propietario recibe ese mismo importe.
                this.propietario.recibe(this.getPrecioAlquilerCompleto());
            }
        }
    }
    
    /**
     * La casilla se compra por el jugador.
     * @param jugador   Jugador que será propietario.
     * @return Siempre devuelve true.
     */
    boolean comprar(Jugador jugador)
    {
        // 2.1
        this.propietario = jugador;
        
        // 2.2
        return this.propietario.paga(precioCompra);
    }
    
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos)
    {
        this.informe(iactual, todos);
        Jugador jugador = todos.get(iactual);
        
        if(!this.tienePropietario())
        {
            jugador.puedeComprarCasilla();
        }
        else
        {
            this.tramitarAlquiler(jugador);
        }
    }
    
    @Override
    public String toString()
    {
        String info;
        
        info = ("CALLE (Propietario: ");
        if(this.propietario != null)
            info += this.propietario.getNombre();
        else
            info += ("N/A");

        info += (", Nombre: " + this.Nombre + ", Precio: " + this.precioCompra + "€, Edificar: "+ this.precioEdificar +"€, Base alquiler: " + this.precioBaseAlquiler
        + "€, Casas: " + this.numCasas + ", Hoteles: "+ this.numHoteles + ")");
        
        return info;
    }
    
    /**
     * Actualiza el propietario de la casilla cuando un Jugador se vuelve Especulador
     * @param especulador Objeto JugadorEspeculador que indica el Jugador convertido
     */
    void actualizaPropietarioPorConversion(JugadorEspeculador especulador)
    {
        this.propietario = especulador;
    }
    
    public String getNombre()
    {
        return this.Nombre;
    }
}
