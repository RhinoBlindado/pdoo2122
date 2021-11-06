# encoding:utf-8

module Controlador_laberinto

  class Controlador

    attr_reader :habitacion_usuario, :vidas, :estado

    def initialize(laberinto)
      @vidas = 0.to_i
      @modelo = laberinto
      @estado = Estado_juego::EN_ENTRADA_LABERINTO
      @habitacion_usuario = nil
    end

    def entrar(vidas)
      entryPoint = @modelo.puerta_entrada
      @vidas = vidas
      @habitacion_usuario = entryPoint.habitacion_al_otro_lado(nil)
      @habitacion_usuario.set_lado(Modelo_laberinto::Direccion::SUR, Modelo_laberinto::Elemento_separador::nueva_pared(@habitacion_usuario, nil))
      @estado = Estado_juego::DENTRO_VIVO

    end

    def intentar_avanzar()
      direction = rand(4)
      if @habitacion_usuario.pasar(direction)
        separator = @habitacion_usuario.get_lado(direction)
        @habitacion_usuario = separator.habitacion_al_otro_lado(@habitacion_usuario)
        if @habitacion_usuario == nil
          @estado = Estado_juego::EN_SALIDA_LABERINTO
        end
      else
        @vidas = @vidas.to_i - 1
        if @vidas == 0
          @estado = Estado_juego::DENTRO_MUERTO
        end
      end
      return Modelo_laberinto::Lista_direcciones[direction]
    end

  end
end
