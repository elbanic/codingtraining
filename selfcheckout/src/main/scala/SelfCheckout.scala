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

    var nItem: Int = 0
    var aPriceQuant = ArrayBuffer[PriceQuant]()
    do {
      aPriceQuant.foreach(r => aPriceQuant -= r)
      nItem = try { input("How many items will you buy? ").toInt }
            catch { case e: Exception => e.printStackTrace; println("Input number properly"); 0}

      if(numberCheck(nItem)) {
        breakable {
          for (i <- 1 to nItem) {
            val dPrice = try { input(s"Price of item $i: ").toDouble }
              catch { case e: Exception => e.printStackTrace; println("Input number properly"); 0}
            val nQuant = try { input(s"Quantity of item $i: ").toInt }
              catch { case e: Exception => e.printStackTrace; println("Input number properly"); 0}
            if (numberCheck(dPrice) && numberCheck(nQuant)) {
              aPriceQuant += PriceQuant(dPrice, nQuant)
            } else
              break;
          }
        }
      }
    }
    while (nItem != aPriceQuant.size)
    println(getOutput(aPriceQuant))
  }

  def input(str: String): String = readLine(str)
  def getOutput(arr: ArrayBuffer[PriceQuant]): String = {

    val sub = arr.map( r => r.price*r.quant).sum
    val tax = sub * taxRatio
    val tot = sub + tax

    s"Subtotal: $$$sub\n" +
    s"Tax: $$${BigDecimal(tax).setScale(2, BigDecimal.RoundingMode.HALF_UP)}\n" +
    s"Subtotal: $$$tot\n"
  }
}