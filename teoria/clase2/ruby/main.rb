#encoding: UTF-8
module Clase1
    require_relative 'mesa'
    require_relative 'otroModulo'

    m1 = Mobiliario::Mesa.new(15)
    m2 = Mobiliario::Mesa.new()

    puts ("Mesa con constructor parametrizado: " + m1.height.to_s)
    puts ("Mesa con constructor por defecto : " + m2.height.to_s)

    m1.height = 20
    m2.height = -1
    puts("Cambiando altura de mesa 1 a 20 metros: " + m1.height.to_s)
    puts("Cambiando altura de mesa 2 a -1 metros: " + m2.height.to_s)

    c1 = OtroModulo::Cosa.new()

    puts "En cosa hay: #{c1.mensaje}"
    puts "Modulo Interno: #{OtroModulo::ModuloInterno::hola}"
end