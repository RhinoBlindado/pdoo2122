
# Revisado: OK
module Domotica
  class Habitacion

    def initialize(id_habitacion)
      @id_habitacion = id_habitacion
      @luminosidad_actual = 0
      @bombillas = Array.new
      @instalacion_persiana = nil
    end

    attr_reader :id_habitacion, :luminosidad_actual

    def ajustar_luz_natural(nivel)

    end

    def ajustar_luz_artificial(nivel)

    end

    def comprobar_codigo_mantenimiento

    end

    def incluir_bombilla(localizacion)

    end

    def incluir_persiana(fecha_estimada_duracion)

    end

  end
end
