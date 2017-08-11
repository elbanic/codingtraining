import java.text.SimpleDateFormat
import java.util.Calendar

object RetirementCalculator {
  def main(args: Array[String]): Unit = {

    var cur: Int = 0
    var retire: Int = 0
    var diff = -1
    def numberCheck(n: Int): Boolean = if (n < 0) false else true
    do {
      cur = try { input("What is your current age? ").toInt }
            catch { case e: Exception => e.printStackTrace; 0}
      retire = try { input("At what age would you like to retire? ").toInt }
            catch { case e: Exception => e.printStackTrace; 0}
      diff = retire - cur
    }
    while (!numberCheck(diff))

    println(s"You have $diff years left until you can retire.\n" +
      s"It's ${getYearFromCurrent()}, so you can retire in ${getYearFromCurrent(diff)}.")
  }

  def input(str: String): String = readLine(str)
  def getYearFromCurrent(after: Int=0): String ={

    val now = Calendar.getInstance()
    now.add(Calendar.YEAR, after)

    val ynow = now.getTime()
    val yearFormat = new SimpleDateFormat("YYYY")
    yearFormat.format(ynow)
  }
}