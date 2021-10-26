
package atributosmetodos;

public class Persona {
    private String nombre;
    private int edad;
    private static int numPersonas=0;
    
    Persona(String nombre, int anios){
        this.nombre = nombre;
        edad = anios;
        numPersonas++;
    }
    
    //Método de clase
    static void metodoClase(){
        //esMayorEdad();
    }
    
    //Método instancia
    Boolean esMayorEdad(){                
        //nombre="otro";
        //numPersonas = 4;
        return (edad >= 18);
    }
    
    
    //Consultor de atributo de clase
    static int getNumPersonas(){
        return numPersonas;
    }
    
    
    //Consultor
    String getNombre(){
        return nombre;
    }
    
    //Modificador
    void setNombre(String n){
        nombre = n;
    }
}