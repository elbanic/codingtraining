import scala.io.StdIn._

object TemperatureConversion {

  def getOrgTypeName(convType: String) = {
    if (List("c", "C").contains(convType)) "Fahrenheit"
    else if (List("f", "F").contains(convType)) "Celsius" else ""
  }

  def getConvTypeName(convType: String) = {
    if (List("c", "C").contains(convType)) "Celsius"
    else if (List("f", "F").contains(convType)) "Fahrenheit" else ""
  }

  def main(args: Array[String]): Unit = {

    var convType = ""
    var temperature = 0d
    var bTempStatus = false
    var bTypeStatus = false
    println("Press C to convert from Fahrenheit to Celsius and F to convert from Celsius to Fahrenheit.")
    do {
      try {
        if (!bTypeStatus) {
          convType = inputChar("Press Key (C or F): ")
          if (!List("c", "f", "C", "F").contains(convType)) throw new NotProperCharInputException
          bTypeStatus = true
        }

        if (!bTempStatus) {
          temperature = inputDouble(s"Please enter the temperature in ${getOrgTypeName(convType)}: ")
          bTempStatus = true
        }
      }
      catch {
        case e: NotProperDoubleInputException => println("Please input temperature properly !");
        case e: NotProperCharInputException => println("Please input character properly !");
      }
    } while(!bTempStatus || !bTypeStatus)

    val out = new TempConverter(convType, temperature).apply()
    println(s"The temperature in ${getConvTypeName(convType)} is $out.")
  }

  def inputDouble(str: String): Double = {
    val in = readLine(str)
    try {
      in.asInstanceOf[String].toDouble
    } catch {
      case e: Exception => throw new NotProperDoubleInputException
    }
  }

  def inputChar(str: String): String = {
    val in = readLine(str)
    in.asInstanceOf[String].toString
  }
}