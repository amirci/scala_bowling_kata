package mavent.bowlingkata

trait ScoreCalculator {
	def calculate(rolls: Iterable[Int]) : Int 
}

class DefaultScoreCalculator extends ScoreCalculator {
	
	def calculate(rolls: Iterable[Int]) : Int = {
		rolls.reduceLeft[Int](_+_)
	}
}
