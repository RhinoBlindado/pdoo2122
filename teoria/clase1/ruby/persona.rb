#encoding: UTF-8

class Persona

  @@atributoclase = "Atributo clase"
  @nombre = "Atributo de instancia de la clase"
  
  def initialize(nombre, apellido)
    @nombre = nombre
    @apellido = apellido
    @nombre_completo = self.nombre + " " + self.apellido
  end

  def what
    puts @nombre_completo
  end
#  private_class_method :metodoClase
  attr_reader :nombre
  attr_reader :apellido
end

p = Persona.new("Fulano", "Perez")
  #en java: Persona p = new Persona("fulano", 34);

#p.metodoClase ERROR! <-- En Java funciona!
#Persona.metodoInstancia - Error!

p.what
