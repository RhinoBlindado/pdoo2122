package civitas;

/**
 *
 * @author valentino
 */
public class Casilla 
{
    /* ATRIBUTOS:
    *************/
    
    // - Indica que clase de casilla es la instancia.
    private TipoCasilla tipo;
    
    // - Nombre de la casilla
    private String Nombre;
    
    // - Contiene para las casillas de tipo calle los respectivos precios relacionados con dicha calle.
    float precioCompra, precioEdificar, precioBaseAlquiler;
    
    // - Contiene para las casillas de tipo calle la cantidad de casas y hoteles que tiene edificados la calle.
    int numCasas, numHoteles;
    
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
}
