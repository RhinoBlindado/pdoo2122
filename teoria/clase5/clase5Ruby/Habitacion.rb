module Domotica

  class Habitacion

    attr_reader :idHabitacion, :luminosidadActual

    def initialize(id, luminosidad)
      @idHabitacion = id
      @luminosidadActual = luminosidad
      @bombillas = Array.new
      @instalacion_persiana = nil
    end

    def ajustarLuzNatural(nivel)
      seguirSubiendo = true
      while(seguirSubiendo)
        # 1.3.1
        subida = @instalacion_persiana.estaCompletamenteSubida
        if(!subida)
          #1.3.2
          @instalacion_persiana.subirPersiana
          #nota
          seguirSubiendo = (@luminosidadActual<nivel)
        else
          #nota
          seguirSubiendo = false
        end
      end
    end

    def ajustarLuzArtificial(nivel)
      i=0
      while(i<@bombillas.length && @luminosidadActual<nivel)
        #1.4.1
        b=@bombillas.at(i)
        #1.4.2
        b = true
        i=i+1
      end
    end

    def comprobarMantenimiento
    end

    def incluirBombilla(localizacion)
    end

    def incluirPersiana(fechaEstimadaDuracion)
    end

  end

end
