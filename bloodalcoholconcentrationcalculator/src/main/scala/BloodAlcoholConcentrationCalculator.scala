import scala.math.BigDecimal
import scala.io.StdIn._

object BloodAlcoholConcentrationCalculator {

  def main(args: Array[String]): Unit = {

    var sd = 0
    var bw = 0.0d
    var wt = 0.0d
    var dp = 0

    var isOverNumber = false
    var isGenderProp = false
    do {
      try {
        if (!isGenderProp) {
          wt = inputDouble("What is your weight?(kg) ")
          val gender = inputInt("What is your gender?(1: male, 2: female) ")
          bw = if (gender == 1) 0.58d else if (gender == 2) 0.49d else throw new NoGenderException
          isGenderProp = true
        }

        if (!isOverNumber) {
          sd = inputInt("How many did you drink?(glass or shot) ")
          dp = inputInt("How long did the drink period in hours ")
          if (dp > sd) throw new OverNumberException
          isOverNumber = true
        }
      }
      catch {
        case e: Exception => println("Please input number properly !");
        case e: NoGenderException => println("Please input gender properly !");
        case e: OverNumberException => println("Please input drink period properly !");
      }
    } while(!isOverNumber || !isGenderProp)

    printBACResult(calcBAC(sd, bw, wt, dp))
  }

  def printBACResult(bac: Double): Unit ={
    println (s"Your BAC is $bac")
    if (bac >= 0.08) println ("It is not legal for you to drive.")
    else println ("It is legal for you to drive.")
  }

  def calcBAC(sd: Int, bw: Double, wt: Double, dp: Int) = (((0.806d * sd * 1.2d) / (bw * wt)) - 0.017d * dp) * 10d

  def inputDouble(str: String): Double = {
    val in = readLine(str)
    in.asInstanceOf[String].toDouble
  }

  def inputInt(str: String): Int = {
    val in = readLine(str)
    in.asInstanceOf[String].toInt
  }
}