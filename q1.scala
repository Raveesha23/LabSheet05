import scala.io.StdIn.readLine

object InventoryManagement{
    def getProductList() : List[String] = {
        def promptForProducts(products : List[String]) : List[String] = {
            val input = readLine("Enter product name (or type 'done' to finish): ")
            if(input.toLowerCase == "done"){
                products
            }
            else{
                promptForProducts(products :+ input)
            }
        }
        promptForProducts(List.empty[String])    
    }

    def printProductList(products : List[String]) : Unit = {
        for(i <- products.indices){
            println(s"${i+1} : ${products(i)}")
        }
    }

    def getTotalProducts(products : List[String]) : Unit = {
        val items = products.length
        println(s"Number of Products: $items")
    }


    def main(args: Array[String]) : Unit = {
        val productList = getProductList()
        printProductList(productList)
        getTotalProducts(productList)
    }
    
}