package mavent.bowlingkata

class BowlingGame(scoreCalc: { def calculate(rolls: Iterable[Int]): Int}, 
				  frames: Iterable[Int] = Nil) {
	
	def score = scoreCalc.calculate(frames)
	
	def roll(score: Int) = new BowlingGame(scoreCalc, frames.toList ::: List(score))
}