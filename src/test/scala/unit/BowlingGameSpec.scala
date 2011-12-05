package mavent.bowlingkata.unit

import mavent.bowlingkata._

import org.scalatest._
import org.scalatest.mock._
import org.scalatest.matchers.ShouldMatchers._

import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory

class BowlingGameSpec extends Spec with MockFactory with ProxyMockFactory {

  describe("BowlingGame") {

    it("Should call the calculator with the rolls list") {
		val calc = mock[ScoreCalculator]
		
		calc expects 'calculate withArgs(*) returning 100

		val game = new BowlingGame(calc)
		
		val actual = game.roll(8)
			.roll(1)
			.roll(2)
			.roll(3)
			
		actual.score should be(100)
    }
  }
}
