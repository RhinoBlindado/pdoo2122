package civitas;

import java.util.ArrayList;

/**
 *
 * @author Lugli, Valentino Glauco.
 */
public class Casilla 
{
    /* Atributos */

    // Constantes
    // - Constantes para el precio del alquiler total.
    private static float  FACTORALQUILERCALLE = 1.0f;
    private static float  FACTORALQUILERCASA = 1.0f;
    private static float  FACTORALQUILERHOTEL = 4.0f;
    
    // Indica que clase de casilla es la instancia.
    private TipoCasilla tipo;
    
    // Nombre de la casilla
    private String Nombre;
    
    // Contiene para las casillas de tipo calle los respectivos precios relacionados con dicha calle.
    float precioCompra;
    float precioEdificar;
    float precioBaseAlquiler;
    
    // Contiene para las casillas de tipo calle la cantidad de casas y hoteles que tiene edificados la calle.
    int numCasas;
    int numHoteles;
    
    // Propietario de la casilla
    Jugador propietario;
    
    // Casilla Sorpresa
    // - Mazo de la casilla
    MazoSorpresas mazo;
    //  - Sorpresa
    Sorpresa sorpresa;
    
    /* Metodos */
    
    /**
     * @brief Inicializar atributos a un valor por defecto.
     */
    private void init()
    {
        this.propietario = null;
        this.precioCompra = 0;
        this.precioEdificar = 0;
        this.precioBaseAlquiler = 0;
        this.numCasas = 0;
        this.numHoteles = 0;
    }
    
    /**
     * @brief Constructor para casillas tipo CALLE.
     * @param unTipo                    Tipo de casilla.
     * @param unNombre                  Nombre de la casilla.
     * @param unPrecioCompra            Precio de compra de la casilla.
     * @param unPrecioEdificar          Precio para edificar en la casilla.
     * @param unPrecioAlquilerBase      Precio de alquiler base.
     */
    Casilla(TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase)
    {
        init();
        
        this.tipo = unTipo;
        this.Nombre = unNombre;
        this.precioCompra = unPrecioCompra;
        this.precioEdificar = unPrecioEdificar;
        this.precioBaseAlquiler = unPrecioAlquilerBase;
    }
    
    /**
     * Constructor para casillas tipo DESCANSO
     * @param tipo      Tipo de casilla.
     * @param nombre    Nombre de la casilla.
     */
    Casilla(TipoCasilla tipo, String nombre)
    {
        init();

        this.tipo = tipo;
        this.Nombre = nombre;
    }
    
    /**
     * Constructor para casillas tipo SORPRESA
     * @param tipo      Tipo de casilla.
     * @param nombre    Nombre de la casilla.
     * @param mazo      Objeto de tipo MazoSorpresas
     */
    Casilla(TipoCasilla tipo, String nombre, MazoSorpresas mazo)
    {
        init();
        
        this.tipo = tipo;
        this.Nombre = nombre;
        this.mazo = mazo;
        this.sorpresa = null;
    }
    
    /**
     * @return Suma de la cantidad de casas y hoteles en la casilla.
     */
    public int cantidadCasasHoteles()
    {
        return this.numCasas + this.numHoteles;
    }
    
    /** [?] No aparece en UML; ¿se borra?
     * @return Nombre de la casilla.
     */
    String getNombre()
    {
        return this.Nombre;
    }
    
    /**
     * @brief Obtener el precio de comprar la casilla.
     * @return  Flotante con dicho precio.
     */
    float getPrecioCompra()
    {
        return this.precioCompra;
    }
    
    /**
     * @brief Obtener el precio de edificar la casilla.
     * @return  Flotante con dicho precio.
     */
    float getPrecioEdificar()
    {
        return this.precioEdificar;
    }
    
    /**
     * @brief Obtener el número de casas que hay en la casilla.
     * @return Número de casas.
     */
    int getNumCasas()
    {
        return this.numCasas;
    }
    
    /**
     * @brief Obtener el número de hoteles que hay en la casilla.
     * @return Número de casas.
     */
    int getNumHoteles()
    {
        return this.numHoteles;
    }
    
    /**
     * @brief Obtener el precio del alquiler completo del casilla.
     * @return Precio total del alquler.
     */
    float getPrecioAlquilerCompleto()
    {
        return (FACTORALQUILERCALLE * this.precioBaseAlquiler) * (FACTORALQUILERCASA + numCasas + (numHoteles * FACTORALQUILERHOTEL));
    }
    
    boolean construirCasa(Jugador jugador)
    {
        //5.1 
        this.propietario.paga(precioEdificar);
        //5.2
        this.numCasas++;
        //5.3
        return true;
    }
    
    boolean construirHotel(Jugador jugador)
    {
        // 3.1
        this.propietario.paga(this.precioEdificar);
        // 3.2
        this.numHoteles++;
        // 3.3
        return true;
    }

    /**
     * @brief Quitar un numero de casas.
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
     * @param jugador   Jugador 
     * @return Determina si el Jugador es el propietario de la casilla.
     */
    public boolean esEsteElPropietario(Jugador jugador)
    {
        return this.propietario == jugador;
    }
    
    /**
     * @brief Informa al diario del jugador que ha caido en la casilla actual.
     * @param iactual Indice de la lista de jugadores.
     * @param todos   Lista de todos los jugadores.
     */
    void informe(int iactual, ArrayList<Jugador> todos)
    {
        if(0 <= iactual && iactual < todos.size())
        {
            Jugador temp = todos.get(iactual);
            String evento = ("[Casilla] " + temp.getNombre()+" ha caido en " + this.Nombre);
            Diario.getInstance().ocurreEvento(evento);
        }
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos)
    {
        switch(this.tipo)
        {
            case CALLE:
                this.recibeJugador_calle(iactual, todos);
            break;
            
            case SORPRESA:
                this.recibeJugador_sorpresa(iactual, todos);
            break;
            
            case DESCANSO:
                this.informe(iactual, todos);
            break;
        }
    }
    
    private void recibeJugador_calle(int iactual, ArrayList<Jugador> todos)
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
    
    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos)
    {
        // 1
        this.sorpresa = this.mazo.siguiente();
        
        // 2
        this.informe(iactual, todos);
        
        // 3
        this.sorpresa.aplicarAJugador(iactual, todos);
    }
    
    /**
     * @return Devuelve true si tiene propietario asignado, false en caso contrario.
     */
    public boolean tienePropietario()
    {
        return this.propietario != null;
    }
    
    /**
     * @brief Tramitar el alquiler de una casilla.
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
     * @brief Obtener el estado actual del objeto.
     * @return Lista con los atributos y su estado.
     */
    @Override
    public String toString()
    {
        String info = "";
        
        switch(this.tipo)
        {
            case CALLE:
                info = ("CALLE (Propietario: ");
                if(this.propietario != null)
                    info += this.propietario.getNombre();
                else
                    info += ("N/A");
                
                info +=(", Nombre: " + this.Nombre + ", Precio: " + this.precioCompra + "€, Edificar: "+ this.precioEdificar +"€, Base alquiler: " + this.precioBaseAlquiler
                + "€, Casas: " + this.numCasas + ", Hoteles: "+ this.numHoteles + ")");
            break;
            
            case DESCANSO:
                info = ("DESCANSO ("+ this.Nombre +")");
            break;
            
            case SORPRESA:
                info = ("SORPRESA ("+ this.Nombre + ")");
            break;
        }
        
        return info;
    }
    
    /**
     * La casilla es comprada por el jugador.
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
    
}
