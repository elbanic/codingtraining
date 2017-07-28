import scala.math.BigDecimal
import scala.io.StdIn._

object TaxCalculator {

  def main(args: Array[String]): Unit = {

    var amount: Double = 0
    var state: String = ""
    amount = java.lang.Double.parseDouble(input("What is the order amount? "))
    state = readLine("What is the state? ")

    printResult(amount, 0.055, state)
  }

  def halfUp(n: Double): BigDecimal = BigDecimal(n).setScale(2, BigDecimal.RoundingMode.HALF_UP)

  def calculateTax(amount: Double, tax_ratio: Double): BigDecimal = halfUp(amount*tax_ratio)

  def printResult(amount: Double, tax_ratio: Double, state: String): Unit ={

    if (state=="WI") {
      val tax = calculateTax(amount, tax_ratio)
      println(s"The subtotal is $$$amount")
      println(s"The tax is $$$tax")
      println(s"The total is $$${amount+tax}")
    }
    if (state!="WI") {
      val tax = calculateTax(amount, tax_ratio)
      println(s"The total is $$${amount+tax}")
    }
  }

  def input(str: String): String = {
    val in = readLine(str)
    try { in.asInstanceOf[String].toDouble; }
    catch { case e: Exception => e.printStackTrace(); println("Input number properly !"); }
    in.toString
  }
}