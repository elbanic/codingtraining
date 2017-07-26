import scala.math.BigDecimal

object SimpleInterestCalculator {

  def main(args: Array[String]): Unit = {

    var principal: Double = 0
    var interest: Double = 0
    var period: Double = 0
    def numberCheck(n: Double): Boolean = if (n <= 0.0d) false else true
    do {
      principal = java.lang.Double.parseDouble(input("Enter the principal: "))
      interest = java.lang.Double.parseDouble(input("Enter the rate of interest: ")) / 100d
      period = java.lang.Double.parseDouble(input("Enter the number of years: "))
    }
    while (!numberCheck(principal) || !numberCheck(interest) || !numberCheck(period))

    printResult(principal, interest, period)
  }

  def halfUp(n: Double): BigDecimal = BigDecimal(n).setScale(0, BigDecimal.RoundingMode.HALF_UP)

  def calculateSimpleInterest(pi: Double, i: Double, p: Double): Double = pi * (1 + i * p)

  def printResult(pi: Double, i: Double, p: Double): Unit ={
    println(s"After $p years at ${i*100}%, the investment will be worth $$${halfUp(calculateSimpleInterest(pi, i, p))}")
  }

  def input(str: String): String = {
    val in = readLine(str)
    try { in.asInstanceOf[String].toDouble; }
    catch { case e: Exception => e.printStackTrace; println("Input number properly !"); }
    in.toString
  }
}