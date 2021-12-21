package civitas;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class JugadorEspeculador extends Jugador 
{
    /* Atributos*/
    private static int factorEspeculador = 2;
    
    /* Métodos */
    /**
     * Constructor por copia
     * @param otro Jugador a convertir a especulador.
     */
    protected JugadorEspeculador(Jugador otro) 
    {
        super(otro);
        this.actualizaPropiedadesPorConversion();
    }

    /**
     * Actualiza las propiedades de Jugador a JugadorEspeculador
     */
    void actualizaPropiedadesPorConversion()
    {
        for(int i = 0; i < this.propiedades.size(); i++)
        {
            this.propiedades.get(i).actualizaPropietarioPorConversion(this);
        }
    }
    
    @Override
    public String toString()
    {
        String canBuy;
        
        if(this.puedeComprar)
            canBuy = "Sí";
        else
            canBuy = "No";
        
        return ("Jugador Especulador: "+this.nombre+", Casilla actual: "+this.casillaActual+", ¿Puede intentar comprar? "+ canBuy +", Saldo: "+this.saldo+"€");
    }
    
    /**
     * Obtener cantidad maxima de casas.
     * @return  Retorna la cantidad máxima de casas.
     */
    @Override
    protected int getCasasMax()
    {
        return super.getCasasMax() * factorEspeculador;
    }
    
    
    /**
     * Obtener cantidad maxima de hoteles.
     * @return Retorna la cantidad máxima de hoteles.
     */
    @Override
    protected int getHotelesMax()
    {
        return super.getHotelesMax() * factorEspeculador;
    }
    
    @Override
    JugadorEspeculador convertir()
    {
        return null;
    }
   
    @Override
    public String getEspeculador() 
    {
        return "Verdadero";
    }
}
