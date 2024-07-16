import scala.io.StdIn.readLine

object fibonacci {
    def fibonacci(n:Int):Int= n match{
        case 0 => 0
        case x if x==1 => 1
        case _ => fibonacci(n-1)+fibonacci(n-2)
    }

    def fibonacciSeq(n:Int):Unit= {
        if (n > 0) fibonacciSeq(n-1)
        println(fibonacci(n))
    }

    def main(args: Array[String]) : Unit = {
        val n = readLine("Enter number of Fibonacci numbers to be printed: ").toInt
        println(s"The first $n Fibonacci numbers are: ")
        fibonacciSeq(n)
    }

    
}
