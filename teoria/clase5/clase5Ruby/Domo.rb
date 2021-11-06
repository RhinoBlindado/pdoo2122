module Domotica

  class Domo

    def initialize
      @habitaciones = Array.new #Atributo de referencia
    end

    #Los métodos por defecto en Ruby son públicos...
    def gestionarMantenimiento
    end

    def subirLuz(nivel, idHabitacion)
      #1.1
      hab = buscarHabitacion(idHabitacion)
      #1.2
      luminosidad = hab.luminosidadActual

      if(luminosidad<nivel)
        # 1.3
        hab.ajustarLuzNatural(nivel)
        # 1.4
        hab.ajustarLuzArtificial(nivel)
      end
    end

    def bajarLuz(nivel, idHabitacion)
    end

    def incluirHabitacion(idHabitacion)
    end

    def incluirBombilla(idHabtiacion, localizacion)
    end

    def incluirPersiana(idHabitacion, fechaEstimadaDuracion)
    end

    #... a no ser que indiquemos lo contrario
    private #OJO! todos los métodos que declare después de esta palabra clave serán privados
    def buscarHabitacion(idHabitacion)
      i = 0
      hab = nil
      while i < @habitaciones.length do
        currHab = @habitaciones.at(i)
        if(currHab.idHabitacion == i)
          hab=currHab
        end
      end
      return hab
    end
  end
end
