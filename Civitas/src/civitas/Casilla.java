package civitas;

/**
 *
 * @author valentino
 */
public class Casilla 
{
    /* ATRIBUTOS:
    *************/
    
    // INSTANCIA
    // - Indica que clase de casilla es la instancia.
    private TipoCasilla tipo;
    
    // - Nombre de la casilla
    private String Nombre;
    
    // - Contiene para las casillas de tipo calle los respectivos precios relacionados con dicha calle.
    float precioCompra;
    float precioEdificar;
    float precioBaseAlquiler;
    
    // - Contiene para las casillas de tipo calle la cantidad de casas y hoteles que tiene edificados la calle.
    int numCasas;
    int numHoteles;
    
    // CONSTANTES
    // - Constantes 
    private final float  FACTORALQUILERCALLE = 1.0f;
    private final float  FACTORALQUILERCASA = 1.0f;
    private final float  FACTORALQUILERHOTEL = 4.0f;
    
    /* METODOS:
    *************/
    
    // CONSTRUCTORES
    /**
     * @brief Constructor con parámetros para crear casillas de tipo calle.
     * @param unTipo                    Tipo de casilla.
     * @param unNombre                  Nombre de la casilla.
     * @param unPrecioCompra            Precio de compra de la casilla.
     * @param unPrecioEdificar          Precio para edificar en la casilla.
     * @param unPrecioAlquilerBase      Precio de alquiler base.
     */
    Casilla(TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase)
    {
        // Se inicializan los atributos con los parámetros que recibe el constructor.
        this.tipo = unTipo;
        this.Nombre = unNombre;
        this.precioCompra = unPrecioCompra;
        this.precioEdificar = unPrecioEdificar;
        this.precioBaseAlquiler = unPrecioAlquilerBase;
        
        // No tienen parametros: Se añade un valor por defecto razonable.
        this.numCasas = 0;
        this.numHoteles = 0;
    }
    
    // CONSULTORES
    /**
     * @brief Obtener el nombre de la casilla.
     * @return String con el Nombre de la casilla.
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
    
    // MODIFICADORES
    /**
     * @brief Construye una casa en la casilla.
     * @return Verdadero en cualquier caso.
     */
    boolean construirCasa()
    {
        this.numCasas++;
        return true;
    }
    
    /**
     * @brief Construye un hotel en la casilla.
     * @return  Verdadero en cualquier caso.
     */
    boolean construirHotel()
    {
        this.numHoteles++;
        return true;
    }
    
    // AUXILIARES
    /**
     * @brief Obtener el estado actual del objeto.
     * @return Lista con los atributos y su estado.
     */
    public String toString()
    {
        return ("Casilla (Tipo: " + this.tipo+", Nombre: " + this.Nombre + ", Precio Compra: " + this.precioCompra + ", Precio Base Alquiler: " + this.precioBaseAlquiler
                + ", Nº Casas: " + this.numCasas + ", Nº Hoteles: "+ this.numHoteles + ")");
    }
    
    /**
     * @brief Compara la identidad de dos casillas.
     * @param otraCasilla   Otro objeto casilla.
     * @return Verdadero si es el mismo objeto, Falso en caso contrario.
     */
    boolean igualdadIdentidad(Casilla otraCasilla)
    {
        return this == otraCasilla;
    }
    
    /**
     * @brief Compara el estado de dos casillas.
     * @param otraCasilla   Otro objeto casilla.
     * @return Verdadero si los objetos tienen el mismo estado, Falso en caso contrario.
     */
    boolean igualdadEstado(Casilla otraCasilla)
    {
        return  this.Nombre.equals(otraCasilla.Nombre) &&
                this.precioBaseAlquiler == otraCasilla.precioBaseAlquiler &&
                this.precioCompra == otraCasilla.precioCompra &&
                this.precioEdificar == otraCasilla.precioEdificar &&
                this.numCasas == otraCasilla.numCasas &&
                this.numHoteles == otraCasilla.numHoteles;
    }
}
