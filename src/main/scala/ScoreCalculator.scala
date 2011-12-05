package mavent.bowlingkata

trait ScoreCalculator {
	def calculate(rolls: Iterable[Int]) : Int 
}

class DefaultScoreCalculator extends ScoreCalculator {
	
	def calculate(rolls: Iterable[Int]) : Int = {
		val f = frames(rolls.toList) 
		f reduce(_+_)
	}
	
	private def frames(rolls: List[Int]) : List[Int] = rolls match {
		case 10 :: 10 :: 10 :: Nil => 30 :: Nil
		case 10 :: second :: third :: tail => strike(second, third, tail)
		case first :: second :: third :: tail => check_spare(first, second, third, tail)
		case first :: second :: Nil => (first + second) :: Nil 
		case first :: Nil => first :: Nil
		case Nil => Nil
	}

	private def strike(a: Int, b: Int, tail: List[Int]) : List[Int] = {
		(10 + a + b) :: frames(a :: b :: tail.toList)
	}
	
	private def check_spare(a: Int, b: Int, c: Int, tail: List[Int]) : List[Int] = a + b match {
		case 10 => (10 + c) :: frames(c :: tail)
		case _  => (a + b) :: frames(c :: tail)
	}
}
