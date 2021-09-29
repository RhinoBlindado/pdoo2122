package civitas;

/**
 *
 * @author valentino
 */
public class Casilla 
{
    /* ATRIBUTOS INSTANCIA:
    *************/
    
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
    // - Constructor de Casillas Tipo Calle
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
    String getNombre()
    {
        return this.Nombre;
    }
    
    float getPrecioCompra()
    {
        return this.precioCompra;
    }
    
    float getPrecioEdificar()
    {
        return this.precioEdificar;
    }
    
    int getNumCasas()
    {
        return this.numCasas;
    }
    
    int getNumHoteles()
    {
        return this.numHoteles;
    }
    
    float getPrecioAlquilerCompleto()
    {
        return (FACTORALQUILERCALLE * this.precioBaseAlquiler) * (FACTORALQUILERCASA + numCasas + (numHoteles * FACTORALQUILERHOTEL));
    }
    
    boolean construirCasa()
    {
        this.numCasas++;
        return true;
    }
    
    boolean construirHotel()
    {
        this.numHoteles++;
        return true;
    }
    
    public String toString()
    {
        return ("Casilla (Tipo: " + this.tipo+", Nombre: " + this.Nombre + ", Precio Compra: " + this.precioCompra + ", Precio Base Alquiler: " + this.precioBaseAlquiler
                + ", Nº Casas: " + this.numCasas + ", Nº Hoteles: "+ this.numHoteles + ")");
    }
}
