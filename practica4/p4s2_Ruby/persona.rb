module Herencia

  class Persona
    def initialize(nombre)
      @nombre = nombre
    end

    def andar
      result = "Soy #{@nombre} y estoy andando"
    end

    def to_s
      result = "Soy una persona y mi hombre es #{@nombre}"
    end

  end


  class Deportista < Persona

    def initialize(nombre, horas)
      super(nombre)
      @horas_entrenamiento = horas
    end

    def competicion_deportiva
      result = "Soy #{@nombre} y voy a una competición deportiva."
    end

    def to_s
      result = super
      result += " y soy un deportista"
      return result
    end

  end

  class Corredor < Deportista
    def correr
      "Soy #{@nombre} y estoy corriendo."
    end

    def to_s
      result = super
      result += " y corro"
    end
  end

  class Nadador < Deportista
    def nadar
      "Soy #{@nombre} y estoy nadando."
    end

    def to_s
      result = super
      result += " y nado"
    end
  end

  # 2.1 R: No es necesario un constructor si no se añaden más atributos
  # 2.2 R: Si no hay un constructor se utiliza el del padre.
  # 2.3 R: Las clases son heredadas de las clases superiores en la jerarquía

  # 3.1 R: Los atributos pueden acceder a sus propios métodos y a los métodos que heredan de su padre y abuelo.


  dep = Deportista.new("Antonio", 20)
  puts dep.to_s
  puts dep.competicion_deportiva

  nad = Nadador.new("Mabe", 999)
  puts nad.to_s
  puts nad.nadar
  puts nad.competicion_deportiva
  puts nad.andar

  cor = Corredor.new("Carlos", 12)
  puts cor.to_s
  puts cor.correr
  puts cor.competicion_deportiva

end