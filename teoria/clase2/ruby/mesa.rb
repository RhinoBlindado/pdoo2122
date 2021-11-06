#encoding: UTF-8
module Mobiliario
	class Mesa

		def initialize(height = 1)
			@height = height
		end

		attr_reader :height

		def height=(p_height)
			if p_height > 0
				@height = p_height
			end
		end
	end

end

class Elevator
	attr_writer :currentFloor
	def currentFloor
		if some_condition_check
			raise error
		end
		currentFloor
	end
end