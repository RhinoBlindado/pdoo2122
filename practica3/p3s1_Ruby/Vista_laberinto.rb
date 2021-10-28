# encoding:utf-8

# require_relative controlador_laberinto/Controlador

class Vista_laberinto

  def initialize(controlador)
    @controlador = controlador
  end

  def menu_usuario
    gameStatus = @controlador.estado

    while gameStatus != "EN_SALIDA_LABERINTO" && gameStatus != "DENTRO_MUERTO"
      case gameStatus
      when "EN_EMTRADA_LABERINTO"
        validLives = false
        inputLives = -1
        puts ">>INICIO DEL JUEGO"
        while !validLives
          puts ">Ingresa un número de vidas (1 hasta 10):"
          inputLives = gets.chomp()
          if 0 < inputLives && inputLives <= 10
            validLives = true
          else
            puts ">Valor erróneo, tiene que ser entre 1 y 10."
          end
        end
        @controlador.entrar(inputLives)

      when "DENTRO_VIVO"
        habs = @controlador.habitacion_usuario
        lives = @controlador.vidas
        informe_dentro(habs, lives)
        puts ">Presiona una tecla para avanzar"
        inputVal = gets.chomp()
        dir = @controlador.intentar_avanzar()
        puts "Intento avanzar en dirección #{dir}"

      else
        habs = @controlador.habitacion_usuario
        lives = @controlador.vidas
        informe_final(habs, lives)
    end
  end

  def informe_dentro(habitacion, vidas)
    puts("Estoy en la habitación"+habitacion.num_habitacion+" y tengo "+vidas+" vida(s).")
  end

  def informe_final(habitacion, vidas)
    if(vidas < 1)
      puts("He muerto en la habitación "+habitacion.num_habitacion)
    else
      puts("He logrado salir del laberinto con "+vidas+" vida(s).")
    end
  end

end