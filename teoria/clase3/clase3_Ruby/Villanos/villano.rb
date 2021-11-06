
module Villanos
  class Villano

    def initialize(nombre, esconditeS, fortuna, mayordomo)
      @nombre = nombre
      @escondite_secreto = esconditeS
      @fortuna = fortuna
      @mayordomo = mayordomo
      @planes = Array.new
    end

    attr_writer :fortuna

    def seguir_plan_prioritario
    end

    def primer_plan_activo
    end

  end
end
