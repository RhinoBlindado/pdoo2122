
module Domotica

  class Instalacion_Persiana

    def initialize(fecha_instalacion, fecha_estimada_duracion, persiana, instalador)
      @fecha_instalacion = fecha_instalacion
      @fecha_estimada_duracion = fecha_estimada_duracion
      @persiana = persiana
      @instalador = instalador
    end

    attr_reader :fecha_instalacion, :fecha_estimada_duracion
    attr_writer :fecha_estimada_duracion

    def subir_persiana

    end

    def bajar_persiana

    end

    def esta_completamente_bajada

    end

  end
end
