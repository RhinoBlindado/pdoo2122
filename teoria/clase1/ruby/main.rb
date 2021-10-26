#encoding: UTF-8
module Clase1
    require_relative 'mesa'

    m1 = Mesa.new(15)
    m2 = Mesa.new()

    puts ("Clase 1: ")
    puts ("Mesa con constructor parametrizado: " + m1.height.to_s)
    puts ("Mesa con constructor por defecto : " + m2.height.to_s)
end