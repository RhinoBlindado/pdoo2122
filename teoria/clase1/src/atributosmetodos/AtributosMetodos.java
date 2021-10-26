package atributosmetodos;

public class AtributosMetodos {

    
    public static void main(String[] args) {
        
        Persona p1 = new Persona("mengano", 20);
        System.out.println(p1.getNumPersonas());
        System.out.println(p1.getNombre());
        
        Persona p2 = new Persona("fulano", 56);
        System.out.println(p1.getNumPersonas());
        System.out.println(p2.getNumPersonas());
        
        System.out.println(Persona.getNumPersonas());
       
        Persona.metodoClase();
        System.out.println(p1.esMayorEdad());
        

        System.out.println("Clase 1: ");

        Mesa m1 = new Mesa(15),
             m2 = new Mesa();
        
        System.out.println("Mesa con constructor parametrizado: "+ m1.getHeight() + "\nMesa con constructor por defecto: " + m2.getHeight());
        
        System.out.print("\n");
    }
    
}
