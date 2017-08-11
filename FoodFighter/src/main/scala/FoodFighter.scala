
import scala.io._
import scala.collection.mutable.Map

object FoodFighter {
  lazy val thrTime = Map[Int, Long]()
  def main(args: Array[String]): Unit = {

    val people_count = input()
    val t = (1 to people_count.toInt).map{ id =>
      new Thread(new Runnable {
      def run() {
          thrTime += id -> runProcess(id)
        }
      })
    }
    t.par.foreach(i => i.start())
    t.par.foreach(i => i.join())

    var min = thrTime(thrTime.keys.head)
    thrTime.foreach{ case(k,v) => if(min > v) min = v}
    thrTime.foreach{ case(k,v) => if(min == v) println(s"Person${k} is winner !")}
  }

  def input(): String = readLine("How many people are ? ")
  def output(name: String): String = "Hello, " + name + ", what's going on?!"

  def runProcess(id: Int): Long ={
    val start = System.nanoTime()
    println(s"Person$id : i'm start eating.")
    (0 to 100000000).foreach(r => r.toInt)
    val end = System.nanoTime()
    println(s"Person$id : i'm done !")
    end - start
  }
}