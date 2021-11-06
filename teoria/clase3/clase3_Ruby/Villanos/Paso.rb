
module Villanos
  class Paso
    def initialize(descripcion, fecha_limite, inversion, ganancia)
      @descripcion = descripcion
      @fecha_limite = fecha_limite
      @inversion = inversion
      @ganancia = ganancia
      @terminado = false
    end

    attr_reader :inversion, :ganancia
    attr_writer :terminado

  end
end
