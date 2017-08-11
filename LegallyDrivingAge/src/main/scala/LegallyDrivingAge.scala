import scala.math.BigDecimal
import scala.io.StdIn._

object LegallyDrivingAge {

  def main(args: Array[String]): Unit = {

    var status = true
    var age = 0
    do {
      try {
        age = input("What is your age? ")
        status = false
      }
      catch {
        case e: Exception => println("Please input number properly !");
      }
    } while(status)

    println(getOutputString(checkAge(age)))
  }

  def checkAge(a: Int): Boolean = {
    if (a >= 16) true else false
  }

  def getOutputString(b: Boolean): String = {
    if (b) "You are old enough to legally drive."
    else "You are not old enough to legally drive."
  }

  def input(str: String): Int = {
    val in = readLine(str)
    in.asInstanceOf[String].toInt
  }

}