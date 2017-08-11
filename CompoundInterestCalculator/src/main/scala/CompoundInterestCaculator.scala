import scala.math.BigDecimal

object CompoundInterestCaculator {

  def main(args: Array[String]): Unit = {

    var amount: Double = 0
    var interest: Double = 0
    var period: Double = 0
    var numcomp: Double = 0
    def numberCheck(n: Double): Boolean = if (n <= 0.0d) false else true
    do {
      amount = java.lang.Double.parseDouble(input("What is the principal amount? "))
      interest = java.lang.Double.parseDouble(input("What is the rate: ")) / 100d
      period = java.lang.Double.parseDouble(input("What is the number of years: "))
      numcomp = java.lang.Double.parseDouble(input("What is the number of times the interest is compounded per year: "))
    }
    while (!numberCheck(amount) || !numberCheck(interest) || !numberCheck(period) || !numberCheck(numcomp))

    printResult(amount, interest, period, numcomp)
  }

  def halfUp(n: Double): BigDecimal = BigDecimal(n).setScale(0, BigDecimal.RoundingMode.HALF_UP)

  def calculateCompoundInterest(pi: Double, i: Double, p: Double, n: Double): Double = pi * math.pow((1 + i/n), n*p)

  def printResult(pi: Double, i: Double, p: Double, n: Double): Unit ={
    println(s"$$${pi.toLong} invested at ${(i*100).toLong}% for ${p.toLong} years compounded ${n.toLong}" +
      s" times per year is $$${halfUp(calculateCompoundInterest(pi, i, p, n))}")
  }

  def input(str: String): String = {
    val in = readLine(str)
    try { in.asInstanceOf[String].toDouble; }
    catch { case e: Exception => e.printStackTrace; println("Input number properly !"); }
    in.toString
  }
}