package mavent.bowlingkata.acceptance

import mavent.bowlingkata._

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers._


class PlayingBowlingFeature extends FeatureSpec with GivenWhenThen {

  feature("Playing 10 pin bowling") {

	info("As a user")
	info("I want to calculate my bowling score")
	info("So I can tell if I won!")
	
    scenario("Playing a perfect game") {
		given("A default bowling game")
		val game = new BowlingGame(new DefaultScoreCalculator)

		when("I do a strike on every frame")
		val actual = (1 to 12).foldLeft(game) { (newGame, i) => newGame.roll(10) }

		then("The score should be perfect!")
		actual.score should be(300)
    }

    scenario("Playing the worst game possible") {
		given("A default bowling game")
		val game = new BowlingGame(new DefaultScoreCalculator)

		when("I miss all the pins in every single frame")
		val actual = (1 to 10).foldLeft(game) { (newGame, i) => newGame.roll(0) }
		
		then("The score should be the lowest possible")
		actual.score should be(0)
    }

    scenario("Playing an average game") {
		val cases = List( (131, List(9, 0, 3, 7, 6, 1, 3, 7, 8, 1, 5, 5, 0, 10, 8, 0, 7, 3, 8, 2, 8)),
					  (82, List(9, 0, 3, 5, 6, 1, 3, 6, 8, 1, 5, 3, 2, 5, 8, 0, 7, 1, 8, 1)),
					(193, List(10, 3, 7, 6, 1, 10, 10, 10, 2, 8, 9, 0, 7, 3, 10, 10, 10)))
					
		cases.foreach { expected =>
			val (score, rolls) = expected
			
			given("A default bowling game")
			val game = new BowlingGame(new DefaultScoreCalculator)

			when("I'm not having my best day")
			val actual = rolls.foldLeft(game) { (newGame, i) => newGame.roll(i) }

			then("The score should be %d".format(score))
			actual.score should be(score)
		}			
    }
  }
}