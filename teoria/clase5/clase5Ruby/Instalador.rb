module Mantenimiento

  class Instalador

      attr_accessor :nombre, :telefono
      
      @@tarifa

      def initialize(nombre, telefono)
        @nombre = nombre
        @telefono = telefono
        @instalacionesPersiana = Array.new
      end

      def realizarMantenimiento(c)
      end
  end

end
