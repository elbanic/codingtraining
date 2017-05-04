import scala.math.BigDecimal

object CurrencyConversion {

  def main(args: Array[String]): Unit = {

    var money: Double = 0
    var rate: Double = 0
    def numberCheck(n: Double): Boolean = if (n <= 0.0d) false else true
    do {
      money = java.lang.Double.parseDouble(input("How many Euros are you exchanging? ").toString)
      rate = java.lang.Double.parseDouble(input("What is the exchange rate? ").toString)
    }
    while (!numberCheck(money) || !numberCheck(rate))

    printResult(money, rate)
  }

  def getConvMoney(m: Double, rate: Double): Double ={
    BigDecimal(m * rate / 100d).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def printResult(m: Double, rate: Double): Unit ={
    println(s"$m Euros at an exchange rate of $rate is")
    println(s"${getConvMoney(m, rate)} dollars")
  }

  def input(str: String): Any = {
    val in = readLine(str)
    try { in.asInstanceOf[String].toDouble; }
    catch { case e: Exception => e.printStackTrace; println("Input number properly !"); }
    in
  }
}