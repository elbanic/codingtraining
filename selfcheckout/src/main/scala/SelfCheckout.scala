import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._
import scala.math.BigDecimal

object SelfCheckout {

  final val taxRatio = 0.07d

  case class PriceQuant(price: Double, quant: Int) { }

  def main(args: Array[String]): Unit = {

    def numberCheck(n: Any): Boolean = {
      n match {
        case n: Int => if (n.asInstanceOf[Int] <= 0) false else true
        case d: Double => if (n.asInstanceOf[Double] <= 0) false else true
        case _ => false
      }
    }

    var nItem = 0
    var aPriceQuant = ArrayBuffer[PriceQuant]()
    do {
      aPriceQuant.foreach(r => aPriceQuant -= r)
      nItem = Integer.parseInt(input("How many items will you buy? ").toString)
      if(numberCheck(nItem)) {
        breakable {
          for (i <- 1 to nItem) {
            val dPrice = java.lang.Double.parseDouble(input(s"Price of item $i: ").toString)
            val nQuant = Integer.parseInt(input(s"Quantity of item $i: ").toString)
            if (numberCheck(dPrice) && numberCheck(nQuant)) {
              aPriceQuant += PriceQuant(dPrice.asInstanceOf[Double], nQuant.asInstanceOf[Int])
            } else
              break;
          }
        }
      }
    }
    while (nItem != aPriceQuant.size)
    println(getOutput(aPriceQuant))
  }

  def input(str: String): Any = {
    val in = readLine(str)
    try { in.toDouble; in.toInt }
    catch { case e: Exception => e.printStackTrace; println("Input number properly"); }
    in
  }

  def getOutput(arr: ArrayBuffer[PriceQuant]): String = {

    val sub = arr.map( r => r.price*r.quant).sum
    val tax = sub * taxRatio
    val tot = sub + tax

    s"Subtotal: $$$sub\n" +
    s"Tax: $$${BigDecimal(tax).setScale(2, BigDecimal.RoundingMode.HALF_UP)}\n" +
    s"Subtotal: $$$tot\n"
  }
}