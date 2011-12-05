package mavent.bowlingkata

trait ScoreCalculator {
	def calculate(rolls: Iterable[Int]) : Int 
}

class DefaultScoreCalculator extends ScoreCalculator {
	
	def calculate(rolls: Iterable[Int]) : Int = {
		frames(rolls.toList) reduce(_+_)
	}
	
	private def frames(rolls: List[Int]) : List[Int] = rolls match {
		case first :: second :: Nil => (first + second) :: Nil
		case first :: second :: third :: Nil => (first + second + third) :: Nil
		case first :: second :: third :: tail => strike_check(first, second, third, tail)
		case Nil => Nil
	}

	private def strike_check(a: Int, b: Int, c: Int, tail: List[Int]) : List[Int] = a match {
		case 10 => (10 + b + c) :: frames(b :: c :: tail)
		case _  => spare_check(a, b, c, tail)
	}
	
	private def spare_check(a: Int, b: Int, c: Int, tail: List[Int]) : List[Int] = a + b match {
		case 10 => (10 + c) :: frames(c :: tail)
		case _  => (a + b) :: frames(c :: tail)
	}
}
