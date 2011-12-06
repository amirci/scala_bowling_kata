package mavent.bowlingkata

trait ScoreCalculator {
	def calculate(rolls: Iterable[Int]) : Int 
}

class DefaultScoreCalculator extends ScoreCalculator {
	
	def calculate(rolls: Iterable[Int]) : Int = {
		frames(rolls.toList)
	}
	
	private def frames(rolls: List[Int]) : Int = rolls match {
		case first :: second :: Nil => first + second
		case first :: second :: third :: Nil => first + second + third
		case first :: second :: third :: tail => strike_check(first, second, third, tail)
		case _ => 0
	}

	private def strike_check(a: Int, b: Int, c: Int, tail: List[Int]) : Int = a match {
		case 10 => 10 + b + c + frames(b :: c :: tail)
		case _  => spare_check(a, b, c) + frames(c :: tail)
	}
	
	private def spare_check(a: Int, b: Int, c: Int) : Int = a + b match {
		case 10 => (10 + c) 
		case _  => (a + b) 
	}
}
