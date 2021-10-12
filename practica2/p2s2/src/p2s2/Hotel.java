package p2s2;

import java.util.ArrayList;

/**
 *
 * @author valentino
 */
public class Hotel 
{
    private static int NUM_HOTELES = 0;
    private String nombre;
    private String ciudad;
    private int estrellas;
    
    /** 
     * Hotel x-> Director
     * - Se asume multiplicidad de 1 por los métodos de la clase.
     */
    private Director director;
    
    /**
     * Hotel <-> (1..*) Reserva
     */
    private ArrayList<Reserva> reservas;
    
    /**
     * Hotel < >--> (1..*) Empleado  
     */
    private ArrayList<Empleado> empleados;
    
    /**
     * Hotel <·>--> (1..*) Habitacion
     */
    private ArrayList<Habitacion> habitaciones;
    
    public Hotel(String nombre, String ciudad, int estrellas)
    {
        NUM_HOTELES++;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        this.director = null;
        this.reservas = new ArrayList<Reserva>();
        this.empleados = new ArrayList<Empleado>();
        this.habitaciones = new ArrayList<Habitacion>();
    }
    
    public int getNUM_HOTELES()
    {
        return NUM_HOTELES;
    }
    
    public void setDirector(Director director)
    {
        this.director = director;
    }
    
    public Director getDirector()
    {
        return this.director;
    }
    
    public void addReserva(Cliente cliente, String fchaEntrada, String fchaSalida)
    {
        /**
         * - Para añadir una reserva, puesto que en el diagrama de clases el Hotel es quien rescibe
         * los parámetros para construir una reserva se ha asumido que entonces el Hotel crea la reserva
         * y se añade a la lista propia.
         * 
         * - Además, en el constructor de la clase reserva, el objeto reserva se añade así mismo en la lista
         * de la clase Cliente, puesto que Cliente solo posee 'addReserva(Reserva: reserva)'.
         */
        this.reservas.add(new Reserva(fchaEntrada, fchaSalida, cliente, this));
    }
    
    public ArrayList<Reserva> getReservas()
    {
        return this.reservas;
    }
    
    public boolean addEmpleado(Empleado empleado)
    {
        boolean addedWorker = false;
        
        if(empleado.addTrabajo(this))
        {
            this.empleados.add(empleado);
            addedWorker = true;
        }
        
        return addedWorker;
    }
    
    public ArrayList<Empleado> getEmpleado()
    {
        return this.empleados;
    }
    
    public void addHabitacion(int numero, int capacidad)
    {

        this.habitaciones.add(new Habitacion(numero, capacidad));
    }
    
    public int buscarHabitacionCapacidad(int capacidad)
    {
        int habNumber = -1;
        
        /**
         * Este método encontrará la primera habitacion que cumpla
         * la condición de manera desoredenada puesto que no se 
         * especifica que la lista debe estar ordenada de alguna manera.
         */
        
        for(int i=0; i<this.habitaciones.size(); i++)
        {
            if(this.habitaciones.get(i).getCapacidad() >= capacidad)
            {
                habNumber = this.habitaciones.get(i).getNumero();
                break;
            }
        }
        
        return habNumber;
    }
}
