# encoding:utf-8

# [CASTELLANO]
# Ejercicios - Practica 1 Sesión 1 (Ruby)
# Asignatura: Programación y Diseño Orientado a Objetos
# Autor: Valentino Lugli (Github: @RhinoBlindado)
# Fecha: Septiempre 2021
#
#
# [ENGLISH]
# Exercises - Practice 1 Session 1 (Ruby)
# Course: Object Oriented Programming and Design
# Author: Valentino Lugli (Github: @RhinoBlindado)
# Date: September 2021

module P1S1
  require_relative 'Parcela'

  anor_londo = Parcela.new("Anor Londo", 400, 600, 150)

  ret = anor_londo.construir_hotel
  anor_londo.construir_casa

  puts "Esta parcela se llama #{anor_londo.nombre} y tiene #{anor_londo.numCasas} casa(s) y #{anor_londo.numHoteles} hotel(es)."
  puts "El valor de ret es #{ret}"
end
