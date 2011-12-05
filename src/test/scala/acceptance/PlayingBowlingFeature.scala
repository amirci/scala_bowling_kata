package mavent.bowlingkata.acceptance

import mavent.bowlingkata._

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers._


class PlayingBowlingFeature extends FeatureSpec with GivenWhenThen {

  feature("Playing 10 pin bowling") {

	info("As a user")
	info("I want to play frames in the game")
	info("So I can get the right score")
	
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

		when("I miss all the pins every single frame")
		val actual = (1 to 10).foldLeft(game) { (newGame, i) => newGame.roll(0) }
		
		then("The score should be the lowest possible")
		actual.score should be(0)
    }
  }
}