import scala.math

object PaintCalculator {

  final val paintUnit: Double = 9.0d

  def main(args: Array[String]): Unit = {


    var area: Double = 0
    def numberCheck(n: Double): Boolean = if (n <= 0) false else true
    do {
      area = try { input("What is the area of the ceil in meters? ").toDouble }
            catch { case e: Exception => e.printStackTrace; 0}
    }
    while (!numberCheck(area))
    printResult(area)
  }

  def printResult(area: Double): Unit ={
    println(s"You will need to purchase ${getPaintNumber(area)} liters of paint")
    println(s"to cover $area square meters.")
  }

  def input(str: String): String = readLine(str)
  def getPaintNumber(area: Double): Int = math.ceil(area/paintUnit).toInt
}