package controladorCivitas;

import civitas.CivitasJuego;
import civitas.GestionInmobiliaria;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import vistaTextualCivitas.VistaTextual;

/**
 *
 * @author Lugli, Valentino Glauco
 */
public class Controlador 
{
    private CivitasJuego juego;
    private VistaTextual vista;
    
    public Controlador(CivitasJuego juego, VistaTextual vista)
    {
        this.juego = juego;
        this.vista = vista;
    }
    
    /**
     * Método base donde se ejecuta el juego
     * @see Práctica 3, /docs/P3-guion.pdf
     */
    public void juega()
    {
        OperacionJuego currOp;
        boolean gameEnded = false;
        Respuesta ret = null;
        OperacionInmobiliaria op = null;
        int prop = -1;
        
        // Mientras no se haya producido el final del juego
        while(!gameEnded)
        {
            // Llamar al método actualiza de la vista para que muestre el estado del juego en cada momento
            this.vista.actualiza();
            
            // Indicar a la vista que haga una pausa. Esto hará que el juego espere la interacción del usuario entre turno y turno.
            this.vista.pausa();
            
            // Pedir al modelo que lleve a cabo el siguiente paso y pedir a la vista que muestre la siguiente operación a realizar.
            currOp = this.juego.siguientePaso();
            this.vista.mostrarSiguienteOperacion(currOp);
            
            // Si la operación anterior no es pasar de turno: indicar a la vista que muestre los eventos pendientes del diario.
            if(currOp != OperacionJuego.PASAR_TURNO)
                this.vista.mostrarEventos();
            
            // Actualizar la condición de juego terminado.
            gameEnded = this.juego.finalDelJuego();
            
            if(!gameEnded)
            {
                if(currOp == OperacionJuego.COMPRAR)
                {
                    ret = this.vista.comprar();
                        
                    if(ret == Respuesta.SI)
                    {
                        this.juego.comprar();
                    }
                        
                    this.juego.siguientePasoCompletado(currOp);
                }
                else if(currOp == OperacionJuego.GESTIONAR)
                {
                    op = this.vista.elegirOperacion();
                    if(op != OperacionInmobiliaria.TERMINAR)
                    {
                        prop = this.vista.elegirPropiedad();
                        GestionInmobiliaria actualGest = new GestionInmobiliaria(op, prop);
                        
                        if(op == OperacionInmobiliaria.CONSTRUIR_CASA)
                        {
                            this.juego.construirCasa(prop);
                        }
                        
                        if(op == OperacionInmobiliaria.CONSTRUIR_HOTEl)
                        {
                            this.juego.construirHotel(prop);
                        }
                    }
                    else
                    {
                        this.juego.siguientePasoCompletado(currOp);
                    }
                }
            }
            else
            {
                // Se llama cuando ha finalizado el juego para mostrar el ranking.
                this.vista.actualiza();
            }

        }
    }
}
