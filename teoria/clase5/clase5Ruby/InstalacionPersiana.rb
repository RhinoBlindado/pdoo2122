module Domotica

  class InstalacionPersiana

    attr_accessor :fechaEstimadaDuracion
    attr_reader :fechaInstalacion

    def initialize(fechaInstalacion, fechaDuracion, instalador, persiana)
      @fechaInstalacion = fechaInstalacion
      @fechaEstimadaDuracion = fechaDuracion
      @instalador = instalador
      @persiana = persiana
    end

    def subirPersiana
    end

    def bajarPersiana
    end

    def estaCompletamenteSubida
    end

  end

end
