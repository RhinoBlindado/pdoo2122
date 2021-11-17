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
     * @return  Retorna la cantidad máxima de casas.
     */
    @Override
    protected int getCasasMax()
    {
        return super.getCasasMax() * factorEspeculador;
    }
    
    
    /**
     * @return Retorna la cantidad máxima de hoteles.
     */
    @Override
    protected int getHotelesMax()
    {
        return super.getHotelesMax() * factorEspeculador;
    }
    
    
    
}
