/**
  * Created by 1003850 on 2017. 8. 11..
  */
class TempConverter(convType:String, temperature: Double) {

  def apply(): Double = {
    if (List("c", "C").contains(convType)) calcCelsius(temperature)
    else if (List("f", "F").contains(convType)) calcFahrenheit(temperature)
    else throw new Exception
  }

  def calcCelsius(F: Double): Double = (F-32) * 5/9
  def calcFahrenheit(C: Double): Double = (C*9/5) + 32
}
