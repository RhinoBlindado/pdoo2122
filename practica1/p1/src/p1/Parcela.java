/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

/**
 *
 * @author valentino
 */
public class Parcela 
{
    private String nombre;
    
    private float precioCompra; 
    private float precioEdificar; 
    private float precioBaseAlquiler;

    private int numCasas;
    private int numHoteles;
    
    private final float  FACTORALQUILERCALLE = 1.0f;
    private final float  FACTORALQUILERCASA = 1.0f;
    private final float  FACTORALQUILERHOTEL = 4.0f;

    Parcela (String p_nombre, float p_precioCompra, float p_precioEdificar, float p_precioBaseAlquiler)
    {
        this.nombre = p_nombre;
        this.precioCompra = p_precioCompra;
        this.precioEdificar = p_precioEdificar;
        this.precioBaseAlquiler = p_precioBaseAlquiler;
        this.numCasas = 0;
        this.numHoteles = 0;
    }
    
    String getNombre()
    {
        return this.nombre;
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
        // Antes
        // return this.precioBaseAlquiler * (1 + numCasas + (numHoteles * 4));
        
        // Ejercicio 2.1
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
    
    boolean igualdadIdentidad(Parcela otraParcela)
    {
        return this == otraParcela;
    }
    
    boolean igualdadEstado(Parcela otraParcela)
    {
        return  this.nombre.equals(otraParcela.nombre) &&
                this.precioBaseAlquiler == otraParcela.precioBaseAlquiler &&
                this.precioCompra == otraParcela.precioCompra &&
                this.precioEdificar == otraParcela.precioEdificar &&
                this.numCasas == otraParcela.numCasas &&
                this.numHoteles == otraParcela.numHoteles;
    }
}
