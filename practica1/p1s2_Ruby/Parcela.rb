# encoding:utf-8

module P1S1
  class Parcela

    # Ejercicio 2.2
    # @@FACTORIALALQUILERCALLE = 1.0
    # @@FACTORIALALQUILERCASA = 1.0
    # @@FACTORIALALQUILERHOTEL = 4.0

    # Ejercicio 2.3
      @FACTORIALALQUILERCALLE = 1.0
      @FACTORIALALQUILERCASA = 1.0
      @FACTORIALALQUILERHOTEL = 4.0

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

    # Ejercicio 2.2
    # def precio_alquiler_completo()
    #   return @@FACTORIALALQUILERCALLE * @precio_base_alquiler * (@@FACTORIALALQUILERCASA + @numCasas + (@numHoteles * @@FACTORIALALQUILERHOTEL))
    # end

    # Ejercicio 2.3
    def precio_alquiler_completo()
         return self.class.FACTORIALALQUILERCALLE * @precio_base_alquiler * (self.class.FACTORIALALQUILERCASA + @numCasas + (@numHoteles * self.class.FACTORIALALQUILERHOTEL))
    end

    private
    def self.FACTORIALALQUILERCALLE
      @FACTORIALALQUILERCALLE
    end

    def self.FACTORIALALQUILERCASA
      @FACTORIALALQUILERCASA
    end

    def self.FACTORIALALQUILERHOTEL
      @FACTORIALALQUILERHOTEL
    end

  end

end
