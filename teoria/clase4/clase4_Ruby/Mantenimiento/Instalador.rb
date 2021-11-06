
# Revisado = OK
module Mantenimiento
  class Instalador

    @@tarifa

    def initialize(nombre, telefono)
      @nombre = nombre
      @telefono = telefono
      @persianas = Array.new
    end

    attr_accessor :nombre, :telefono

    def realizar_mantenimiento(codigo_mantienimiento)

    end

  end
end
