module OtroModulo
  class Cosa
    def initialize
      @numero = 4
      @mensaje = "The"
    end

    attr_reader :numero, :mensaje

  end

  module ModuloInterno
    def hola
      puts "Buenas"
    end

  end

end
