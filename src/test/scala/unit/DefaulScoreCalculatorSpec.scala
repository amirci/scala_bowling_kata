package mavent.bowlingkata.unit

import mavent.bowlingkata._

import org.scalatest._
import org.scalatest.mock._
import org.scalatest.matchers.ShouldMatchers._

import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory

class DefaultScoreCalculatorSpec extends WordSpec {

  "A Default Score Calculator" when {

	val calc = new DefaultScoreCalculator
	
    "frame is less than 10" should {
		"add both rolls" in {
			calc.calculate(List(2, 6)) should be(8)
		}
    }

	"frame is a spare" should {
		"add the first of the next roll" in {
			calc.calculate(List(8, 2, 4, 2)) should be(20)
		}
	}
	
	"frame is a strike" should {
		"add both next rolls" in {
			calc.calculate(List(10, 4, 2)) should be(22)
		}
		"add both next rolls but not for the last two" in {
			calc.calculate(List(10, 10, 10)) should be(30)
		}
	}
  }
}
