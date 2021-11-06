module Domotica

  class Bombilla

    attr_accessor :estado
    attr_reader :localizacion

    def initialize(localizacion)
      @estado = false
      @localizacion = localizacion
    end

  end

end
