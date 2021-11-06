
module Domotica
  class Bombilla
    def initialize(localizacion)
      @estado = false
      @localizacion = localizacion
    end
    attr_accessor :estado
    attr_reader :localizacion
  end
end
