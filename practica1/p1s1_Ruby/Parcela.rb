# encoding:utf-8

module P1S1
  class Parcela

    def initialize(nombre, precio_compra, precio_edificar, precio_base_alquiler)
      @nombre = nombre
      @precio_compra = precio_compra
      @precio_edificar = precio_edificar
      @precio_base_alquiler = precio_base_alquiler

      @numCasas = 0
      @numHoteles = 0
    end

    attr_reader :nombre, :precio_compra, :numCasas, :numHoteles

    def construir_casa()
      @numCasas += 1
      return TRUE
    end

    def construir_hotel()
      @numHoteles += 1
      return  TRUE
    end

    def precio_alquiler_completo()
      return @precio_base_alquiler * (1 + @numCasas + (@numHoteles * 4))
    end

  end

end
