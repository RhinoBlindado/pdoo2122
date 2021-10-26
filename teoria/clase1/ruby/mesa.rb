#encoding: UTF-8

class Mesa
  
	def initialize(height = 1)
		@height = height
	end

	def height
		@height
	end

	attr_accessor :height

end