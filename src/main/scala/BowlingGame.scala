package mavent.bowlingkata

class BowlingGame(scoreCalc: { def calculate(rolls: Iterable[Int]): Int}) {
	
	def score = 300
	
	def roll(score: Int) = new BowlingGame(scoreCalc)
}