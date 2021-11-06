module Villanos
  class Plan

    def initialize(nombre, fecha_consecuscion, prioridad, objetivo)
      @nombre = nombre
      @fecha_consecusion = fecha_consecuscion
      @prioridad = prioridad
      @posicion_paso_siguiente = 0
      @terminado = false
      @pasos = Array.new
      @objetivo = objetivo
    end

    attr_reader :terminado

    def estaActivo
    end

    def darPasoSiguiente
    end

    def inversionPasoSiguiente
    end

  end
end
