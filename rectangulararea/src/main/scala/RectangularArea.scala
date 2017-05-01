import java.text.SimpleDateFormat
import java.util.Calendar

object RectangularArea {

  final val f2mconst = 0.09290304

  def main(args: Array[String]): Unit = {

    var length: Double = 0
    var width: Double = 0
    var diff = -1
    def numberCheck(n: Double): Boolean = if (n <= 0) false else true
    do {
      length = try { input("What is the length of the room in feet? ").toDouble }
            catch { case e: Exception => e.printStackTrace; 0}
      width = try { input("What is the width of the room in feet? ").toDouble }
            catch { case e: Exception => e.printStackTrace; 0}
    }
    while (!numberCheck(length) && !numberCheck(width))

    printResult(length, width)
  }

  def printResult(l: Double, w: Double): Unit ={

    val areaf = calcRectArea(l, w)
    println(s"You entered dimensions of $l feet by $w feet.")
    println("The area is")
    println(s"\t$areaf square feet")
    println(s"\t${convFeat2Meter(areaf)} square meters")
  }

  def input(str: String): String = readLine(str)
  def calcRectArea(l: Double, w: Double) = l*w
  def convFeat2Meter(f: Double) = f*f2mconst
}