# encoding:utf-8

require_relative 'Controlador_laberinto/Controlador'
require_relative 'Controlador_laberinto/Estado_juego'
require_relative 'modelo_laberinto/laberinto'

class Vista_laberinto

  def initialize(controlador)
    @controlador = controlador
  end

  def informe_dentro(habitacion, vidas)
    puts("Estoy en la habitación #{habitacion.num_habitacion} y tengo #{vidas} vida(s).")
  end

  def informe_final(habitacion, vidas)
    if vidas.to_i < 1
      puts("He muerto en la habitación #{habitacion.num_habitacion}")
    else
      puts("He logrado salir del laberinto con #{vidas.to_i} vida(s).")
    end
  end

  def menu_usuario
    gameStatus = Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO

    while gameStatus !=  Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO && gameStatus != Controlador_laberinto::Estado_juego::DENTRO_MUERTO
      case gameStatus
      when Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO
        validLives = false
        inputLives = -1
        puts ">>INICIO DEL JUEGO"
        while !validLives
          puts ">Ingresa un número de vidas (1 hasta 10):"
          inputLives = gets.chomp()
          if 0 < inputLives.to_i && inputLives.to_i <= 10
            validLives = true
          else
            puts ">Valor erróneo, tiene que ser entre 1 y 10."
          end
        end
        @controlador.entrar(inputLives)

      when Controlador_laberinto::Estado_juego::DENTRO_VIVO
        habs = @controlador.habitacion_usuario
        lives = @controlador.vidas
        informe_dentro(habs, lives)
        puts ">Presiona una tecla para avanzar"
        inputVal = gets.chomp()
        dir = @controlador.intentar_avanzar()
        puts "Intento avanzar en dirección #{dir}"
      end

      gameStatus = @controlador.estado

      if gameStatus == Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO || gameStatus == Controlador_laberinto::Estado_juego::DENTRO_MUERTO
        habs = @controlador.habitacion_usuario
        lives = @controlador.vidas
        informe_final(habs, lives)
      end
    end
  end
end

maze = Modelo_laberinto::Laberinto.new
controller = Controlador_laberinto::Controlador.new(maze)
vista = Vista_laberinto.new(controller)

vista.menu_usuario