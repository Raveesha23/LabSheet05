import scala.collection.mutable

case class Book(title: String, author: String, isbn: String)

object LibraryManagement {
  def main(args: Array[String]): Unit = {
    
    // Initial set of books
    val initialBooks: Set[Book] = Set(
      Book("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0"),
      Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4"),
      Book("1984", "George Orwell", "978-0-452-28423-4")
    )

    var library: mutable.Set[Book] = mutable.Set() ++ initialBooks

    displayLibrary(library)

    addBook(library, Book("Brave New World", "Aldous Huxley", "978-0-06-085052-4"))
    removeBook(library, "978-0-316-76948-0")
    println(s"\nIs '1984' in the library? ${isBookInLibrary(library, "978-0-452-28423-4")}")

    displayLibrary(library)
    searchByTitle(library, "1984")
    displayBooksByAuthor(library, "Harper Lee")
  }

  def addBook(library: mutable.Set[Book], book: Book): Unit = {
    library += book
    println(s"\nBook added: ${book.title} by ${book.author}")
  }

  def removeBook(library: mutable.Set[Book], isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"\nBook removed: ${book.title} by ${book.author}")
      case None =>
        println(s"\nNo book found with ISBN: $isbn")
    }
  }

  def isBookInLibrary(library: mutable.Set[Book], isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(library: mutable.Set[Book]): Unit = {
    println("\n---------------------Current Library Collection:----------------------")
    library.foreach { book =>
      println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    }
  }

  def searchByTitle(library: mutable.Set[Book], title: String): Unit = {
    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(s"\nBook found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"\nNo book found with title: $title")
    }
  }

  def displayBooksByAuthor(library: mutable.Set[Book], author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"\n------Books by $author:------")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    } else {
      println(s"No books found by author: $author")
    }
  }
}
